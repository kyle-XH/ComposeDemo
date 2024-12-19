package com.cyc.composedemo.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyc.composedemo.ui.theme.ComposeTheme

@Composable
fun BoxScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 4.dp, top = 20.dp, end = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box (
            propagateMinConstraints = false,
            modifier = Modifier.size(100.dp)
        ){
            Box(
                modifier = Modifier.size(150.dp).background(ComposeTheme.colors.secondary)
            )
            Box(
                modifier = Modifier.size(80.dp).background(ComposeTheme.colors.tertiary)
            )
            Text(
                text = "World",
                style = ComposeTheme.typography.displayLarge
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun BoxPreView() {
    BoxScreen()
}