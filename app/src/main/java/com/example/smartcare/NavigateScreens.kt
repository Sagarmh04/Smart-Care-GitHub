package com.example.smartcare

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.smartcare.ui.screen.AppointmentBookingScreen
import com.example.smartcare.ui.screen.HomeScreen
import com.example.smartcare.ui.screen.HospitalDetailsScreen
import com.example.smartcare.ui.screen.LoginScreen
import com.example.smartcare.ui.screen.ProfileScreen
import com.example.smartcare.ui.screen.RecordScreen
import com.example.smartcare.ui.screen.SearchScreen
import com.example.smartcare.ui.screen.SignupScreen
import com.example.smartcare.ui.screen.SplashScreen
import com.example.smartcare.viewModel.AppointmentViewModel
import com.example.smartcare.viewModel.MedicalRecordViewModel
import com.example.smartcare.viewModel.ProfileViewModel

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun NavigateScreens(
    innerPadding: PaddingValues,
    navController: NavHostController,
    profile: ProfileData?,
    profileViewModel: ProfileViewModel,
    onSplashComplete: () -> Unit,
    medicalViewModel: MedicalRecordViewModel,
    appointmentViewModel: AppointmentViewModel,
    hideBottomScreen: () -> Unit,
) {
    NavHost(navController, startDestination = OtherScreens.SplashScreen.route) {
        composable(
            OtherScreens.SplashScreen.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(100)) }
        ) {
            SplashScreen(navController, profileViewModel)
        }
        composable(
            route = BottomNavScreen.Home.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            HomeScreen(innerPadding, navController, profileViewModel, onSplashComplete,
                appointmentViewModel
            )
        }
        composable(
            OtherScreens.Login.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            LoginScreen(onLoginSuccess = {
                profileViewModel.updateLoginState(true)
                navController.popBackStack()
                navController.navigate(BottomNavScreen.Home.route)
            },
                onSignupClick = {
                    navController.navigate(OtherScreens.signup.route) {
                        popUpTo(0) { inclusive = true }
                    }
                },
                onForgotPasswordClick = {})
        }
        composable(
            route = OtherScreens.signup.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            SignupScreen(
                onSignupSuccess = {
                    profileViewModel.updateLoginState(true)
                    navController.popBackStack()
                    navController.navigate(BottomNavScreen.Home.route)
                },
                onLoginClick = {
                    navController.navigate(OtherScreens.Login.route) {
                        popUpTo(0) { inclusive = true }
                    }
                },
                profileViewModel = profileViewModel
            )
        }
        composable(
            route = OtherScreens.bookingScreen.route
        ){
            AppointmentBookingScreen(
                navController = navController,
                appointmentViewModel = appointmentViewModel,
                hideBottomScreen,
                modifier = Modifier.padding(innerPadding)
                )
        }
        composable(
            BottomNavScreen.Search.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            SearchScreen(
                modifier = Modifier.padding(innerPadding),
                onBack = {},
                navController = navController,
                hideBottomScreen = onSplashComplete
            )
        }
        // Add to your navigation graph
        composable(
            route = "hospitalDetails"
        ) {
            HospitalDetailsScreen(
                navController,
                hideBottomScreen = hideBottomScreen)
        }
        composable(
            BottomNavScreen.Records.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            RecordScreen(innerPadding)
        }
        composable(
            BottomNavScreen.Profile.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            ProfileScreen(
                innerPadding, profileViewModel, onLogout = {
                    profileViewModel.updateLoginState(false)
                    profileViewModel.deleteProfile()
                    navController.navigate(OtherScreens.Login.route) {
                        popUpTo(0) { inclusive = true }
                    }
                },
                onSettings = {},
                onEdit = {  }
            )
        }
    }
}


