package com.example.smartcare.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.smartcare.OtherScreens
import com.example.smartcare.R
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

    LaunchedEffect(onSplashComplete()) {
        onSplashComplete()
    }
        val isLoggedIn = profileViewModel.isLoggedIn.collectAsState(
            initial = false
        ).value
    val scrollState = rememberScrollState()
    var searchQuery by remember { mutableStateOf("") }


    @Composable
    fun RideOptionButton(text: String, color: Color, function: () -> Unit) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .clickable { function() } // Makes entire Box clickable
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Clickable Image
                Image(
                    painter = painterResource(R.drawable.img_1), // Replace with actual image
                    contentDescription = "Ride Option Icon",
                    modifier = Modifier
                        .size(170.dp)  // Adjust image size
                        .clip(RoundedCornerShape(8.dp))
                        .clickable { function() } // Make Image clickable
                )

                Spacer(modifier = Modifier.height(8.dp)) // Space between Image & Text

                // Text inside Box instead of Button for better spacing
                Text(
                    text = text,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )
            }
        }
    }



    when(isLoggedIn) {
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
                                .background(color = Color(0xFF000080))
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.splash_screen), // Replace with your app logo
                                contentDescription = "App Logo",
                                tint = Color.White,
                                modifier = Modifier.size(32.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "CampusCruze",
                                fontSize = 22.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Search Bar


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

                        Spacer(modifier = Modifier.height(30.dp))

                        // Trending Rides Section
                        Text(
                            text = "Previous Rides",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color =Color.Blue
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        // Sample Ride Cards
                        RideCard("John Doe", "Campus Gate", "City Center", "2:30 PM", 3, "₹50",color = Color(0xFFb3e6ff)
                        ) { navController.navigate(OtherScreens.trendingScreen.route) }
                        RideCard(
                            "Emily Smith",
                            "Library",
                            "Downtown",
                            "3:00 PM",
                            2,
                            "₹40",
                            color=Color(0xFFb3e6ff)
                        ) { navController.navigate(OtherScreens.trendingScreen.route) }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Emergency Requests Box


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
        shape = RoundedCornerShape(50.dp),
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
            .background(color=Color(0xFF99d6ff))

    ) {
        Row(
            modifier = Modifier.padding(16.dp).background(color=Color(0xFF99d6ff)),
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Icon(
                painter = painterResource(id = R.drawable.default_profile_screen), // Replace with profile image
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

