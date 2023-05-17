package com.jetpackcompose.disposableeffect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jetpackcompose.disposableeffect.screen.DisposableEffectScreen
import com.jetpackcompose.disposableeffect.ui.theme.JetpackComposeDisposableEffectTheme
import com.jetpackcompose.disposableeffect.viewModel.DisposableEffectViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDisposableEffectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisposableEffectScreen(viewModel = DisposableEffectViewModel())
//                    DisposableEffectTestScreen(DisposableEffectTestViewModel())
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeDisposableEffectTheme {
        Greeting("Android")
    }
}