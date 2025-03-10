package com.example.smartcare.ui.screen

import AppTheme
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.EventAvailable
import androidx.compose.material.icons.filled.EventBusy
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.smartcare.AppointmentLists
import com.example.smartcare.BottomNavScreen
import com.example.smartcare.R
import com.example.smartcare.ui.theme.black
import com.example.smartcare.ui.theme.skin
import com.example.smartcare.ui.theme.transparent
import com.example.smartcare.ui.theme.white
import com.example.smartcare.viewModel.AppointmentViewModel
import com.example.smartcare.viewModel.ProfileViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navController: NavHostController,
    profileViewModel: ProfileViewModel,
    onSplashComplete: () -> Unit,
    appointmentViewModel: AppointmentViewModel
) {
        val isLoggedIn = profileViewModel.isLoggedIn.observeAsState(initial = null)
        when(isLoggedIn.value) {
            false-> Column(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator()
                Text("Loading...")
            }
            true-> {
                onSplashComplete()
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(top = 5.dp)) {
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp), // Adds space at left & right end
                            horizontalArrangement = Arrangement.SpaceEvenly // Equal spacing everywhere
                        ) {
                            // Large Button - Reduce width by 20%
                            Box(modifier = Modifier.weight(1.6f)) { // Reduced weight from 2f to 1.6f (-20%)
                                Button(
                                    onClick = {navController.navigate(BottomNavScreen.Search.route)},
                                    modifier = Modifier
                                        .fillMaxWidth() // Expands within Box
                                        .height(50.dp), // Keep height same
                                    colors = ButtonColors(
                                        containerColor = skin,
                                        contentColor = black,
                                        disabledContainerColor = skin,
                                        disabledContentColor = black
                                    ),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Row(
                                        Modifier.fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Start
                                    ) {
                                        Text("Search", style = AppTheme.typography.heading)
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Icon(Icons.Default.Search, contentDescription = "Search")
                                    }
                                }
                            }
                            Spacer(Modifier.width(10.dp))
                            // Small Buttons - Keep size equal
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(10.dp), // Adds spacing between buttons
                            ) {
                                Button(
                                    onClick = {},
                                    modifier = Modifier
                                        .size(50.dp), // Ensures the button is square
                                    contentPadding = PaddingValues(0.dp), // Removes default button padding
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = skin,
                                        contentColor = black
                                    ),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Notifications,
                                        contentDescription = "Home",
                                        modifier = Modifier.size(30.dp) // Ensures proper icon size
                                    )
                                }

                            }


                        }
                        HorizontalDivider(
                            modifier = Modifier.padding(vertical = 15.dp), // Space around the divider
                            thickness = 2.dp, // Line thickness
                            // Separator Line
                            color = Color(0x48000000) // Line color
                        )
                        Box {
                            val pagerState = rememberPagerState(pageCount = { 2 })
                            val coroutineScope = rememberCoroutineScope()
                            var selectedTab by remember { mutableIntStateOf(0) }
                            val SelectedColor = skin
                            val BaseColor = white
                            Box(modifier = Modifier.fillMaxSize()) {
                                // Observe pager state changes
                                LaunchedEffect(pagerState.currentPage) {
                                    selectedTab = pagerState.currentPage
                                }



                                Column {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(transparent),
                                        horizontalArrangement = Arrangement.Center
                                    ) {
                                        listOf(
                                            "Upcoming" to 0,
                                            "Completed" to 1
                                        ).forEach { (title, index) ->
                                            Box(
                                                modifier = Modifier
                                                    .border(
                                                        1.dp,
                                                        if (selectedTab == index) black else transparent,
                                                        RoundedCornerShape(50.dp)
                                                    )
                                                    .clip(RoundedCornerShape(50.dp))
                                                    .background(if (selectedTab == index) SelectedColor else BaseColor)
                                                    .clickable(
                                                        interactionSource = remember { MutableInteractionSource() },
                                                        indication = null // Disables Ripple Effect
                                                    ) {
                                                        coroutineScope.launch {
                                                            pagerState.animateScrollToPage(index)
                                                            selectedTab = index
                                                        }
                                                    }
                                                    .padding(vertical = 12.dp, horizontal = 24.dp),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Text(text = title, color = AppTheme.colors.primary)
                                            }
                                        }
                                    }

                                    HorizontalPager(
                                        state = pagerState
                                    ) { page ->
                                        when (page) {
                                            0 -> PendingAppointmentsScreen(appointmentViewModel)

                                            1 -> CompletedAppointmentsScreen(appointmentViewModel)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            null-> Box(modifier = Modifier.fillMaxSize()) {
                Text("Loading...")
            }
        }
    }


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PendingAppointmentsScreen(appointmentViewModel: AppointmentViewModel  ) {
    val pendingAppointments by appointmentViewModel.getPendingAppointments().collectAsState(initial = emptyList())
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        if (pendingAppointments.isEmpty()) {
            EmptyStateMessage("No pending appointments", "Schedule a new appointment to get started")
        } else {
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(
                    items = pendingAppointments,
                    key = { it.id }
                ) { appointment ->
                    AppointmentCard(
                        appointment = appointment,
                        onCancel = {
                            coroutineScope.launch {
                                appointmentViewModel.cancelAppointment(appointment.id)
                            }
                        },
                        onComplete = {
                            coroutineScope.launch {
                                appointmentViewModel.updateAppointmentStatus(appointment.id, true)
                            }
                        }
                    )
                }
            }
            Spacer(Modifier.height(55.dp))
        }
    }
}

@Composable
fun CompletedAppointmentsScreen(appointmentViewModel: AppointmentViewModel){
    val completedAppointments by appointmentViewModel.getCompletedAppointments().collectAsState(initial = emptyList())
    val listState = rememberLazyListState()

    Box(modifier = Modifier.fillMaxSize()) {
        if (completedAppointments.isEmpty()) {
            EmptyStateMessage("No completed appointments", "Your completed appointments will appear here")
        } else {
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(
                    items = completedAppointments,
                    key = { it.id }
                ) { appointment ->
                    CompletedAppointmentCard(appointment = appointment)
                }
            }
            Spacer(Modifier.height(55.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun AppointmentCard(
    appointment: AppointmentLists,
    onCancel: () -> Unit,
    onComplete: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val transitionState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }

    val transition = rememberTransition(transitionState, label = "cardTransition")
    val cardScale by transition.animateFloat(
        label = "cardScale",
        transitionSpec = { tween(durationMillis = 300) }
    ) { state ->
        if (state) 1f else 0.95f
    }

    // Status color mapping
    val statusColor = when (appointment.status) {
        "Confirmed" -> MaterialTheme.colorScheme.primary
        "Pending" -> MaterialTheme.colorScheme.tertiary
        else -> MaterialTheme.colorScheme.error
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .scale(cardScale)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = androidx.compose.ui.graphics.Brush.horizontalGradient(
                        colors = listOf(
                            statusColor.copy(alpha = 0.1f),
                            MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.05f)
                        )
                    )
                )
        ) {
            // Status badge
            Surface(
                shape = RoundedCornerShape(topEnd = 20.dp, bottomStart = 20.dp),
                color = statusColor,
                modifier = Modifier
                    .align(Alignment.TopEnd)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = when (appointment.status) {
                            "Confirmed" -> Icons.Default.EventAvailable
                            "Pending" -> Icons.Default.Schedule
                            else -> Icons.Default.ErrorOutline
                        },
                        contentDescription = "Status",
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = appointment.status,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // Doctor info section
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Doctor Image with border
                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .border(
                                width = 2.dp,
                                color = statusColor,
                                shape = CircleShape
                            )
                            .padding(2.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.default_profile_screen),
                            contentDescription = "Doctor ${appointment.doctorName}",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.surfaceVariant)
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    // Doctor Info
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Dr. ${appointment.doctorName}",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Date and time with decorative elements
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.7f)
                            ),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.CalendarToday,
                                        contentDescription = "Date",
                                        modifier = Modifier.size(18.dp),
                                        tint = statusColor
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = appointment.date,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.Medium,
                                        color = MaterialTheme.colorScheme.onSecondaryContainer
                                    )
                                }

                                Box(
                                    modifier = Modifier
                                        .height(20.dp)
                                        .width(1.dp)
                                        .background(MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.3f))
                                )

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.AccessTime,
                                        contentDescription = "Time",
                                        modifier = Modifier.size(18.dp),
                                        tint = statusColor
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = appointment.time,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.Medium,
                                        color = MaterialTheme.colorScheme.onSecondaryContainer
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Divider with gradient
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(
                            brush = androidx.compose.ui.graphics.Brush.horizontalGradient(
                                colors = listOf(
                                    statusColor.copy(alpha = 0.1f),
                                    statusColor.copy(alpha = 0.5f),
                                    statusColor.copy(alpha = 0.1f)
                                )
                            )
                        )
                )
Spacer(Modifier.height(6.dp))
                // Reason section with animation
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                        .clickable { expanded = !expanded }
                        .padding(6.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.MedicalServices,
                                contentDescription = "Reason",
                                tint = statusColor,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Reason for visit",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        IconButton(
                            onClick = { expanded = !expanded },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                contentDescription = if (expanded) "Show less" else "Show more",
                                tint = statusColor
                            )
                        }
                    }

                    AnimatedVisibility(
                        visible = expanded,
                        enter = expandVertically() + fadeIn(),
                        exit = shrinkVertically() + fadeOut()
                    ) {
                        Column {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = appointment.reason,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }

                    if (!expanded) {
                        Text(
                            text = appointment.reason,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                // Action buttons with enhanced design
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = onCancel,
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = MaterialTheme.colorScheme.error
                        ),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.error),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Cancel,
                            contentDescription = "Cancel"
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Cancel",
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Button(
                        onClick = onComplete,
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        ),
                        shape = RoundedCornerShape(12.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 2.dp,
                            pressedElevation = 0.dp
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Complete"
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Complete",
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}



@Composable
fun CompletedAppointmentCard(appointment: AppointmentLists) {
    var expanded by remember { mutableStateOf(false) }
    val transitionState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }

    val transition = rememberTransition(transitionState, label = "completedCardTransition")
    val cardScale by transition.animateFloat(
        label = "cardScale",
        transitionSpec = { tween(durationMillis = 300) }
    ) { state ->
        if (state) 1f else 0.95f
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .scale(cardScale)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = androidx.compose.ui.graphics.Brush.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                            MaterialTheme.colorScheme.tertiary.copy(alpha = 0.05f)
                        )
                    )
                )
        ) {
            // Completed badge
            Surface(
                shape = RoundedCornerShape(topEnd = 20.dp, bottomStart = 20.dp),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .align(Alignment.TopEnd)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Completed",
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Completed",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // Doctor info section
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Doctor Image with border
                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .border(
                                width = 2.dp,
                                color = MaterialTheme.colorScheme.primary,
                                shape = CircleShape
                            )
                            .padding(2.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.default_profile_screen),
                            contentDescription = "Doctor ${appointment.doctorName}",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.surfaceVariant)
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    // Doctor Info
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Dr. ${appointment.doctorName}",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Date and time with decorative elements
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.7f)
                            ),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.CalendarToday,
                                        contentDescription = "Date",
                                        modifier = Modifier.size(18.dp),
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = appointment.date,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.Medium,
                                        color = MaterialTheme.colorScheme.onSecondaryContainer
                                    )
                                }

                                Box(
                                    modifier = Modifier
                                        .height(20.dp)
                                        .width(1.dp)
                                        .background(MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.3f))
                                )

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.AccessTime,
                                        contentDescription = "Time",
                                        modifier = Modifier.size(18.dp),
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = appointment.time,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.Medium,
                                        color = MaterialTheme.colorScheme.onSecondaryContainer
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Divider with gradient
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(
                            brush = androidx.compose.ui.graphics.Brush.horizontalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                                    MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                                    MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                                )
                            )
                        )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Reason section with animation
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                        .clickable { expanded = !expanded }
                        .padding(12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.MedicalServices,
                                contentDescription = "Reason",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Reason for visit",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        IconButton(
                            onClick = { expanded = !expanded },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                contentDescription = if (expanded) "Show less" else "Show more",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }

                    AnimatedVisibility(
                        visible = expanded,
                        enter = expandVertically() + fadeIn(),
                        exit = shrinkVertically() + fadeOut()
                    ) {
                        Column {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = appointment.reason,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }

                    if (!expanded) {
                        Text(
                            text = appointment.reason,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun EmptyStateMessage(title: String, subtitle: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.EventBusy,
            contentDescription = "No appointments",
            modifier = Modifier.size(80.dp),
            tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
    }
}

