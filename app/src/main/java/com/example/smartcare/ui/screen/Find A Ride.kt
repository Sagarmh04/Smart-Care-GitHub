package com.example.smartcare.ui.screen

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartcare.database.RideDTO
import com.example.smartcare.database.entity.Ride
import com.example.smartcare.database.viewModel.RideViewModel
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun AvailableRideItem(
    ride: Ride,
    onBookClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "${ride.pickupLocationName} ➝ ${ride.destinationName}",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text("Date: ${ride.date}", style = MaterialTheme.typography.bodyMedium)
            Text("Time: ${ride.time}", style = MaterialTheme.typography.bodyMedium)
            Text("Type: ${ride.rideType}", style = MaterialTheme.typography.bodyMedium)
            Text("Seats Available: 6, style = MaterialTheme.typography.bodyMedium)")

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onBookClick,
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Book Ride")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindRideScreen(
    navController: NavController,
    rideViewModel: RideViewModel,
    uid: String,
    rideViewModel1: RideViewModel
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    var pickupLocation by remember { mutableStateOf("") }
    var destination by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var rideType by remember { mutableStateOf("Any") }
    var gender by remember { mutableStateOf("") }
    var numSeats by remember { mutableStateOf("") }

    val locations = listOf(
        "Main Campus", "Library", "Student Center", "Engineering Building",
        "Science Complex", "Arts Center", "Sports Complex", "Downtown",
        "North Residence", "South Residence", "East Residence", "West Residence",
        "Bus Terminal", "Train Station", "Shopping Mall", "Airport"
    )

    val allRides by rideViewModel.allRides.observeAsState()
    val filteredRides = remember(allRides, pickupLocation, destination, rideType) {
        allRides?.filter { ride ->
            (pickupLocation.isEmpty() || ride.pickupLocationName == pickupLocation) &&
                    (destination.isEmpty() || ride.destinationName == destination) &&
                    (rideType == "Any" || ride.rideType == rideType) &&
                    ride.status == "Available"
        }
    }

    var pickupExpanded by remember { mutableStateOf(false) }
    var destinationExpanded by remember { mutableStateOf(false) }
    var rideTypeExpanded by remember { mutableStateOf(false) }
    var genderExpanded by remember { mutableStateOf(false) }
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
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(scrollState),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ExposedDropdownMenuBox(
                        expanded = pickupExpanded,
                        onExpandedChange = { pickupExpanded = it },
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                    ) {
                        OutlinedTextField(
                            value = pickupLocation,
                            onValueChange = { pickupLocation = it },
                            label = { Text("Pickup Location") },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = pickupExpanded)
                            },
                            modifier = Modifier.fillMaxWidth().menuAnchor()
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

                    ExposedDropdownMenuBox(
                        expanded = destinationExpanded,
                        onExpandedChange = { destinationExpanded = it },
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                    ) {
                        OutlinedTextField(
                            value = destination,
                            onValueChange = { destination = it },
                            label = { Text("Destination") },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = destinationExpanded)
                            },
                            modifier = Modifier.fillMaxWidth().menuAnchor()
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

                    OutlinedTextField(
                        value = date,
                        onValueChange = {},
                        label = { Text("Date") },
                        trailingIcon = {
                            IconButton(onClick = {
                                val calendar = Calendar.getInstance()
                                DatePickerDialog(
                                    context,
                                    { _, year, month, dayOfMonth ->
                                        date = "%02d/%02d/%04d".format(dayOfMonth, month + 1, year)
                                    },
                                    calendar.get(Calendar.YEAR),
                                    calendar.get(Calendar.MONTH),
                                    calendar.get(Calendar.DAY_OF_MONTH)
                                ).show()
                            }) {
                                Icon(Icons.Default.DateRange, contentDescription = "Select Date")
                            }
                        },
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                        readOnly = true
                    )

                    OutlinedTextField(
                        value = time,
                        onValueChange = {},
                        label = { Text("Time") },
                        trailingIcon = {
                            IconButton(onClick = {
                                val calendar = Calendar.getInstance()
                                TimePickerDialog(
                                    context,
                                    { _, hour, minute ->
                                        time = "%02d:%02d".format(hour, minute)
                                    },
                                    calendar.get(Calendar.HOUR_OF_DAY),
                                    calendar.get(Calendar.MINUTE),
                                    true
                                ).show()
                            }) {
                                Icon(Icons.Default.AccessTime, contentDescription = "Select Time")
                            }
                        },
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                        readOnly = true
                    )

                    ExposedDropdownMenuBox(
                        expanded = rideTypeExpanded,
                        onExpandedChange = { rideTypeExpanded = it },
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                    ) {
                        OutlinedTextField(
                            value = rideType,
                            onValueChange = { rideType = it },
                            label = { Text("Ride Type") },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = rideTypeExpanded)
                            },
                            modifier = Modifier.fillMaxWidth().menuAnchor()
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

                    ExposedDropdownMenuBox(
                        expanded = genderExpanded,
                        onExpandedChange = { genderExpanded = it },
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                    ) {
                        OutlinedTextField(
                            value = gender,
                            onValueChange = { gender = it },
                            label = { Text("Gender") },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = genderExpanded)
                            },
                            modifier = Modifier.fillMaxWidth().menuAnchor()
                        )
                        ExposedDropdownMenu(
                            expanded = genderExpanded,
                            onDismissRequest = { genderExpanded = false }
                        ) {
                            listOf("Male", "Female", "Other").forEach { g ->
                                DropdownMenuItem(
                                    text = { Text(g) },
                                    onClick = {
                                        gender = g
                                        genderExpanded = false
                                    }
                                )
                            }
                        }
                    }

                    OutlinedTextField(
                        value = numSeats,
                        onValueChange = { if (it.length <= 1 && it.all { ch -> ch.isDigit() }) numSeats = it },
                        label = { Text("Number of Seats") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)
                    )

                    Button(
                        onClick = { showResults = true },
                        modifier = Modifier.fillMaxWidth().height(50.dp),
                        enabled = pickupLocation.isNotEmpty() && destination.isNotEmpty()
                    ) {
                        Text("Search Rides")
                    }
                }
            } else {
                Column(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "Available Rides",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    if (filteredRides != null && filteredRides!!.isNotEmpty()) {
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth().weight(1f)
                        ) {
                            items(filteredRides!!) { ride ->
                                AvailableRideItem(
                                    ride = ride,
                                    onBookClick = {
                                        val updatedRide = ride.copy(
                                            passengerId = uid,
                                            status = "Booked"
                                        )
                                        rideViewModel.updateRide(updatedRide)
                                        navController.navigateUp()
                                    }
                                )
                            }
                        }
                    } else {
                        Box(
                            modifier = Modifier.fillMaxWidth().weight(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "No rides found matching your criteria",
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Button(
                        onClick = { showResults = false },
                        modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
                    ) {
                        Text("Back to Search")
                    }
                }
            }
        }
    }
}
