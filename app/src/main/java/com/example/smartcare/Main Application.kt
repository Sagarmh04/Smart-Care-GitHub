package com.example.smartcare

import android.app.Application
import androidx.room.Room
import com.example.smartcare.database.entity.Message
import com.google.firebase.FirebaseApp

class MainApplication : Application() {
    companion object {
        lateinit var profileDatabase: ProfileDatabase
        lateinit var messageDatabase: ProfileDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()
        profileDatabase = Room.databaseBuilder(
            applicationContext,
            ProfileDatabase::class.java,
            ProfileDatabase.NAME
        ).fallbackToDestructiveMigration()
            .build()
        FirebaseApp.initializeApp(this)
    }
}



