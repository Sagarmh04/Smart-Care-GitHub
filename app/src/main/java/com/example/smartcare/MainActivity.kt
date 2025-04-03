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
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.smartcare.ui.theme.white
import com.example.smartcare.viewModel.AppointmentViewModel
import com.example.smartcare.viewModel.AppointmentViewModelFactory
import com.example.smartcare.viewModel.MedicalRecordViewModel
import com.example.smartcare.viewModel.MedicalRecordViewModelFactory
import com.example.smartcare.viewModel.ProfileViewModel
import com.example.smartcare.viewModel.ProfileViewModelFactory
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        val profileDao = MainApplication.profileDatabase.profileDao()
        val medicalDao = MainApplication.profileDatabase.medicalRecordDao()
        val appointmentDao = MainApplication.profileDatabase.appointmentDao()

// Profile ViewModel
        val profileFactory = ProfileViewModelFactory(profileDao)
        val profileViewModel = ViewModelProvider(this, profileFactory)[ProfileViewModel::class.java]

// Medical Record ViewModel
        val medicalFactory = MedicalRecordViewModelFactory(medicalDao)
        val medicalViewModel = ViewModelProvider(this, medicalFactory)[MedicalRecordViewModel::class.java]

// Appointment ViewModel
        val appointmentFactory = AppointmentViewModelFactory(appointmentDao)
        val appointmentViewModel = ViewModelProvider(this, appointmentFactory)[AppointmentViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            var showBottomBar by remember { mutableStateOf(false) }
            val navController = rememberNavController()
            val systemUiController = rememberSystemUiController()
            val isDarkTheme = isSystemInDarkTheme()

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
                val profile by profileViewModel.profile.observeAsState()
                val isLoggedIn by profileViewModel.isLoggedIn.observeAsState()
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
                            if(isLoggedIn == true&&showBottomBar)
                                BottomNavigationBar(navController)
                        } // ✅ Bottom bar inside Scaffold
                    ) { innerPadding ->
                        NavigateScreens(
                            innerPadding,
                            navController,
                            profile, profileViewModel,
                            onSplashComplete = { showBottomBar = true },
                            hideBottomScreen = { showBottomBar = false },
                            medicalViewModel = medicalViewModel,
                            appointmentViewModel =appointmentViewModel,
                        )
                    }
                }
            }
        }
    }
}

