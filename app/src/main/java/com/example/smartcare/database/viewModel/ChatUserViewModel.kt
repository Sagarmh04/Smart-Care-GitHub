package com.example.smartcare.database.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.smartcare.database.dao.ChatUserDAO
import com.example.smartcare.database.entity.ChatUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChatUserViewModel(private val dao: ChatUserDAO) : ViewModel() {
    private val firestore = FirebaseFirestore.getInstance()

    private val _chatUsersList = MutableStateFlow<List<ChatUser>>(emptyList())
    val chatUsersList: StateFlow<List<ChatUser>> = _chatUsersList.asStateFlow()

    private val searchQuery = MutableStateFlow("")

    fun fetchChatUsers() {
        viewModelScope.launch {
            searchQuery
                .debounce(300) // 🔹 Debounce: Wait 300ms before fetching
                .distinctUntilChanged() // 🔹 Only fetch if query changes
                .collect { query ->
                    if (query.isNotBlank()) {
                        fetchChatUsersFromFirestore(query)
                    } else {
                        _chatUsersList.value = emptyList()
                    }
                }
        }
    }

    fun updateSearchQuery(query: String) {
        searchQuery.value = query
    }

    private fun fetchChatUsersFromFirestore(query: String) {
        firestore.collection("profiles") // 🔹 Change to your collection name
            .whereGreaterThanOrEqualTo("name", query) // 🔹 Firestore filtering
            .whereLessThanOrEqualTo("name", query + "\uf8ff") // 🔹 Ensure correct range
            .get()
            .addOnSuccessListener { result ->
                val users = result.documents.mapNotNull { document ->
                    val id = document.getString("id") ?: document.id
                    val name = document.getString("name") ?: return@mapNotNull null

                    ChatUser(
                        id = id,
                        name = name,
                        lastMessage = "", // Default values
                        time = "" // Default values
                    )
                }
                _chatUsersList.value = users
            }
            .addOnFailureListener { exception ->
            }
    }


    val allChatUsers: LiveData<List<ChatUser>> = dao.getAllChatUsers()
    val names: LiveData<List<String>> = dao.getNames()
    fun insertOrUpdateChatUser(chatUser: ChatUser) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insertOrUpdateChatUser(chatUser)
        }
    }

    fun getChatUserById(userId: String, onResult: (ChatUser?) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = dao.getChatUserById(userId)
            withContext(Dispatchers.Main) {
                onResult(user)
            }
        }
    }

    fun deleteChatUser(userId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteChatUser(userId)
        }
    }

    fun deleteAllChatUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteAllChatUsers()
        }
    }
}
class ChatUserViewModelFactory(private val dao: ChatUserDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ChatUserViewModel::class.java) -> ChatUserViewModel(dao) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}

