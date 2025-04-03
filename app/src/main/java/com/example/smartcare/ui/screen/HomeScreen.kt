package com.example.smartcare.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartcare.OtherScreens
import com.example.smartcare.ui.theme.white
import com.example.smartcare.database.viewModel.ProfileViewModel


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navController: NavHostController,
    profileViewModel: ProfileViewModel,
    onSplashComplete: () -> Unit,
) {

        val isLoggedIn = profileViewModel.isLoggedIn.observeAsState(initial = null)
    val scrollState = rememberScrollState()
    var searchQuery by remember { mutableStateOf("") }
    @Composable

    fun RideOptionButton(text: String, color: Color, function: () -> Unit) {
        Button(
            onClick = { function() },
            colors = ButtonDefaults.buttonColors(containerColor = white),
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = text, color = Color.Black)
        }
    }

    when(isLoggedIn.value) {
            false-> Column(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator()
                Text("Loading...")
            }
            true-> {








                    val primaryColor = Color(0xFF1ABC9C) // Teal
                    val secondaryColor = Color(0xFF2C3E50) // Dark Blue
                    val backgroundColor = Color(0xFFECF0F1) // Soft White
                    val accentColor = Color(0xFFD5D8DC) // Light Grey

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(backgroundColor)
                            .padding(16.dp)
                            .padding(paddingValues)
                    ) {
                        // Top Bar
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(primaryColor)
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = android.R.drawable.ic_menu_compass), // Replace with your app logo
                                contentDescription = "App Logo",
                                tint = Color.White,
                                modifier = Modifier.size(32.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Campus Rides",
                                fontSize = 22.sp,
                                color = secondaryColor,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Search Bar

                        SearchBarWithDropdown()

                        Spacer(modifier = Modifier.height(12.dp))

                        // Ride Options (Offer a Ride | Find a Ride)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            RideOptionButton(text = "Offer a Ride", primaryColor) {
                                navController.navigate(
                                    OtherScreens.offerARideScreen.route
                                )
                            }
                            RideOptionButton(
                                text = "Find a Ride",
                                primaryColor
                            ) { navController.navigate(OtherScreens.findARideScreen.route) }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Trending Rides Section
                        Text(
                            text = "Trending Rides",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = secondaryColor
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        // Sample Ride Cards
                        RideCard("John Doe", "Campus Gate", "City Center", "2:30 PM", 3, "₹50", primaryColor
                        ) { navController.navigate(OtherScreens.trendingScreen.route) }
                        RideCard(
                            "Emily Smith",
                            "Library",
                            "Downtown",
                            "3:00 PM",
                            2,
                            "₹40",
                            primaryColor
                        ) { navController.navigate(OtherScreens.trendingScreen.route) }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Emergency Requests Box
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color.Red)
                                .clickable { /* Handle Emergency Click */ }
                                .padding(16.dp)
                                .clickable { navController.navigate(OtherScreens.emergencyScreen) },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "🚨 Emergency Request",
                                fontSize = 18.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.weight(1f))



                    }
                }













            null-> Box(modifier = Modifier.fillMaxSize()) {
                Text("Loading...")
            }
        }
    }


@Composable
fun RideOptionButton(text: String, color: Color) {
    Button(
        onClick = { /* Handle Click */ },
        colors = ButtonDefaults.buttonColors(containerColor =Color.White),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .width(160.dp)
            .height(50.dp)
    ) {
        Text(text = text, fontSize = 16.sp, color = Color.White)
    }
}

@Composable
fun RideCard(
    driver: String,
    start: String,
    end: String,
    time: String,
    seats: Int,
    price: String,
    color: Color,
    function: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { function() }

    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_mylocation), // Replace with profile image
                contentDescription = "Driver Image",
                tint = color,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(text = driver, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Black)
                Text(text = "$start ➝ $end", color = Color.DarkGray, fontSize = 14.sp)
                Text(text = "⏰ $time | 🪑 $seats seats | 💰 $price", fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}
