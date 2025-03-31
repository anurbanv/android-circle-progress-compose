package com.example.circleprogressanimation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun SegmentedGradientArc(
    radius: Float = 100f,
    thickness: Float = 20f,
    colors: List<Color> = listOf(Color.Red, Color.Green, Color.Blue),
) {
    Canvas(modifier = Modifier.size((radius * 2 + thickness).dp)) {
        val step = 1f
        val segmentAngle = 90f

        for (segment in 0 until colors.size - 1) {
            val startAngle = -90 + (segment * segmentAngle)
            val endAngle = startAngle + segmentAngle
            val startColor = colors[segment]
            val endColor = colors[segment + 1]

            val totalSteps = ((endAngle - startAngle) / step).toInt()

            for (i in 0 until totalSteps) {
                val angle = startAngle + (i * step)
                val nextAngle = angle + step

                val fraction = i.toFloat() / totalSteps
                val blendedColor = lerp(startColor, endColor, fraction)

                val startX = center.x + radius * cos(Math.toRadians(angle.toDouble())).toFloat()
                val startY = center.y + radius * sin(Math.toRadians(angle.toDouble())).toFloat()
                val endX = center.x + radius * cos(Math.toRadians(nextAngle.toDouble())).toFloat()
                val endY = center.y + radius * sin(Math.toRadians(nextAngle.toDouble())).toFloat()

                drawLine(
                    color = blendedColor,
                    start = Offset(startX, startY),
                    end = Offset(endX, endY),
                    strokeWidth = thickness,
                    cap = StrokeCap.Round
                )
            }
        }
    }
}

@Preview
@Composable
private fun SegmentedGradientArcPreView() {
    Box { SegmentedGradientArc() }
}
