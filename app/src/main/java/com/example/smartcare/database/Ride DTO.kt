package com.example.smartcare.database

import com.example.smartcare.database.entity.Ride
import com.example.smartcare.database.entity.Stop
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
data class RideDTO(
    val id: String = "",
    val driverId: String = "",
    val passengerId: String = "",
    val noOfPassenger: Int = 0,

    val pickupLocationName: String = "",

    val destinationName: String = "",

    val middleStops: List<StopDTO> = emptyList(),

    val date: String = "",
    val time: String = "",
    val status: String = "",
    val price: Double = 0.0,
    val rating: Double = 0.0,
    val review: String = "",
    val paymentMethod: String = "",
    val paymentStatus: String = "",
    val rideType: String = ""
)

data class StopDTO(
    val stopName: String = "",
    val lat: Double = 0.0,
    val lng: Double = 0.0
)
