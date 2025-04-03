package com.example.smartcare.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

class OfferRideActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OfferARideScreen()
        }
    }
}

@Composable
fun OfferARideScreen(navController: NavController? = null) {
    val primaryColor = Color(0xFF1ABC9C) // Teal
    val secondaryColor = Color(0xFF2C3E50) // Dark Blue
    val backgroundColor = Color(0xFFECF0F1) // Soft White

    var from by remember { mutableStateOf("") }
    var to by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var seats by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var vehicle by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(primaryColor)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Offer a Ride",
                fontSize = 22.sp,
                color = secondaryColor,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Input Fields
        RideInputField("From (Start Location)", from) { from = it }
        RideInputField("To (Destination)", to) { to = it }
        RideInputField("Departure Time", time) { time = it }
        RideInputField("Available Seats", seats, KeyboardType.Number) { seats = it }
        RideInputField("Price per Seat (Optional)", price, KeyboardType.Number) { price = it }
        RideInputField("Vehicle Details (Optional)", vehicle) { vehicle = it }
        RideInputField("Notes for Passengers (Optional)", notes) { notes = it }

        Spacer(modifier = Modifier.height(16.dp))

        // Confirm Ride Button
        Button(
            onClick = { /* Handle Ride Submission */ },
            colors = ButtonDefaults.buttonColors(backgroundColor = primaryColor),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Confirm Ride", fontSize = 18.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Back Button
        TextButton(
            onClick = { navController?.popBackStack() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Back to Home", color = secondaryColor)
        }
    }
}

@Composable
fun RideInputField(label: String, value: String, keyboardType: KeyboardType = KeyboardType.Text, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        textStyle = TextStyle(fontSize = 16.sp),
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewOfferRideScreen() {
    OfferARideScreen()
}
