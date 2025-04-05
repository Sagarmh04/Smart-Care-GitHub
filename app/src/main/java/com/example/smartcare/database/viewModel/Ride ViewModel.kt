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
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt


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

    fun getRideById(rideId: String): LiveData<Ride?> {
        return liveData {
            val ride = rideDAO.getRideById(rideId)
            emit(ride)
        }
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



}

data class LocationData(val name: String, val lat: Double, val lng: Double)
