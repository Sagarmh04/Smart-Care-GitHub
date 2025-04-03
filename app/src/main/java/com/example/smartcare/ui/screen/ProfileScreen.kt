package com.example.smartcare.ui.screen

// Compose Core
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.smartcare.R
import com.example.smartcare.database.entity.ProfileData
import com.example.smartcare.database.viewModel.ProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    innerPadding: PaddingValues,
    profileViewModel: ProfileViewModel,
    onLogout: () -> Unit,
    onEdit: () -> Unit,
    onSettings: () -> Unit
) {
    val profile = profileViewModel.profile.collectAsState( ProfileData(
        idOne = 1,
        id = "TODO",
        name = "TODO()",
        age = 0,
        gender = "TODO()",
        height = 9,
        weight = 2,
        bloodGroup = "TODO()",
        address = "TODO()",
        contact = "TODO()",
        email = "TODO()",
        profilePic = "TODO()",
        isCompleted = false,
        isLoggedIn = false
    )
    ).value
    val gradientColors = listOf(Color(0xFF7F81F1), Color(0xFFB473F3), Color(0xFFD467EC))
    val accentColor = Color(0xFF6366F1)

    Box(modifier = Modifier
        .padding(innerPadding)
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        ) {
            // Profile Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .background(
                        brush = Brush.verticalGradient(gradientColors)
                    ),
                contentAlignment = Alignment.Center
            ) {
                // Profile Image with Neon Border
                Box(
                    modifier = Modifier
                        .size(150.dp)
                        .shadow(24.dp, shape = CircleShape, spotColor = accentColor)
                        .background(
                            brush = Brush.radialGradient(
                                colors = listOf(Color.White, Color.LightGray)
                            ),
                            shape = CircleShape
                        )
                        .padding(4.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.default_profile_screen),
                        contentDescription = "Profile picture",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop,
                    )
                }

                // Edit Button
                FloatingActionButton(
                    onClick = onEdit,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(24.dp),
                    containerColor = Color.White,
                    contentColor = accentColor
                ) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit")
                }
            }

            // Profile Content
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                // Name and Basic Info
                profile?.let {
                    Text(
                        text = it.name,
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Stats Grid
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ProfileStat("Age", "${profile?.age}", Icons.Default.Cake)
                    ProfileStat("Height", "${profile?.height}cm", Icons.Default.Height)
                    ProfileStat("Weight", "${profile?.weight}kg", Icons.Default.MonitorWeight)
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Personal Info Section
                Text(
                    text = "Personal Information",
                    style = MaterialTheme.typography.titleLarge,
                    color = accentColor,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                profile?.let {
                    InfoCard(
                        icon = Icons.Default.Face,
                        title = "Gender",
                        value = it.gender,
                        color = Color(0xFFA855F7)
                    )
                }

                profile?.let {
                    InfoCard(
                        icon = Icons.Default.Favorite,
                        title = "Blood Group",
                        value = it.bloodGroup,
                        color = Color(0xFFEC4899)
                    )
                }

                profile?.let {
                    InfoCard(
                        icon = Icons.Default.Home,
                        title = "Address",
                        value = it.address,
                        color = Color(0xFF6366F1)
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Logout Button
                Button(
                    onClick = {
                        onLogout()
                              },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF6B6B),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(Icons.Default.Logout, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Logout", style = MaterialTheme.typography.labelLarge)
                }
            }
        }
    }
}

@Composable
private fun ProfileStat(title: String, value: String, icon: ImageVector) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(Color.White, CircleShape)
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                icon,
                contentDescription = title,
                tint = Color(0xFF6366F1),
                modifier = Modifier.size(32.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = value, style = MaterialTheme.typography.titleMedium)
        Text(text = title, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
private fun InfoCard(icon: ImageVector, title: String, value: String, color: Color) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.1f))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                icon,
                contentDescription = title,
                tint = color,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    color = color.copy(alpha = 0.8f)
                )
                Text(
                    text = value,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}