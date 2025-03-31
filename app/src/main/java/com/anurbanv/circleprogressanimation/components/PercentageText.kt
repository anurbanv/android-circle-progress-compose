package com.anurbanv.circleprogressanimation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.anurbanv.circleprogressanimation.theme.DeepBlue

@Composable
fun PercentageText(modifier: Modifier = Modifier, percentage: Float) {
    val plusSign = if (percentage > 0) "+" else ""
    Text(
        modifier = modifier,
        text = "$plusSign${(percentage).toInt()}%",
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 28.sp
        ),
        color = DeepBlue,
    )
}

@Preview
@Composable
private fun PercentageTextPreview() {
    Box { PercentageText(percentage = 68.0f) }
}
