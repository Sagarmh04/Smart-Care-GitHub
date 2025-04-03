package com.example.smartcare.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.smartcare.database.entity.Message
import com.example.smartcare.database.viewModel.MessageViewModel

@Composable
fun MessageChatScreen(
    navController: NavHostController,
    messageViewModel: MessageViewModel,
    ourId: String,
    hideBottomScreen: () -> Unit
) {
    LaunchedEffect(Unit) {
        hideBottomScreen()
    }
    val requestId = navController.previousBackStackEntry?.savedStateHandle?.get<String>("user") ?: return
    val chatId = if (ourId < requestId) "$ourId-$requestId" else "$requestId-$ourId"

    val messages by messageViewModel.messages.collectAsState()
    var messageText by remember { mutableStateOf("") }

    LaunchedEffect(chatId) {
        messageViewModel.fetchMessages(chatId)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Messages List
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(items = messages) { message ->
                MessageItem(message, ourId)
            }
        }

        // Message Input Box
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = messageText,
                onValueChange = { messageText = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Type a message...") }
            )
            IconButton(onClick = {
                if (messageText.isNotBlank()) {
                    messageViewModel.sendMessage(chatId, messageText, ourId, requestId)
                    messageText = "" // Clear input field after sending
                }
            }) {
                Icon(Icons.AutoMirrored.Filled.Send, contentDescription = "Send")
            }
        }
    }
}

@Composable
fun MessageItem(message: Message, ourId: String) {
    val isSent = message.senderId == ourId
    val alignment = if (isSent) Alignment.End else Alignment.Start
    val backgroundColor = if (isSent) Color.Blue else Color.Gray

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = message.messageText,
            color = Color.White,
            modifier = Modifier
                .background(backgroundColor, shape = RoundedCornerShape(8.dp))
                .padding(8.dp)
        )
    }
}
