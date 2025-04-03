package com.example.smartcare.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartcare.R
import com.example.smartcare.database.Destination
import com.example.smartcare.database.entity.Ride
import com.example.smartcare.database.viewModel.RideViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    rideViewModel: RideViewModel,
    innerPadding: PaddingValues
) {
    val pagerState = rememberPagerState(pageCount = { 2 })
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .padding(innerPadding)
    ) {

        // Pager for Home and Messages screens
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            when (page) {
                0 -> HomeContent(navController, rideViewModel)
                1 -> MessageScreen(navController, rideViewModel, innerPadding)
            }
        }
    }
}

@Composable
fun HomeContent(
    navController: NavController,
    rideViewModel: RideViewModel
) {
    val rides by rideViewModel.allRides.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // App Title
        Text(
            text = "Campus Cruise",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Ride Options
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Offer a Ride Box
            RideOptionBox(
                title = "Offer a Ride",
                imageResId = R.drawable.img,
                onClick = { navController.navigate(Destination.OfferRide.route) }
            )

            // Find a Ride Box
            RideOptionBox(
                title = "Find a Ride",
                imageResId = R.drawable.img,
                onClick = { navController.navigate(Destination.FindRide.route) }
            )
        }

        // Previous Rides Section
        Text(
            text = "Previous Rides",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(vertical = 8.dp)
        )

        // List of previous rides
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(rides.orEmpty()) { ride ->
                RideItem(ride = ride)
            }
        }
    }
}

@Composable
fun RideOptionBox(
    title: String,
    imageResId: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .size(150.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = title,
                modifier = Modifier
                    .size(80.dp)
                    .padding(bottom = 8.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun RideItem(ride: Ride) {
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
                    text = "${ride.pickupLocation} → ${ride.destination}",
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

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${ride.date} at ${ride.time}",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Text(
                    text = ride.status,
                    fontSize = 14.sp,
                    color = when(ride.status) {
                        "Completed" -> Color.Green
                        "Cancelled" -> Color.Red
                        else -> Color.Blue
                    }
                )
            }
        }
    }
}

