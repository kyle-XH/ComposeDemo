package com.cyc.composedemo.ui.layout

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.AccountBox
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material.icons.twotone.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyc.composedemo.ui.theme.ComposeTheme
import kotlin.math.roundToInt

@Composable
fun ColumnScreen() {
    Box(){
        Row(
            modifier = Modifier
                .matchParentSize()
                .padding(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(ComposeTheme.colors.disable)
                    .weight(1f),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.Start
            ) {
                Icon(
                    Icons.TwoTone.AccountBox,
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
                Icon(
                    Icons.TwoTone.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
                Icon(
                    Icons.TwoTone.AddCircle,
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
            }

            Spacer(modifier = Modifier.width(30.dp))

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(ComposeTheme.colors.disable)
                    .weight(1f),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    Icons.TwoTone.AccountBox,
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
                Icon(
                    Icons.TwoTone.AccountCircle,
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
                Icon(
                    Icons.TwoTone.AddCircle,
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ColumnPreView() {
    ColumnScreen()
}