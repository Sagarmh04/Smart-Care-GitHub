package com.example.smartcare.database.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartcare.database.dao.MessageDAO
import com.example.smartcare.database.entity.Message
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModelProvider
import com.example.smartcare.database.entity.ProfileData
import com.example.smartcare.database.entity.ProfileDataFireBase
import com.google.firebase.Firebase
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.UUID

class MessageViewModel(private val dao: MessageDAO) : ViewModel() {
    private val db = Firebase.firestore
    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages

    fun fetchMessages(chatId: String) {
        db.collection("chats").document(chatId)
            .collection("messages")
            .orderBy("timestamp", Query.Direction.ASCENDING)
            .addSnapshotListener { snapshot, _ ->
                val fetchedMessages = snapshot?.toObjects(Message::class.java) ?: emptyList()
                _messages.value = fetchedMessages
            }
    }
    private val _searchResults = MutableStateFlow<List<ProfileDataFireBase>>(emptyList())
    val searchResults: StateFlow<List<ProfileDataFireBase>> = _searchResults

    fun sendMessage(chatId: String, message: String, senderId: String, receiverId: String) {
        val newMessage = hashMapOf(
            "messageId" to UUID.randomUUID().toString(),
            "senderId" to senderId,
            "receiverId" to receiverId,
            "message" to message,
            "timestamp" to System.currentTimeMillis()
        )

        db.collection("chats").document(chatId)
            .collection("messages").add(newMessage)
    }

    fun searchUsers(query: String) {
        if (query.isBlank()) {
            _searchResults.value = emptyList()
            return
        }

        db.collection("profiles")
            .orderBy("name")
            .startAt(query)
            .endAt(query + "\uf8ff") // Firestore prefix search
            .get()
            .addOnSuccessListener { documents ->
                val users = documents.map { it.toObject(ProfileDataFireBase::class.java) }
                _searchResults.value = users
            }
    }
    fun sendMessage(message: Message) {
        viewModelScope.launch {
            dao.insertMessage(message)
        }
    }

    suspend fun getChatMessages(senderId: String, receiverId: String): List<Message> {
        return dao.getMessagesBetweenUsers(senderId, receiverId)
    }

    fun clearMessages() {
        viewModelScope.launch {
            dao.clearAllMessages()
        }
    }
}


class MessageViewModelFactory(private val dao: MessageDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MessageViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MessageViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
