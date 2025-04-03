package com.example.smartcare.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.smartcare.OtherScreens
import com.example.smartcare.database.viewModel.MessageViewModel
@Composable
fun MessageScreen(
    innerPadding: PaddingValues,
    messageViewModel: MessageViewModel,
    navController: NavController,
    hideBottomScreen: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    val searchResults by messageViewModel.searchResults.collectAsState()

    Column(modifier = Modifier.padding(innerPadding)) {
        TextField(
            value = searchQuery,
            onValueChange = {
                searchQuery = it
                messageViewModel.searchUsers(it)
            },
            label = { Text("Search Users") },
            modifier = Modifier.fillMaxWidth()
        )

        LazyColumn {
            items(searchResults) { user ->
                DropdownMenuItem(
                    text = { Text(user.name) },
                    onClick = {
                        navController.currentBackStackEntry?.savedStateHandle?.set("user", user.id)
                        navController.navigate(OtherScreens.MessageChatScreen.route)
                    }
                )
            }
        }
    }
}
