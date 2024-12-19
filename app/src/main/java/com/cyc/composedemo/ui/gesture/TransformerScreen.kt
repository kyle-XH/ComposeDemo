package com.cyc.composedemo.ui.gesture

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.cyc.composedemo.ui.theme.ComposeTheme
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TransformerScreen() {
    val boxSizeWidth = 150.dp
    var offset by remember {
        mutableStateOf(Offset.Zero)
    }
    var rotationAngle by remember {
        mutableFloatStateOf(0f)
    }
    var scale by remember {
        mutableFloatStateOf(1f)
    }
    
    var transformableState = rememberTransformableState{ zoomChange, panChange, rotationChange ->
        scale *= zoomChange
        offset += panChange
        rotationAngle += rotationChange
    }
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Box(
            modifier = Modifier
                .size(boxSizeWidth)
                .rotate(rotationAngle)
                .offset {
                    IntOffset(offset.x.roundToInt(),offset.y.roundToInt())
                }
                .scale(scale)
                .background(ComposeTheme.colors.secondary)
                .transformable(
                    state = transformableState,
                    lockRotationOnZoomPan = false
                )
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun TransformerPreview() {
    TransformerScreen()
}

