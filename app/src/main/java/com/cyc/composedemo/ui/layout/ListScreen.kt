package com.cyc.composedemo.ui.layout

import android.text.TextPaint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState

import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextPainter
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyc.composedemo.R
import com.cyc.composedemo.ui.theme.ComposeTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

var refreshCount = 0

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListScreen() {
    val data = remember {
        mutableStateOf<List<String>>(emptyList())
    }
    data.value = refresh()
    val isRefreshing by remember {
        mutableStateOf(false)
    }
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val angle by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing)
        ), label = ""
    )

    val refreshState =
        rememberPullRefreshState(refreshing = isRefreshing, onRefresh = {
            data.value = refresh()
        })
    Box(
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 50.dp)
            .fillMaxSize()
            .height(400.dp)
            .pullRefresh(refreshState)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = ComposeTheme.colors.bgPrimary,
                    shape = RoundedCornerShape(24.dp)
                ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            data.value.forEach {
                item {
                    Card {
                        Text(
                            text = it,
                            style = ComposeTheme.typography.displayLarge,
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentSize(Alignment.Center),
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_loading),
                        contentDescription = "load more",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(30.dp, 30.dp)
                            .graphicsLayer { rotationZ = angle })
                }
                LaunchedEffect(data.value.size) {
                    loadMore(list = data)
                }
            }
        }
        PullRefreshIndicator(
            refreshing = isRefreshing,
            state = refreshState,
            modifier = Modifier.align(Alignment.TopCenter)
        )
        TextPainter
    }
}

private fun refresh(): List<String> {
    refreshCount++
    val text =
        "大江东去，浪淘尽，千古风流人物。故垒西边，人道是：三国周郎赤壁。乱石穿空，惊涛拍岸，卷起千堆雪。江山如画，一时多少豪杰。遥想公瑾当年，小乔初嫁了，雄姿英发。羽扇纶巾，谈笑间、樯橹灰飞烟灭。故国神游，多情应笑我，早生华发。人生如梦，一尊还酹江月。"
    return text.split("，", "。", "：").dropLast(1).toMutableList().apply {
        add(0, refreshCount.toString())
    }
}

private suspend fun loadMore(list: MutableState<List<String>>) = withContext(Dispatchers.IO) {
    delay(2000)
    val text =
        "大江东去，浪淘尽，千古风流人物。故垒西边，人道是：三国周郎赤壁。乱石穿空，惊涛拍岸，卷起千堆雪。江山如画，一时多少豪杰。"
    list.value = list.value.toMutableList().apply {
        addAll(text.split("，", "。", "：").dropLast(1))
    }
}

@Composable
@Preview(showSystemUi = true)
fun ListPreView() {
    ListScreen()
}