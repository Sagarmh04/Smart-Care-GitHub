package com.example.smartcare.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ride(
    @PrimaryKey var id: String,
    var driverId: String,
    var passengerId: String,
    var pickupLocation: String,
    var destination: String,
    var date: String,
    var time: String,
    var middleStops : List<String>,
    var status: String,
    var price: Double,
    var rating: Double,
    var review: String,
    var paymentMethod: String,
    var paymentStatus: String,
    var rideType: String,
)