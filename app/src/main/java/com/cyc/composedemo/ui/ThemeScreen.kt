package com.cyc.composedemo.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cyc.composedemo.ui.theme.ComposeTheme
import com.cyc.composedemo.data.ThemeState
import com.cyc.composedemo.ui.theme.bamboo500
import com.cyc.composedemo.ui.theme.blue500
import com.cyc.composedemo.ui.theme.cyan500
import com.cyc.composedemo.ui.theme.dawn500
import com.cyc.composedemo.ui.theme.violet500

@Composable
fun ThemeScreen(
    themeState: ThemeState,
    onModeChange: (ThemeState.Mode) -> Unit,
    onColorPalletChange: (ThemeState.ColorPallet) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier
                .padding(100.dp)
                .size(200.dp, 50.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                if (themeState.mode == ThemeState.Mode.Light) {
                    onModeChange(ThemeState.Mode.Dark)
                } else {
                    onModeChange(ThemeState.Mode.Light)
                }
            }) {
            Text(
                text = if (themeState.mode == ThemeState.Mode.Light) {
                    "黑夜模式"
                } else {
                    "白天模式"
                },
                color = ComposeTheme.colors.textPrimary
            )
        }

        ColorPalletSelect(themeState.pallet, ThemeState.ColorPallet.CYAN, cyan500) {
            onColorPalletChange(it)
        }
        ColorPalletSelect(themeState.pallet, ThemeState.ColorPallet.BAMBOO, bamboo500) {
            onColorPalletChange(it)
        }
        ColorPalletSelect(themeState.pallet, ThemeState.ColorPallet.DAWN, dawn500) {
            onColorPalletChange(it)
        }
        ColorPalletSelect(themeState.pallet, ThemeState.ColorPallet.BLUE, blue500) {
            onColorPalletChange(it)
        }
        ColorPalletSelect(themeState.pallet, ThemeState.ColorPallet.VIOLET, violet500) {
            onColorPalletChange(it)
        }

    }
}

@Composable
fun ColorPalletSelect(
    currentColorPallet: ThemeState.ColorPallet,
    colorPallet: ThemeState.ColorPallet,
    color: Color,
    onColorPalletSelect: (ThemeState.ColorPallet) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            colors = RadioButtonDefaults.colors(
                selectedColor = color,
                unselectedColor = ComposeTheme.colors.input
            ),
            onClick = {
                onColorPalletSelect.invoke(colorPallet)
            },
            selected = currentColorPallet == colorPallet
        )
        Text(
            text = colorPallet.value,
            color = color,
            style = ComposeTheme.typography.titleLarge
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun ThemePreview() {
    ThemeScreen(
        themeState = ThemeState(),
        onModeChange = {},
        onColorPalletChange = {}
    )
}