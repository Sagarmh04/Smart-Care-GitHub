package com.example.smartcare.Hospitals

var selectedCityName:String = "Bagalkot"

data class HospitalsData(
    val cityName: String,
    val hospitals: MutableList<Hospital>
)

var allHospitalData:MutableList<HospitalsData> = mutableListOf(
    HospitalsData(
        cityName = "Bagalkot",
        hospitals =  mutableListOf(
            Hospital(
                id = "H1",
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
        )),
        HospitalsData(
            cityName = "Badami",
            hospitals = mutableListOf(
                Hospital(
                    id = "H1",
                    name = "Badami General Hospital",
                    cityId = "Badami",
                    specialties = mutableListOf("Cardiology", "Orthopedics", "General Medicine"),
                    rating = 4.2f,
                    district = "Bagalkot",
                    distance = "2.5",
                    reviewCount = "1.8k reviews",
                    openingHours = "08:00 AM - 08:00 PM",
                    phone = "+91 9876543210",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Rajesh Kumar",
                            age = 45,
                            specialization = mutableListOf("Cardiology", "General Physician"),
                            experience = 20,
                            rating = 4.5,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 12
                        ),
                        Doctor(
                            name = "Dr. Priya Singh",
                            age = 38,
                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
                            experience = 13,
                            rating = 4.1,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 8
                        ),
                        Doctor(
                            name = "Dr. Anil Desai",
                            age = 50,
                            specialization = mutableListOf("General Medicine", "Diabetology"),
                            experience = 25,
                            rating = 4.3,
                            appointments = mutableListOf(
                                true, true, true, true, false, false, false, false,
                                false, false, false, false, true, true, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 15
                        )
                    )
                ),
                Hospital(
                    id = "H2",
                    name = "City Care Clinic",
                    cityId = "Badami",
                    specialties = mutableListOf("Pediatrics", "Dermatology"),
                    rating = 3.9f,
                    district = "Bagalkot",
                    distance = "1.2",
                    reviewCount = "2.4k reviews",
                    openingHours = "09:00 AM - 07:00 PM",
                    phone = "+91 8765123456",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Sunita Reddy",
                            age = 42,
                            specialization = mutableListOf("Pediatrics", "Neonatology"),
                            experience = 17,
                            rating = 4.7,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, true, true, false, false, false, false,
                                false, false, false, false, true, true, true, true
                            ),
                            localAppointments = 10
                        ),
                        Doctor(
                            name = "Dr. Arjun Malhotra",
                            age = 47,
                            specialization = mutableListOf("Dermatology", "Cosmetology"),
                            experience = 22,
                            rating = 4.0,
                            appointments = mutableListOf(
                                false, true, true, false, false, true, true, false,
                                true, false, false, true, true, false, false, true,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 7
                        ),
                        Doctor(
                            name = "Dr. Nandini Sharma",
                            age = 35,
                            specialization = mutableListOf("General Physician", "Nutrition"),
                            experience = 10,
                            rating = 3.8,
                            appointments = mutableListOf(
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 9
                        )
                    )
                ),
                // 3 more hospitals with similar structure
                Hospital(
                    id = "H3",
                    name = "Sunrise Medical Center",
                    cityId = "Badami",
                    specialties = mutableListOf("Neurology", "Psychiatry"),
                    rating = 4.5f,
                    district = "Bagalkot",
                    distance = "3.8",
                    reviewCount = "900 reviews",
                    openingHours = "24/7 Emergency",
                    phone = "+91 7654321890",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Vikram Joshi",
                            age = 55,
                            specialization = mutableListOf("Neurology", "Stroke Care"),
                            experience = 30,
                            rating = 4.9,
                            appointments = mutableListOf(
                                true, true, true, true, true, true, true, true,
                                false, false, false, false, false, false, false, false,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 18
                        ),
                        Doctor(
                            name = "Dr. Meera Krishnan",
                            age = 39,
                            specialization = mutableListOf("Psychiatry", "Counseling"),
                            experience = 14,
                            rating = 4.4,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 11
                        ),
                        Doctor(
                            name = "Dr. Sanjay Gupta",
                            age = 44,
                            specialization = mutableListOf("Sleep Medicine", "Pain Management"),
                            experience = 19,
                            rating = 4.2,
                            appointments = mutableListOf(
                                true, false, false, true, true, false, false, true,
                                false, true, true, false, false, true, true, false,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 6
                        )
                    )
                ),
                Hospital(
                    id = "H4",
                    name = "Women's Wellness Hub",
                    cityId = "Badami",
                    specialties = mutableListOf("Gynecology", "Obstetrics"),
                    rating = 4.6f,
                    district = "Bagalkot",
                    distance = "4.3",
                    reviewCount = "2.1k reviews",
                    openingHours = "07:00 AM - 10:00 PM",
                    phone = "+91 8989898989",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Anjali Rao",
                            age = 37,
                            specialization = mutableListOf("Gynecology", "Infertility"),
                            experience = 12,
                            rating = 4.8,
                            appointments = mutableListOf(
                                true, true, true, false, false, false, true, true,
                                false, false, true, true, true, true, false, false,
                                true, false, false, true, true, false, false, true,
                                false, true, true, false, false, true, true, false
                            ),
                            localAppointments = 14
                        ),
                        Doctor(
                            name = "Dr. Kavita Patel",
                            age = 51,
                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
                            experience = 26,
                            rating = 4.7,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, false, false, true, true, true, true,
                                true, true, true, true, false, false, false, false
                            ),
                            localAppointments = 9
                        ),
                        Doctor(
                            name = "Dr. Rohan Mehra",
                            age = 43,
                            specialization = mutableListOf("Fertility", "Endocrinology"),
                            experience = 18,
                            rating = 4.5,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 13
                        )
                    )
                ),
                Hospital(
                    id = "H5",
                    name = "Emergency Trauma Center",
                    cityId = "Badami",
                    specialties = mutableListOf("Emergency Medicine", "Critical Care"),
                    rating = 4.8f,
                    district = "Bagalkot",
                    distance = "0.5",
                    reviewCount = "3.5k reviews",
                    openingHours = "24/7 Emergency",
                    phone = "+91 9090909090",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Akash Bannerjee",
                            age = 48,
                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
                            experience = 23,
                            rating = 4.9,
                            appointments = mutableListOf(
                                true, true, true, true, true, true, true, true,
                                true, true, true, true, true, true, true, true,
                                true, true, true, true, true, true, true, true,
                                true, true, true, true, true, true, true, true
                            ),
                            localAppointments = 20
                        ),
                        Doctor(
                            name = "Dr. Neha Chopra",
                            age = 36,
                            specialization = mutableListOf("Critical Care", "Pulmonology"),
                            experience = 11,
                            rating = 4.6,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 16
                        ),
                        Doctor(
                            name = "Dr. Ravi Shastri",
                            age = 53,
                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
                            experience = 28,
                            rating = 4.7,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 19
                        )
                    )
                )
            )
        ),
        HospitalsData(
            cityName = "Ilkal",
            hospitals = mutableListOf(
                Hospital(
                    id = "H1",
                    name = "Ilkal General Hospital",
                    cityId = "Ilkal",
                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
                    rating = 4.0f,
                    district = "Bagalkot",
                    distance = "1.5",
                    reviewCount = "1.3k reviews",
                    openingHours = "08:00 AM - 08:00 PM",
                    phone = "+91 9876543210",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Rajeshwar Rao",
                            age = 47,
                            specialization = mutableListOf("General Medicine", "Diabetology"),
                            experience = 22,
                            rating = 4.2,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 10
                        ),
                        Doctor(
                            name = "Dr. Ananya Desai",
                            age = 35,
                            specialization = mutableListOf("Cardiology", "Hypertension"),
                            experience = 10,
                            rating = 4.1,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 8
                        ),
                        Doctor(
                            name = "Dr. Vikram Singh",
                            age = 50,
                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
                            experience = 25,
                            rating = 4.4,
                            appointments = mutableListOf(
                                true, true, true, true, false, false, false, false,
                                false, false, false, false, true, true, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 12
                        )
                    )
                ),
                Hospital(
                    id = "H2",
                    name = "Ilkal Women's Health Center",
                    cityId = "Ilkal",
                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
                    rating = 4.3f,
                    district = "Bagalkot",
                    distance = "2.0",
                    reviewCount = "1.7k reviews",
                    openingHours = "09:00 AM - 07:00 PM",
                    phone = "+91 8765432109",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Priya Reddy",
                            age = 40,
                            specialization = mutableListOf("Gynecology", "Infertility"),
                            experience = 15,
                            rating = 4.5,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 9
                        ),
                        Doctor(
                            name = "Dr. Arjun Malhotra",
                            age = 45,
                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
                            experience = 20,
                            rating = 4.6,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 11
                        ),
                        Doctor(
                            name = "Dr. Nandini Sharma",
                            age = 38,
                            specialization = mutableListOf("Pediatrics", "Neonatology"),
                            experience = 12,
                            rating = 4.3,
                            appointments = mutableListOf(
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 7
                        )
                    )
                ),
                Hospital(
                    id = "H3",
                    name = "Ilkal Ortho Care",
                    cityId = "Ilkal",
                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
                    rating = 4.1f,
                    district = "Bagalkot",
                    distance = "3.2",
                    reviewCount = "1.1k reviews",
                    openingHours = "08:30 AM - 07:30 PM",
                    phone = "+91 7654321098",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Sanjay Gupta",
                            age = 52,
                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
                            experience = 27,
                            rating = 4.4,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 14
                        ),
                        Doctor(
                            name = "Dr. Meera Krishnan",
                            age = 39,
                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
                            experience = 14,
                            rating = 4.2,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 8
                        ),
                        Doctor(
                            name = "Dr. Rohan Mehra",
                            age = 44,
                            specialization = mutableListOf("Pain Management", "Spine Care"),
                            experience = 18,
                            rating = 4.3,
                            appointments = mutableListOf(
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 10
                        )
                    )
                ),
                Hospital(
                    id = "H4",
                    name = "Ilkal Eye Care Center",
                    cityId = "Ilkal",
                    specialties = mutableListOf("Ophthalmology", "Optometry"),
                    rating = 4.5f,
                    district = "Bagalkot",
                    distance = "2.8",
                    reviewCount = "1.9k reviews",
                    openingHours = "09:00 AM - 06:00 PM",
                    phone = "+91 6543210987",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Anjali Rao",
                            age = 37,
                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
                            experience = 12,
                            rating = 4.7,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 9
                        ),
                        Doctor(
                            name = "Dr. Kavita Patel",
                            age = 51,
                            specialization = mutableListOf("Optometry", "Contact Lenses"),
                            experience = 26,
                            rating = 4.6,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 11
                        ),
                        Doctor(
                            name = "Dr. Ravi Shastri",
                            age = 53,
                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
                            experience = 28,
                            rating = 4.8,
                            appointments = mutableListOf(
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 13
                        )
                    )
                ),
                Hospital(
                    id = "H5",
                    name = "Ilkal Emergency Care",
                    cityId = "Ilkal",
                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
                    rating = 4.7f,
                    district = "Bagalkot",
                    distance = "0.8",
                    reviewCount = "2.5k reviews",
                    openingHours = "24/7 Emergency",
                    phone = "+91 9090909090",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Akash Bannerjee",
                            age = 48,
                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
                            experience = 23,
                            rating = 4.9,
                            appointments = mutableListOf(
                                true, true, true, true, true, true, true, true,
                                true, true, true, true, true, true, true, true,
                                true, true, true, true, true, true, true, true,
                                true, true, true, true, true, true, true, true
                            ),
                            localAppointments = 20
                        ),
                        Doctor(
                            name = "Dr. Neha Chopra",
                            age = 36,
                            specialization = mutableListOf("Critical Care", "Pulmonology"),
                            experience = 11,
                            rating = 4.6,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 16
                        ),
                        Doctor(
                            name = "Dr. Ravi Shastri",
                            age = 53,
                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
                            experience = 28,
                            rating = 4.7,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 19
                        )
                    )
                )
            )
        )
        ,
        HospitalsData(
            cityName = "Jamkhandi",
            hospitals = mutableListOf(
                Hospital(
                    id = "H1",
                    name = "Jamkhandi General Hospital",
                    cityId = "Jamkhandi",
                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
                    rating = 4.1f,
                    district = "Bagalkot",
                    distance = "1.2",
                    reviewCount = "1.4k reviews",
                    openingHours = "08:00 AM - 08:00 PM",
                    phone = "+91 9876543210",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Rajeshwar Rao",
                            age = 47,
                            specialization = mutableListOf("General Medicine", "Diabetology"),
                            experience = 22,
                            rating = 4.2,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 10
                        ),
                        Doctor(
                            name = "Dr. Ananya Desai",
                            age = 35,
                            specialization = mutableListOf("Cardiology", "Hypertension"),
                            experience = 10,
                            rating = 4.1,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 8
                        ),
                        Doctor(
                            name = "Dr. Vikram Singh",
                            age = 50,
                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
                            experience = 25,
                            rating = 4.4,
                            appointments = mutableListOf(
                                true, true, true, true, false, false, false, false,
                                false, false, false, false, true, true, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 12
                        )
                    )
                ),
                Hospital(
                    id = "H2",
                    name = "Jamkhandi Women's Health Center",
                    cityId = "Jamkhandi",
                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
                    rating = 4.3f,
                    district = "Bagalkot",
                    distance = "2.5",
                    reviewCount = "1.6k reviews",
                    openingHours = "09:00 AM - 07:00 PM",
                    phone = "+91 8765432109",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Priya Reddy",
                            age = 40,
                            specialization = mutableListOf("Gynecology", "Infertility"),
                            experience = 15,
                            rating = 4.5,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 9
                        ),
                        Doctor(
                            name = "Dr. Arjun Malhotra",
                            age = 45,
                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
                            experience = 20,
                            rating = 4.6,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 11
                        ),
                        Doctor(
                            name = "Dr. Nandini Sharma",
                            age = 38,
                            specialization = mutableListOf("Pediatrics", "Neonatology"),
                            experience = 12,
                            rating = 4.3,
                            appointments = mutableListOf(
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 7
                        )
                    )
                ),
                Hospital(
                    id = "H3",
                    name = "Jamkhandi Ortho Care",
                    cityId = "Jamkhandi",
                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
                    rating = 4.2f,
                    district = "Bagalkot",
                    distance = "3.0",
                    reviewCount = "1.2k reviews",
                    openingHours = "08:30 AM - 07:30 PM",
                    phone = "+91 7654321098",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Sanjay Gupta",
                            age = 52,
                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
                            experience = 27,
                            rating = 4.4,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 14
                        ),
                        Doctor(
                            name = "Dr. Meera Krishnan",
                            age = 39,
                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
                            experience = 14,
                            rating = 4.2,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 8
                        ),
                        Doctor(
                            name = "Dr. Rohan Mehra",
                            age = 44,
                            specialization = mutableListOf("Pain Management", "Spine Care"),
                            experience = 18,
                            rating = 4.3,
                            appointments = mutableListOf(
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 10
                        )
                    )
                ),
                Hospital(
                    id = "H4",
                    name = "Jamkhandi Eye Care Center",
                    cityId = "Jamkhandi",
                    specialties = mutableListOf("Ophthalmology", "Optometry"),
                    rating = 4.5f,
                    district = "Bagalkot",
                    distance = "2.7",
                    reviewCount = "1.8k reviews",
                    openingHours = "09:00 AM - 06:00 PM",
                    phone = "+91 6543210987",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Anjali Rao",
                            age = 37,
                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
                            experience = 12,
                            rating = 4.7,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 9
                        ),
                        Doctor(
                            name = "Dr. Kavita Patel",
                            age = 51,
                            specialization = mutableListOf("Optometry", "Contact Lenses"),
                            experience = 26,
                            rating = 4.6,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 11
                        ),
                        Doctor(
                            name = "Dr. Ravi Shastri",
                            age = 53,
                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
                            experience = 28,
                            rating = 4.8,
                            appointments = mutableListOf(
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 13
                        )
                    )
                ),
                Hospital(
                    id = "H5",
                    name = "Jamkhandi Emergency Care",
                    cityId = "Jamkhandi",
                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
                    rating = 4.7f,
                    district = "Bagalkot",
                    distance = "0.9",
                    reviewCount = "2.3k reviews",
                    openingHours = "24/7 Emergency",
                    phone = "+91 9090909090",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Akash Bannerjee",
                            age = 48,
                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
                            experience = 23,
                            rating = 4.9,
                            appointments = mutableListOf(
                                true, true, true, true, true, true, true, true,
                                true, true, true, true, true, true, true, true,
                                true, true, true, true, true, true, true, true,
                                true, true, true, true, true, true, true, true
                            ),
                            localAppointments = 20
                        ),
                        Doctor(
                            name = "Dr. Neha Chopra",
                            age = 36,
                            specialization = mutableListOf("Critical Care", "Pulmonology"),
                            experience = 11,
                            rating = 4.6,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 16
                        ),
                        Doctor(
                            name = "Dr. Ravi Shastri",
                            age = 53,
                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
                            experience = 28,
                            rating = 4.7,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 19
                        )
                    )
                )
            )
        )
        ,
        HospitalsData(
            cityName = "Mudhol",
            hospitals = mutableListOf(
                Hospital(
                    id = "H1",
                    name = "Mudhol General Hospital",
                    cityId = "Mudhol",
                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
                    rating = 4.0f,
                    district = "Bagalkot",
                    distance = "1.0",
                    reviewCount = "1.5k reviews",
                    openingHours = "08:00 AM - 08:00 PM",
                    phone = "+91 9876543210",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Rajeshwar Rao",
                            age = 47,
                            specialization = mutableListOf("General Medicine", "Diabetology"),
                            experience = 22,
                            rating = 4.2,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 10
                        ),
                        Doctor(
                            name = "Dr. Ananya Desai",
                            age = 35,
                            specialization = mutableListOf("Cardiology", "Hypertension"),
                            experience = 10,
                            rating = 4.1,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 8
                        ),
                        Doctor(
                            name = "Dr. Vikram Singh",
                            age = 50,
                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
                            experience = 25,
                            rating = 4.4,
                            appointments = mutableListOf(
                                true, true, true, true, false, false, false, false,
                                false, false, false, false, true, true, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 12
                        )
                    )
                ),
                Hospital(
                    id = "H2",
                    name = "Mudhol Women's Health Center",
                    cityId = "Mudhol",
                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
                    rating = 4.3f,
                    district = "Bagalkot",
                    distance = "2.2",
                    reviewCount = "1.7k reviews",
                    openingHours = "09:00 AM - 07:00 PM",
                    phone = "+91 8765432109",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Priya Reddy",
                            age = 40,
                            specialization = mutableListOf("Gynecology", "Infertility"),
                            experience = 15,
                            rating = 4.5,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 9
                        ),
                        Doctor(
                            name = "Dr. Arjun Malhotra",
                            age = 45,
                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
                            experience = 20,
                            rating = 4.6,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 11
                        ),
                        Doctor(
                            name = "Dr. Nandini Sharma",
                            age = 38,
                            specialization = mutableListOf("Pediatrics", "Neonatology"),
                            experience = 12,
                            rating = 4.3,
                            appointments = mutableListOf(
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 7
                        )
                    )
                ),
                Hospital(
                    id = "H3",
                    name = "Mudhol Ortho Care",
                    cityId = "Mudhol",
                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
                    rating = 4.2f,
                    district = "Bagalkot",
                    distance = "3.5",
                    reviewCount = "1.1k reviews",
                    openingHours = "08:30 AM - 07:30 PM",
                    phone = "+91 7654321098",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Sanjay Gupta",
                            age = 52,
                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
                            experience = 27,
                            rating = 4.4,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 14
                        ),
                        Doctor(
                            name = "Dr. Meera Krishnan",
                            age = 39,
                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
                            experience = 14,
                            rating = 4.2,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 8
                        ),
                        Doctor(
                            name = "Dr. Rohan Mehra",
                            age = 44,
                            specialization = mutableListOf("Pain Management", "Spine Care"),
                            experience = 18,
                            rating = 4.3,
                            appointments = mutableListOf(
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 10
                        )
                    )
                ),
                Hospital(
                    id = "H4",
                    name = "Mudhol Eye Care Center",
                    cityId = "Mudhol",
                    specialties = mutableListOf("Ophthalmology", "Optometry"),
                    rating = 4.5f,
                    district = "Bagalkot",
                    distance = "2.8",
                    reviewCount = "1.9k reviews",
                    openingHours = "09:00 AM - 06:00 PM",
                    phone = "+91 6543210987",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Anjali Rao",
                            age = 37,
                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
                            experience = 12,
                            rating = 4.7,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 9
                        ),
                        Doctor(
                            name = "Dr. Kavita Patel",
                            age = 51,
                            specialization = mutableListOf("Optometry", "Contact Lenses"),
                            experience = 26,
                            rating = 4.6,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 11
                        ),
                        Doctor(
                            name = "Dr. Ravi Shastri",
                            age = 53,
                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
                            experience = 28,
                            rating = 4.8,
                            appointments = mutableListOf(
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 13
                        )
                    )
                ),
                Hospital(
                    id = "H5",
                    name = "Mudhol Emergency Care",
                    cityId = "Mudhol",
                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
                    rating = 4.7f,
                    district = "Bagalkot",
                    distance = "0.7",
                    reviewCount = "2.4k reviews",
                    openingHours = "24/7 Emergency",
                    phone = "+91 9090909090",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Akash Bannerjee",
                            age = 48,
                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
                            experience = 23,
                            rating = 4.9,
                            appointments = mutableListOf(
                                true, true, true, true, true, true, true, true,
                                true, true, true, true, true, true, true, true,
                                true, true, true, true, true, true, true, true,
                                true, true, true, true, true, true, true, true
                            ),
                            localAppointments = 20
                        ),
                        Doctor(
                            name = "Dr. Neha Chopra",
                            age = 36,
                            specialization = mutableListOf("Critical Care", "Pulmonology"),
                            experience = 11,
                            rating = 4.6,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 16
                        ),
                        Doctor(
                            name = "Dr. Ravi Shastri",
                            age = 53,
                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
                            experience = 28,
                            rating = 4.7,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 19
                        )
                    )
                )
            )
        )
        ,
        HospitalsData(
            cityName = "Bengaluru",
            hospitals = mutableListOf(
                Hospital(
                    id = "H1",
                    name = "Apollo Hospitals",
                    cityId = "Bengaluru",
                    specialties = mutableListOf("Cardiology", "Oncology", "Neurology"),
                    rating = 4.8f,
                    district = "Bengaluru Urban",
                    distance = "3.5",
                    reviewCount = "10.2k reviews",
                    openingHours = "24/7 Emergency",
                    phone = "+91 9876543210",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Rajesh Kumar",
                            age = 52,
                            specialization = mutableListOf("Cardiology", "Interventional Cardiology"),
                            experience = 28,
                            rating = 4.9,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 15
                        ),
                        Doctor(
                            name = "Dr. Anjali Rao",
                            age = 45,
                            specialization = mutableListOf("Oncology", "Medical Oncology"),
                            experience = 20,
                            rating = 4.7,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 12
                        ),
                        Doctor(
                            name = "Dr. Vikram Singh",
                            age = 50,
                            specialization = mutableListOf("Neurology", "Stroke Care"),
                            experience = 25,
                            rating = 4.8,
                            appointments = mutableListOf(
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 18
                        )
                    )
                ),
                Hospital(
                    id = "H2",
                    name = "Fortis Hospitals",
                    cityId = "Bengaluru",
                    specialties = mutableListOf("Orthopedics", "Gastroenterology", "Dermatology"),
                    rating = 4.7f,
                    district = "Bengaluru Urban",
                    distance = "4.2",
                    reviewCount = "8.7k reviews",
                    openingHours = "08:00 AM - 10:00 PM",
                    phone = "+91 8765432109",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Arjun Malhotra",
                            age = 48,
                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
                            experience = 23,
                            rating = 4.6,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 14
                        ),
                        Doctor(
                            name = "Dr. Priya Reddy",
                            age = 40,
                            specialization = mutableListOf("Gastroenterology", "Hepatology"),
                            experience = 15,
                            rating = 4.5,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 11
                        ),
                        Doctor(
                            name = "Dr. Nandini Sharma",
                            age = 38,
                            specialization = mutableListOf("Dermatology", "Cosmetology"),
                            experience = 12,
                            rating = 4.4,
                            appointments = mutableListOf(
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 9
                        )
                    )
                ),
                Hospital(
                    id = "H3",
                    name = "Manipal Hospitals",
                    cityId = "Bengaluru",
                    specialties = mutableListOf("Pediatrics", "Psychiatry", "Endocrinology"),
                    rating = 4.6f,
                    district = "Bengaluru Urban",
                    distance = "5.0",
                    reviewCount = "7.9k reviews",
                    openingHours = "09:00 AM - 09:00 PM",
                    phone = "+91 7654321098",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Sunita Reddy",
                            age = 42,
                            specialization = mutableListOf("Pediatrics", "Neonatology"),
                            experience = 17,
                            rating = 4.7,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 13
                        ),
                        Doctor(
                            name = "Dr. Ravi Shastri",
                            age = 53,
                            specialization = mutableListOf("Psychiatry", "Counseling"),
                            experience = 28,
                            rating = 4.5,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 10
                        ),
                        Doctor(
                            name = "Dr. Anil Desai",
                            age = 50,
                            specialization = mutableListOf("Endocrinology", "Diabetes Care"),
                            experience = 25,
                            rating = 4.6,
                            appointments = mutableListOf(
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 12
                        )
                    )
                ),
                Hospital(
                    id = "H4",
                    name = "Narayana Health",
                    cityId = "Bengaluru",
                    specialties = mutableListOf("Cardiac Surgery", "Nephrology", "Urology"),
                    rating = 4.5f,
                    district = "Bengaluru Urban",
                    distance = "6.5",
                    reviewCount = "6.8k reviews",
                    openingHours = "08:00 AM - 08:00 PM",
                    phone = "+91 6543210987",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Akash Bannerjee",
                            age = 48,
                            specialization = mutableListOf("Cardiac Surgery", "Heart Transplant"),
                            experience = 23,
                            rating = 4.8,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 16
                        ),
                        Doctor(
                            name = "Dr. Neha Chopra",
                            age = 36,
                            specialization = mutableListOf("Nephrology", "Dialysis"),
                            experience = 11,
                            rating = 4.4,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 9
                        ),
                        Doctor(
                            name = "Dr. Rohan Mehra",
                            age = 44,
                            specialization = mutableListOf("Urology", "Kidney Transplant"),
                            experience = 18,
                            rating = 4.5,
                            appointments = mutableListOf(
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 11
                        )
                    )
                ),
                Hospital(
                    id = "H5",
                    name = "Columbia Asia Hospitals",
                    cityId = "Bengaluru",
                    specialties = mutableListOf("General Surgery", "ENT", "Radiology"),
                    rating = 4.4f,
                    district = "Bengaluru Urban",
                    distance = "7.0",
                    reviewCount = "5.6k reviews",
                    openingHours = "08:30 AM - 07:30 PM",
                    phone = "+91 9090909090",
                    doctors = mutableListOf(
                        Doctor(
                            name = "Dr. Sanjay Gupta",
                            age = 52,
                            specialization = mutableListOf("General Surgery", "Laparoscopic Surgery"),
                            experience = 27,
                            rating = 4.5,
                            appointments = mutableListOf(
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true,
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true
                            ),
                            localAppointments = 14
                        ),
                        Doctor(
                            name = "Dr. Kavita Patel",
                            age = 51,
                            specialization = mutableListOf("ENT", "Head and Neck Surgery"),
                            experience = 26,
                            rating = 4.3,
                            appointments = mutableListOf(
                                false, true, false, true, false, true, false, true,
                                true, false, true, false, true, false, true, false,
                                false, false, true, true, false, false, true, true,
                                true, true, false, false, true, true, false, false
                            ),
                            localAppointments = 10
                        ),
                        Doctor(
                            name = "Dr. Ravi Shastri",
                            age = 53,
                            specialization = mutableListOf("Radiology", "Interventional Radiology"),
                            experience = 28,
                            rating = 4.4,
                            appointments = mutableListOf(
                                true, true, false, false, true, true, false, false,
                                false, false, true, true, false, false, true, true,
                                true, false, true, false, true, false, true, false,
                                false, true, false, true, false, true, false, true
                            ),
                            localAppointments = 12
                        )
                    )
                )
            )
        )
//        ,
//        HospitalsData(
//            cityName = "Devanahalli",
//            hospitals = mutableListOf(
//                Hospital(
//                    id = "H1",
//                    name = "Devanahalli General Hospital",
//                    cityId = "Devanahalli",
//                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
//                    rating = 4.0f,
//                    district = "Bengaluru Rural",
//                    distance = "1.5",
//                    reviewCount = "1.2k reviews",
//                    openingHours = "08:00 AM - 08:00 PM",
//                    phone = "+91 9876543210",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Rajeshwar Rao",
//                            age = 47,
//                            specialization = mutableListOf("General Medicine", "Diabetology"),
//                            experience = 22,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 10
//                        ),
//                        Doctor(
//                            name = "Dr. Ananya Desai",
//                            age = 35,
//                            specialization = mutableListOf("Cardiology", "Hypertension"),
//                            experience = 10,
//                            rating = 4.1,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Vikram Singh",
//                            age = 50,
//                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
//                            experience = 25,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, true, true, true, false, false, false, false,
//                                false, false, false, false, true, true, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 12
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H2",
//                    name = "Devanahalli Women's Health Center",
//                    cityId = "Devanahalli",
//                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
//                    rating = 4.3f,
//                    district = "Bengaluru Rural",
//                    distance = "2.0",
//                    reviewCount = "1.5k reviews",
//                    openingHours = "09:00 AM - 07:00 PM",
//                    phone = "+91 8765432109",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Priya Reddy",
//                            age = 40,
//                            specialization = mutableListOf("Gynecology", "Infertility"),
//                            experience = 15,
//                            rating = 4.5,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Arjun Malhotra",
//                            age = 45,
//                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
//                            experience = 20,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Nandini Sharma",
//                            age = 38,
//                            specialization = mutableListOf("Pediatrics", "Neonatology"),
//                            experience = 12,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 7
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H3",
//                    name = "Devanahalli Ortho Care",
//                    cityId = "Devanahalli",
//                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
//                    rating = 4.2f,
//                    district = "Bengaluru Rural",
//                    distance = "3.2",
//                    reviewCount = "1.1k reviews",
//                    openingHours = "08:30 AM - 07:30 PM",
//                    phone = "+91 7654321098",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Sanjay Gupta",
//                            age = 52,
//                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
//                            experience = 27,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 14
//                        ),
//                        Doctor(
//                            name = "Dr. Meera Krishnan",
//                            age = 39,
//                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
//                            experience = 14,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Rohan Mehra",
//                            age = 44,
//                            specialization = mutableListOf("Pain Management", "Spine Care"),
//                            experience = 18,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 10
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H4",
//                    name = "Devanahalli Eye Care Center",
//                    cityId = "Devanahalli",
//                    specialties = mutableListOf("Ophthalmology", "Optometry"),
//                    rating = 4.5f,
//                    district = "Bengaluru Rural",
//                    distance = "2.8",
//                    reviewCount = "1.9k reviews",
//                    openingHours = "09:00 AM - 06:00 PM",
//                    phone = "+91 6543210987",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Anjali Rao",
//                            age = 37,
//                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
//                            experience = 12,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Kavita Patel",
//                            age = 51,
//                            specialization = mutableListOf("Optometry", "Contact Lenses"),
//                            experience = 26,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
//                            experience = 28,
//                            rating = 4.8,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 13
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H5",
//                    name = "Devanahalli Emergency Care",
//                    cityId = "Devanahalli",
//                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
//                    rating = 4.7f,
//                    district = "Bengaluru Rural",
//                    distance = "0.8",
//                    reviewCount = "2.5k reviews",
//                    openingHours = "24/7 Emergency",
//                    phone = "+91 9090909090",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Akash Bannerjee",
//                            age = 48,
//                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
//                            experience = 23,
//                            rating = 4.9,
//                            appointments = mutableListOf(
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true
//                            ),
//                            localAppointments = 20
//                        ),
//                        Doctor(
//                            name = "Dr. Neha Chopra",
//                            age = 36,
//                            specialization = mutableListOf("Critical Care", "Pulmonology"),
//                            experience = 11,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 16
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
//                            experience = 28,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 19
//                        )
//                    )
//                )
//            )
//        )
//        ,
//        HospitalsData(
//            cityName = "Doddaballapura",
//            hospitals = mutableListOf(
//                Hospital(
//                    id = "H1",
//                    name = "Doddaballapura General Hospital",
//                    cityId = "Doddaballapura",
//                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
//                    rating = 4.0f,
//                    district = "Bengaluru Rural",
//                    distance = "1.5",
//                    reviewCount = "1.3k reviews",
//                    openingHours = "08:00 AM - 08:00 PM",
//                    phone = "+91 9876543210",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Rajeshwar Rao",
//                            age = 47,
//                            specialization = mutableListOf("General Medicine", "Diabetology"),
//                            experience = 22,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 10
//                        ),
//                        Doctor(
//                            name = "Dr. Ananya Desai",
//                            age = 35,
//                            specialization = mutableListOf("Cardiology", "Hypertension"),
//                            experience = 10,
//                            rating = 4.1,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Vikram Singh",
//                            age = 50,
//                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
//                            experience = 25,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, true, true, true, false, false, false, false,
//                                false, false, false, false, true, true, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 12
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H2",
//                    name = "Doddaballapura Women's Health Center",
//                    cityId = "Doddaballapura",
//                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
//                    rating = 4.3f,
//                    district = "Bengaluru Rural",
//                    distance = "2.0",
//                    reviewCount = "1.6k reviews",
//                    openingHours = "09:00 AM - 07:00 PM",
//                    phone = "+91 8765432109",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Priya Reddy",
//                            age = 40,
//                            specialization = mutableListOf("Gynecology", "Infertility"),
//                            experience = 15,
//                            rating = 4.5,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Arjun Malhotra",
//                            age = 45,
//                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
//                            experience = 20,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Nandini Sharma",
//                            age = 38,
//                            specialization = mutableListOf("Pediatrics", "Neonatology"),
//                            experience = 12,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 7
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H3",
//                    name = "Doddaballapura Ortho Care",
//                    cityId = "Doddaballapura",
//                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
//                    rating = 4.2f,
//                    district = "Bengaluru Rural",
//                    distance = "3.2",
//                    reviewCount = "1.1k reviews",
//                    openingHours = "08:30 AM - 07:30 PM",
//                    phone = "+91 7654321098",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Sanjay Gupta",
//                            age = 52,
//                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
//                            experience = 27,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 14
//                        ),
//                        Doctor(
//                            name = "Dr. Meera Krishnan",
//                            age = 39,
//                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
//                            experience = 14,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Rohan Mehra",
//                            age = 44,
//                            specialization = mutableListOf("Pain Management", "Spine Care"),
//                            experience = 18,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 10
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H4",
//                    name = "Doddaballapura Eye Care Center",
//                    cityId = "Doddaballapura",
//                    specialties = mutableListOf("Ophthalmology", "Optometry"),
//                    rating = 4.5f,
//                    district = "Bengaluru Rural",
//                    distance = "2.8",
//                    reviewCount = "1.9k reviews",
//                    openingHours = "09:00 AM - 06:00 PM",
//                    phone = "+91 6543210987",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Anjali Rao",
//                            age = 37,
//                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
//                            experience = 12,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Kavita Patel",
//                            age = 51,
//                            specialization = mutableListOf("Optometry", "Contact Lenses"),
//                            experience = 26,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
//                            experience = 28,
//                            rating = 4.8,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 13
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H5",
//                    name = "Doddaballapura Emergency Care",
//                    cityId = "Doddaballapura",
//                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
//                    rating = 4.7f,
//                    district = "Bengaluru Rural",
//                    distance = "0.8",
//                    reviewCount = "2.5k reviews",
//                    openingHours = "24/7 Emergency",
//                    phone = "+91 9090909090",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Akash Bannerjee",
//                            age = 48,
//                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
//                            experience = 23,
//                            rating = 4.9,
//                            appointments = mutableListOf(
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true
//                            ),
//                            localAppointments = 20
//                        ),
//                        Doctor(
//                            name = "Dr. Neha Chopra",
//                            age = 36,
//                            specialization = mutableListOf("Critical Care", "Pulmonology"),
//                            experience = 11,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 16
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
//                            experience = 28,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 19
//                        )
//                    )
//                )
//            )
//        )
//        ,
//        HospitalsData(
//            cityName = "Hoskote",
//            hospitals = mutableListOf(
//                Hospital(
//                    id = "H1",
//                    name = "Hoskote General Hospital",
//                    cityId = "Hoskote",
//                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
//                    rating = 4.0f,
//                    district = "Bengaluru Rural",
//                    distance = "1.5",
//                    reviewCount = "1.3k reviews",
//                    openingHours = "08:00 AM - 08:00 PM",
//                    phone = "+91 9876543210",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Rajeshwar Rao",
//                            age = 47,
//                            specialization = mutableListOf("General Medicine", "Diabetology"),
//                            experience = 22,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 10
//                        ),
//                        Doctor(
//                            name = "Dr. Ananya Desai",
//                            age = 35,
//                            specialization = mutableListOf("Cardiology", "Hypertension"),
//                            experience = 10,
//                            rating = 4.1,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Vikram Singh",
//                            age = 50,
//                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
//                            experience = 25,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, true, true, true, false, false, false, false,
//                                false, false, false, false, true, true, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 12
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H2",
//                    name = "Hoskote Women's Health Center",
//                    cityId = "Hoskote",
//                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
//                    rating = 4.3f,
//                    district = "Bengaluru Rural",
//                    distance = "2.0",
//                    reviewCount = "1.6k reviews",
//                    openingHours = "09:00 AM - 07:00 PM",
//                    phone = "+91 8765432109",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Priya Reddy",
//                            age = 40,
//                            specialization = mutableListOf("Gynecology", "Infertility"),
//                            experience = 15,
//                            rating = 4.5,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Arjun Malhotra",
//                            age = 45,
//                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
//                            experience = 20,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Nandini Sharma",
//                            age = 38,
//                            specialization = mutableListOf("Pediatrics", "Neonatology"),
//                            experience = 12,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 7
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H3",
//                    name = "Hoskote Ortho Care",
//                    cityId = "Hoskote",
//                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
//                    rating = 4.2f,
//                    district = "Bengaluru Rural",
//                    distance = "3.2",
//                    reviewCount = "1.1k reviews",
//                    openingHours = "08:30 AM - 07:30 PM",
//                    phone = "+91 7654321098",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Sanjay Gupta",
//                            age = 52,
//                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
//                            experience = 27,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 14
//                        ),
//                        Doctor(
//                            name = "Dr. Meera Krishnan",
//                            age = 39,
//                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
//                            experience = 14,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Rohan Mehra",
//                            age = 44,
//                            specialization = mutableListOf("Pain Management", "Spine Care"),
//                            experience = 18,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 10
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H4",
//                    name = "Hoskote Eye Care Center",
//                    cityId = "Hoskote",
//                    specialties = mutableListOf("Ophthalmology", "Optometry"),
//                    rating = 4.5f,
//                    district = "Bengaluru Rural",
//                    distance = "2.8",
//                    reviewCount = "1.9k reviews",
//                    openingHours = "09:00 AM - 06:00 PM",
//                    phone = "+91 6543210987",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Anjali Rao",
//                            age = 37,
//                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
//                            experience = 12,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Kavita Patel",
//                            age = 51,
//                            specialization = mutableListOf("Optometry", "Contact Lenses"),
//                            experience = 26,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
//                            experience = 28,
//                            rating = 4.8,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 13
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H5",
//                    name = "Hoskote Emergency Care",
//                    cityId = "Hoskote",
//                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
//                    rating = 4.7f,
//                    district = "Bengaluru Rural",
//                    distance = "0.8",
//                    reviewCount = "2.5k reviews",
//                    openingHours = "24/7 Emergency",
//                    phone = "+91 9090909090",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Akash Bannerjee",
//                            age = 48,
//                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
//                            experience = 23,
//                            rating = 4.9,
//                            appointments = mutableListOf(
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true
//                            ),
//                            localAppointments = 20
//                        ),
//                        Doctor(
//                            name = "Dr. Neha Chopra",
//                            age = 36,
//                            specialization = mutableListOf("Critical Care", "Pulmonology"),
//                            experience = 11,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 16
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
//                            experience = 28,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 19
//                        )
//                    )
//                )
//            )
//        )
//        ,
//        HospitalsData(
//            cityName = "Nelamangala",
//            hospitals = mutableListOf(
//                Hospital(
//                    id = "H1",
//                    name = "Nelamangala General Hospital",
//                    cityId = "Nelamangala",
//                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
//                    rating = 4.0f,
//                    district = "Bengaluru Rural",
//                    distance = "1.5",
//                    reviewCount = "1.3k reviews",
//                    openingHours = "08:00 AM - 08:00 PM",
//                    phone = "+91 9876543210",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Rajeshwar Rao",
//                            age = 47,
//                            specialization = mutableListOf("General Medicine", "Diabetology"),
//                            experience = 22,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 10
//                        ),
//                        Doctor(
//                            name = "Dr. Ananya Desai",
//                            age = 35,
//                            specialization = mutableListOf("Cardiology", "Hypertension"),
//                            experience = 10,
//                            rating = 4.1,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Vikram Singh",
//                            age = 50,
//                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
//                            experience = 25,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, true, true, true, false, false, false, false,
//                                false, false, false, false, true, true, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 12
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H2",
//                    name = "Nelamangala Women's Health Center",
//                    cityId = "Nelamangala",
//                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
//                    rating = 4.3f,
//                    district = "Bengaluru Rural",
//                    distance = "2.0",
//                    reviewCount = "1.6k reviews",
//                    openingHours = "09:00 AM - 07:00 PM",
//                    phone = "+91 8765432109",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Priya Reddy",
//                            age = 40,
//                            specialization = mutableListOf("Gynecology", "Infertility"),
//                            experience = 15,
//                            rating = 4.5,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Arjun Malhotra",
//                            age = 45,
//                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
//                            experience = 20,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Nandini Sharma",
//                            age = 38,
//                            specialization = mutableListOf("Pediatrics", "Neonatology"),
//                            experience = 12,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 7
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H3",
//                    name = "Nelamangala Ortho Care",
//                    cityId = "Nelamangala",
//                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
//                    rating = 4.2f,
//                    district = "Bengaluru Rural",
//                    distance = "3.2",
//                    reviewCount = "1.1k reviews",
//                    openingHours = "08:30 AM - 07:30 PM",
//                    phone = "+91 7654321098",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Sanjay Gupta",
//                            age = 52,
//                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
//                            experience = 27,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 14
//                        ),
//                        Doctor(
//                            name = "Dr. Meera Krishnan",
//                            age = 39,
//                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
//                            experience = 14,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Rohan Mehra",
//                            age = 44,
//                            specialization = mutableListOf("Pain Management", "Spine Care"),
//                            experience = 18,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 10
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H4",
//                    name = "Nelamangala Eye Care Center",
//                    cityId = "Nelamangala",
//                    specialties = mutableListOf("Ophthalmology", "Optometry"),
//                    rating = 4.5f,
//                    district = "Bengaluru Rural",
//                    distance = "2.8",
//                    reviewCount = "1.9k reviews",
//                    openingHours = "09:00 AM - 06:00 PM",
//                    phone = "+91 6543210987",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Anjali Rao",
//                            age = 37,
//                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
//                            experience = 12,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Kavita Patel",
//                            age = 51,
//                            specialization = mutableListOf("Optometry", "Contact Lenses"),
//                            experience = 26,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
//                            experience = 28,
//                            rating = 4.8,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 13
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H5",
//                    name = "Nelamangala Emergency Care",
//                    cityId = "Nelamangala",
//                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
//                    rating = 4.7f,
//                    district = "Bengaluru Rural",
//                    distance = "0.8",
//                    reviewCount = "2.5k reviews",
//                    openingHours = "24/7 Emergency",
//                    phone = "+91 9090909090",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Akash Bannerjee",
//                            age = 48,
//                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
//                            experience = 23,
//                            rating = 4.9,
//                            appointments = mutableListOf(
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true
//                            ),
//                            localAppointments = 20
//                        ),
//                        Doctor(
//                            name = "Dr. Neha Chopra",
//                            age = 36,
//                            specialization = mutableListOf("Critical Care", "Pulmonology"),
//                            experience = 11,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 16
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
//                            experience = 28,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 19
//                        )
//                    )
//                )
//            )
//        )
//        ,
//        HospitalsData(
//            cityName = "Belagavi",
//            hospitals = mutableListOf(
//                Hospital(
//                    id = "H1",
//                    name = "Belagavi General Hospital",
//                    cityId = "Belagavi",
//                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
//                    rating = 4.0f,
//                    district = "Belagavi",
//                    distance = "1.5",
//                    reviewCount = "1.3k reviews",
//                    openingHours = "08:00 AM - 08:00 PM",
//                    phone = "+91 9876543210",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Rajeshwar Rao",
//                            age = 47,
//                            specialization = mutableListOf("General Medicine", "Diabetology"),
//                            experience = 22,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 10
//                        ),
//                        Doctor(
//                            name = "Dr. Ananya Desai",
//                            age = 35,
//                            specialization = mutableListOf("Cardiology", "Hypertension"),
//                            experience = 10,
//                            rating = 4.1,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Vikram Singh",
//                            age = 50,
//                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
//                            experience = 25,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, true, true, true, false, false, false, false,
//                                false, false, false, false, true, true, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 12
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H2",
//                    name = "Belagavi Women's Health Center",
//                    cityId = "Belagavi",
//                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
//                    rating = 4.3f,
//                    district = "Belagavi",
//                    distance = "2.0",
//                    reviewCount = "1.6k reviews",
//                    openingHours = "09:00 AM - 07:00 PM",
//                    phone = "+91 8765432109",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Priya Reddy",
//                            age = 40,
//                            specialization = mutableListOf("Gynecology", "Infertility"),
//                            experience = 15,
//                            rating = 4.5,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Arjun Malhotra",
//                            age = 45,
//                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
//                            experience = 20,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Nandini Sharma",
//                            age = 38,
//                            specialization = mutableListOf("Pediatrics", "Neonatology"),
//                            experience = 12,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 7
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H3",
//                    name = "Belagavi Ortho Care",
//                    cityId = "Belagavi",
//                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
//                    rating = 4.2f,
//                    district = "Belagavi",
//                    distance = "3.2",
//                    reviewCount = "1.1k reviews",
//                    openingHours = "08:30 AM - 07:30 PM",
//                    phone = "+91 7654321098",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Sanjay Gupta",
//                            age = 52,
//                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
//                            experience = 27,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 14
//                        ),
//                        Doctor(
//                            name = "Dr. Meera Krishnan",
//                            age = 39,
//                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
//                            experience = 14,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Rohan Mehra",
//                            age = 44,
//                            specialization = mutableListOf("Pain Management", "Spine Care"),
//                            experience = 18,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 10
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H4",
//                    name = "Belagavi Eye Care Center",
//                    cityId = "Belagavi",
//                    specialties = mutableListOf("Ophthalmology", "Optometry"),
//                    rating = 4.5f,
//                    district = "Belagavi",
//                    distance = "2.8",
//                    reviewCount = "1.9k reviews",
//                    openingHours = "09:00 AM - 06:00 PM",
//                    phone = "+91 6543210987",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Anjali Rao",
//                            age = 37,
//                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
//                            experience = 12,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Kavita Patel",
//                            age = 51,
//                            specialization = mutableListOf("Optometry", "Contact Lenses"),
//                            experience = 26,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
//                            experience = 28,
//                            rating = 4.8,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 13
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H5",
//                    name = "Belagavi Emergency Care",
//                    cityId = "Belagavi",
//                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
//                    rating = 4.7f,
//                    district = "Belagavi",
//                    distance = "0.8",
//                    reviewCount = "2.5k reviews",
//                    openingHours = "24/7 Emergency",
//                    phone = "+91 9090909090",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Akash Bannerjee",
//                            age = 48,
//                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
//                            experience = 23,
//                            rating = 4.9,
//                            appointments = mutableListOf(
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true
//                            ),
//                            localAppointments = 20
//                        ),
//                        Doctor(
//                            name = "Dr. Neha Chopra",
//                            age = 36,
//                            specialization = mutableListOf("Critical Care", "Pulmonology"),
//                            experience = 11,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 16
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
//                            experience = 28,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 19
//                        )
//                    )
//                )
//            )
//        )
//        ,
//        HospitalsData(
//            cityName = "Athani",
//            hospitals = mutableListOf(
//                Hospital(
//                    id = "H1",
//                    name = "Athani General Hospital",
//                    cityId = "Athani",
//                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
//                    rating = 4.0f,
//                    district = "Belagavi",
//                    distance = "1.5",
//                    reviewCount = "1.3k reviews",
//                    openingHours = "08:00 AM - 08:00 PM",
//                    phone = "+91 9876543210",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Rajeshwar Rao",
//                            age = 47,
//                            specialization = mutableListOf("General Medicine", "Diabetology"),
//                            experience = 22,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 10
//                        ),
//                        Doctor(
//                            name = "Dr. Ananya Desai",
//                            age = 35,
//                            specialization = mutableListOf("Cardiology", "Hypertension"),
//                            experience = 10,
//                            rating = 4.1,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Vikram Singh",
//                            age = 50,
//                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
//                            experience = 25,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, true, true, true, false, false, false, false,
//                                false, false, false, false, true, true, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 12
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H2",
//                    name = "Athani Women's Health Center",
//                    cityId = "Athani",
//                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
//                    rating = 4.3f,
//                    district = "Belagavi",
//                    distance = "2.0",
//                    reviewCount = "1.6k reviews",
//                    openingHours = "09:00 AM - 07:00 PM",
//                    phone = "+91 8765432109",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Priya Reddy",
//                            age = 40,
//                            specialization = mutableListOf("Gynecology", "Infertility"),
//                            experience = 15,
//                            rating = 4.5,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Arjun Malhotra",
//                            age = 45,
//                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
//                            experience = 20,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Nandini Sharma",
//                            age = 38,
//                            specialization = mutableListOf("Pediatrics", "Neonatology"),
//                            experience = 12,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 7
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H3",
//                    name = "Athani Ortho Care",
//                    cityId = "Athani",
//                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
//                    rating = 4.2f,
//                    district = "Belagavi",
//                    distance = "3.2",
//                    reviewCount = "1.1k reviews",
//                    openingHours = "08:30 AM - 07:30 PM",
//                    phone = "+91 7654321098",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Sanjay Gupta",
//                            age = 52,
//                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
//                            experience = 27,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 14
//                        ),
//                        Doctor(
//                            name = "Dr. Meera Krishnan",
//                            age = 39,
//                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
//                            experience = 14,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Rohan Mehra",
//                            age = 44,
//                            specialization = mutableListOf("Pain Management", "Spine Care"),
//                            experience = 18,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 10
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H4",
//                    name = "Athani Eye Care Center",
//                    cityId = "Athani",
//                    specialties = mutableListOf("Ophthalmology", "Optometry"),
//                    rating = 4.5f,
//                    district = "Belagavi",
//                    distance = "2.8",
//                    reviewCount = "1.9k reviews",
//                    openingHours = "09:00 AM - 06:00 PM",
//                    phone = "+91 6543210987",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Anjali Rao",
//                            age = 37,
//                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
//                            experience = 12,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Kavita Patel",
//                            age = 51,
//                            specialization = mutableListOf("Optometry", "Contact Lenses"),
//                            experience = 26,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
//                            experience = 28,
//                            rating = 4.8,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 13
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H5",
//                    name = "Athani Emergency Care",
//                    cityId = "Athani",
//                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
//                    rating = 4.7f,
//                    district = "Belagavi",
//                    distance = "0.8",
//                    reviewCount = "2.5k reviews",
//                    openingHours = "24/7 Emergency",
//                    phone = "+91 9090909090",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Akash Bannerjee",
//                            age = 48,
//                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
//                            experience = 23,
//                            rating = 4.9,
//                            appointments = mutableListOf(
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true
//                            ),
//                            localAppointments = 20
//                        ),
//                        Doctor(
//                            name = "Dr. Neha Chopra",
//                            age = 36,
//                            specialization = mutableListOf("Critical Care", "Pulmonology"),
//                            experience = 11,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 16
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
//                            experience = 28,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 19
//                        )
//                    )
//                )
//            )
//        ),
//        HospitalsData(
//            cityName = "Chikodi",
//            hospitals = mutableListOf(
//                Hospital(
//                    id = "H1",
//                    name = "Chikodi General Hospital",
//                    cityId = "Chikodi",
//                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
//                    rating = 4.0f,
//                    district = "Belagavi",
//                    distance = "1.5",
//                    reviewCount = "1.3k reviews",
//                    openingHours = "08:00 AM - 08:00 PM",
//                    phone = "+91 9876543210",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Rajeshwar Rao",
//                            age = 47,
//                            specialization = mutableListOf("General Medicine", "Diabetology"),
//                            experience = 22,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 10
//                        ),
//                        Doctor(
//                            name = "Dr. Ananya Desai",
//                            age = 35,
//                            specialization = mutableListOf("Cardiology", "Hypertension"),
//                            experience = 10,
//                            rating = 4.1,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Vikram Singh",
//                            age = 50,
//                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
//                            experience = 25,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, true, true, true, false, false, false, false,
//                                false, false, false, false, true, true, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 12
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H2",
//                    name = "Chikodi Women's Health Center",
//                    cityId = "Chikodi",
//                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
//                    rating = 4.3f,
//                    district = "Belagavi",
//                    distance = "2.0",
//                    reviewCount = "1.6k reviews",
//                    openingHours = "09:00 AM - 07:00 PM",
//                    phone = "+91 8765432109",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Priya Reddy",
//                            age = 40,
//                            specialization = mutableListOf("Gynecology", "Infertility"),
//                            experience = 15,
//                            rating = 4.5,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Arjun Malhotra",
//                            age = 45,
//                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
//                            experience = 20,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Nandini Sharma",
//                            age = 38,
//                            specialization = mutableListOf("Pediatrics", "Neonatology"),
//                            experience = 12,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 7
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H3",
//                    name = "Chikodi Ortho Care",
//                    cityId = "Chikodi",
//                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
//                    rating = 4.2f,
//                    district = "Belagavi",
//                    distance = "3.2",
//                    reviewCount = "1.1k reviews",
//                    openingHours = "08:30 AM - 07:30 PM",
//                    phone = "+91 7654321098",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Sanjay Gupta",
//                            age = 52,
//                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
//                            experience = 27,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 14
//                        ),
//                        Doctor(
//                            name = "Dr. Meera Krishnan",
//                            age = 39,
//                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
//                            experience = 14,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Rohan Mehra",
//                            age = 44,
//                            specialization = mutableListOf("Pain Management", "Spine Care"),
//                            experience = 18,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 10
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H4",
//                    name = "Chikodi Eye Care Center",
//                    cityId = "Chikodi",
//                    specialties = mutableListOf("Ophthalmology", "Optometry"),
//                    rating = 4.5f,
//                    district = "Belagavi",
//                    distance = "2.8",
//                    reviewCount = "1.9k reviews",
//                    openingHours = "09:00 AM - 06:00 PM",
//                    phone = "+91 6543210987",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Anjali Rao",
//                            age = 37,
//                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
//                            experience = 12,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Kavita Patel",
//                            age = 51,
//                            specialization = mutableListOf("Optometry", "Contact Lenses"),
//                            experience = 26,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
//                            experience = 28,
//                            rating = 4.8,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 13
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H5",
//                    name = "Chikodi Emergency Care",
//                    cityId = "Chikodi",
//                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
//                    rating = 4.7f,
//                    district = "Belagavi",
//                    distance = "0.8",
//                    reviewCount = "2.5k reviews",
//                    openingHours = "24/7 Emergency",
//                    phone = "+91 9090909090",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Akash Bannerjee",
//                            age = 48,
//                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
//                            experience = 23,
//                            rating = 4.9,
//                            appointments = mutableListOf(
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true
//                            ),
//                            localAppointments = 20
//                        ),
//                        Doctor(
//                            name = "Dr. Neha Chopra",
//                            age = 36,
//                            specialization = mutableListOf("Critical Care", "Pulmonology"),
//                            experience = 11,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 16
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
//                            experience = 28,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 19
//                        )
//                    )
//                )
//            )
//        ),
//        HospitalsData(
//            cityName = "Gokak",
//            hospitals = mutableListOf(
//                Hospital(
//                    id = "H1",
//                    name = "Gokak General Hospital",
//                    cityId = "Gokak",
//                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
//                    rating = 4.0f,
//                    district = "Belagavi",
//                    distance = "1.5",
//                    reviewCount = "1.3k reviews",
//                    openingHours = "08:00 AM - 08:00 PM",
//                    phone = "+91 9876543210",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Rajeshwar Rao",
//                            age = 47,
//                            specialization = mutableListOf("General Medicine", "Diabetology"),
//                            experience = 22,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 10
//                        ),
//                        Doctor(
//                            name = "Dr. Ananya Desai",
//                            age = 35,
//                            specialization = mutableListOf("Cardiology", "Hypertension"),
//                            experience = 10,
//                            rating = 4.1,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Vikram Singh",
//                            age = 50,
//                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
//                            experience = 25,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, true, true, true, false, false, false, false,
//                                false, false, false, false, true, true, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 12
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H2",
//                    name = "Gokak Women's Health Center",
//                    cityId = "Gokak",
//                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
//                    rating = 4.3f,
//                    district = "Belagavi",
//                    distance = "2.0",
//                    reviewCount = "1.6k reviews",
//                    openingHours = "09:00 AM - 07:00 PM",
//                    phone = "+91 8765432109",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Priya Reddy",
//                            age = 40,
//                            specialization = mutableListOf("Gynecology", "Infertility"),
//                            experience = 15,
//                            rating = 4.5,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Arjun Malhotra",
//                            age = 45,
//                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
//                            experience = 20,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Nandini Sharma",
//                            age = 38,
//                            specialization = mutableListOf("Pediatrics", "Neonatology"),
//                            experience = 12,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 7
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H3",
//                    name = "Gokak Ortho Care",
//                    cityId = "Gokak",
//                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
//                    rating = 4.2f,
//                    district = "Belagavi",
//                    distance = "3.2",
//                    reviewCount = "1.1k reviews",
//                    openingHours = "08:30 AM - 07:30 PM",
//                    phone = "+91 7654321098",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Sanjay Gupta",
//                            age = 52,
//                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
//                            experience = 27,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 14
//                        ),
//                        Doctor(
//                            name = "Dr. Meera Krishnan",
//                            age = 39,
//                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
//                            experience = 14,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Rohan Mehra",
//                            age = 44,
//                            specialization = mutableListOf("Pain Management", "Spine Care"),
//                            experience = 18,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 10
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H4",
//                    name = "Gokak Eye Care Center",
//                    cityId = "Gokak",
//                    specialties = mutableListOf("Ophthalmology", "Optometry"),
//                    rating = 4.5f,
//                    district = "Belagavi",
//                    distance = "2.8",
//                    reviewCount = "1.9k reviews",
//                    openingHours = "09:00 AM - 06:00 PM",
//                    phone = "+91 6543210987",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Anjali Rao",
//                            age = 37,
//                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
//                            experience = 12,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Kavita Patel",
//                            age = 51,
//                            specialization = mutableListOf("Optometry", "Contact Lenses"),
//                            experience = 26,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
//                            experience = 28,
//                            rating = 4.8,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 13
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H5",
//                    name = "Gokak Emergency Care",
//                    cityId = "Gokak",
//                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
//                    rating = 4.7f,
//                    district = "Belagavi",
//                    distance = "0.8",
//                    reviewCount = "2.5k reviews",
//                    openingHours = "24/7 Emergency",
//                    phone = "+91 9090909090",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Akash Bannerjee",
//                            age = 48,
//                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
//                            experience = 23,
//                            rating = 4.9,
//                            appointments = mutableListOf(
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true
//                            ),
//                            localAppointments = 20
//                        ),
//                        Doctor(
//                            name = "Dr. Neha Chopra",
//                            age = 36,
//                            specialization = mutableListOf("Critical Care", "Pulmonology"),
//                            experience = 11,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 16
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
//                            experience = 28,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 19
//                        )
//                    )
//                )
//            )
//        )
//        ,
//        HospitalsData(
//            cityName = "Nipani",
//            hospitals = mutableListOf(
//                Hospital(
//                    id = "H1",
//                    name = "Nipani General Hospital",
//                    cityId = "Nipani",
//                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
//                    rating = 4.0f,
//                    district = "Belagavi",
//                    distance = "1.5",
//                    reviewCount = "1.3k reviews",
//                    openingHours = "08:00 AM - 08:00 PM",
//                    phone = "+91 9876543210",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Rajeshwar Rao",
//                            age = 47,
//                            specialization = mutableListOf("General Medicine", "Diabetology"),
//                            experience = 22,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 10
//                        ),
//                        Doctor(
//                            name = "Dr. Ananya Desai",
//                            age = 35,
//                            specialization = mutableListOf("Cardiology", "Hypertension"),
//                            experience = 10,
//                            rating = 4.1,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Vikram Singh",
//                            age = 50,
//                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
//                            experience = 25,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, true, true, true, false, false, false, false,
//                                false, false, false, false, true, true, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 12
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H2",
//                    name = "Nipani Women's Health Center",
//                    cityId = "Nipani",
//                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
//                    rating = 4.3f,
//                    district = "Belagavi",
//                    distance = "2.0",
//                    reviewCount = "1.6k reviews",
//                    openingHours = "09:00 AM - 07:00 PM",
//                    phone = "+91 8765432109",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Priya Reddy",
//                            age = 40,
//                            specialization = mutableListOf("Gynecology", "Infertility"),
//                            experience = 15,
//                            rating = 4.5,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Arjun Malhotra",
//                            age = 45,
//                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
//                            experience = 20,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Nandini Sharma",
//                            age = 38,
//                            specialization = mutableListOf("Pediatrics", "Neonatology"),
//                            experience = 12,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 7
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H3",
//                    name = "Nipani Ortho Care",
//                    cityId = "Nipani",
//                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
//                    rating = 4.2f,
//                    district = "Belagavi",
//                    distance = "3.2",
//                    reviewCount = "1.1k reviews",
//                    openingHours = "08:30 AM - 07:30 PM",
//                    phone = "+91 7654321098",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Sanjay Gupta",
//                            age = 52,
//                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
//                            experience = 27,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 14
//                        ),
//                        Doctor(
//                            name = "Dr. Meera Krishnan",
//                            age = 39,
//                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
//                            experience = 14,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Rohan Mehra",
//                            age = 44,
//                            specialization = mutableListOf("Pain Management", "Spine Care"),
//                            experience = 18,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 10
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H4",
//                    name = "Nipani Eye Care Center",
//                    cityId = "Nipani",
//                    specialties = mutableListOf("Ophthalmology", "Optometry"),
//                    rating = 4.5f,
//                    district = "Belagavi",
//                    distance = "2.8",
//                    reviewCount = "1.9k reviews",
//                    openingHours = "09:00 AM - 06:00 PM",
//                    phone = "+91 6543210987",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Anjali Rao",
//                            age = 37,
//                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
//                            experience = 12,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Kavita Patel",
//                            age = 51,
//                            specialization = mutableListOf("Optometry", "Contact Lenses"),
//                            experience = 26,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
//                            experience = 28,
//                            rating = 4.8,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 13
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H5",
//                    name = "Nipani Emergency Care",
//                    cityId = "Nipani",
//                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
//                    rating = 4.7f,
//                    district = "Belagavi",
//                    distance = "0.8",
//                    reviewCount = "2.5k reviews",
//                    openingHours = "24/7 Emergency",
//                    phone = "+91 9090909090",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Akash Bannerjee",
//                            age = 48,
//                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
//                            experience = 23,
//                            rating = 4.9,
//                            appointments = mutableListOf(
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true
//                            ),
//                            localAppointments = 20
//                        ),
//                        Doctor(
//                            name = "Dr. Neha Chopra",
//                            age = 36,
//                            specialization = mutableListOf("Critical Care", "Pulmonology"),
//                            experience = 11,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 16
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
//                            experience = 28,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 19
//                        )
//                    )
//                )
//            )
//        )
//        ,
//        HospitalsData(
//            cityName = "Ramdurg",
//            hospitals = mutableListOf(
//                Hospital(
//                    id = "H1",
//                    name = "Ramdurg General Hospital",
//                    cityId = "Ramdurg",
//                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
//                    rating = 4.0f,
//                    district = "Belagavi",
//                    distance = "1.5",
//                    reviewCount = "1.3k reviews",
//                    openingHours = "08:00 AM - 08:00 PM",
//                    phone = "+91 9876543210",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Rajeshwar Rao",
//                            age = 47,
//                            specialization = mutableListOf("General Medicine", "Diabetology"),
//                            experience = 22,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 10
//                        ),
//                        Doctor(
//                            name = "Dr. Ananya Desai",
//                            age = 35,
//                            specialization = mutableListOf("Cardiology", "Hypertension"),
//                            experience = 10,
//                            rating = 4.1,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Vikram Singh",
//                            age = 50,
//                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
//                            experience = 25,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, true, true, true, false, false, false, false,
//                                false, false, false, false, true, true, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 12
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H2",
//                    name = "Ramdurg Women's Health Center",
//                    cityId = "Ramdurg",
//                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
//                    rating = 4.3f,
//                    district = "Belagavi",
//                    distance = "2.0",
//                    reviewCount = "1.6k reviews",
//                    openingHours = "09:00 AM - 07:00 PM",
//                    phone = "+91 8765432109",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Priya Reddy",
//                            age = 40,
//                            specialization = mutableListOf("Gynecology", "Infertility"),
//                            experience = 15,
//                            rating = 4.5,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Arjun Malhotra",
//                            age = 45,
//                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
//                            experience = 20,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Nandini Sharma",
//                            age = 38,
//                            specialization = mutableListOf("Pediatrics", "Neonatology"),
//                            experience = 12,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 7
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H3",
//                    name = "Ramdurg Ortho Care",
//                    cityId = "Ramdurg",
//                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
//                    rating = 4.2f,
//                    district = "Belagavi",
//                    distance = "3.2",
//                    reviewCount = "1.1k reviews",
//                    openingHours = "08:30 AM - 07:30 PM",
//                    phone = "+91 7654321098",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Sanjay Gupta",
//                            age = 52,
//                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
//                            experience = 27,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 14
//                        ),
//                        Doctor(
//                            name = "Dr. Meera Krishnan",
//                            age = 39,
//                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
//                            experience = 14,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Rohan Mehra",
//                            age = 44,
//                            specialization = mutableListOf("Pain Management", "Spine Care"),
//                            experience = 18,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 10
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H4",
//                    name = "Ramdurg Eye Care Center",
//                    cityId = "Ramdurg",
//                    specialties = mutableListOf("Ophthalmology", "Optometry"),
//                    rating = 4.5f,
//                    district = "Belagavi",
//                    distance = "2.8",
//                    reviewCount = "1.9k reviews",
//                    openingHours = "09:00 AM - 06:00 PM",
//                    phone = "+91 6543210987",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Anjali Rao",
//                            age = 37,
//                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
//                            experience = 12,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Kavita Patel",
//                            age = 51,
//                            specialization = mutableListOf("Optometry", "Contact Lenses"),
//                            experience = 26,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
//                            experience = 28,
//                            rating = 4.8,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 13
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H5",
//                    name = "Ramdurg Emergency Care",
//                    cityId = "Ramdurg",
//                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
//                    rating = 4.7f,
//                    district = "Belagavi",
//                    distance = "0.8",
//                    reviewCount = "2.5k reviews",
//                    openingHours = "24/7 Emergency",
//                    phone = "+91 9090909090",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Akash Bannerjee",
//                            age = 48,
//                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
//                            experience = 23,
//                            rating = 4.9,
//                            appointments = mutableListOf(
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true
//                            ),
//                            localAppointments = 20
//                        ),
//                        Doctor(
//                            name = "Dr. Neha Chopra",
//                            age = 36,
//                            specialization = mutableListOf("Critical Care", "Pulmonology"),
//                            experience = 11,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 16
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
//                            experience = 28,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 19
//                        )
//                    )
//                )
//            )
//        )
//        ,
//        HospitalsData(
//            cityName = "Saundatti",
//            hospitals = mutableListOf(
//                Hospital(
//                    id = "H1",
//                    name = "Saundatti General Hospital",
//                    cityId = "Saundatti",
//                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
//                    rating = 4.0f,
//                    district = "Belagavi",
//                    distance = "1.5",
//                    reviewCount = "1.3k reviews",
//                    openingHours = "08:00 AM - 08:00 PM",
//                    phone = "+91 9876543210",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Rajeshwar Rao",
//                            age = 47,
//                            specialization = mutableListOf("General Medicine", "Diabetology"),
//                            experience = 22,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 10
//                        ),
//                        Doctor(
//                            name = "Dr. Ananya Desai",
//                            age = 35,
//                            specialization = mutableListOf("Cardiology", "Hypertension"),
//                            experience = 10,
//                            rating = 4.1,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Vikram Singh",
//                            age = 50,
//                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
//                            experience = 25,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, true, true, true, false, false, false, false,
//                                false, false, false, false, true, true, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 12
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H2",
//                    name = "Saundatti Women's Health Center",
//                    cityId = "Saundatti",
//                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
//                    rating = 4.3f,
//                    district = "Belagavi",
//                    distance = "2.0",
//                    reviewCount = "1.6k reviews",
//                    openingHours = "09:00 AM - 07:00 PM",
//                    phone = "+91 8765432109",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Priya Reddy",
//                            age = 40,
//                            specialization = mutableListOf("Gynecology", "Infertility"),
//                            experience = 15,
//                            rating = 4.5,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Arjun Malhotra",
//                            age = 45,
//                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
//                            experience = 20,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Nandini Sharma",
//                            age = 38,
//                            specialization = mutableListOf("Pediatrics", "Neonatology"),
//                            experience = 12,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 7
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H3",
//                    name = "Saundatti Ortho Care",
//                    cityId = "Saundatti",
//                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
//                    rating = 4.2f,
//                    district = "Belagavi",
//                    distance = "3.2",
//                    reviewCount = "1.1k reviews",
//                    openingHours = "08:30 AM - 07:30 PM",
//                    phone = "+91 7654321098",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Sanjay Gupta",
//                            age = 52,
//                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
//                            experience = 27,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 14
//                        ),
//                        Doctor(
//                            name = "Dr. Meera Krishnan",
//                            age = 39,
//                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
//                            experience = 14,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Rohan Mehra",
//                            age = 44,
//                            specialization = mutableListOf("Pain Management", "Spine Care"),
//                            experience = 18,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 10
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H4",
//                    name = "Saundatti Eye Care Center",
//                    cityId = "Saundatti",
//                    specialties = mutableListOf("Ophthalmology", "Optometry"),
//                    rating = 4.5f,
//                    district = "Belagavi",
//                    distance = "2.8",
//                    reviewCount = "1.9k reviews",
//                    openingHours = "09:00 AM - 06:00 PM",
//                    phone = "+91 6543210987",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Anjali Rao",
//                            age = 37,
//                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
//                            experience = 12,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Kavita Patel",
//                            age = 51,
//                            specialization = mutableListOf("Optometry", "Contact Lenses"),
//                            experience = 26,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
//                            experience = 28,
//                            rating = 4.8,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 13
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H5",
//                    name = "Saundatti Emergency Care",
//                    cityId = "Saundatti",
//                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
//                    rating = 4.7f,
//                    district = "Belagavi",
//                    distance = "0.8",
//                    reviewCount = "2.5k reviews",
//                    openingHours = "24/7 Emergency",
//                    phone = "+91 9090909090",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Akash Bannerjee",
//                            age = 48,
//                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
//                            experience = 23,
//                            rating = 4.9,
//                            appointments = mutableListOf(
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true
//                            ),
//                            localAppointments = 20
//                        ),
//                        Doctor(
//                            name = "Dr. Neha Chopra",
//                            age = 36,
//                            specialization = mutableListOf("Critical Care", "Pulmonology"),
//                            experience = 11,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 16
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
//                            experience = 28,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 19
//                        )
//                    )
//                )
//            )
//        )
//        ,
//        HospitalsData(
//            cityName = "Ballari",
//            hospitals = mutableListOf(
//                Hospital(
//                    id = "H1",
//                    name = "Ballari General Hospital",
//                    cityId = "Ballari",
//                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
//                    rating = 4.0f,
//                    district = "Ballari",
//                    distance = "1.5",
//                    reviewCount = "1.3k reviews",
//                    openingHours = "08:00 AM - 08:00 PM",
//                    phone = "+91 9876543210",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Rajeshwar Rao",
//                            age = 47,
//                            specialization = mutableListOf("General Medicine", "Diabetology"),
//                            experience = 22,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 10
//                        ),
//                        Doctor(
//                            name = "Dr. Ananya Desai",
//                            age = 35,
//                            specialization = mutableListOf("Cardiology", "Hypertension"),
//                            experience = 10,
//                            rating = 4.1,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Vikram Singh",
//                            age = 50,
//                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
//                            experience = 25,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, true, true, true, false, false, false, false,
//                                false, false, false, false, true, true, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 12
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H2",
//                    name = "Ballari Women's Health Center",
//                    cityId = "Ballari",
//                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
//                    rating = 4.3f,
//                    district = "Ballari",
//                    distance = "2.0",
//                    reviewCount = "1.6k reviews",
//                    openingHours = "09:00 AM - 07:00 PM",
//                    phone = "+91 8765432109",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Priya Reddy",
//                            age = 40,
//                            specialization = mutableListOf("Gynecology", "Infertility"),
//                            experience = 15,
//                            rating = 4.5,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Arjun Malhotra",
//                            age = 45,
//                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
//                            experience = 20,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Nandini Sharma",
//                            age = 38,
//                            specialization = mutableListOf("Pediatrics", "Neonatology"),
//                            experience = 12,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 7
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H3",
//                    name = "Ballari Ortho Care",
//                    cityId = "Ballari",
//                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
//                    rating = 4.2f,
//                    district = "Ballari",
//                    distance = "3.2",
//                    reviewCount = "1.1k reviews",
//                    openingHours = "08:30 AM - 07:30 PM",
//                    phone = "+91 7654321098",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Sanjay Gupta",
//                            age = 52,
//                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
//                            experience = 27,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 14
//                        ),
//                        Doctor(
//                            name = "Dr. Meera Krishnan",
//                            age = 39,
//                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
//                            experience = 14,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Rohan Mehra",
//                            age = 44,
//                            specialization = mutableListOf("Pain Management", "Spine Care"),
//                            experience = 18,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 10
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H4",
//                    name = "Ballari Eye Care Center",
//                    cityId = "Ballari",
//                    specialties = mutableListOf("Ophthalmology", "Optometry"),
//                    rating = 4.5f,
//                    district = "Ballari",
//                    distance = "2.8",
//                    reviewCount = "1.9k reviews",
//                    openingHours = "09:00 AM - 06:00 PM",
//                    phone = "+91 6543210987",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Anjali Rao",
//                            age = 37,
//                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
//                            experience = 12,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Kavita Patel",
//                            age = 51,
//                            specialization = mutableListOf("Optometry", "Contact Lenses"),
//                            experience = 26,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
//                            experience = 28,
//                            rating = 4.8,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 13
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H5",
//                    name = "Ballari Emergency Care",
//                    cityId = "Ballari",
//                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
//                    rating = 4.7f,
//                    district = "Ballari",
//                    distance = "0.8",
//                    reviewCount = "2.5k reviews",
//                    openingHours = "24/7 Emergency",
//                    phone = "+91 9090909090",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Akash Bannerjee",
//                            age = 48,
//                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
//                            experience = 23,
//                            rating = 4.9,
//                            appointments = mutableListOf(
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true
//                            ),
//                            localAppointments = 20
//                        ),
//                        Doctor(
//                            name = "Dr. Neha Chopra",
//                            age = 36,
//                            specialization = mutableListOf("Critical Care", "Pulmonology"),
//                            experience = 11,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 16
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
//                            experience = 28,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 19
//                        )
//                    )
//                )
//            )
//        )
//        ,
//        HospitalsData(
//            cityName = "Hospet",
//            hospitals = mutableListOf(
//                Hospital(
//                    id = "H1",
//                    name = "Hospet General Hospital",
//                    cityId = "Hospet",
//                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
//                    rating = 4.0f,
//                    district = "Ballari",
//                    distance = "1.5",
//                    reviewCount = "1.3k reviews",
//                    openingHours = "08:00 AM - 08:00 PM",
//                    phone = "+91 9876543210",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Rajeshwar Rao",
//                            age = 47,
//                            specialization = mutableListOf("General Medicine", "Diabetology"),
//                            experience = 22,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 10
//                        ),
//                        Doctor(
//                            name = "Dr. Ananya Desai",
//                            age = 35,
//                            specialization = mutableListOf("Cardiology", "Hypertension"),
//                            experience = 10,
//                            rating = 4.1,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Vikram Singh",
//                            age = 50,
//                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
//                            experience = 25,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, true, true, true, false, false, false, false,
//                                false, false, false, false, true, true, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 12
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H2",
//                    name = "Hospet Women's Health Center",
//                    cityId = "Hospet",
//                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
//                    rating = 4.3f,
//                    district = "Ballari",
//                    distance = "2.0",
//                    reviewCount = "1.6k reviews",
//                    openingHours = "09:00 AM - 07:00 PM",
//                    phone = "+91 8765432109",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Priya Reddy",
//                            age = 40,
//                            specialization = mutableListOf("Gynecology", "Infertility"),
//                            experience = 15,
//                            rating = 4.5,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Arjun Malhotra",
//                            age = 45,
//                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
//                            experience = 20,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Nandini Sharma",
//                            age = 38,
//                            specialization = mutableListOf("Pediatrics", "Neonatology"),
//                            experience = 12,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 7
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H3",
//                    name = "Hospet Ortho Care",
//                    cityId = "Hospet",
//                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
//                    rating = 4.2f,
//                    district = "Ballari",
//                    distance = "3.2",
//                    reviewCount = "1.1k reviews",
//                    openingHours = "08:30 AM - 07:30 PM",
//                    phone = "+91 7654321098",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Sanjay Gupta",
//                            age = 52,
//                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
//                            experience = 27,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 14
//                        ),
//                        Doctor(
//                            name = "Dr. Meera Krishnan",
//                            age = 39,
//                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
//                            experience = 14,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Rohan Mehra",
//                            age = 44,
//                            specialization = mutableListOf("Pain Management", "Spine Care"),
//                            experience = 18,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 10
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H4",
//                    name = "Hospet Eye Care Center",
//                    cityId = "Hospet",
//                    specialties = mutableListOf("Ophthalmology", "Optometry"),
//                    rating = 4.5f,
//                    district = "Ballari",
//                    distance = "2.8",
//                    reviewCount = "1.9k reviews",
//                    openingHours = "09:00 AM - 06:00 PM",
//                    phone = "+91 6543210987",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Anjali Rao",
//                            age = 37,
//                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
//                            experience = 12,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Kavita Patel",
//                            age = 51,
//                            specialization = mutableListOf("Optometry", "Contact Lenses"),
//                            experience = 26,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
//                            experience = 28,
//                            rating = 4.8,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 13
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H5",
//                    name = "Hospet Emergency Care",
//                    cityId = "Hospet",
//                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
//                    rating = 4.7f,
//                    district = "Ballari",
//                    distance = "0.8",
//                    reviewCount = "2.5k reviews",
//                    openingHours = "24/7 Emergency",
//                    phone = "+91 9090909090",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Akash Bannerjee",
//                            age = 48,
//                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
//                            experience = 23,
//                            rating = 4.9,
//                            appointments = mutableListOf(
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true
//                            ),
//                            localAppointments = 20
//                        ),
//                        Doctor(
//                            name = "Dr. Neha Chopra",
//                            age = 36,
//                            specialization = mutableListOf("Critical Care", "Pulmonology"),
//                            experience = 11,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 16
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
//                            experience = 28,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 19
//                        )
//                    )
//                )
//            )
//        )
//        ,
//
//        HospitalsData(
//            cityName = "Sandur",
//            hospitals = mutableListOf(
//                Hospital(
//                    id = "H1",
//                    name = "Sandur General Hospital",
//                    cityId = "Sandur",
//                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
//                    rating = 4.0f,
//                    district = "Ballari",
//                    distance = "1.5",
//                    reviewCount = "1.3k reviews",
//                    openingHours = "08:00 AM - 08:00 PM",
//                    phone = "+91 9876543210",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Rajeshwar Rao",
//                            age = 47,
//                            specialization = mutableListOf("General Medicine", "Diabetology"),
//                            experience = 22,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 10
//                        ),
//                        Doctor(
//                            name = "Dr. Ananya Desai",
//                            age = 35,
//                            specialization = mutableListOf("Cardiology", "Hypertension"),
//                            experience = 10,
//                            rating = 4.1,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Vikram Singh",
//                            age = 50,
//                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
//                            experience = 25,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, true, true, true, false, false, false, false,
//                                false, false, false, false, true, true, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 12
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H2",
//                    name = "Sandur Women's Health Center",
//                    cityId = "Sandur",
//                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
//                    rating = 4.3f,
//                    district = "Ballari",
//                    distance = "2.0",
//                    reviewCount = "1.6k reviews",
//                    openingHours = "09:00 AM - 07:00 PM",
//                    phone = "+91 8765432109",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Priya Reddy",
//                            age = 40,
//                            specialization = mutableListOf("Gynecology", "Infertility"),
//                            experience = 15,
//                            rating = 4.5,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Arjun Malhotra",
//                            age = 45,
//                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
//                            experience = 20,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Nandini Sharma",
//                            age = 38,
//                            specialization = mutableListOf("Pediatrics", "Neonatology"),
//                            experience = 12,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 7
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H3",
//                    name = "Sandur Ortho Care",
//                    cityId = "Sandur",
//                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
//                    rating = 4.2f,
//                    district = "Ballari",
//                    distance = "3.2",
//                    reviewCount = "1.1k reviews",
//                    openingHours = "08:30 AM - 07:30 PM",
//                    phone = "+91 7654321098",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Sanjay Gupta",
//                            age = 52,
//                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
//                            experience = 27,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 14
//                        ),
//                        Doctor(
//                            name = "Dr. Meera Krishnan",
//                            age = 39,
//                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
//                            experience = 14,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Rohan Mehra",
//                            age = 44,
//                            specialization = mutableListOf("Pain Management", "Spine Care"),
//                            experience = 18,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 10
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H4",
//                    name = "Sandur Eye Care Center",
//                    cityId = "Sandur",
//                    specialties = mutableListOf("Ophthalmology", "Optometry"),
//                    rating = 4.5f,
//                    district = "Ballari",
//                    distance = "2.8",
//                    reviewCount = "1.9k reviews",
//                    openingHours = "09:00 AM - 06:00 PM",
//                    phone = "+91 6543210987",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Anjali Rao",
//                            age = 37,
//                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
//                            experience = 12,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Kavita Patel",
//                            age = 51,
//                            specialization = mutableListOf("Optometry", "Contact Lenses"),
//                            experience = 26,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
//                            experience = 28,
//                            rating = 4.8,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 13
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H5",
//                    name = "Sandur Emergency Care",
//                    cityId = "Sandur",
//                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
//                    rating = 4.7f,
//                    district = "Ballari",
//                    distance = "0.8",
//                    reviewCount = "2.5k reviews",
//                    openingHours = "24/7 Emergency",
//                    phone = "+91 9090909090",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Akash Bannerjee",
//                            age = 48,
//                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
//                            experience = 23,
//                            rating = 4.9,
//                            appointments = mutableListOf(
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true
//                            ),
//                            localAppointments = 20
//                        ),
//                        Doctor(
//                            name = "Dr. Neha Chopra",
//                            age = 36,
//                            specialization = mutableListOf("Critical Care", "Pulmonology"),
//                            experience = 11,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 16
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
//                            experience = 28,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 19
//                        )
//                    )
//                )
//            )
//        )
//
//        ,
//
//        HospitalsData(
//            cityName = "Chikballapur",
//            hospitals = mutableListOf(
//                Hospital(
//                    id = "H1",
//                    name = "Chikballapur General Hospital",
//                    cityId = "Chikballapur",
//                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
//                    rating = 4.0f,
//                    district = "Chikballapur",
//                    distance = "1.5",
//                    reviewCount = "1.3k reviews",
//                    openingHours = "08:00 AM - 08:00 PM",
//                    phone = "+91 9876543210",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Rajeshwar Rao",
//                            age = 47,
//                            specialization = mutableListOf("General Medicine", "Diabetology"),
//                            experience = 22,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 10
//                        ),
//                        Doctor(
//                            name = "Dr. Ananya Desai",
//                            age = 35,
//                            specialization = mutableListOf("Cardiology", "Hypertension"),
//                            experience = 10,
//                            rating = 4.1,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Vikram Singh",
//                            age = 50,
//                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
//                            experience = 25,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, true, true, true, false, false, false, false,
//                                false, false, false, false, true, true, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 12
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H2",
//                    name = "Chikballapur Women's Health Center",
//                    cityId = "Chikballapur",
//                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
//                    rating = 4.3f,
//                    district = "Chikballapur",
//                    distance = "2.0",
//                    reviewCount = "1.6k reviews",
//                    openingHours = "09:00 AM - 07:00 PM",
//                    phone = "+91 8765432109",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Priya Reddy",
//                            age = 40,
//                            specialization = mutableListOf("Gynecology", "Infertility"),
//                            experience = 15,
//                            rating = 4.5,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Arjun Malhotra",
//                            age = 45,
//                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
//                            experience = 20,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Nandini Sharma",
//                            age = 38,
//                            specialization = mutableListOf("Pediatrics", "Neonatology"),
//                            experience = 12,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 7
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H3",
//                    name = "Chikballapur Ortho Care",
//                    cityId = "Chikballapur",
//                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
//                    rating = 4.2f,
//                    district = "Chikballapur",
//                    distance = "3.2",
//                    reviewCount = "1.1k reviews",
//                    openingHours = "08:30 AM - 07:30 PM",
//                    phone = "+91 7654321098",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Sanjay Gupta",
//                            age = 52,
//                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
//                            experience = 27,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 14
//                        ),
//                        Doctor(
//                            name = "Dr. Meera Krishnan",
//                            age = 39,
//                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
//                            experience = 14,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Rohan Mehra",
//                            age = 44,
//                            specialization = mutableListOf("Pain Management", "Spine Care"),
//                            experience = 18,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 10
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H4",
//                    name = "Chikballapur Eye Care Center",
//                    cityId = "Chikballapur",
//                    specialties = mutableListOf("Ophthalmology", "Optometry"),
//                    rating = 4.5f,
//                    district = "Chikballapur",
//                    distance = "2.8",
//                    reviewCount = "1.9k reviews",
//                    openingHours = "09:00 AM - 06:00 PM",
//                    phone = "+91 6543210987",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Anjali Rao",
//                            age = 37,
//                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
//                            experience = 12,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Kavita Patel",
//                            age = 51,
//                            specialization = mutableListOf("Optometry", "Contact Lenses"),
//                            experience = 26,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
//                            experience = 28,
//                            rating = 4.8,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 13
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H5",
//                    name = "Chikballapur Emergency Care",
//                    cityId = "Chikballapur",
//                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
//                    rating = 4.7f,
//                    district = "Chikballapur",
//                    distance = "0.8",
//                    reviewCount = "2.5k reviews",
//                    openingHours = "24/7 Emergency",
//                    phone = "+91 9090909090",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Akash Bannerjee",
//                            age = 48,
//                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
//                            experience = 23,
//                            rating = 4.9,
//                            appointments = mutableListOf(
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true
//                            ),
//                            localAppointments = 20
//                        ),
//                        Doctor(
//                            name = "Dr. Neha Chopra",
//                            age = 36,
//                            specialization = mutableListOf("Critical Care", "Pulmonology"),
//                            experience = 11,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 16
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
//                            experience = 28,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 19
//                        )
//                    )
//                )
//            )
//        )
//        ,
//
//        HospitalsData(
//            cityName = "Chitradurga",
//            hospitals = mutableListOf(
//                Hospital(
//                    id = "H1",
//                    name = "Chitradurga General Hospital",
//                    cityId = "Chitradurga",
//                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
//                    rating = 4.0f,
//                    district = "Chitradurga",
//                    distance = "1.5",
//                    reviewCount = "1.3k reviews",
//                    openingHours = "08:00 AM - 08:00 PM",
//                    phone = "+91 9876543210",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Rajeshwar Rao",
//                            age = 47,
//                            specialization = mutableListOf("General Medicine", "Diabetology"),
//                            experience = 22,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 10
//                        ),
//                        Doctor(
//                            name = "Dr. Ananya Desai",
//                            age = 35,
//                            specialization = mutableListOf("Cardiology", "Hypertension"),
//                            experience = 10,
//                            rating = 4.1,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Vikram Singh",
//                            age = 50,
//                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
//                            experience = 25,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, true, true, true, false, false, false, false,
//                                false, false, false, false, true, true, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 12
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H2",
//                    name = "Chitradurga Women's Health Center",
//                    cityId = "Chitradurga",
//                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
//                    rating = 4.3f,
//                    district = "Chitradurga",
//                    distance = "2.0",
//                    reviewCount = "1.6k reviews",
//                    openingHours = "09:00 AM - 07:00 PM",
//                    phone = "+91 8765432109",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Priya Reddy",
//                            age = 40,
//                            specialization = mutableListOf("Gynecology", "Infertility"),
//                            experience = 15,
//                            rating = 4.5,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Arjun Malhotra",
//                            age = 45,
//                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
//                            experience = 20,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Nandini Sharma",
//                            age = 38,
//                            specialization = mutableListOf("Pediatrics", "Neonatology"),
//                            experience = 12,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 7
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H3",
//                    name = "Chitradurga Ortho Care",
//                    cityId = "Chitradurga",
//                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
//                    rating = 4.2f,
//                    district = "Chitradurga",
//                    distance = "3.2",
//                    reviewCount = "1.1k reviews",
//                    openingHours = "08:30 AM - 07:30 PM",
//                    phone = "+91 7654321098",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Sanjay Gupta",
//                            age = 52,
//                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
//                            experience = 27,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 14
//                        ),
//                        Doctor(
//                            name = "Dr. Meera Krishnan",
//                            age = 39,
//                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
//                            experience = 14,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Rohan Mehra",
//                            age = 44,
//                            specialization = mutableListOf("Pain Management", "Spine Care"),
//                            experience = 18,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 10
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H4",
//                    name = "Chitradurga Eye Care Center",
//                    cityId = "Chitradurga",
//                    specialties = mutableListOf("Ophthalmology", "Optometry"),
//                    rating = 4.5f,
//                    district = "Chitradurga",
//                    distance = "2.8",
//                    reviewCount = "1.9k reviews",
//                    openingHours = "09:00 AM - 06:00 PM",
//                    phone = "+91 6543210987",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Anjali Rao",
//                            age = 37,
//                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
//                            experience = 12,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Kavita Patel",
//                            age = 51,
//                            specialization = mutableListOf("Optometry", "Contact Lenses"),
//                            experience = 26,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
//                            experience = 28,
//                            rating = 4.8,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 13
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H5",
//                    name = "Chitradurga Emergency Care",
//                    cityId = "Chitradurga",
//                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
//                    rating = 4.7f,
//                    district = "Chitradurga",
//                    distance = "0.8",
//                    reviewCount = "2.5k reviews",
//                    openingHours = "24/7 Emergency",
//                    phone = "+91 9090909090",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Akash Bannerjee",
//                            age = 48,
//                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
//                            experience = 23,
//                            rating = 4.9,
//                            appointments = mutableListOf(
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true
//                            ),
//                            localAppointments = 20
//                        ),
//                        Doctor(
//                            name = "Dr. Neha Chopra",
//                            age = 36,
//                            specialization = mutableListOf("Critical Care", "Pulmonology"),
//                            experience = 11,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 16
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
//                            experience = 28,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 19
//                        )
//                    )
//                )
//            )
//        )
//        ,
//        HospitalsData(
//            cityName = "Moodabidri",
//            hospitals = mutableListOf(
//                Hospital(
//                    id = "H1",
//                    name = "Moodabidri General Hospital",
//                    cityId = "Moodabidri",
//                    specialties = mutableListOf("General Medicine", "Cardiology", "Orthopedics"),
//                    rating = 4.0f,
//                    district = "Dakshina Kannada",
//                    distance = "1.5",
//                    reviewCount = "1.3k reviews",
//                    openingHours = "08:00 AM - 08:00 PM",
//                    phone = "+91 9876543210",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Rajeshwar Rao",
//                            age = 47,
//                            specialization = mutableListOf("General Medicine", "Diabetology"),
//                            experience = 22,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 10
//                        ),
//                        Doctor(
//                            name = "Dr. Ananya Desai",
//                            age = 35,
//                            specialization = mutableListOf("Cardiology", "Hypertension"),
//                            experience = 10,
//                            rating = 4.1,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Vikram Singh",
//                            age = 50,
//                            specialization = mutableListOf("Orthopedics", "Sports Medicine"),
//                            experience = 25,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, true, true, true, false, false, false, false,
//                                false, false, false, false, true, true, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 12
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H2",
//                    name = "Moodabidri Women's Health Center",
//                    cityId = "Moodabidri",
//                    specialties = mutableListOf("Gynecology", "Obstetrics", "Pediatrics"),
//                    rating = 4.3f,
//                    district = "Dakshina Kannada",
//                    distance = "2.0",
//                    reviewCount = "1.6k reviews",
//                    openingHours = "09:00 AM - 07:00 PM",
//                    phone = "+91 8765432109",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Priya Reddy",
//                            age = 40,
//                            specialization = mutableListOf("Gynecology", "Infertility"),
//                            experience = 15,
//                            rating = 4.5,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Arjun Malhotra",
//                            age = 45,
//                            specialization = mutableListOf("Obstetrics", "High-Risk Pregnancy"),
//                            experience = 20,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Nandini Sharma",
//                            age = 38,
//                            specialization = mutableListOf("Pediatrics", "Neonatology"),
//                            experience = 12,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 7
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H3",
//                    name = "Moodabidri Ortho Care",
//                    cityId = "Moodabidri",
//                    specialties = mutableListOf("Orthopedics", "Physiotherapy", "Pain Management"),
//                    rating = 4.2f,
//                    district = "Dakshina Kannada",
//                    distance = "3.2",
//                    reviewCount = "1.1k reviews",
//                    openingHours = "08:30 AM - 07:30 PM",
//                    phone = "+91 7654321098",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Sanjay Gupta",
//                            age = 52,
//                            specialization = mutableListOf("Orthopedics", "Joint Replacement"),
//                            experience = 27,
//                            rating = 4.4,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 14
//                        ),
//                        Doctor(
//                            name = "Dr. Meera Krishnan",
//                            age = 39,
//                            specialization = mutableListOf("Physiotherapy", "Rehabilitation"),
//                            experience = 14,
//                            rating = 4.2,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 8
//                        ),
//                        Doctor(
//                            name = "Dr. Rohan Mehra",
//                            age = 44,
//                            specialization = mutableListOf("Pain Management", "Spine Care"),
//                            experience = 18,
//                            rating = 4.3,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 10
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H4",
//                    name = "Moodabidri Eye Care Center",
//                    cityId = "Moodabidri",
//                    specialties = mutableListOf("Ophthalmology", "Optometry"),
//                    rating = 4.5f,
//                    district = "Dakshina Kannada",
//                    distance = "2.8",
//                    reviewCount = "1.9k reviews",
//                    openingHours = "09:00 AM - 06:00 PM",
//                    phone = "+91 6543210987",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Anjali Rao",
//                            age = 37,
//                            specialization = mutableListOf("Ophthalmology", "Cataract Surgery"),
//                            experience = 12,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 9
//                        ),
//                        Doctor(
//                            name = "Dr. Kavita Patel",
//                            age = 51,
//                            specialization = mutableListOf("Optometry", "Contact Lenses"),
//                            experience = 26,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 11
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Retina Specialist", "Glaucoma"),
//                            experience = 28,
//                            rating = 4.8,
//                            appointments = mutableListOf(
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true,
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true
//                            ),
//                            localAppointments = 13
//                        )
//                    )
//                ),
//                Hospital(
//                    id = "H5",
//                    name = "Moodabidri Emergency Care",
//                    cityId = "Moodabidri",
//                    specialties = mutableListOf("Emergency Medicine", "Trauma Care"),
//                    rating = 4.7f,
//                    district = "Dakshina Kannada",
//                    distance = "0.8",
//                    reviewCount = "2.5k reviews",
//                    openingHours = "24/7 Emergency",
//                    phone = "+91 9090909090",
//                    doctors = mutableListOf(
//                        Doctor(
//                            name = "Dr. Akash Bannerjee",
//                            age = 48,
//                            specialization = mutableListOf("Trauma Surgery", "Emergency Care"),
//                            experience = 23,
//                            rating = 4.9,
//                            appointments = mutableListOf(
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true,
//                                true, true, true, true, true, true, true, true
//                            ),
//                            localAppointments = 20
//                        ),
//                        Doctor(
//                            name = "Dr. Neha Chopra",
//                            age = 36,
//                            specialization = mutableListOf("Critical Care", "Pulmonology"),
//                            experience = 11,
//                            rating = 4.6,
//                            appointments = mutableListOf(
//                                true, false, true, false, true, false, true, false,
//                                false, true, false, true, false, true, false, true,
//                                true, true, false, false, true, true, false, false,
//                                false, false, true, true, false, false, true, true
//                            ),
//                            localAppointments = 16
//                        ),
//                        Doctor(
//                            name = "Dr. Ravi Shastri",
//                            age = 53,
//                            specialization = mutableListOf("Disaster Medicine", "Toxicology"),
//                            experience = 28,
//                            rating = 4.7,
//                            appointments = mutableListOf(
//                                false, true, false, true, false, true, false, true,
//                                true, false, true, false, true, false, true, false,
//                                false, false, true, true, false, false, true, true,
//                                true, true, false, false, true, true, false, false
//                            ),
//                            localAppointments = 19
//                        )
//                    )
//                )
//            )
//        )
)