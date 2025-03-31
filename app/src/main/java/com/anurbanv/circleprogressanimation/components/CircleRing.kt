package com.anurbanv.circleprogressanimation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anurbanv.circleprogressanimation.theme.CoolGray

@Composable
fun CircleRing(
    radius: Float = 100f,
    thickness: Float = 20f,
) {
    Canvas(modifier = Modifier.size((radius * 2 + thickness).dp)) {
        drawCircle(
            color = CoolGray,
            radius = radius,
            style = Stroke(width = thickness)
        )
    }
}

@Preview
@Composable
private fun CircleRingPreview() {
    Box { CircleRing() }
}
