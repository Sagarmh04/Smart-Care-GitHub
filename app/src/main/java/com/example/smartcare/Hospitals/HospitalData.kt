package com.example.smartcare.Hospitals

object HospitalData {
    val hospitals = listOf(
        Hospital(
            id = "1",
            name = "City General Hospital",
            cityId = "BENGALURU",
            district = "Central",
            specialties = listOf("Cardiology", "Orthopedics"),
            rating = 4.8f,
            reviewCount = "1.5k",
            distance = "1.2",
            openingHours = "Open until 20:00"

        ),
    )
}