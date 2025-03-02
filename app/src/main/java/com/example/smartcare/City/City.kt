package com.example.smartcare.City

// Create a new file: City.kt
data class City(
    val id: String,       // Unique identifier (we'll generate)
    val name: String,     // First part (e.g., "Bagalkot")
    val district: String, // Second part (e.g., "Bagalkot")
    val fullName: String  // Full display format (e.g., "Bagalkot, Bagalkot, Karnataka")
)

// Parsing function
fun parseCities(rawCities: List<String>): List<City> {
    return rawCities.mapIndexed { index, cityString ->
        val parts = cityString.split(",").map { it.trim() }
        City(
            id = "city_${index + 1}",
            name = parts[0],
            district = parts[1],
            fullName = cityString
        )
    }
}