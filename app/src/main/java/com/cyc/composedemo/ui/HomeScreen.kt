package com.cyc.composedemo.ui

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material.ripple.RippleTheme.Companion.defaultRippleAlpha
import androidx.compose.material.ripple.RippleTheme.Companion.defaultRippleColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyc.composedemo.ComposeScreen
import com.cyc.composedemo.ui.theme.ComposeTheme

@Composable
fun HomeScreen(
    onClick: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CompositionLocalProvider (LocalRippleTheme provides DebugRippleTheme){
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = ComposeTheme.colors.primary
                ),
                onClick = {
                    onClick(ComposeScreen.View.name)
                },
                modifier = Modifier
                    .width(200.dp),
                interactionSource = remember { MutableInteractionSource() }
            ) {
                Text(text = "基础控件")
            }
        }


        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(ComposeScreen.Layout.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "布局组件")
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(ComposeScreen.Animation.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "动画")
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(ComposeScreen.Theme.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "主题")
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(ComposeScreen.Gesture.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "手势")
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(ComposeScreen.Graphics.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "绘制")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomePreview() {
    HomeScreen(onClick = {})
}

@Immutable
private object DebugRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = defaultRippleColor(Color.Black, lightTheme = true)

    @Composable
    override fun rippleAlpha(): RippleAlpha = defaultRippleAlpha(
        Color.Red,
        lightTheme = true
    )
}