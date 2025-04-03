package com.example.smartcare.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

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