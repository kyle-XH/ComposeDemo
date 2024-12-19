package com.cyc.composedemo.ui.gesture

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.cyc.composedemo.ui.theme.ComposeTheme
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DraggableScreen() {
    var offsetX by remember {
        mutableFloatStateOf(0f)
    }
    val boxSizeWidth = 50.dp
    val boxSizeWidthPx = with(LocalDensity.current) {
        boxSizeWidth.toPx()
    }
    val draggableState = rememberDraggableState {
        offsetX = (offsetX + it).coerceIn(0f, 3 * boxSizeWidthPx)
    }
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Box(
            modifier = Modifier
                .width(boxSizeWidth * 4)
                .height(boxSizeWidth)
                .align(Alignment.Center)
                .background(ComposeTheme.colors.dividerBlock)
        ) {
            Box(
                modifier = Modifier
                    .size(boxSizeWidth)
                    .offset {
                        IntOffset(offsetX.roundToInt(), 0)
                    }
                    .draggable(
                        state = draggableState,
                        orientation = Orientation.Horizontal
                    )
                    .background(ComposeTheme.colors.secondary)
            )

        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun DraggablePreview() {
    DraggableScreen()
}

