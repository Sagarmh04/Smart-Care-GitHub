package com.example.smartcare.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartcare.R
import com.example.smartcare.database.Destination
import com.example.smartcare.database.entity.Ride
import com.example.smartcare.database.viewModel.ChatUserViewModel
import com.example.smartcare.database.viewModel.RideViewModel
import com.google.firebase.firestore.FirebaseFirestore

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    rideViewModel: RideViewModel,
    innerPadding: PaddingValues,
    chatUserViewModel: ChatUserViewModel,
    db: FirebaseFirestore
) {

    LaunchedEffect(Unit) {
    rideViewModel.syncRidesFromCloud()}
    val pagerState = rememberPagerState(pageCount = { 2 })

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
                1 -> MessageScreen(
                    navController,
                    rideViewModel,
                    innerPadding,
                    chatUserViewModel,
                    db
                )
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
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // App Title
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(12.dp),
                    spotColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
                )
                .background(
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    shape = RoundedCornerShape(12.dp)
                )
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Text(
                text = "Campus Cruise",
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(vertical = 20.dp, horizontal = 32.dp),
                fontFamily = FontFamily(Font(R.font.sans)),
                letterSpacing = 1.sp,
                style = MaterialTheme.typography.headlineLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

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
fun RideItem(ride: Ride, modifier: Modifier = Modifier) {
    // Custom color palette using analogous blues with accent
    val cardColor = Color(0xFFF8FAFF)  // Very light blue background
    val primaryBlue = Color(0xFF3A7BFF)  // Vibrant primary blue
    val secondaryBlue = Color(0xFF5D9DFF)  // Lighter secondary blue
    val accentGreen = Color(0xFF00C897)  // Complementary green accent
    val textPrimary = Color(0xFF1A2B49)  // Dark blue for text
    val textSecondary = Color(0xFF6B7B99)  // Grayish blue for secondary text

    // Status colors
    val statusColor = when (ride.status.lowercase()) {
        "completed" -> accentGreen
        "active" -> primaryBlue
        "cancelled" -> Color(0xFFFF5A5A)
        else -> secondaryBlue
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardColor,
            contentColor = textPrimary
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            // First row: Locations
            Column {
                // Pickup
                Text(
                    text = "From: ${ride.pickupLocation}",
                    color = textSecondary,
                    fontSize = 13.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                // Destination
                Text(
                    text = "To: ${ride.destination}",
                    color = textPrimary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Second row: Date/Time and Status
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Date and time
                Text(
                    text = "${ride.date} • ${ride.time}",
                    color = textSecondary,
                    fontSize = 12.sp
                )

                // Status badge
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(statusColor.copy(alpha = 0.2f))
                        .border(
                            width = 1.dp,
                            color = statusColor.copy(alpha = 0.4f),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(horizontal = 6.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = ride.status.uppercase(),
                        color = statusColor,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}