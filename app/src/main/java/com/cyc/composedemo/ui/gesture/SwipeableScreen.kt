package com.cyc.composedemo.ui.gesture

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.cyc.composedemo.ui.theme.ComposeTheme
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun SwipeableScreen() {
    val boxSizeWidth = 100.dp
    val boxSizeWidthPx = with(LocalDensity.current) {
        boxSizeWidth.toPx()
    }
    var swipeStatus = rememberSwipeableState(initialValue = 0)
    val anchors = mapOf(0f to 0, boxSizeWidthPx * 2 to 1)

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .width(boxSizeWidth * 3)
                .align(Alignment.Center)
                .swipeable(
                    state = swipeStatus,
                    anchors = anchors,
                    thresholds = { from, to ->
                        if (from == 0) {
                            FractionalThreshold(0.3f)
                        } else {
                            FractionalThreshold(0.6f)
                        }
                    },
                    orientation = Orientation.Horizontal
                )
                .background(ComposeTheme.colors.dividerBlock)
        ) {
            Box(
                modifier = Modifier
                    .offset {
                        IntOffset(swipeStatus.offset.value.toInt(), 0)
                    }
                    .size(boxSizeWidth)
                    .background(ComposeTheme.colors.secondary)
            )

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SwipeableSample() {
    val width = 300.dp
    val squareSize = 100.dp

    val swipeableState = rememberSwipeableState(0)
    val sizePx = with(LocalDensity.current) { squareSize.toPx() }
    val anchors = mapOf(0f to 0, sizePx * 2 to 1) // Maps anchor points (in px) to states

    Box(
        modifier = Modifier
            .width(width)
            .swipeable(
                state = swipeableState,
                anchors = anchors,
                thresholds = { _, _ -> FractionalThreshold(0.3f) },
                orientation = Orientation.Horizontal
            )
            .background(Color.LightGray)
    ) {
        Box(
            Modifier
                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                .size(squareSize)
                .background(Color.DarkGray)
        )
    }
}


enum class SwipeableStatus {
    CLOSE, OPEN
}

@Composable
@Preview(showSystemUi = true)
fun SwipeablePreview() {
    SwipeableScreen()
}

