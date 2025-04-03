package com.example.smartcare.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.smartcare.database.entity.ProfileData
import kotlinx.coroutines.flow.Flow


@Dao
interface ProfileDAO {

    @Query("SELECT * FROM ProfileData WHERE idOne = 1")
    fun getProfileSync(): ProfileData?  // ✅ Fetch single profile synchronously

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(profileData: ProfileData)  // ✅ Works in background

    @Query("DELETE FROM ProfileData WHERE idOne = 1")
    suspend fun deleteProfile()  // ✅ Works in background

    @Query("UPDATE ProfileData SET isLoggedIn = :isLoggedIn WHERE idOne = 1")
    suspend fun updateLoginState(isLoggedIn: Boolean)  // ✅ Works in background

    @Query("SELECT * FROM ProfileData WHERE idOne = 1")
    fun getProfile(): Flow<ProfileData?>  // ✅ Flow instead of LiveData (prevents crashes)

    @Query("SELECT isLoggedIn FROM ProfileData WHERE idOne = 1")
    fun checkLoginStatus(): Flow<Boolean>  // ✅ Returns Flow<Boolean> instead of Boolean

    @Query("SELECT isLoggedIn FROM ProfileData WHERE idOne = 1")
    suspend fun getLoggedInStatus(): Boolean  // ✅ Safe suspend function

    @Query("UPDATE ProfileData SET id = :id WHERE idOne = 1")
    suspend fun updateId(id: String)  // ✅ Fixed: Removed empty function body
}
