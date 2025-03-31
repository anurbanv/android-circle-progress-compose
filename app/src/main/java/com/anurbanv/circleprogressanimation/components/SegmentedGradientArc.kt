package com.anurbanv.circleprogressanimation.components

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
import com.anurbanv.circleprogressanimation.theme.colorSectionsList
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun SegmentedGradientArc(
    sweepAngle: Float,
    radius: Float = 100f,
    thickness: Float = 20f,
) {
    val colors = colorsForGradient(sweepAngle)

    val lastSegmentAngle = sweepAngle % 90
    val lastSegmentIndex = colors.size - 2

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

                if (lastSegmentAngle != 0f) {
                    if (segment == lastSegmentIndex) {
                        if (i > lastSegmentAngle) return@Canvas
                    }
                }

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

private fun colorsForGradient(animatedSweep: Float): List<Color> {
    return when {
        animatedSweep == 0f -> listOf()
        animatedSweep <= 90 -> colorSectionsList.subList(0, 2)
        animatedSweep <= 180 -> colorSectionsList.subList(0, 3)
        animatedSweep <= 270 -> colorSectionsList.subList(0, 4)
        animatedSweep <= 360 -> colorSectionsList.subList(0, 5)
        animatedSweep <= 450 -> colorSectionsList.subList(0, 6)
        animatedSweep <= 540 -> colorSectionsList.subList(0, 7)
        animatedSweep <= 630 -> colorSectionsList.subList(0, 8)
        animatedSweep <= 720 -> colorSectionsList
        else -> listOf()
    }
}

@Preview
@Composable
private fun SegmentedGradientArcPreView() {
    Box { SegmentedGradientArc(sweepAngle = 300f) }
}
