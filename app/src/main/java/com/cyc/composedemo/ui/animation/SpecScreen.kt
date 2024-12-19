package com.cyc.composedemo.ui.animation

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyc.composedemo.ui.theme.ComposeTheme

@Composable
fun SpecScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(ComposeTheme.colors.surface)
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        SpringView()

        TweenView()

        KeyframesSpecView()

        Spacer(modifier = Modifier.height(50.dp))

        SnapSpecView()

        Spacer(modifier = Modifier.height(50.dp))

        RepeatableSpecView()
    }
}

@Composable
fun SpringView() {
    var status by remember {
        mutableStateOf(false)
    }

    Button(onClick = {
        status = !status
    }) {
        Text(text = "spring")
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        val size1 by animateDpAsState(
            targetValue = if (status) 100.dp else 50.dp,
            animationSpec = spring(
                dampingRatio = 0.2f,
                stiffness = 1500f
            ),
            label = ""
        )
        Box(modifier = Modifier
            .padding(start = 50.dp)
            .background(ComposeTheme.colors.secondary)
            .size(size = size1)
        )

        val size2 by animateDpAsState(
            targetValue = if (status) 100.dp else 50.dp,
            animationSpec = spring(
                dampingRatio = 1f,
                stiffness = 1500f
            ),
            label = ""
        )
        Box(modifier = Modifier
            .padding(start = 170.dp)
            .background(ComposeTheme.colors.secondary)
            .size(size = size2)
        )

        val size3 by animateDpAsState(
            targetValue = if (status) 100.dp else 50.dp,
            animationSpec = spring(
                dampingRatio = 1.5f,
                stiffness = 1500f
            ),
            label = ""
        )
        Box(modifier = Modifier
            .padding(start = 290.dp)
            .background(ComposeTheme.colors.secondary)
            .size(size = size3)
        )
    }

}

@Composable
fun TweenView() {
    var status by remember {
        mutableStateOf(false)
    }

    Button(onClick = {
        status = !status
    }) {
        Text(text = "tween")
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
    ) {
        val size1 by animateDpAsState(
            targetValue = if (status) 100.dp else 50.dp,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 0
            ),
            label = ""
        )
        Box(modifier = Modifier
            .padding(start = 50.dp)
            .background(ComposeTheme.colors.secondary)
            .size(size = size1)
        )

        val size2 by animateDpAsState(
            targetValue = if (status) 100.dp else 50.dp,
            animationSpec = tween(
                durationMillis = 2000,
                delayMillis = 0
            ),
            label = ""
        )
        Box(modifier = Modifier
            .padding(start = 170.dp)
            .background(ComposeTheme.colors.secondary)
            .size(size = size2)
        )

        val size3 by animateDpAsState(
            targetValue = if (status) 100.dp else 50.dp,
            animationSpec = tween(
                durationMillis = 2000,
                delayMillis = 1000,
                easing = LinearEasing
            ),
            label = ""
        )
        Box(modifier = Modifier
            .padding(start = 290.dp)
            .background(ComposeTheme.colors.secondary)
            .size(size = size3)
        )
    }
}

@Composable
fun KeyframesSpecView(){
    var status by remember {
        mutableStateOf(false)
    }
    val customSize by animateDpAsState(
        targetValue = if (status) 200.dp else 50.dp,
        animationSpec = keyframes {
            durationMillis = 5000
            50.dp at 0 with LinearEasing
            100.dp at 1000 with FastOutLinearInEasing
            150.dp at 4000 with LinearEasing
            200.dp at 5000
        },
        label = ""
    )
    Box(modifier = Modifier
        .background(ComposeTheme.colors.secondary)
        .size(customSize)
        .clickable {
            status = !status
        })
}

@Composable
fun SnapSpecView(){
    var status by remember {
        mutableStateOf(false)
    }
    val customSize by animateDpAsState(
        targetValue = if (status) 100.dp else 50.dp,
        animationSpec = snap() ,
        label = ""
    )
    Box(modifier = Modifier
        .background(ComposeTheme.colors.secondary)
        .size(customSize)
        .clickable {
            status = !status
        })
}

@Composable
fun RepeatableSpecView(){
    var status by remember {
        mutableStateOf(false)
    }
    val customSize by animateDpAsState(
        targetValue = if (status) 100.dp else 50.dp,
        animationSpec = repeatable(
            iterations = 5,
            animation = tween(500),
            repeatMode = RepeatMode.Reverse,
            initialStartOffset = StartOffset(1000)
        ) ,
        label = ""
    )
    Box(modifier = Modifier
        .background(ComposeTheme.colors.secondary)
        .size(customSize)
        .clickable {
            status = !status
        })
}

@Composable
@Preview(showSystemUi = true)
fun SpecPreview() {
    SpecScreen()
}