package com.jetpackcompose.disposableeffect.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jetpackcompose.disposableeffect.viewModel.DisposableEffectTestViewModel

@SuppressLint("RememberReturnType")
@Composable
fun DisposableEffectTestScreen(
    viewModel: DisposableEffectTestViewModel
) {
    val count = viewModel.count.collectAsState()
    DisposableEffect(count.value) {
        println("DisposableEffect block called for count = ${count.value}")
        onDispose {
            println("onDispose Called")
        }
    }

    remember(count.value) {
        println("Remember block called for count = ${count.value}")
    }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "DisposableEffect Screen")
    }
}