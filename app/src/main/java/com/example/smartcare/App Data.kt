package com.example.smartcare

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.smartcare.database.dao.ChatUserDAO
import com.example.smartcare.database.dao.MessageDAO
import com.example.smartcare.database.dao.ProfileDAO
import com.example.smartcare.database.dao.RideDAO
import com.example.smartcare.database.entity.ChatUser
import com.example.smartcare.database.entity.Message
import com.example.smartcare.database.entity.ProfileData
import com.example.smartcare.database.entity.Ride
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class Converters {

    @TypeConverter
    fun fromList(list: List<String>): String {
        return Json.encodeToString(list) // ✅ Convert List to JSON String
    }

    @TypeConverter
    fun toList(json: String): List<String> {
        return Json.decodeFromString(json) // ✅ Convert JSON String back to List
    }
}

@Database(entities = [ProfileData::class, Message::class, Ride::class, ChatUser::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ProfileDatabase : RoomDatabase() {

    abstract fun profileDao(): ProfileDAO
    abstract fun messageDao(): MessageDAO
    abstract fun rideDao():RideDAO
    abstract fun chatUserDao(): ChatUserDAO

    companion object {
        const val NAME = "Profile_DB"

        @Volatile
        private var INSTANCE: ProfileDatabase? = null

        fun getDatabase(context: Context): ProfileDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProfileDatabase::class.java,
                    NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}



