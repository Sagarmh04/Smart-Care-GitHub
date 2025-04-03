package com.example.smartcare.database

import com.example.smartcare.database.entity.Ride

data class RideDTO(
    var id: String = "",
    var driverId: String = "",
    var passengerId: String = "",
    var pickupLocation: String = "",
    var destination: String = "",
    var date: String = "",
    var time: String = "",
    var middleStops: List<String> = emptyList(), // ✅ Firestore supports this
    var status: String = "",
    var price: Double = 0.0,
    var rating: Double = 0.0,
    var review: String = "",
    var paymentMethod: String = "",
    var paymentStatus: String = "",
    var rideType: String = ""
) {
    companion object {
        fun fromRide(ride: Ride): RideDTO {
            return RideDTO(
                id = ride.id,
                driverId = ride.driverId,
                passengerId = ride.passengerId,
                pickupLocation = ride.pickupLocation,
                destination = ride.destination,
                date = ride.date,
                time = ride.time,
                middleStops = ride.middleStops.toList(), // ✅ Ensure it's a Firestore-compatible List
                status = ride.status,
                price = ride.price,
                rating = ride.rating,
                review = ride.review,
                paymentMethod = ride.paymentMethod,
                paymentStatus = ride.paymentStatus,
                rideType = ride.rideType
            )
        }
    }

    fun toRide(): Ride {
        return Ride(
            id = id,
            driverId = driverId,
            passengerId = passengerId,
            pickupLocation = pickupLocation,
            destination = destination,
            date = date,
            time = time,
            middleStops = middleStops ?: emptyList(), // ✅ Handle potential null values
            status = status,
            price = price,
            rating = rating,
            review = review,
            paymentMethod = paymentMethod,
            paymentStatus = paymentStatus,
            rideType = rideType
        )
    }
}

