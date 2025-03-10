package com.example.smartcare.Hospitals

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Doctor(
    val name : String,
    val age : Int,
    val specialization : MutableList<String>,
    val experience : Int,
    val rating : Double,
    var appointments:  MutableList<Boolean>,
    var localAppointments : Int
) : Parcelable

