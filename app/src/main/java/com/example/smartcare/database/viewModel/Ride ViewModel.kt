package com.example.smartcare.database.viewModel

import androidx.lifecycle.*
import com.example.smartcare.database.RideDTO
import com.example.smartcare.database.dao.ProfileDAO
import com.example.smartcare.database.dao.RideDAO
import com.example.smartcare.database.entity.Ride
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class RideViewModelFactory(private val dao: RideDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RideViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RideViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


class RideViewModel(private val rideDAO: RideDAO) : ViewModel() {


    val allRides: LiveData<List<Ride>> = rideDAO.getAllRides()

    fun doesRideExist(rideId: String): Boolean {
        return rideDAO.doesRideExist(rideId)
    }

    fun insertRide(ride: Ride) {
        viewModelScope.launch(Dispatchers.IO) {
            rideDAO.insertRide(ride)
        }
    }

    fun updateRide(ride: Ride) {
        viewModelScope.launch(Dispatchers.IO) {
            rideDAO.updateRide(ride)
        }
    }

    fun deleteRide(ride: Ride) {
        viewModelScope.launch(Dispatchers.IO) {
            rideDAO.deleteRide(ride)
        }
    }

    fun updateRideStatus(rideId: String, newStatus: String) {
        viewModelScope.launch(Dispatchers.IO) {
            rideDAO.updateRideStatus(rideId, newStatus)
        }
    }

    fun updateRideRating(rideId: String, newRating: Double, newReview: String) {
        viewModelScope.launch(Dispatchers.IO) {
            rideDAO.updateRideRating(rideId, newRating, newReview)
        }
    }
    private val firestore = FirebaseFirestore.getInstance()
    private val ridesCollection = firestore.collection("rides")
    fun syncRidesFromCloud() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // ✅ Fetch rides from Firestore
                val snapshot = ridesCollection.get().await()
                val cloudRides = snapshot.documents.mapNotNull { it.toObject(RideDTO::class.java)?.toRide() }

                // ✅ Fetch rides from Local Database
                val localRides = rideDAO.getAllRides().value // This must be a suspend function

                // ✅ Convert to a Map for Quick Lookup
                val localRideMap = localRides?.associateBy { it.id }

                val ridesToInsertOrUpdate = mutableListOf<Ride>()

                for (ride in cloudRides) {
                    val existingRide = localRideMap?.get(ride.id)

                    if (existingRide == null || existingRide != ride) {
                        // ✅ Insert if not exists OR Update if different
                        ridesToInsertOrUpdate.add(ride)
                    }
                }

                // ✅ Bulk Insert/Update in RoomDB
                if (ridesToInsertOrUpdate.isNotEmpty()) {
                    rideDAO.insertOrUpdateAll(ridesToInsertOrUpdate)
                }

            } catch (e: Exception) {
            }
        }
    }

    fun saveRide(ride: Ride, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val rideDTO = RideDTO.fromRide(ride) // ✅ Convert Ride -> RideDTO

            ridesCollection.document(ride.id) // ✅ Use ride ID as document ID
                .set(rideDTO)
                .addOnSuccessListener { onSuccess() }
                .addOnFailureListener { exception -> onFailure(exception) }
        }
    }


    fun getRideById(rideId: String, onSuccess: (Ride?) -> Unit, onFailure: (Exception) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            ridesCollection.document(rideId)
                .get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
                        try {
                            val rideDTO = document.toObject(RideDTO::class.java)
                            if (rideDTO != null) {
                                onSuccess(rideDTO.toRide()) // ✅ Safe conversion
                            } else {
                                onSuccess(null) // ✅ Return null if conversion fails
                            }
                        } catch (e: Exception) {
                            onFailure(e) // ✅ Handle JSON conversion issues
                        }
                    } else {
                        onSuccess(null) // ✅ Return null if no document found
                    }
                }
                .addOnFailureListener { exception -> onFailure(exception) }
        }
    }


    /** ✅ Fetch All Rides */
    fun getAllRides(onSuccess: (List<Ride>) -> Unit, onFailure: (Exception) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            ridesCollection.get()
                .addOnSuccessListener { result ->
                    val rides = result.documents.mapNotNull {
                        it.toObject(RideDTO::class.java)?.toRide()
                    } // ✅ Convert DTO -> Ride
                    onSuccess(rides)
                }
                .addOnFailureListener { exception -> onFailure(exception) }
        }
    }
}

