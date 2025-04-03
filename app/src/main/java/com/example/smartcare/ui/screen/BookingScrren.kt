package com.example.smartcare.ui.screen

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.smartcare.AppointmentLists
import com.example.smartcare.BottomNavScreen
import com.example.smartcare.Hospitals.Doctor
import com.example.smartcare.Hospitals.allHospitalData
import com.example.smartcare.Hospitals.selectedCityName
import com.example.smartcare.OtherScreens
import com.example.smartcare.viewModel.AppointmentViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun AppointmentBookingScreen(
    navController: NavHostController,
    appointmentViewModel: AppointmentViewModel,
    onSplashScreen: () -> Unit,
    modifier: Modifier
) {
    val doctor = navController.previousBackStackEntry?.savedStateHandle?.get<Doctor>("doctor")
    val selectedCity = navController.previousBackStackEntry?.savedStateHandle?.get<String>("city")
    val currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy"))
    var selectedSlot by remember { mutableStateOf<Int?>(null) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    LaunchedEffect(onSplashScreen) {
        onSplashScreen()
    }

    fun calculateTimeFromIndex(index: Int): String {
        val hour = index / 4 + 9
        val minute = (index % 4) * 15
        val period = if (hour >= 12) "PM" else "AM"
        val displayHour = when {
            hour > 12 -> hour - 12
            hour == 0 -> 12
            else -> hour
        }
        return "$displayHour:${minute.toString().padStart(2, '0')} $period"
    }

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Doctor info section with card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    if (doctor != null) {
                        Text(
                            text = doctor.name,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    if (doctor != null) {
                        Text(
                            text = "${doctor.specialization.joinToString(", ")} • ${doctor.experience} years experience",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        if (doctor != null) {
                            RatingBar(rating = doctor.rating)
                        }
                        if (doctor != null) {
                            Text(
                                text = doctor.rating.toString(),
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }
                    }
                }
            }

            // Date and instructions
            Text(
                text = "Select an appointment slot",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.AccessTime,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Available slots for $currentDate",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Legend for slot colors
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SlotLegendItem(
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    text = "Available"
                )
                SlotLegendItem(
                    color = Color(0xFFFFCDD2), // Light red
                    text = "Booked"
                )
                SlotLegendItem(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    text = "Selected"
                )
            }

            // Appointment slots grid
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    contentPadding = PaddingValues(bottom = 16.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    if (doctor != null) {
                        items(doctor.appointments.size) { index ->
                            AppointmentSlot(
                                index = index,
                                isAvailable = doctor.appointments[index],
                                isSelected = selectedSlot == index,
                                onSlotClick = { selectedSlot = if (selectedSlot == index) null else index },
                                calculateTimeFromIndex = ::calculateTimeFromIndex
                            )
                        }
                    }
                }

                // Add a spacer at the bottom to create space for the FAB and bottom nav
                Spacer(modifier = Modifier.height(80.dp))
            }
        }

        // Confirm button with animation
        AnimatedVisibility(
            visible = selectedSlot != null,
            enter = slideInVertically(initialOffsetY = { it }) + fadeIn(),
            exit = slideOutVertically(targetOffsetY = { it }) + fadeOut(),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        ) {
            ExtendedFloatingActionButton(
                onClick = {
                    val hospitalData = allHospitalData.find { it.cityName.equals(selectedCityName) }
                    val hospitalDataIndex = allHospitalData.indexOf(hospitalData)
                    val hospital = hospitalData?.hospitals?.find { it.cityId.equals(selectedCityName) }
                    val hospitalIndex = hospitalData?.hospitals?.indexOf(hospital)
                    val doctorIndex = hospital?.doctors?.indexOf(doctor)
                    selectedSlot?.let { index ->
                        if (doctor != null) {
                            navController.currentBackStackEntry?.savedStateHandle?.set("data",AppointmentLists(
                                id = 0,
                                doctorName = doctor.name,
                                doctorImageUrl = "",
                                date = currentDate,
                                time = calculateTimeFromIndex(index),
                                reason = doctor.specialization.firstOrNull() ?: "Checkup",
                                status = "Pending",
                                isCompleted = false,
                                hospitalDataIndex = hospitalDataIndex,
                                hospitalIndex = hospitalIndex ?: 0,
                                doctorIndex = doctorIndex ?: 0,
                                appointmentIndex = index,
                                hospitalName = allHospitalData[hospitalDataIndex].hospitals[hospitalIndex!!].name,
                                cityName = allHospitalData[hospitalDataIndex].cityName
                            ))
                        }



                        scope.launch {
                            Toast.makeText(
                                context,
                                "✓ Appointment confirmed for ${calculateTimeFromIndex(index)}",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                        selectedSlot = null
                    }
                    navController.navigate(OtherScreens.paymentScreen.route)
                },
                icon = { Icon(Icons.Filled.Check, contentDescription = "Confirm") },
                text = { Text("Confirm Appointment") },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .padding(16.dp)
                    .shadow(8.dp, RoundedCornerShape(16.dp))
            )
        }
    }
}

    @Composable
    fun AppointmentSlot(
        index: Int,
        isAvailable: Boolean,
        isSelected: Boolean,
        onSlotClick: () -> Unit,
        calculateTimeFromIndex: (Int) -> String
    ) {
        val scale by animateFloatAsState(
            targetValue = if (isSelected) 1.05f else 1f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )

        val elevation by animateDpAsState(
            targetValue = if (isSelected) 8.dp else 2.dp,
            animationSpec = tween(durationMillis = 300)
        )

        Card(
            modifier = Modifier
                .padding(4.dp)
                .aspectRatio(1f)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                }
                .clickable(enabled = isAvailable, onClick = onSlotClick),
            elevation = CardDefaults.cardElevation(
                defaultElevation = elevation
            ),
            colors = CardDefaults.cardColors(
                containerColor = when {
                    isSelected -> MaterialTheme.colorScheme.primaryContainer
                    isAvailable -> MaterialTheme.colorScheme.surfaceVariant
                    else -> Color(0xFFFFCDD2) // Light red for booked slots
                }
            ),
            border = BorderStroke(
                width = if (isSelected) 2.dp else 0.dp,
                color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent
            )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(
                            color = when {
                                isSelected -> MaterialTheme.colorScheme.primary
                                isAvailable -> MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
                                else -> Color(0xFFE57373) // Medium red for booked icon background
                            },
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = when {
                            isSelected -> Icons.Filled.Check
                            isAvailable -> Icons.Filled.AccessTime
                            else -> Icons.Filled.Close
                        },
                        contentDescription = when {
                            isSelected -> "Selected slot"
                            isAvailable -> "Available slot"
                            else -> "Booked slot"
                        },
                        tint = when {
                            isSelected -> MaterialTheme.colorScheme.onPrimary
                            isAvailable -> MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                            else -> Color.White
                        },
                        modifier = Modifier.size(16.dp)
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = calculateTimeFromIndex(index),
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }

    @Composable
    fun SlotLegendItem(
        color: Color,
        text: String
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(color, RoundedCornerShape(2.dp))
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }

    @Composable
    fun RatingBar(
        rating: Double,
        maxRating: Int = 5
    ) {
        Row {
            repeat(maxRating) { index ->
                val starAlpha = when {
                    index < rating.toInt() -> 1f
                    index == rating.toInt() && rating % 1 > 0 -> rating % 1
                    else -> 0.3f
                }

                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    tint = Color(0xFFFFC107).copy(alpha = starAlpha.toFloat()),
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }

