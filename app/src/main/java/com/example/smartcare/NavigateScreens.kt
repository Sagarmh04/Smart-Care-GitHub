package com.example.smartcare

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.smartcare.database.entity.ProfileData
import com.example.smartcare.database.viewModel.MessageViewModel
import com.example.smartcare.ui.screen.HomeScreen
import com.example.smartcare.ui.screen.LoginScreen
import com.example.smartcare.ui.screen.ProfileScreen
import com.example.smartcare.ui.screen.SignupScreen
import com.example.smartcare.ui.screen.SplashScreen
import com.example.smartcare.database.viewModel.ProfileViewModel
import com.example.smartcare.ui.screen.EmergencyRide
import com.example.smartcare.ui.screen.FindARideScreen
import com.example.smartcare.ui.screen.MessageChatScreen
import com.example.smartcare.ui.screen.MessageScreen
import com.example.smartcare.ui.screen.OfferARideScreen
import com.example.smartcare.ui.screen.TrendingScreen
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun NavigateScreens(
    innerPadding: PaddingValues,
    navController: NavHostController,
    profile: ProfileData?,
    profileViewModel: ProfileViewModel,
    messageViewModel: MessageViewModel,
    isLoggedIn: Boolean,
    onSplashComplete: () -> Unit,
    hideBottomScreen: () -> Unit,
) {
    var user = Firebase.auth.currentUser
    NavHost(navController, startDestination = OtherScreens.SplashScreen.route) {
        composable(
            OtherScreens.SplashScreen.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(100)) }
        ) {
            SplashScreen(navController, profileViewModel,isLoggedIn)
        }
        composable(
            route = BottomNavScreen.Home.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            HomeScreen(innerPadding, navController, profileViewModel, onSplashComplete)
        }
        composable(
            route = BottomNavScreen.MessageScreen.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            MessageScreen(innerPadding,messageViewModel,navController,hideBottomScreen)
        }
        composable(
            OtherScreens.Login.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            LoginScreen(onLoginSuccess = {
                profileViewModel.updateLoginState(true)
                navController.popBackStack()
                onSplashComplete()
                navController.navigate(BottomNavScreen.Home.route)
            },
                onSignupClick = {
                    navController.navigate(OtherScreens.signup.route) {
                        popUpTo(0) { inclusive = true }
                    }
                },
                onForgotPasswordClick = {},
                profileViewModel
                )
        }
        composable(
            route = OtherScreens.signup.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            SignupScreen(
                onSignupSuccess = {
                    profileViewModel.updateLoginState(true)
                    if (user != null) {
                        profileViewModel.updateId(user.uid)
                    }
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
        composable(
            OtherScreens.trendingScreen.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            TrendingScreen(navController)
        }
        composable(
            OtherScreens.findARideScreen.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            FindARideScreen()
        }
        composable(
            OtherScreens.emergencyScreen.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            EmergencyRide()
        }
        composable(
            OtherScreens.offerARideScreen.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            OfferARideScreen()
        }
        composable(
            OtherScreens.MessageChatScreen.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            if (user != null) {
                MessageChatScreen(navController,messageViewModel, user.uid, hideBottomScreen)
            }
        }
        }
    }
