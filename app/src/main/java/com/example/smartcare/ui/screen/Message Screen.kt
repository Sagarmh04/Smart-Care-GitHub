package com.example.smartcare.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartcare.database.Destination
import com.example.smartcare.database.viewModel.RideViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageScreen(
    navController: NavController,
    rideViewModel: RideViewModel,
    innerPadding: PaddingValues
) {
    var searchQuery by remember { mutableStateOf("") }
    var isSearchActive by remember { mutableStateOf(false) }

    // Mock data for chat users
    val chatUsers = remember {
        listOf(
            ChatUser("1", "John Smith", "Hey, are you still offering the ride?", "10:30 AM"),
            ChatUser("2", "Emma Johnson", "Thanks for the ride yesterday!", "Yesterday"),
            ChatUser("3", "Michael Brown", "Can I book a seat for tomorrow?", "Yesterday"),
            ChatUser("4", "Sophia Davis", "What time are you leaving?", "Monday"),
            ChatUser("5", "James Wilson", "Is there still space available?", "Sunday")
        )
    }

    // Filtered users based on search query
    val filteredUsers = remember(searchQuery) {
        if (searchQuery.isEmpty()) {
            chatUsers
        } else {
            chatUsers.filter { it.name.contains(searchQuery, ignoreCase = true) }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(innerPadding)
    ) {
        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = {
                searchQuery = it
                isSearchActive = it.isNotEmpty()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = if (isSearchActive) 0.dp else 16.dp),
            placeholder = { Text("Search users...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
            singleLine = true,
            shape = RoundedCornerShape(24.dp)
        )

        // Search Results
        if (isSearchActive) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            ) {
                items(filteredUsers) { user ->
                    SearchResultItem(
                        user = user,
                        onClick = {
                            navController.navigate(Destination.Chat.createRouteWithParam(user.id))
                            searchQuery = ""
                            isSearchActive = false
                        }
                    )
                }
            }
        }

        // Recent Chats Title
        Text(
            text = "Recent Chats",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Chat List
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(chatUsers) { user ->
                ChatItem(
                    user = user,
                    onClick = {
                        navController.navigate(Destination.Chat.createRouteWithParam(user.id))
                    }
                )
            }
        }
    }
}

@Composable
fun SearchResultItem(
    user: ChatUser,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // User Avatar
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = user.name.first().toString(),
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // User Name
        Text(
            text = user.name,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ChatItem(
    user: ChatUser,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // User Avatar
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = user.name.first().toString(),
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Chat Info
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = user.name,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = user.lastMessage,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1
            )
        }

        // Time
        Text(
            text = user.time,
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }

    Divider(
        modifier = Modifier.padding(start = 66.dp),
        color = MaterialTheme.colorScheme.outlineVariant
    )
}

// Data class for chat users
data class ChatUser(
    val id: String,
    val name: String,
    val lastMessage: String,
    val time: String
)

