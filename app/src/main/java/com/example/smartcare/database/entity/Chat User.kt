package com.example.smartcare.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ChatUser(
    @PrimaryKey var id: String,
    var name: String,
    var lastMessage: String,
    var time: String
)