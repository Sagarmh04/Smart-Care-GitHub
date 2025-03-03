package com.example.smartcare.Hospitals

data class HospitalsData(
    val cityName: String,
    val hospitals: List<Hospital>
)

val allHospitalData:List<HospitalsData> = listOf(
    HospitalsData(
        cityName = "Bagalkot",
        hospitals =  listOf(
            Hospital(
                id = "1",
                name = "City General Hospital",
                cityId = "Bagalkot",
                specialties = listOf("Cardiologist","Ortho"),
                rating = 1.5f,
                district = "Bagalkot",
                distance = "1.6 km",
                reviewCount = "1.2k",
                openingHours = "Opens 10:00 AM"
            )
        )))