package com.example.smartcare.Hospitals

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hospital(
    var id: String,
    var name: String,
    var cityId: String,
    var specialties: List<String>,
    val rating: Float,
    var district: String,
    var distance: String,
    var reviewCount: String,
    var openingHours: String,
    // Other fields
) : Parcelable