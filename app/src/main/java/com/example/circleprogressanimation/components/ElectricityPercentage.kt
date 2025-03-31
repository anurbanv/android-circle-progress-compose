package com.example.circleprogressanimation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ElectricityPercentage(modifier: Modifier = Modifier, percentage: Float) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ElectricityIcon()
        Spacer(modifier = Modifier.height(4.dp))
        PercentageText(percentage = percentage)
    }
}

@Preview
@Composable
private fun ElectricityPercentagePreview() {
    Box { ElectricityPercentage(percentage = 68f) }
}
