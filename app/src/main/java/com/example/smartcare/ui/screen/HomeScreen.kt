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
import androidx.compose.ui.text.font.FontStyle
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    rideViewModel: RideViewModel,
    innerPadding: PaddingValues,
    chatUserViewModel: ChatUserViewModel,
    db: FirebaseFirestore,
    uid: String
) {
    syncRidesFromCloud(rideViewModel, uid)
    val pagerState = rememberPagerState(pageCount = { 2 })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .padding(innerPadding)
    ) {
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
                    color = Color(0xFF88CCFF),
                    shape = RoundedCornerShape(12.dp)
                )
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Text(
                text = "CampusCruze",
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF051459),
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

        Column(
            modifier = Modifier

                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RideOptionBox(
                title = "Offer a Ride",
                imageResId = R.drawable.blueoffer,
                onClick = { navController.navigate(Destination.OfferRide.route) }
            )

            RideOptionBox(
                title = "Find a Ride",
                imageResId = R.drawable.bluefind,
                onClick = { navController.navigate(Destination.FindRide.route) }
            )
        }

        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Rides",
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.sans)),
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(vertical = 8.dp)
                .padding(start = 16.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(rides.orEmpty().take(2)) { ride ->
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
    Box(
        modifier = Modifier
            .fillMaxWidth()

            .clip(RoundedCornerShape(12.dp))

            .clickable(onClick = onClick)


    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(220.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = title,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.width(300.dp)
                )
            }

            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,

                color = Color.Black,

            )
        }
    }
}

@Composable
fun RideItem(ride: Ride, modifier: Modifier = Modifier) {
    val cardColor = Color(0xFFF8FAFF)
    val primaryBlue = Color(0xFF3A7BFF)
    val secondaryBlue = Color(0xFF5D9DFF)
    val accentGreen = Color(0xFF00C897)
    val textPrimary = Color(0xFF1A2B49)
    val textSecondary = Color(0xFF6B7B99)

    val statusColor = when (ride.status.lowercase()) {
        "completed" -> accentGreen
        "active" -> primaryBlue
        "cancelled" -> Color(0xFFFF5A5A)
        else -> secondaryBlue
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .background(cardColor, shape = RoundedCornerShape(10.dp))
            .border(1.dp, color = Color.LightGray.copy(alpha = 0.2f), shape = RoundedCornerShape(10.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Column {
                Text(
                    text = "From: ${ride.pickupLocationName}",
                    color = textSecondary,
                    fontSize = 13.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = "To: ${ride.destinationName}",
                    color = textPrimary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${ride.date} • ${ride.time}",
                    color = textSecondary,
                    fontSize = 12.sp
                )

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

fun syncRidesFromCloud(rideViewModel: RideViewModel, uid: String) {
    val db = FirebaseFirestore.getInstance()

    db.collection("rides")
        .whereEqualTo("driverId", uid)
        .get()
        .addOnSuccessListener { result ->
            CoroutineScope(Dispatchers.IO).launch {
                for (document in result) {
                    val rideDTO = document.toObject(RideDTOf::class.java)
                    val existingRide = rideViewModel.getRideById(rideDTO.id)
                    val ride = rideDTO.toEntity()
                    rideViewModel.insertRide(ride)
                }
            }
        }
        .addOnFailureListener { e -> }
}
