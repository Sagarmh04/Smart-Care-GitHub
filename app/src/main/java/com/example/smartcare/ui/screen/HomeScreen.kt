package com.example.smartcare.ui.screen

import AppTheme
import androidx.compose.animation.ExperimentalAnimationApi
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.smartcare.BottomNavScreen
import com.example.smartcare.ui.theme.black
import com.example.smartcare.ui.theme.skin
import com.example.smartcare.ui.theme.transparent
import com.example.smartcare.ui.theme.white
import com.example.smartcare.database.viewModel.ProfileViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navController: NavHostController,
    profileViewModel: ProfileViewModel,
    onSplashComplete: () -> Unit,
) {

        val isLoggedIn = profileViewModel.isLoggedIn.observeAsState(initial = null)
    val scrollState = rememberScrollState()
    var searchQuery by remember { mutableStateOf("") }
        when(isLoggedIn.value) {
            false-> Column(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator()
                Text("Loading...")
            }
            true-> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(top = 5.dp)
                ) {
                    LazyColumn {
                        item {
                            OutlinedTextField(
                                value = searchQuery,
                                onValueChange = { searchQuery = it },
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth() // Optional: Make it take full width
                            )
                        }
                        // add elements inside item only , or chatgpt maadri
                    }
                }

            }
            null-> Box(modifier = Modifier.fillMaxSize()) {
                Text("Loading...")
            }
        }
    }

@Composable
fun CompletedAppointmentsScreen() {
    Box(modifier = Modifier.fillMaxWidth()){
        Text("hwfu7i")
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PendingAppointmentsScreen(  ) {
    Box(modifier = Modifier.fillMaxWidth()){
        Text("hwfu7i")
    }
}
