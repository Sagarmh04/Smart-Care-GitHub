package com.example.smartcare.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.smartcare.database.entity.ProfileData


@Dao
interface ProfileDAO {

    @Query("SELECT * FROM ProfileData WHERE id = 1")
    fun getProfileSync(): ProfileData?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(profileData: ProfileData) // 🔹 Now suspend

    @Query("DELETE FROM ProfileData WHERE id = 1")
    suspend fun deleteProfile() // 🔹 Now suspend

    @Query("UPDATE ProfileData SET isLoggedIn = :isLoggedIn WHERE id = 1")
    suspend fun updateLoginState(isLoggedIn: Boolean) // 🔹 Now suspend

    @Query("SELECT * FROM ProfileData WHERE id = 1")
    fun getProfile(): LiveData<ProfileData>

    @Query("SELECT isLoggedIn FROM ProfileData WHERE id = 1")
    fun checkLoginStatus(): LiveData<Boolean> // 🔹 Now suspend
}