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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Snackbar
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.twotone.AccountBox
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material.icons.twotone.AddCircle
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyc.composedemo.ui.theme.ComposeTheme
import com.cyc.composedemo.ui.theme.bamboo400
import com.cyc.composedemo.ui.theme.bamboo500Alpha24
import kotlin.math.roundToInt
import androidx.compose.material3.SnackbarHostState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldScreen() {
    val selectItem = remember {
        mutableIntStateOf(0)
    }
    val snackBarHostState =  remember {
        SnackbarHostState()
    }
    val coroutineScope = rememberCoroutineScope()
    Box {
        Scaffold (
            modifier = Modifier.matchParentSize(),
            topBar ={
                TopBarScreen()
            },
            bottomBar = {
                BottomNavigationScreen(selectItem)
            },
            floatingActionButton = {
                IconButton(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(bamboo400),
                    onClick = {
                        coroutineScope.launch {
                            snackBarHostState.showSnackbar(message = "show snack bar")
                        }
                    }
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "")
                }
            },
            floatingActionButtonPosition = FabPosition.Center,
            snackbarHost = {
                SnackbarHost(snackBarHostState) {
                    Snackbar (
                        modifier = Modifier.padding(horizontal = 30.dp)
                    ){
                        Text(text = it.visuals.message)
                    }
                }
            }
        ){
            Surface(Modifier.padding(it)) {
                when(selectItem.intValue){
                    0 ->   PageScreen()
                    1 , 2 -> {
                        Text(
                            text = "Screen ${selectItem.intValue}",
                            style = ComposeTheme.typography.displayLarge,
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentSize(Alignment.Center),
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ScaffoldPreView() {
    ScaffoldScreen()
}