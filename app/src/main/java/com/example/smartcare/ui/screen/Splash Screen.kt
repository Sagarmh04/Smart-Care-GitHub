package com.example.smartcare.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.smartcare.R
import com.example.smartcare.database.viewModel.ProfileViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    profileViewModel: ProfileViewModel,
    isLoggedIn: State<Boolean>
) {

    LaunchedEffect(Unit) {
        delay(2000) // Simulate splash duration
        if (!isLoggedIn.value) {
            navController.navigate("login") {
                popUpTo("splash") { inclusive = true } // Prevent going back to splash
            }
        } else {
            navController.navigate("home") {
                popUpTo("splash") { inclusive = true } // Prevent going back to splash
            }


        }
    }
    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFFFFFFFF)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.splash_screen),
            contentDescription = "Splash Logo",
            modifier = Modifier.fillMaxWidth()
        )
        Box(modifier = Modifier.padding(bottom = 45.dp).align(Alignment.BottomCenter)){

        }
    }

}
