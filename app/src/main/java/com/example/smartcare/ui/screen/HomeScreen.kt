package com.example.smartcare.ui.screen

import AppTheme
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartcare.viewModel.ProfileViewModel
import com.example.smartcare.R
import com.example.smartcare.ui.theme.black
import com.example.smartcare.ui.theme.skin
import com.example.smartcare.ui.theme.transparent
import com.example.smartcare.ui.theme.white
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    innerPadding: PaddingValues,
    navController: NavHostController,
    profileViewModel: ProfileViewModel,
    onSplashComplete: () -> Unit
) {
    val isLoggedIn = profileViewModel.isLoggedIn.observeAsState(initial = null)
    when(isLoggedIn.value) {
        false-> Column(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator()
            Text("Loading...")
        }
        true-> {
            onSplashComplete()
            Box(modifier = Modifier.fillMaxSize().padding(innerPadding).padding(top = 5.dp)) {
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
                            onClick = {},
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
                                painter = painterResource(R.drawable.home_selected),
                                contentDescription = "Home",
                                modifier = Modifier.size(30.dp) // Ensures proper icon size
                            )
                        }

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
                                painter = painterResource(R.drawable.home_selected),
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
                Box() {
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
                                    .background(AppTheme.colors.background),
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
                                    0 -> CompletedAppointments()
                                    1 -> UpcomingAppointments(profileViewModel)
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

@Composable
fun UpcomingAppointments(profileViewModel: ProfileViewModel) {
    val profile by profileViewModel.profile.observeAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        profile?.let {
            Text(text = "Name: ${it.name}", fontSize = 20.sp)
            Text(text = "Email: ${it.email}", fontSize = 20.sp)
            Text(text = "Logged In: ${it.isLoggedIn}", fontSize = 20.sp)

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                // Update name and persist in database
                profileViewModel.insertOrUpdateProfile(it.copy(name = "Updated Name"))
            }) {
                Text(text = "Update Name")
            }
        } ?: Text(text = "No profile found!", fontSize = 20.sp)
    }
}

@Composable
fun CompletedAppointments() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
        Text("Hello")
    }
}
