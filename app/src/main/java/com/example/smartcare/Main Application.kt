package com.example.smartcare

import android.app.Application
import androidx.room.Room

class MainApplication : Application() {
    companion object {
        lateinit var profileDatabase: ProfileDatabase
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
    }
}



