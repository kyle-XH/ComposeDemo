package com.cyc.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cyc.composedemo.data.ThemeState
import com.cyc.composedemo.ui.theme.ComposeTheme
import com.cyc.composedemo.viewmodel.ThemeViewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ThemeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val themeState = remember {
                mutableStateOf(ThemeState())
            }
            ComposeTheme (themeState.value){
                ComposeDemoApp(
                    themeState.value,
                    onModeChange = {
                        themeState.value = ThemeState(
                            mode = it,
                            pallet = themeState.value.pallet
                        )
                    },
                    onColorPalletChange = {
                        themeState.value = ThemeState(
                            mode = themeState.value.mode,
                            pallet = it
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTheme {
        Greeting("Android")
    }
}