package com.cyc.composedemo.ui.layout

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyc.composedemo.ui.theme.ComposeTheme
import com.cyc.composedemo.ui.theme.sunset500
import com.cyc.composedemo.ui.theme.sunset500Alpha24
import com.cyc.composedemo.ui.theme.sunset500Alpha8
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun PageScreen() {
    val pageList = listOf("Android", "Compose", "Flutter", "IOS")
    val pageState = rememberPagerState {
        pageList.size
    }
    val scope = rememberCoroutineScope()
    Column(
        Modifier
            .padding(top = 20.dp)
            .fillMaxSize()
    ) {
        TabRow(
            selectedTabIndex = pageState.currentPage,
            modifier = Modifier.fillMaxWidth(),
            indicator = {
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(
                        it[pageState.currentPage]
                    )
                )
            }
        ) {
            pageList.forEachIndexed { index, item ->
                Tab(
                    text = { Text(item, style = ComposeTheme.typography.titleSmall) },
                    selected = pageState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pageState.animateScrollToPage(index)
                        }
                    },
                )
            }
        }

        HorizontalPager(
            contentPadding = PaddingValues(30.dp),
            state = pageState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            pageSpacing = 10.dp
        ) {
            Box(modifier =
                Modifier.fillMaxSize()
                .background(sunset500Alpha24)){
                Text(
                    text = "Page $it",
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

@Composable
@Preview(showSystemUi = true)
fun PagePreView() {
    PageScreen()
}