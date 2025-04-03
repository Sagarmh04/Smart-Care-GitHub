package com.example.smartcare.ui.screen

import androidx.compose.runtime.Composable
import com.example.smartcare.R



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.NavController

data class TrendingRide(
    val driverName: String,
    val from: String,
    val to: String,
    val time: String,
    val seatsAvailable: Int,
    val price: String,
    val profilePic: Int // Replace with actual image resource
)

@Composable
fun TrendingScreen(navController: NavController) {
    val trendingRides = listOf(
        TrendingRide("Amit Sharma", "Hostel", "Library", "10:30 AM", 2, "₹50", R.drawable.location),
        TrendingRide("Neha Verma", "Main Gate", "Cafeteria", "12:00 PM", 3, "₹40", R.drawable.female),
        TrendingRide("Rahul Singh", "Block A", "Auditorium", "3:00 PM", 1, "₹60", R.drawable.male)
    )

    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFECF0F1))) {
        TopAppBar(
            title = { Text("Trending Rides", color = Color.White) },
            backgroundColor = Color(0xFF1ABC9C)
        )

        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(trendingRides) { ride ->
                TrendingRideCard(ride, navController)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun TrendingRideCard(ride: TrendingRide, navController: androidx.navigation.NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate("ride_details") },
        elevation = 6.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = ride.profilePic),
                contentDescription = "Driver Image",
                modifier = Modifier.size(50.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(ride.driverName, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFF2C3E50))
                Text("From: ${ride.from} → To: ${ride.to}", fontSize = 14.sp, color = Color.Gray)
                Text("Time: ${ride.time}", fontSize = 14.sp, color = Color.Gray)
                Text("Seats: ${ride.seatsAvailable}", fontSize = 14.sp, color = Color.Gray)
                Text("Price: ${ride.price}", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1ABC9C))
            }
        }
    }
}
