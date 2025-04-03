package com.example.smartcare.ui.screen

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
    var date by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var vehicleType by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var showRides by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // White Background
    ) {
        // Top Bar
        Spacer(modifier = Modifier.height(30.dp))
        TopAppBar(
            title = { Text("Find a Ride", color = Color.White) },
            backgroundColor = Color(0xFF004a95) // Dark Navy Blue
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
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = date,
                onValueChange = { date = it },
                label = { Text("Date (DD/MM/YYYY)") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = time,
                onValueChange = { time = it },
                label = { Text("Time (HH:MM AM/PM)") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = vehicleType,
                onValueChange = { vehicleType = it },
                label = { Text("Vehicle Type (Car/Bike)") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = gender,
                onValueChange = { gender = it },
                label = { Text("Driver Gender (Male/Female)") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Find Rides Button
        Button(
            onClick = { showRides = true },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF004a95)) // Dark Navy Blue
        ) {
            Text("Find Rides", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}
