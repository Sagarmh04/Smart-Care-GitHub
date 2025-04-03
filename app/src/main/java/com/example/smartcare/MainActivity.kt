package com.example.smartcare

import AppTheme
import SmartCareTheme
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.smartcare.database.entity.ProfileData
import com.example.smartcare.database.viewModel.MessageViewModel
import com.example.smartcare.database.viewModel.MessageViewModelFactory
import com.example.smartcare.ui.theme.white
import com.example.smartcare.database.viewModel.ProfileViewModel
import com.example.smartcare.database.viewModel.ProfileViewModelFactory
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        val profileDao = MainApplication.profileDatabase.profileDao()
        val messageDao = MainApplication.profileDatabase.messageDao()

// Profile ViewModel
        val profileFactory = ProfileViewModelFactory(profileDao)
        val profileViewModel = ViewModelProvider(this, profileFactory)[ProfileViewModel::class.java]
        val messageFactory = MessageViewModelFactory(messageDao)
        val messageViewModel = ViewModelProvider(this, messageFactory)[MessageViewModel::class.java]


        enableEdgeToEdge()
        setContent {
            var showBottomBar by remember { mutableStateOf(false) }
            val navController = rememberNavController()
            val systemUiController = rememberSystemUiController()

            SideEffect {
                systemUiController.setStatusBarColor(
                    color = white, // Or any color u want
                    darkIcons = true // Auto adjusts icons based on theme
                )

                systemUiController.setNavigationBarColor(
                    color = Color.Transparent, // Makes bottom system bar transparent
                    darkIcons = true // Auto adjusts icons based on theme
                )
            }


            SmartCareTheme {
                val profile by profileViewModel.profile.collectAsState(
                    ProfileData(
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
                )
                val isLoggedIn = profileViewModel.isLoggedIn.collectAsState(initial = false).value
                LaunchedEffect(Unit) {
                    profileViewModel.ensureProfileExists()
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(AppTheme.colors.background)
                ) {
                    Scaffold(
                        bottomBar = {
                            if(isLoggedIn &&showBottomBar)
                                BottomNavigationBar(navController)
                        } // ✅ Bottom bar inside Scaffold
                    ) { innerPadding ->
                        NavigateScreens(
                            innerPadding,
                            navController,
                            profile,
                            profileViewModel,
                            messageViewModel,
                            isLoggedIn,
                            onSplashComplete = { showBottomBar = true },
                            hideBottomScreen = { showBottomBar = false }
                        )
                    }
                }
            }
        }
    }
}

