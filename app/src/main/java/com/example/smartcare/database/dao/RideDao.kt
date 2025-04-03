package com.example.smartcare.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.smartcare.database.entity.Ride

@Dao
interface RideDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRide(ride: Ride)

    @Update
    suspend fun updateRide(ride: Ride)

    @Delete
    suspend fun deleteRide(ride: Ride)

    @Query("SELECT * FROM Ride WHERE id = :rideId")
    suspend fun getRideById(rideId: String): Ride?

    @Query("SELECT * FROM Ride WHERE driverId = :driverId")
    fun getRidesByDriver(driverId: String): LiveData<List<Ride>>

    @Query("SELECT * FROM Ride WHERE passengerId = :passengerId")
    fun getRidesByPassenger(passengerId: String): LiveData<List<Ride>>

    @Query("SELECT * FROM Ride ORDER BY date DESC, time DESC")
    fun getAllRides(): LiveData<List<Ride>>

    @Query("UPDATE Ride SET status = :newStatus WHERE id = :rideId")
    suspend fun updateRideStatus(rideId: String, newStatus: String)

    @Query("UPDATE Ride SET rating = :newRating, review = :newReview WHERE id = :rideId")
    suspend fun updateRideRating(rideId: String, newRating: Double, newReview: String)
}
