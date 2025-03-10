package com.example.smartcare.Hospitals

data class HospitalsData(
    val cityName: String,
    val hospitals: MutableList<Hospital>
)

var allHospitalData:MutableList<HospitalsData> = mutableListOf(
    HospitalsData(
        cityName = "Bagalkot",
        hospitals =  mutableListOf(
            Hospital(
                id = "1",
                name = "City General Hospital",
                cityId = "Bagalkot",
                specialties = mutableListOf("Cardiologist", "Ortho"),
                rating = 1.5f,
                district = "Bagalkot",
                distance = "5",
                reviewCount = "1.2k reviews",
                openingHours = "08:30 PM",
                doctors = mutableListOf(
                    Doctor(
                        name = "Shekhar Dev",
                        age = 34,
                        specialization = mutableListOf("Cardiologist", "General Physician"),
                        experience = 23,
                        rating = 3.8,
                        appointments = mutableListOf(
                            false, true, true, false,
                            true,true, true, true,
                            false, false, true, false,
                            false, true, true, false,
                            true,true, true, true,
                            false, false, true, false,
                            false, true, true, false,
                            true,true, true, false),
                        localAppointments = 8
                    )
                ),
                phone = "+91 9684579425"
            )
        )))