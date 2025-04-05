package com.example.smartcare.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ride(
    @PrimaryKey var id: String,
    var driverId: String,
    var passengerId: String,
    var noOfPassenger: Int,

    var pickupLocationName: String,

    var destinationName: String,

    var middleStops: List<Stop>,

    var date: String,
    var time: String,
    var status: String,
    var price: Double,
    var rating: Double,
    var review: String,
    var paymentMethod: String,
    var paymentStatus: String,
    var rideType: String,
)
data class Stop(
    val stopName: String,
    val lat: Double,
    val lng: Double
)
