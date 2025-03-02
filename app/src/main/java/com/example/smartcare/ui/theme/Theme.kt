import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.smartcare.ui.theme.AppColors
import com.example.smartcare.ui.theme.AppTypography
import com.example.smartcare.ui.theme.LocalColors
import com.example.smartcare.ui.theme.LocalTypography

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