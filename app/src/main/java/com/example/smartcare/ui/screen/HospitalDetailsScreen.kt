package com.example.smartcare.ui.screen

import AppTheme
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.StarHalf
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartcare.Hospitals.Doctor
import com.example.smartcare.Hospitals.Hospital
import com.example.smartcare.OtherScreens
import kotlin.math.floor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HospitalDetailsScreen(
    navController: NavController,
    hideBottomScreen: () -> Unit,
) {
    val hospital = navController.previousBackStackEntry?.savedStateHandle?.get<Hospital>("hospital")
    val city = navController.previousBackStackEntry?.savedStateHandle?.get<String>("city")
    LaunchedEffect(hideBottomScreen) {
        hideBottomScreen()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hospital Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        Box(modifier = Modifier.padding(horizontal = 12.dp)) {
            if (hospital == null) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    contentAlignment = Center
                ) {
                    Text("Hospital not found", color = MaterialTheme.colorScheme.error)
                }
            } else {
                HospitalDetailsContent(hospital!!, Modifier.padding(padding),navController, city)
            }
        }
    }
}

@Composable
fun DoctorSection(
    doctors: List<Doctor>,
    navController: NavController,
    city: String?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Column(modifier = Modifier.padding(bottom = 16.dp, start = 16.dp, end=16.dp)) {
        Text(
            text = "Available Doctors",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )
            }

        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            doctors.forEach(){ doctor ->
                DoctorCard(doctor = doctor, onBookClick = {
                    // Handle navigation here
                    navController.currentBackStackEntry?.savedStateHandle?.set("city", city)
                    navController.currentBackStackEntry?.savedStateHandle?.set(key = "doctor", value = doctor)
                    navController.navigate(OtherScreens.bookingScreen.route)
                })
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun DoctorCard(doctor: Doctor, onBookClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Person, contentDescription = "person")
                    Spacer(Modifier.width(12.dp))
                    Text(
                        text = " ${doctor.name}",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Text(
                    text = "${doctor.age} years old",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Specialization Chips
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    doctor.specialization.forEach { specialty ->
                        SpecializationChip(text = specialty)
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Work,
                        contentDescription = "Experience",
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.secondary
                    )
                    Text(
                        text = "${doctor.experience}+ years experience",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                RatingBar(rating = doctor.rating, modifier = Modifier.padding(top = 4.dp))
            }

            // Book Button
            OutlinedButton(
                onClick = onBookClick,
                modifier = Modifier.padding(start = 16.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.CalendarMonth,
                        contentDescription = "Book",
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Book")
                }
            }
        }
    }
}

@Composable
private fun SpecializationChip(text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
    }
}

@Composable
private fun RatingBar(rating: Double, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        val filledStars = floor(rating).toInt()
        val halfStar = rating - filledStars > 0.5

        repeat(filledStars) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(18.dp)
            )
        }

        if (halfStar) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.StarHalf,
                contentDescription = "Half Star",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(18.dp)
            )
        }

        repeat(5 - filledStars - (if (halfStar) 1 else 0)) {
            Icon(
                imageVector = Icons.Default.StarOutline,
                contentDescription = "Empty Star",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(18.dp)
            )
        }

        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "%.1f".format(rating),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
private fun HospitalDetailsContent(
    hospital: Hospital,
    modifier: Modifier = Modifier,
    navController: NavController,
    city: String?
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end=16.dp)) {
            // Header Section
            HospitalHeader(hospital)
        }
        Spacer(modifier = Modifier.height(24.dp))

        // Key Details
        HospitalKeyInfo(hospital)

        Spacer(modifier = Modifier.height(24.dp))

        Column(modifier = Modifier.padding(bottom = 16.dp, start = 16.dp, end=16.dp)) {
            // Specialties
            HospitalSpecialties(hospital)

            Spacer(modifier = Modifier.height(24.dp))

            // Contact & Timing
            HospitalContactSection(hospital)
        }
            DoctorSection(doctors = hospital.doctors, navController = navController,city)
            Spacer(Modifier.height(90.dp))
    }
}

@Composable
private fun HospitalHeader(hospital: Hospital) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier) {
            Text(
                text = hospital.name,
                style = AppTheme.typography.heading.copy(fontSize = 24.sp, letterSpacing = 1.sp),
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "${hospital.district}, Karnataka",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
            )
            RatingBar(rating = hospital.rating, modifier = Modifier.padding(top = 8.dp))
        }
    }
}

@Composable
private fun RatingBar(rating: Float, modifier: Modifier = Modifier) {
    Row( verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "%.1f".format(rating),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.width(8.dp))
        repeat(5) { index ->
            Icon(
                imageVector = if (rating >= index + 1) Icons.Filled.Star else Icons.Outlined.Star,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}
@Composable
private fun HospitalKeyInfo(hospital: Hospital) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            InfoItem(
                icon = Icons.Default.LocationOn,
                value = "${hospital.distance} km",
                label = "Distance",
                iconTint = MaterialTheme.colorScheme.primary
            )

            HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))

            InfoItem(
                icon = Icons.Default.Schedule,
                value = "Open until ${hospital.openingHours}",
                label = "Closing time",
                iconTint = MaterialTheme.colorScheme.tertiary
            )

            HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))

            InfoItem(
                icon = Icons.Default.People,
                value = hospital.reviewCount.toString(),
                label = "Reviews",
                iconTint = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
private fun InfoItem(icon: ImageVector, value: String, label: String, iconTint: Color) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconTint,
                modifier = Modifier.size(20.dp)
            )

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                        text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
            )
        }

        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
private fun InfoRow(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.width(16.dp))
        Text(text, style = MaterialTheme.typography.bodyLarge)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun HospitalSpecialties(hospital: Hospital) {
    Column (modifier = Modifier){
        Text(
            text = "Specialties",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            hospital.specialties.forEach { specialty ->
                FilterChip(
                    selected = true,
                    onClick = {},
                    label = { Text(specialty) }
                )
            }
        }
    }
}

@Composable
private fun HospitalContactSection(hospital: Hospital) {
    Column(modifier = Modifier) {
        Text(
            text = "Contact Information",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        InfoRow(Icons.Default.Phone, "+91 98765 43210")
        InfoRow(Icons.Default.Email, "contact@${hospital.name.lowercase().replace(" ", "")}.com")
        InfoRow(Icons.Default.Language, "www.${hospital.name.lowercase().replace(" ", "")}.com")

        Spacer(modifier = Modifier.height(16.dp))


    }
}