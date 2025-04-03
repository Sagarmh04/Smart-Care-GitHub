package com.example.smartcare.database.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartcare.database.dao.MessageDAO
import com.example.smartcare.database.entity.Message
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModelProvider

class MessageViewModel(private val dao: MessageDAO) : ViewModel() {

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
