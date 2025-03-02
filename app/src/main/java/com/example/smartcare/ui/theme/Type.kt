package com.example.smartcare.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.smartcare.R

val sans = FontFamily(
    Font(R.font.sans, FontWeight.Normal) // Make sure the filename matches your `res/font/` file
)

@Immutable
data class AppTypography(
    val heading : TextStyle,
    val body : TextStyle
)
val LocalTypography = staticCompositionLocalOf {
    AppTypography(
        heading = TextStyle(
            fontFamily = sans,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp
        ),
        body = TextStyle(
            fontFamily = sans,
            fontWeight = FontWeight.Normal,
            fontSize = 8.sp,
            lineHeight = 12.sp,
            letterSpacing = 0.5.sp
        )
    )
}