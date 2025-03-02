package com.example.smartcare.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val skin = Color(0xFFFCD1BA)
val transparent = Color(0x00000000)
val black = Color(0xFF000000)
val white = Color(0xFFFFFFFF)

data class AppColors(
    val background : Color,
    val surface : Color,
    val onSurface : Color,
    val primary : Color,
)

val LocalColors = staticCompositionLocalOf {
    AppColors(
        background = white,
        surface = skin,
        onSurface = transparent,
        primary = black
    )
}