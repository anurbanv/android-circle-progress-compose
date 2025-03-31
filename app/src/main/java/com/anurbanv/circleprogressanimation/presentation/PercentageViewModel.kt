package com.anurbanv.circleprogressanimation.presentation

import androidx.compose.runtime.FloatState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.lifecycle.ViewModel

class PercentageViewModel : ViewModel() {

    private val _sliderPosition = mutableFloatStateOf(0f)
    private val _targetPercentage = mutableFloatStateOf(0f)

    val sliderPosition: FloatState = _sliderPosition
    val targetPercentage: FloatState = _targetPercentage

    fun onSliderPositionChange(position: Float) {
        _sliderPosition.floatValue = position
        _targetPercentage.floatValue = position / 100 * 360
    }
}
