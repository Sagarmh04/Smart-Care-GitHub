package com.example.smartcare

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FileCopy
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavScreen(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomNavScreen("home", "Home", Icons.Default.Home )
    object Search : BottomNavScreen("search", "Search", Icons.Default.Search)
    object Records : BottomNavScreen("records", "Records", Icons.Default.FileCopy)
    object Profile : BottomNavScreen("profile", "Profile", Icons.Default.AccountCircle)
}

sealed class OtherScreens(val route: String, val title: String, val icon: Int = R.drawable.home_unselected) {
    object Login : OtherScreens("login", "Login")
    object SplashScreen : OtherScreens("splash", "Splash Screen")
    object signup : OtherScreens("signup", "Signup")
    object bookingScreen : OtherScreens(route = "bookingScreen", title = "bookingScreen")
    object paymentScreen : OtherScreens(route = "paymentScreen", title = "paymentScreen")
}
