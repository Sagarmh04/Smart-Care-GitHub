import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.smartcare.ui.theme.AppColors
import com.example.smartcare.ui.theme.AppTypography
import com.example.smartcare.ui.theme.LocalColors
import com.example.smartcare.ui.theme.LocalTypography
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.smartcare.ui.theme.md_theme_dark_background
import com.example.smartcare.ui.theme.md_theme_dark_error
import com.example.smartcare.ui.theme.md_theme_dark_errorContainer
import com.example.smartcare.ui.theme.md_theme_dark_inverseOnSurface
import com.example.smartcare.ui.theme.md_theme_dark_inversePrimary
import com.example.smartcare.ui.theme.md_theme_dark_inverseSurface
import com.example.smartcare.ui.theme.md_theme_dark_onBackground
import com.example.smartcare.ui.theme.md_theme_dark_onError
import com.example.smartcare.ui.theme.md_theme_dark_onErrorContainer
import com.example.smartcare.ui.theme.md_theme_dark_onPrimary
import com.example.smartcare.ui.theme.md_theme_dark_onPrimaryContainer
import com.example.smartcare.ui.theme.md_theme_dark_onSecondary
import com.example.smartcare.ui.theme.md_theme_dark_onSecondaryContainer
import com.example.smartcare.ui.theme.md_theme_dark_onSurface
import com.example.smartcare.ui.theme.md_theme_dark_onSurfaceVariant
import com.example.smartcare.ui.theme.md_theme_dark_onTertiary
import com.example.smartcare.ui.theme.md_theme_dark_onTertiaryContainer
import com.example.smartcare.ui.theme.md_theme_dark_outline
import com.example.smartcare.ui.theme.md_theme_dark_primary
import com.example.smartcare.ui.theme.md_theme_dark_primaryContainer
import com.example.smartcare.ui.theme.md_theme_dark_secondary
import com.example.smartcare.ui.theme.md_theme_dark_secondaryContainer
import com.example.smartcare.ui.theme.md_theme_dark_surface
import com.example.smartcare.ui.theme.md_theme_dark_surfaceTint
import com.example.smartcare.ui.theme.md_theme_dark_surfaceVariant
import com.example.smartcare.ui.theme.md_theme_dark_tertiary
import com.example.smartcare.ui.theme.md_theme_dark_tertiaryContainer
import com.example.smartcare.ui.theme.md_theme_light_background
import com.example.smartcare.ui.theme.md_theme_light_error
import com.example.smartcare.ui.theme.md_theme_light_errorContainer
import com.example.smartcare.ui.theme.md_theme_light_inverseOnSurface
import com.example.smartcare.ui.theme.md_theme_light_inversePrimary
import com.example.smartcare.ui.theme.md_theme_light_inverseSurface
import com.example.smartcare.ui.theme.md_theme_light_onBackground
import com.example.smartcare.ui.theme.md_theme_light_onError
import com.example.smartcare.ui.theme.md_theme_light_onErrorContainer
import com.example.smartcare.ui.theme.md_theme_light_onPrimary
import com.example.smartcare.ui.theme.md_theme_light_onPrimaryContainer
import com.example.smartcare.ui.theme.md_theme_light_onSecondary
import com.example.smartcare.ui.theme.md_theme_light_onSecondaryContainer
import com.example.smartcare.ui.theme.md_theme_light_onSurface
import com.example.smartcare.ui.theme.md_theme_light_onSurfaceVariant
import com.example.smartcare.ui.theme.md_theme_light_onTertiary
import com.example.smartcare.ui.theme.md_theme_light_onTertiaryContainer
import com.example.smartcare.ui.theme.md_theme_light_outline
import com.example.smartcare.ui.theme.md_theme_light_primary
import com.example.smartcare.ui.theme.md_theme_light_primaryContainer
import com.example.smartcare.ui.theme.md_theme_light_secondary
import com.example.smartcare.ui.theme.md_theme_light_secondaryContainer
import com.example.smartcare.ui.theme.md_theme_light_surface
import com.example.smartcare.ui.theme.md_theme_light_surfaceTint
import com.example.smartcare.ui.theme.md_theme_light_surfaceVariant
import com.example.smartcare.ui.theme.md_theme_light_tertiary
import com.example.smartcare.ui.theme.md_theme_light_tertiaryContainer

private val LightColorScheme = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    error = md_theme_light_error,
    errorContainer = md_theme_light_errorContainer,
    onError = md_theme_light_onError,
    onErrorContainer = md_theme_light_onErrorContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    outline = md_theme_light_outline,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    inverseSurface = md_theme_light_inverseSurface,
    inversePrimary = md_theme_light_inversePrimary,
    surfaceTint = md_theme_light_surfaceTint,
)

private val DarkColorScheme = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inverseSurface = md_theme_dark_inverseSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint,
)

@Composable
fun HospitalAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}


@Composable
fun SmartCareTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        content=content
    )
}

object AppTheme {
    val colors: AppColors
        @Composable
        get() = LocalColors.current
    val typography: AppTypography
        @Composable
        get() = LocalTypography.current
}