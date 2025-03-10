package com.example.smartcare

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Entity
data class ProfileData(
    @PrimaryKey val id: Int = 1, // Fixed ID for single row
    var name: String = "Enter name",
    var age: Int = 0,
    var gender: String = "Enter gender",
    var height: Int = 0,
    var weight: Int = 0,
    var bloodGroup: String = "Enter Blood Group",
    var address: String = "Enter Address",
    var contact: String = "Enter Contact Name",
    var email: String = "Enter email",
    var profilePic: String? = null,
    var isCompleted: Boolean = false, // Use this field for profile completion state
    var isLoggedIn: Boolean  // Determines if user is logged in
)

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

@Entity
data class AppointmentLists(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val doctorName: String,
    val doctorImageUrl: String,  // ✅ Store the image URL instead of the actual image
    val date: String,
    val time: String,
    val reason: String,
    val status: String,
    val isCompleted: Boolean = false,
    val hospitalDataIndex: Int,
    val hospitalIndex:Int,
    val doctorIndex:Int,
    val appointmentIndex:Int
)

@Entity
data class MedicalRecord(
    @PrimaryKey(autoGenerate = true) val recordId: Int = 0,
    val userId: Int, // Links to ProfileData
    val recordType: String, // Example: "Prescription", "Lab Report"
    val date: String,
    val notes: String,
    val notesImageUrl: List<String>
)

@Dao
interface AppointmentDAO {

    @Query("SELECT * FROM AppointmentLists")
    fun getAllAppointments(): Flow<List<AppointmentLists>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAppointment(appointment: AppointmentLists)

    @Query("DELETE FROM AppointmentLists WHERE id = :id")
    suspend fun cancelAppointment(id: Int)

    @Query("UPDATE AppointmentLists SET isCompleted = :isCompleted WHERE id = :id")
    suspend fun updateAppointmentStatus(id: Int, isCompleted: Boolean)

    @Query("SELECT * FROM AppointmentLists WHERE id = :id")
    fun getAppointmentById(id: Int): Flow<AppointmentLists?>

    @Query("SELECT * FROM AppointmentLists WHERE isCompleted = 1")
    fun getCompletedAppointments(): Flow<List<AppointmentLists>>

    @Query("SELECT * FROM AppointmentLists WHERE isCompleted = 0")
    fun getPendingAppointments(): Flow<List<AppointmentLists>>

    @Query("SELECT * FROM AppointmentLists WHERE status = :status")
    fun getAppointmentsByStatus(status: String): Flow<List<AppointmentLists>>
}

@Dao
interface MedicalRecordDAO {

    @Query("SELECT * FROM MedicalRecord WHERE userId = :userId")
    fun getMedicalRecordsForUser(userId: Int): Flow<List<MedicalRecord>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedicalRecord(record: MedicalRecord)

    @Delete
    suspend fun deleteMedicalRecord(record: MedicalRecord)

    @Query("UPDATE MedicalRecord SET notes = :notes WHERE recordId = :recordId")
    suspend fun updateMedicalRecordNotes(recordId: Int, notes: String)
}

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

@Database(entities = [ProfileData::class, AppointmentLists::class, MedicalRecord::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ProfileDatabase : RoomDatabase() {

    abstract fun profileDao(): ProfileDAO
    abstract fun appointmentDao(): AppointmentDAO
    abstract fun medicalRecordDao(): MedicalRecordDAO

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



