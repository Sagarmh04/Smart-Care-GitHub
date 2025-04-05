package com.example.smartcare.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartcare.database.RideDTO
import com.example.smartcare.database.entity.Ride
import com.example.smartcare.database.viewModel.RideViewModel
import com.google.firebase.firestore.FirebaseFirestore

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindRideScreen(
    navController: NavController,
    rideViewModel: RideViewModel,
    uid: String,
    rideViewModel1: RideViewModel
) {
    val scrollState = rememberScrollState()

    // State variables for form fields
    var pickupLocation by remember { mutableStateOf("") }
    var destination by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var timeRange by remember { mutableStateOf("") }
    var rideType by remember { mutableStateOf("Any") }

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

    // Get all rides and filter them
    val allRides by rideViewModel.allRides.observeAsState()
    var filteredRides = remember(allRides, pickupLocation, destination, rideType) {
        allRides?.filter { ride ->
            (pickupLocation.isEmpty() || ride.pickupLocationName == pickupLocation) &&
                    (destination.isEmpty() || ride.destinationName == destination) &&
                    (rideType == "Any" || ride.rideType == rideType) &&
                    ride.status == "Available"
        }
    }
    getAllRidesFromFirestore { rides->
        filteredRides=rides
    }

    var showResults by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Find a Ride") },
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
        ) {
            if (!showResults) {
                // Search Form
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
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

                    // Time Range Field
                    OutlinedTextField(
                        value = timeRange,
                        onValueChange = { timeRange = it },
                        label = { Text("Preferred Time Range (e.g., 14:00-16:00)") },
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
                            .padding(bottom = 24.dp)
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
                            listOf("Any", "Solo", "Shared").forEach { type ->
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

                    // Search Button
                    Button(
                        onClick = { showResults = true },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        enabled = pickupLocation.isNotEmpty() && destination.isNotEmpty()
                    ) {
                        Text("Search Rides")
                    }
                }
            } else {
                // Results Screen
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Header
                    Text(
                        text = "Available Rides",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    if (filteredRides != null) {
                        if (filteredRides!!.isEmpty()) {
                            // No rides found
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "No rides found matching your criteria",
                                    fontSize = 16.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        } else {
                            // List of available rides
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                            ) {
                                items(filteredRides!!) { ride ->
                                    AvailableRideItem(
                                        ride = ride,
                                        onBookClick = {
                                            // Book the ride
                                            val updatedRide = ride.copy(
                                                passengerId = uid, // Replace with actual user ID
                                                status = "Booked"
                                            )
                                            rideViewModel.updateRide(updatedRide)
                                            updateRideInFirestore(ride=updatedRide,uid =uid, rideViewModel = rideViewModel)
                                            syncRidesFromCloud(rideViewModel = rideViewModel1, uid = uid)
                                            navController.navigateUp()
                                        }
                                    )
                                }
                            }
                        }
                    }

                    // Back to Search Button
                    Button(
                        onClick = { showResults = false },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    ) {
                        Text("Back to Search")
                    }
                }
            }
        }
    }
}
fun updateRideInFirestore(ride: Ride, rideViewModel: RideViewModel,uid: String) {
    val db = FirebaseFirestore.getInstance()
    val rideDTO = ride.toDTO() // Reuse the toDTO() you already have

    db.collection("rides")
        .document(rideDTO.id)
        .set(rideDTO) // Replace the entire ride document with updated fields
        .addOnSuccessListener {
            syncRidesFromCloud(
                rideViewModel = rideViewModel,
                uid = uid
            )
//            Log.d("Firestore", "Ride ${rideDTO.id} updated successfully.")
        }
        .addOnFailureListener { e ->
//            Log.e("Firestore", "Error updating ride ${rideDTO.id}", e)
        }
}

@Composable
fun AvailableRideItem(
    ride: Ride,
    onBookClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${ride.pickupLocationName} → ${ride.destinationName}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                Text(
                    text = "₹${ride.price}",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "${ride.date} at ${ride.time}",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Ride Type: ${ride.rideType}",
                fontSize = 14.sp
            )

            Text(
                text = "Payment: ${ride.paymentMethod}",
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onBookClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Book This Ride")
            }
        }
    }
}
fun getAllRidesFromFirestore(onResult: (List<Ride>) -> Unit) {
    val db = FirebaseFirestore.getInstance()

    db.collection("rides")
        .get()
        .addOnSuccessListener { result ->
            val rideList = result.mapNotNull { document ->
                document.toObject(RideDTOf::class.java).toEntity() // Convert DTO to Room entity
            }
            onResult(rideList) // Return the list via callback
        }
        .addOnFailureListener { e ->
//            Log.e("Firestore", "Error fetching rides", e)
            onResult(emptyList()) // Return empty list if failure
        }
}

