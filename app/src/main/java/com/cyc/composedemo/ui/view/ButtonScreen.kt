package com.cyc.composedemo.ui.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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

@Composable
fun ButtonScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 4.dp, top = 20.dp, end = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val interactionSource = remember {
            MutableInteractionSource()
        }
        val pressState = interactionSource.collectIsPressedAsState()
        val draggedState = interactionSource.collectIsDraggedAsState()

        val (text, color) = when {
            draggedState.value -> {
                "Dragged " to ComposeTheme.colors.tertiary
            }
            pressState.value -> {
                "Pressed " to ComposeTheme.colors.disable
            }
            else -> "No Drag No press" to ComposeTheme.colors.bgPrimary
        }

        var offsetY by remember {
            mutableFloatStateOf(0f)
        }
        val lengthDp = 50.dp
        val lengthPx = with(LocalDensity.current) {
            lengthDp.toPx() * 3
        }
        val draggableState = rememberDraggableState {
            offsetY = (offsetY + it).coerceIn(-lengthPx, lengthPx)
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.secondary,
                contentColor = ComposeTheme.colors.bgPrimary
            ),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(2.dp, color = color),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 20.dp,
                pressedElevation = 20.dp,
                focusedElevation = 30.dp,
                disabledElevation = 30.dp
            ),
            interactionSource = interactionSource,
            modifier = Modifier
                .offset {
                    IntOffset(0, offsetY.roundToInt())
                }
                .draggable(
                    state = draggableState,
                    orientation = Orientation.Vertical,
                    interactionSource = interactionSource
                )
        ) {
            Text(text = text)
        }

        Spacer(modifier = Modifier.height(100.dp))

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                Icons.Filled.Check,
                modifier = Modifier.size(60.dp),
                contentDescription = "")
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ButtonPreView() {
    ButtonScreen()
}