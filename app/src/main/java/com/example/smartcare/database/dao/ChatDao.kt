package com.example.smartcare.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.smartcare.database.entity.ChatUser

@Dao
interface ChatUserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateChatUser(chatUser: ChatUser)

    @Query("SELECT * FROM ChatUser WHERE id = :userId")
    suspend fun getChatUserById(userId: String): ChatUser?

    @Query("SELECT * FROM ChatUser ORDER BY time DESC")
    fun getAllChatUsers(): LiveData<List<ChatUser>>

    @Query("DELETE FROM ChatUser WHERE id = :userId")
    suspend fun deleteChatUser(userId: String)

    @Query("DELETE FROM ChatUser")
    suspend fun deleteAllChatUsers()

    @Query("SELECT name FROM ChatUser")
    fun getNames(): LiveData<List<String>>

}
