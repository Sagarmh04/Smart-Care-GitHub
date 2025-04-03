package com.example.smartcare

import AppTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.smartcare.ui.theme.white

@Composable
fun BottomNavigationBar(navController: NavHostController, modifier: Modifier = Modifier) {
    val screens = listOf(
        BottomNavScreen.Home,
        BottomNavScreen.Search,
        BottomNavScreen.Records,
        BottomNavScreen.Profile
    )

    BottomNavigation(
        modifier = modifier,
        backgroundColor = AppTheme.colors.surface
    ) {
        screens.forEach { screen ->
            var currentRoute by remember {  mutableStateOf( BottomNavScreen.Home.route)}
            BottomNavigationItem(
                selected = true,
                onClick = {
                    if (navController.currentDestination?.route != screen.route) {
                        navController.navigate(screen.route) {
                            launchSingleTop = true

                        }
                        currentRoute=screen.route
                    }
                },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Spacer(modifier = Modifier.height(15.dp)) // **Space above the icon**
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = screen.title,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                },
                label = {
                    Text(
                        text = screen.title,
                        style = AppTheme.typography.body.copy(fontSize = 16.sp, fontWeight = FontWeight.Thin)
                        )
                Spacer(Modifier.height(40.dp))
                }
            )
        }
    }

}