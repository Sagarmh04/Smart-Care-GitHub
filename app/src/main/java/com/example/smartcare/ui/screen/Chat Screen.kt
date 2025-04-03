package com.example.smartcare.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartcare.database.viewModel.RideViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    navController: NavController,
    userId: String,
    rideViewModel: RideViewModel,
    innerPadding: PaddingValues
) {
    // Mock data for the chat
    val chatUser = remember {
        when (userId) {
            "1" -> ChatUser("1", "John Smith", "", "")
            "2" -> ChatUser("2", "Emma Johnson", "", "")
            "3" -> ChatUser("3", "Michael Brown", "", "")
            "4" -> ChatUser("4", "Sophia Davis", "", "")
            "5" -> ChatUser("5", "James Wilson", "", "")
            else -> ChatUser("0", "Unknown User", "", "")
        }
    }

    // Mock messages
    val initialMessages = remember {
        when (userId) {
            "1" -> listOf(
                Message("1", "Hey, are you still offering the ride?", "10:30 AM", false),
                Message("2", "Yes, I am! Are you interested?", "10:32 AM", true),
                Message("3", "Great! How many seats are available?", "10:33 AM", false),
                Message("4", "I have 2 seats available. When do you need it?", "10:35 AM", true)
            )
            "2" -> listOf(
                Message("1", "Thanks for the ride yesterday!", "Yesterday", false),
                Message("2", "You're welcome! Hope you had a good day.", "Yesterday", true),
                Message("3", "It was great. Would you be available next week too?", "Yesterday", false)
            )
            "3" -> listOf(
                Message("1", "Can I book a seat for tomorrow?", "Yesterday", false),
                Message("2", "Sure, what time do you need?", "Yesterday", true),
                Message("3", "Around 9 AM if possible.", "Yesterday", false),
                Message("4", "That works for me. I'll pick you up at the main entrance.", "Yesterday", true),
                Message("5", "Perfect, see you then!", "Yesterday", false)
            )
            else -> listOf(
                Message("1", "Hello there!", "Just now", true)
            )
        }
    }

    val messages = remember { mutableStateListOf<Message>().apply { addAll(initialMessages) } }
    var newMessage by remember { mutableStateOf("") }

    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    // Scroll to bottom when new messages are added
    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty()) {
            listState.animateScrollToItem(messages.size - 1)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(chatUser.name) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Messages List
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(messages) { message ->
                    MessageItem(message = message)
                }
            }

            // Message Input
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = newMessage,
                    onValueChange = { newMessage = it },
                    placeholder = { Text("Type a message...") },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(24.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                IconButton(
                    onClick = {
                        if (newMessage.isNotEmpty()) {
                            val timeFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
                            val currentTime = timeFormat.format(Date())

                            messages.add(
                                Message(
                                    id = UUID.randomUUID().toString(),
                                    text = newMessage,
                                    time = currentTime,
                                    isFromCurrentUser = true
                                )
                            )

                            newMessage = ""

                            // Simulate a reply after a short delay
                            coroutineScope.launch {
                                kotlinx.coroutines.delay(1000)
                                val replyTime = timeFormat.format(Date())
                                messages.add(
                                    Message(
                                        id = UUID.randomUUID().toString(),
                                        text = getRandomReply(),
                                        time = replyTime,
                                        isFromCurrentUser = false
                                    )
                                )
                            }
                        }
                    },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Icon(Icons.Default.Send, contentDescription = "Send")
                }
            }
        }
    }
}

@Composable
fun MessageItem(message: Message) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalAlignment = if (message.isFromCurrentUser) Alignment.End else Alignment.Start
    ) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomStart = if (message.isFromCurrentUser) 16.dp else 0.dp,
                        bottomEnd = if (message.isFromCurrentUser) 0.dp else 16.dp
                    )
                )
                .background(
                    if (message.isFromCurrentUser)
                        MaterialTheme.colorScheme.primary
                    else
                        MaterialTheme.colorScheme.surfaceVariant
                )
                .padding(12.dp)
        ) {
            Text(
                text = message.text,
                color = if (message.isFromCurrentUser)
                    MaterialTheme.colorScheme.onPrimary
                else
                    MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Text(
            text = message.time,
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(top = 4.dp, start = 4.dp, end = 4.dp)
        )
    }
}

// Data class for messages
data class Message(
    val id: String,
    val text: String,
    val time: String,
    val isFromCurrentUser: Boolean
)

// Function to generate random replies
fun getRandomReply(): String {
    val replies = listOf(
        "Sure, that works for me!",
        "I'll check and get back to you.",
        "Can you provide more details?",
        "That sounds good!",
        "I'm available at that time.",
        "Let me think about it.",
        "Perfect! See you then.",
        "I'll be there on time.",
        "Is there anything else I should know?",
        "Thanks for letting me know."
    )
    return replies.random()
}

