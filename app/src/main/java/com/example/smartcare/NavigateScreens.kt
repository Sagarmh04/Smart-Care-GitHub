package com.example.smartcare

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.smartcare.database.Destination
import com.example.smartcare.database.entity.ProfileData
import com.example.smartcare.database.viewModel.ChatUserViewModel
import com.example.smartcare.database.viewModel.MessageViewModel
import com.example.smartcare.ui.screen.HomeScreen
import com.example.smartcare.ui.screen.LoginScreen
import com.example.smartcare.ui.screen.ProfileScreen
import com.example.smartcare.ui.screen.SignupScreen
import com.example.smartcare.ui.screen.SplashScreen
import com.example.smartcare.database.viewModel.ProfileViewModel
import com.example.smartcare.database.viewModel.RideViewModel
import com.example.smartcare.ui.screen.ChatScreen
import com.example.smartcare.ui.screen.FindRideScreen
import com.example.smartcare.ui.screen.MessageScreen
import com.example.smartcare.ui.screen.OfferRideScreen
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun NavigateScreens(
    innerPadding: PaddingValues,
    navController: NavHostController,
    profile: ProfileData?,
    profileViewModel: ProfileViewModel,
    messageViewModel: MessageViewModel,
    isLoggedIn: State<Boolean>,
    rideViewModel: RideViewModel,
    chatUserViewModel: ChatUserViewModel,
    auth: FirebaseAuth,
    db: FirebaseFirestore,
) {
    val user = Firebase.auth.currentUser
    NavHost(navController, startDestination = OtherScreens.SplashScreen.route) {
        composable(
            OtherScreens.SplashScreen.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(100)) }
        ) {
            SplashScreen(navController, profileViewModel,isLoggedIn)
        }
        composable(
            OtherScreens.Login.route,
            enterTransition = { fadeIn(animationSpec = tween(50)) },
            exitTransition = { fadeOut(animationSpec = tween(0)) }
        ) {
            LoginScreen(onLoginSuccess = {
                profileViewModel.updateLoginState(true)
                navController.popBackStack()
                navController.navigate(Destination.Home.route)
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
                    navController.navigate(Destination.Home.route)
                },
                onLoginClick = {
                    navController.navigate(OtherScreens.Login.route) {
                        popUpTo(0) { inclusive = true }
                    }
                },
                profileViewModel = profileViewModel,
                auth,
                db
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
        composable(Destination.Home.route) {
            HomeScreen(
                navController = navController,
                rideViewModel = rideViewModel,
                innerPadding,
                chatUserViewModel,
                db
            )
        }
        composable(Destination.Messages.route) {
            MessageScreen(
                navController = navController,
                rideViewModel = rideViewModel,
                innerPadding,
                chatUserViewModel,
                db
            )
        }
        composable(Destination.OfferRide.route) {
            OfferRideScreen(
                navController = navController,
                rideViewModel = rideViewModel
            )
        }
        composable(Destination.FindRide.route) {
            FindRideScreen(
                navController = navController,
                rideViewModel = rideViewModel
            )
        }
        composable(
            route = "${Destination.Chat.route}/{userId}",
            arguments = Destination.Chat.arguments
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            ChatScreen(
                navController = navController,
                userId = userId ?: "",
                rideViewModel = rideViewModel,
                innerPadding
            )
        }
        }
    }
