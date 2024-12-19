package com.cyc.composedemo.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyc.composedemo.ui.theme.ComposeTheme
import com.cyc.composedemo.ui.theme.bamboo500
import com.cyc.composedemo.ui.theme.bamboo500Alpha8
import com.cyc.composedemo.ui.theme.bamboo900
import com.cyc.composedemo.ui.theme.grayDark00
import com.cyc.composedemo.ui.theme.sunset500

@Composable
fun CheckScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 4.dp, top = 20.dp, end = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var progress by remember {
            mutableFloatStateOf(0f)
        }
        Slider(
            modifier = Modifier.padding(horizontal = 50.dp),
            value = progress,
            onValueChange = {
                progress = it
            },
            colors = SliderDefaults.colors(
                thumbColor = ComposeTheme.colors.secondary,
                activeTrackColor = bamboo900
            )
        )

        Spacer(modifier = Modifier.height(100.dp))

        val checkedState = remember {
            mutableStateOf(false)
        }
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            colors = CheckboxDefaults.colors(
                checkedColor = ComposeTheme.colors.primary,
                uncheckedColor = ComposeTheme.colors.disable
            )
        )

        Spacer(modifier = Modifier.height(100.dp))

        val switchState = remember {
            mutableStateOf(false)
        }
        Switch(
            thumbContent = {
                Icon(Icons.Filled.Favorite,
                    contentDescription = "",
                    )
            },
            checked = switchState.value,
            onCheckedChange ={
                switchState.value = it
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = bamboo500,
                checkedIconColor = sunset500,
                checkedTrackColor = bamboo500Alpha8,
                uncheckedThumbColor = ComposeTheme.colors.disable,
                uncheckedIconColor = sunset500,
                uncheckedTrackColor = grayDark00,
            ),

        )

        Spacer(modifier = Modifier.height(100.dp))

        val radioState = remember {
            mutableStateOf(false)
        }
        RadioButton(
            selected = radioState.value,
            onClick = {
                radioState.value = !radioState.value
            },
            colors = RadioButtonDefaults.colors(
                selectedColor = ComposeTheme.colors.primary,
                unselectedColor = ComposeTheme.colors.disable
            ))
    }
}

@Composable
@Preview(showSystemUi = true)
fun CheckPreView() {
    CheckScreen()
}