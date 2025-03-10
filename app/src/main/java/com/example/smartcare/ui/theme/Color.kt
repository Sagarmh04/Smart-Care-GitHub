package com.example.smartcare.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// Light Theme Colors
val md_theme_light_primary = Color(0xFF006C51)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFF89F8D0)
val md_theme_light_onPrimaryContainer = Color(0xFF002116)
val md_theme_light_secondary = Color(0xFF4C6358)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFCEE9DB)
val md_theme_light_onSecondaryContainer = Color(0xFF082017)
val md_theme_light_tertiary = Color(0xFF3D6373)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFC1E8FB)
val md_theme_light_onTertiaryContainer = Color(0xFF001F29)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFBFDF9)
val md_theme_light_onBackground = Color(0xFF191C1A)
val md_theme_light_surface = Color(0xFFFBFDF9)
val md_theme_light_onSurface = Color(0xFF191C1A)
val md_theme_light_surfaceVariant = Color(0xFFDBE5DE)
val md_theme_light_onSurfaceVariant = Color(0xFF404943)
val md_theme_light_outline = Color(0xFF707973)
val md_theme_light_inverseOnSurface = Color(0xFFEFF1ED)
val md_theme_light_inverseSurface = Color(0xFF2E312F)
val md_theme_light_inversePrimary = Color(0xFF6CDBB5)
val md_theme_light_surfaceTint = Color(0xFF006C51)

// Dark Theme Colors
val md_theme_dark_primary = Color(0xFF6CDBB5)
val md_theme_dark_onPrimary = Color(0xFF003828)
val md_theme_dark_primaryContainer = Color(0xFF00513C)
val md_theme_dark_onPrimaryContainer = Color(0xFF89F8D0)
val md_theme_dark_secondary = Color(0xFFB2CDBE)
val md_theme_dark_onSecondary = Color(0xFF1E352B)
val md_theme_dark_secondaryContainer = Color(0xFF344C41)
val md_theme_dark_onSecondaryContainer = Color(0xFFCEE9DB)
val md_theme_dark_tertiary = Color(0xFFA5CCDF)
val md_theme_dark_onTertiary = Color(0xFF073543)
val md_theme_dark_tertiaryContainer = Color(0xFF244C5B)
val md_theme_dark_onTertiaryContainer = Color(0xFFC1E8FB)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF191C1A)
val md_theme_dark_onBackground = Color(0xFFE1E3DF)
val md_theme_dark_surface = Color(0xFF191C1A)
val md_theme_dark_onSurface = Color(0xFFE1E3DF)
val md_theme_dark_surfaceVariant = Color(0xFF404943)
val md_theme_dark_onSurfaceVariant = Color(0xFFBFC9C2)
val md_theme_dark_outline = Color(0xFF8A938C)
val md_theme_dark_inverseOnSurface = Color(0xFF191C1A)
val md_theme_dark_inverseSurface = Color(0xFFE1E3DF)
val md_theme_dark_inversePrimary = Color(0xFF006C51)
val md_theme_dark_surfaceTint = Color(0xFF6CDBB5)

// Additional colors
val toast_background = Color(0xFF323232)
val toast_text = Color(0xFFFFFFFF)
val toast_success = Color(0xFF4CAF50)


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