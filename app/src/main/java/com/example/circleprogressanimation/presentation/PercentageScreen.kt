package com.example.circleprogressanimation.presentation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.circleprogressanimation.components.CircleRing
import com.example.circleprogressanimation.components.ElectricityPercentage
import com.example.circleprogressanimation.components.SegmentedGradientArc
import com.example.circleprogressanimation.ui.theme.DeepBlue
import com.example.circleprogressanimation.util.toPx

private const val animationDurationMillis = 2000

private val ringRadius = 74.dp
private val ringThickness = 12.dp
private val easing = LinearEasing

@Composable
fun PercentageScreen(modifier: Modifier = Modifier, viewModel: PercentageViewModel = viewModel()) {
    Column(modifier = modifier.padding(32.dp)) {
        var sliderPosition = remember { viewModel.sliderPosition }
        var targetPercentage = remember { viewModel.targetPercentage }

        val animatedSweep by animateFloatAsState(
            targetValue = targetPercentage.value,
            animationSpec = tween(durationMillis = animationDurationMillis, easing = easing),
        )

        val percentage = animatedSweep / 360 * 100

        Box(contentAlignment = Alignment.Center) {
            CircleRing(
                radius = ringRadius.toPx(),
                thickness = ringThickness.toPx(),
            )
            SegmentedGradientArc(
                radius = ringRadius.toPx(),
                thickness = ringThickness.toPx(),
                sweepAngle = animatedSweep,
            )
            ElectricityPercentage(percentage = percentage)
        }

        Column(
            modifier = Modifier.padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "${sliderPosition.value.toInt()}",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 28.sp
                ),
                color = DeepBlue,
            )
            Slider(
                value = sliderPosition.value,
                onValueChange = { viewModel.onSliderPositionChange(it) },
                valueRange = 0f..200f,
            )
        }
    }
}

@Preview
@Composable
private fun PercentageScreenPreview() {
    Box { PercentageScreen() }
}
