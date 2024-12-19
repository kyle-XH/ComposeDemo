package com.cyc.composedemo.ui.animation

import androidx.compose.animation.Animatable
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.cyc.composedemo.ui.theme.ComposeTheme

@Composable
fun LowApiScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .background(ComposeTheme.colors.surface)
    ) {

        Spacer(modifier = Modifier.height(100.dp))

        AsStateView()

        Divider(modifier = Modifier.padding(vertical = 20.dp))

        AnimatableView()

        Divider(modifier = Modifier.padding(vertical = 20.dp))

        UpdateTransitionView()

        Divider(modifier = Modifier.padding(vertical = 20.dp))

        InfiniteTransitionView()

        Divider(modifier = Modifier.padding(vertical = 20.dp))
    }
}


@Composable
fun AsStateView() {
    var change by remember {
        mutableStateOf(false)
    }

    val iconSize by animateDpAsState(
        targetValue = if (change) 80.dp else 40.dp, label = ""
    )
    val iconColor by animateColorAsState(
        targetValue = if (change)
            ComposeTheme.colors.secondary
        else
            ComposeTheme.colors.tertiary,
        label = "iconColor"
    )
    Icon(
        imageVector = Icons.Filled.LocationOn,
        contentDescription = "",
        tint = iconColor,
        modifier = Modifier
            .size(iconSize)
            .clickable {
                change = !change
            }
    )
}

@Composable
fun AnimatableView() {
    var change by remember {
        mutableStateOf(false)
    }

    val iconSize = remember {
        Animatable(
            initialValue = 40.dp,
            typeConverter = Dp.VectorConverter
        )
    }
    val colorNegative = ComposeTheme.colors.tertiary
    val colorPosition = ComposeTheme.colors.secondary
    val iconColor2 = remember {
        Animatable(colorNegative)
    }
    LaunchedEffect(change) {
        iconSize.animateTo(
            if (change) 80.dp else 40.dp
        )
    }
    LaunchedEffect(change) {
        iconColor2.animateTo(
            if (change) colorPosition else colorNegative
        )
    }

    Icon(
        imageVector = Icons.Filled.LocationOn,
        contentDescription = "",
        tint = iconColor2.value,
        modifier = Modifier
            .size(iconSize.value)
            .clickable {
                change = !change
            }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UpdateTransitionView() {
    var localState: SwitchState by remember {
        mutableStateOf(SwitchState.START)
    }
    val transient = updateTransition(
        targetState = localState,
        label = null
    )
    val iconSize3 by transient.animateDp(
        transitionSpec = { tween(1000) }, label = ""
    ) {
        when (it) {
            SwitchState.START -> 40.dp
            SwitchState.END -> 80.dp
        }
    }
    val iconColor3 by transient.animateColor(
        transitionSpec = { tween(1000) }, label = ""
    ) {
        when (it) {
            SwitchState.START -> ComposeTheme.colors.tertiary
            SwitchState.END -> ComposeTheme.colors.secondary
        }
    }
    Icon(
        imageVector = Icons.Filled.LocationOn,
        contentDescription = "",
        tint = iconColor3,
        modifier = Modifier
            .size(iconSize3)
            .clickable {
                localState = if (localState == SwitchState.START) {
                    SwitchState.END
                } else {
                    SwitchState.START
                }
            }
    )
}

@Composable
fun InfiniteTransitionView() {
    val transient = rememberInfiniteTransition(
        label = "infiniteTransition"
    )
    val iconSize by transient.animateValue(
        initialValue = 40.dp,
        targetValue = 80.dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(2000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "",
    )
    val iconColor by transient.animateColor(
        initialValue = ComposeTheme.colors.tertiary,
        targetValue = ComposeTheme.colors.secondary,
        animationSpec = infiniteRepeatable(
            animation = tween(2000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "")
    Box(modifier = Modifier
        .height(100.dp)
        .fillMaxWidth(),
        contentAlignment = Alignment.Center){
        Icon(
            imageVector = Icons.Filled.LocationOn,
            contentDescription = "",
            tint = iconColor,
            modifier = Modifier
                .size(iconSize)
        )
    }
}


sealed class SwitchState {
    object START : SwitchState()
    object END : SwitchState()
}

@Composable
@Preview(showSystemUi = true)
fun LowApiPreview(){
    LowApiScreen()
}