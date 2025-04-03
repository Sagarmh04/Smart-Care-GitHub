package com.example.smartcare.database.viewModel

import com.example.smartcare.database.RideDTO
import com.example.smartcare.database.entity.Ride
import com.google.firebase.firestore.FirebaseFirestore

class RideRepository {
    private val firestore = FirebaseFirestore.getInstance()
    private val ridesCollection = firestore.collection("rides")

    /** ✅ Save Ride to Firestore */
    fun saveRide(ride: Ride, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        val rideDTO = RideDTO.fromRide(ride) // Convert Ride -> RideDTO

        ridesCollection.document(ride.id) // Use ride ID as document ID
            .set(rideDTO)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener { exception ->
                onFailure(exception)
            }
    }

    /** ✅ Fetch Ride by ID */
    fun getRideById(rideId: String, onSuccess: (Ride?) -> Unit, onFailure: (Exception) -> Unit) {
        ridesCollection.document(rideId)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val rideDTO = document.toObject(RideDTO::class.java)
                    onSuccess(rideDTO?.toRide()) // Convert DTO back to Ride
                } else {
                    onSuccess(null) // No ride found
                }
            }
            .addOnFailureListener { exception ->
                onFailure(exception)
            }
    }
}
