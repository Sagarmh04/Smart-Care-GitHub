package com.example.smartcare.ui.screen

import androidx.compose.runtime.Composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FindARideScreen() {
    var from by remember { mutableStateOf("") }
    var to by remember { mutableStateOf("") }
    var showRides by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFECF0F1))) {
        // Top Bar
        TopAppBar(
            title = { Text("Find a Ride", color = Color.White) },
            backgroundColor = Color(0xFF1ABC9C)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Search Fields
        Column(modifier = Modifier.padding(16.dp)) {
            OutlinedTextField(
                value = from,
                onValueChange = { from = it },
                label = { Text("From") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = to,
                onValueChange = { to = it },
                label = { Text("To") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Find Rides Button
        Button(
            onClick = { showRides = true },
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1ABC9C))
        ) {
            Text("Find Rides", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        // Available Rides List
        if (showRides) {
            AvailableRidesList()
        }
    }
}

@Composable
fun AvailableRidesList() {
    val rideList = listOf(
        Ride("John Doe", "Campus A", "Campus B", "10:30 AM", 3, "₹100"),
        Ride("Sarah Lee", "Campus C", "Campus D", "12:00 PM", 2, "₹80"),
        Ride("Michael Scott", "Campus A", "Campus E", "2:30 PM", 4, "₹120")
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        rideList.forEach { ride ->
            RideCard(ride)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun RideCard(ride: Ride) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable {},
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = android.R.drawable.ic_menu_myplaces), contentDescription = "Profile Pic")
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(ride.driverName, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFF2C3E50))
                Text("${ride.from} → ${ride.to}", fontSize = 14.sp, color = Color.Gray)
                Text("${ride.time} | Seats: ${ride.seatsAvailable}", fontSize = 14.sp, color = Color.Gray)
                Text("Price: ${ride.price}", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1ABC9C))
            }
        }
    }
}

data class Ride(
    val driverName: String,
    val from: String,
    val to: String,
    val time: String,
    val seatsAvailable: Int,
    val price: String
)
