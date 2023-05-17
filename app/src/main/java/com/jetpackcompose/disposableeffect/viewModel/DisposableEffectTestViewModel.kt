package com.jetpackcompose.disposableeffect.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DisposableEffectTestViewModel: ViewModel() {

    private var _count = MutableStateFlow(1)
    val count: StateFlow<Int> get() = _count.asStateFlow()

    init {
        viewModelScope.launch {
            var displayCount = 1
            while (displayCount < 3) {
                delay(1000L)
                displayCount += 1
                _count.value = displayCount
            }
        }
    }
}