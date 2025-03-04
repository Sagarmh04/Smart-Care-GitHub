package com.example.smartcare.ui.screen

import AppTheme
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.smartcare.Hospitals.Hospital
import com.example.smartcare.viewModel.SearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HospitalDetailsScreen(
    navController: NavController,
) {
    val hospital = navController.previousBackStackEntry?.savedStateHandle?.get<Hospital>("hospital")

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
        Box(modifier = Modifier.padding(start = 12.dp)) {
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
                HospitalDetailsContent(hospital!!, Modifier.padding(padding))
            }
        }
    }
}

@Composable
private fun HospitalDetailsContent(hospital: Hospital, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Header Section
        HospitalHeader(hospital)

        Spacer(modifier = Modifier.height(24.dp))

        // Key Details
        HospitalKeyInfo(hospital)

        Spacer(modifier = Modifier.height(24.dp))

        // Specialties
        HospitalSpecialties(hospital)

        Spacer(modifier = Modifier.height(24.dp))

        // Contact & Timing
        HospitalContactSection(hospital)
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