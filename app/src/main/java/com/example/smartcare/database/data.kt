package com.example.smartcare.database


import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Destination(
    val route: String,
    val title: String
) {
    object Home : Destination(
        route = "home",
        title = "Home"
    )

    object Messages : Destination(
        route = "messages",
        title = "Messages"
    )

    object OfferRide : Destination(
        route = "offer_ride",
        title = "Offer a Ride"
    )

    object FindRide : Destination(
        route = "find_ride",
        title = "Find a Ride"
    )

    object Chat : Destination(
        route = "chat",
        title = "Chat"
    ) {
        const val userId = "userId"
        val arguments = listOf(
            navArgument(name = userId) {
                type = NavType.StringType
            }
        )

        fun createRouteWithParam(userId: String) = "$route/$userId"
    }
}

