package com.example.smartcare.database.viewModel

import androidx.lifecycle.*
import com.example.smartcare.database.dao.ProfileDAO
import com.example.smartcare.database.dao.RideDAO
import com.example.smartcare.database.entity.Ride
import kotlinx.coroutines.launch


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

    fun getRidesByDriver(driverId: String): LiveData<List<Ride>> {
        return rideDAO.getRidesByDriver(driverId)
    }

    fun getRidesByPassenger(passengerId: String): LiveData<List<Ride>> {
        return rideDAO.getRidesByPassenger(passengerId)
    }

    fun insertRide(ride: Ride) {
        viewModelScope.launch {
            rideDAO.insertRide(ride)
        }
    }

    fun updateRide(ride: Ride) {
        viewModelScope.launch {
            rideDAO.updateRide(ride)
        }
    }

    fun deleteRide(ride: Ride) {
        viewModelScope.launch {
            rideDAO.deleteRide(ride)
        }
    }

    fun updateRideStatus(rideId: String, newStatus: String) {
        viewModelScope.launch {
            rideDAO.updateRideStatus(rideId, newStatus)
        }
    }

    fun updateRideRating(rideId: String, newRating: Double, newReview: String) {
        viewModelScope.launch {
            rideDAO.updateRideRating(rideId, newRating, newReview)
        }
    }
}
