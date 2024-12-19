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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.twotone.AccountBox
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material.icons.twotone.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
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
import com.cyc.composedemo.ui.theme.bamboo500
import com.cyc.composedemo.ui.theme.bamboo500Alpha24
import com.cyc.composedemo.ui.theme.sunset500
import com.cyc.composedemo.ui.theme.sunset500Alpha24
import com.cyc.composedemo.ui.theme.volcano500
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationScreen(selectedItem : MutableState<Int> = remember {
    mutableIntStateOf(0)
}) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        val items = listOf("首页", "订单", "设置")
        BottomNavigation(
            backgroundColor = bamboo500Alpha24,
            modifier = Modifier.height(70.dp),
            elevation = 0.dp
        ) {
            items.forEachIndexed { index, item ->
                BottomNavigationItem(
                    selected = selectedItem.value == index,
                    onClick = { selectedItem.value = index },
                    icon = {
                        when (index) {
                            0 -> Icon(
                                Icons.Filled.Home,
                                contentDescription = null,
                                modifier = Modifier.padding(bottom = 10.dp)
                            )

                            1 -> Icon(
                                Icons.Filled.ShoppingCart,
                                contentDescription = null,
                                modifier = Modifier.padding(bottom = 10.dp)
                            )

                            else -> Icon(
                                Icons.Filled.Settings,
                                contentDescription = null,
                                modifier = Modifier.padding(bottom = 10.dp)
                            )
                        }
                    },
                    label = {
                        Text(text = item)
                    },
                )
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun BottomNavigationPreView() {
    BottomNavigationScreen()
}