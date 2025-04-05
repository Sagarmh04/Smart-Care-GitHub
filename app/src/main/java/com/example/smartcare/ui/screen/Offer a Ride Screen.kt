package com.example.smartcare.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.smartcare.database.RideDTO
import com.example.smartcare.database.StopDTO
import com.example.smartcare.database.entity.Ride
import com.example.smartcare.database.entity.Stop
import com.example.smartcare.database.viewModel.RideViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferRideScreen(
    navController: NavController,
    rideViewModel: RideViewModel,
    auth: FirebaseAuth
) {
    val scrollState = rememberScrollState()

    // State variables for form fields
    var pickupLocation by remember { mutableStateOf("") }
    var destination by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var rideType by remember { mutableStateOf("Solo") }
    var paymentMethod by remember { mutableStateOf("Cash") }

    // Predefined locations
    val locations = listOf(
        "Main Campus", "Library", "Student Center", "Engineering Building",
        "Science Complex", "Arts Center", "Sports Complex", "Downtown",
        "North Residence", "South Residence", "East Residence", "West Residence",
        "Bus Terminal", "Train Station", "Shopping Mall", "Airport"
    )

    // Dropdown menu states
    var pickupExpanded by remember { mutableStateOf(false) }
    var destinationExpanded by remember { mutableStateOf(false) }
    var rideTypeExpanded by remember { mutableStateOf(false) }
    var paymentMethodExpanded by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Offer a Ride") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Pickup Location Dropdown
            ExposedDropdownMenuBox(
                expanded = pickupExpanded,
                onExpandedChange = { pickupExpanded = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                OutlinedTextField(
                    value = pickupLocation,
                    onValueChange = { pickupLocation = it },
                    label = { Text("Pickup Location") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = pickupExpanded)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )

                ExposedDropdownMenu(
                    expanded = pickupExpanded,
                    onDismissRequest = { pickupExpanded = false }
                ) {
                    locations.forEach { location ->
                        DropdownMenuItem(
                            text = { Text(location) },
                            onClick = {
                                pickupLocation = location
                                pickupExpanded = false
                            }
                        )
                    }
                }
            }

            // Destination Dropdown
            ExposedDropdownMenuBox(
                expanded = destinationExpanded,
                onExpandedChange = { destinationExpanded = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                OutlinedTextField(
                    value = destination,
                    onValueChange = { destination = it },
                    label = { Text("Destination") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = destinationExpanded)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )

                ExposedDropdownMenu(
                    expanded = destinationExpanded,
                    onDismissRequest = { destinationExpanded = false }
                ) {
                    locations.forEach { location ->
                        DropdownMenuItem(
                            text = { Text(location) },
                            onClick = {
                                destination = location
                                destinationExpanded = false
                            }
                        )
                    }
                }
            }

            // Date Field
            OutlinedTextField(
                value = date,
                onValueChange = { date = it },
                label = { Text("Date (DD/MM/YYYY)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                trailingIcon = {
                    Icon(Icons.Default.DateRange, contentDescription = "Select Date")
                }
            )

            // Time Field
            OutlinedTextField(
                value = time,
                onValueChange = { time = it },
                label = { Text("Time (HH:MM)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Price Field
            OutlinedTextField(
                value = price,
                onValueChange = { price = it },
                label = { Text("Price (₹)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Ride Type Dropdown
            ExposedDropdownMenuBox(
                expanded = rideTypeExpanded,
                onExpandedChange = { rideTypeExpanded = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                OutlinedTextField(
                    value = rideType,
                    onValueChange = { rideType = it },
                    label = { Text("Ride Type") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = rideTypeExpanded)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )

                ExposedDropdownMenu(
                    expanded = rideTypeExpanded,
                    onDismissRequest = { rideTypeExpanded = false }
                ) {
                    listOf("Solo", "Shared").forEach { type ->
                        DropdownMenuItem(
                            text = { Text(type) },
                            onClick = {
                                rideType = type
                                rideTypeExpanded = false
                            }
                        )
                    }
                }
            }

            // Payment Method Dropdown
            ExposedDropdownMenuBox(
                expanded = paymentMethodExpanded,
                onExpandedChange = { paymentMethodExpanded = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            ) {
                OutlinedTextField(
                    value = paymentMethod,
                    onValueChange = { paymentMethod = it },
                    label = { Text("Payment Method") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = paymentMethodExpanded)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )

                ExposedDropdownMenu(
                    expanded = paymentMethodExpanded,
                    onDismissRequest = { paymentMethodExpanded = false }
                ) {
                    listOf("Cash", "Card", "UPI").forEach { method ->
                        DropdownMenuItem(
                            text = { Text(method) },
                            onClick = {
                                paymentMethod = method
                                paymentMethodExpanded = false
                            }
                        )
                    }
                }
            }

            // Submit Button
            Button(
                onClick = {
                    // Create a new ride and save it
                    val newRide = auth.currentUser?.let {
                        Ride(
                            id = UUID.randomUUID().toString(),
                            driverId = it.uid, // Replace with actual user ID
                            passengerId = "emptyList()",
                            pickupLocationName = pickupLocation,
                            destinationName = destination,
                            date = date,
                            time = time,
                            middleStops = emptyList<Stop>(),
                            status = "Available",
                            price = price.toDoubleOrNull() ?: 0.0,
                            rating = 0.0,
                            review = "",
                            paymentMethod = paymentMethod,
                            paymentStatus = "Pending",
                            rideType = rideType,
                            noOfPassenger = 2
                        )
                    }

                    if (newRide != null) {
                        rideViewModel.insertRide(newRide)
                        uploadRideToFirestore(newRide)
                    }
                    navController.navigateUp()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                enabled = pickupLocation.isNotEmpty() && destination.isNotEmpty() &&
                        date.isNotEmpty() && time.isNotEmpty() && price.isNotEmpty()
            ) {
                Text("Offer Ride")
            }
        }
    }
}

fun Ride.toDTO(): RideDTO {
    return RideDTO(
        id = id,
        driverId = driverId,
        passengerId = passengerId,
        noOfPassenger = noOfPassenger,
        pickupLocationName = pickupLocationName,
        destinationName = destinationName,
        middleStops = middleStops.map { it.toDTO() },
        date = date,
        time = time,
        status = status,
        price = price,
        rating = rating,
        review = review,
        paymentMethod = paymentMethod,
        paymentStatus = paymentStatus,
        rideType = rideType
    )
}

fun Stop.toDTO(): StopDTO {
    return StopDTO(
        stopName = stopName,
        lat = lat,
        lng = lng
    )
}
fun uploadRideToFirestore(ride: Ride) {
    val db = FirebaseFirestore.getInstance()
    val rideDTO = ride.toDTO()

    db.collection("rides")
        .document(rideDTO.id)
        .set(rideDTO)
        .addOnSuccessListener {
//            Log.d("Firestore", "Ride uploaded successfully.")
        }
        .addOnFailureListener { e ->
//            Log.e("Firestore", "Error uploading ride", e)
        }
}

data class RideDTOf(
    val id: String = "",
    val driverId: String = "",
    val passengerId: String = "",
    val noOfPassenger: Int = 0,
    val pickupLocationName: String = "",
    val destinationName: String = "",
    val middleStops: List<StopDTO> = emptyList<StopDTO>(),
    val date: String = "",
    val time: String = "",
    val status: String = "",
    val price: Double = 0.0,
    val rating: Double = 0.0,
    val review: String = "",
    val paymentMethod: String = "",
    val paymentStatus: String = "",
    val rideType: String = ""
)

data class StopDTO(
    val stopName: String = "",
    val lat: Double = 0.0,
    val lng: Double = 0.0
)

fun RideDTOf.toEntity(): Ride {
    return Ride(
        id = id,
        driverId = driverId,
        passengerId = passengerId,
        noOfPassenger = noOfPassenger,
        pickupLocationName = pickupLocationName,
        destinationName = destinationName,
        middleStops = middleStops.map { it.toEntity() },
        date = date,
        time = time,
        status = status,
        price = price,
        rating = rating,
        review = review,
        paymentMethod = paymentMethod,
        paymentStatus = paymentStatus,
        rideType = rideType
    )
}

fun StopDTO.toEntity(): Stop {
    return Stop(
        stopName = stopName,
        lat = lat,
        lng = lng
    )
}
