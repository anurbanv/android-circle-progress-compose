package com.example.circleprogressanimation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.circleprogressanimation.R

@Composable
fun ElectricityIcon(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(36.dp),
        imageVector = ImageVector.vectorResource(R.drawable.ic_electricity_color),
        contentDescription = stringResource(id = R.string.electricity_icon)
    )
}

@Preview
@Composable
private fun ElectricityIconPreview() {
    Box { ElectricityIcon() }
}
