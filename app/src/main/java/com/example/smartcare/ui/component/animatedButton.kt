package com.example.smartcare.ui.component

// AnimatedAddIcon.kt
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BreathingAddIcon(
    modifier: Modifier = Modifier,
    iconColor: Color = Color.DarkGray,
    backgroundColor: List<Color> = pastelColors,
    cornerRadius: Dp = 12.dp,
    animationDuration: Int = 4000
) {
    val infiniteTransition = rememberInfiniteTransition()

    val animatedColor by infiniteTransition.animateColor(
        initialValue = backgroundColor.first(),
        targetValue = backgroundColor.last(),
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = animationDuration
                backgroundColor.forEachIndexed { index, color ->
                    color at (animationDuration * index / (backgroundColor.size - 1))
                }
            },
            repeatMode = RepeatMode.Reverse
        )
    )

    Canvas(
        modifier = modifier
            .size(48.dp) // Default icon size
    ) {
        // Draw background
        drawRoundRect(
            color = animatedColor,
            size = size,
            cornerRadius = CornerRadius(0.5f)
        )

        // Draw plus icon
        drawPlusIcon(iconColor)
    }
}

private fun DrawScope.drawPlusIcon(color: Color) {
    val iconSize = size.minDimension * 0.4f
    val strokeWidth = iconSize * 0.2f
    val centerX = size.width / 2
    val centerY = size.height / 2

    // Horizontal line
    drawLine(
        color = color,
        start = Offset(centerX - iconSize / 2, centerY),
        end = Offset(centerX + iconSize / 2, centerY),
        strokeWidth = strokeWidth
    )

    // Vertical line
    drawLine(
        color = color,
        start = Offset(centerX, centerY - iconSize / 2),
        end = Offset(centerX, centerY + iconSize / 2),
        strokeWidth = strokeWidth
    )
}

private val pastelColors = listOf(
    Color(0xFFFFB3BA), // Pink
    Color(0xFFBAFFC9), // Mint
    Color(0xFF2C73AB), // Blue
    Color(0xFFFFFFBA)  // Yellow
)