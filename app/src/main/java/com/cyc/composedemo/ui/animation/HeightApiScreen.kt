package com.cyc.composedemo.ui.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyc.composedemo.ui.theme.ComposeTheme

@Composable
fun HeightApiScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .background(ComposeTheme.colors.surface)
    )
    {
        Spacer(modifier = Modifier.height(50.dp))

        AnimationVisibilityView()

        AnimationContentView()

        CrossfadeView()

        Spacer(modifier = Modifier.height(50.dp))

        AnimateContentSizeView()
    }
}


@Composable
fun AnimationVisibilityView() {
    var state by remember {
        mutableStateOf(true)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        contentAlignment = Alignment.Center
    )
    {
        //fade： 淡入淡出动画
        //slide：滑动入场、出场动画
        //changeSize：改变尺寸大小的入场、出场动画
        //scale：缩放方式的入场、出场动画
        AnimatedVisibility(
            visible = state,
            exit = fadeOut(
                animationSpec = tween(1000),
                targetAlpha = 0.3f
            ),
            enter = slideInVertically(
                initialOffsetY = { -100 },
                animationSpec = tween(durationMillis = 2000)
            ) + fadeIn(
                animationSpec = tween(2000),
                initialAlpha = 0.0f
            ),
        ) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 50.dp)
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(ComposeTheme.colors.secondary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "AnimatedVisibility",
                    style = ComposeTheme.typography.displayMedium
                )
            }
        }
    }
    Button(onClick = {
        state = !state
    }) {
        Text(text = if (state) "隐藏" else "显示")
    }
}

@Composable
fun AnimationContentView() {
    var state by remember {
        mutableStateOf(true)
    }
    Box(
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxWidth()
            .height(100.dp),
        contentAlignment = Alignment.Center
    )
    {
        AnimatedContent(
            targetState = state, label = ""
        ) {
            if(it){
                Box(
                    modifier = Modifier
                        .padding(horizontal = 50.dp)
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(ComposeTheme.colors.secondary),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "AnimatedContent",
                        style = ComposeTheme.typography.displayMedium
                    )
                }
            }else{
                Icon(Icons.Filled.Face, contentDescription = "")
            }
        }
    }
    Button(onClick = {
        state = !state
    }) {
        Text(text =  "切换")
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AnimateContentSizeView() {
    var text by remember {
        mutableStateOf("AnimateContentSize")
    }
    Text(
        text = text,
        modifier = Modifier
            .combinedClickable(
                onClick = {
                    text += text
                },
                onLongClick = {
                    text = "AnimateContentSize"
                }
            )
            .animateContentSize()
    )
}

@Composable
fun CrossfadeView() {
    var flag by remember {
        mutableStateOf(false)
    }
    Column (Modifier.padding(top = 50.dp)){
        Crossfade(
            targetState = flag,
            animationSpec = tween(2000),
            label = "sjdisji"
        ) {
            when (it) {
                false -> {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .background(
                                ComposeTheme.colors.secondary,
                                shape = RoundedCornerShape(24.dp)
                            )
                    )
                }

                true -> {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .background(
                                ComposeTheme.colors.tertiary,
                                shape = AbsoluteCutCornerShape(30.dp)
                            )
                    )
                }
            }
        }
        Button(onClick = {
            flag = !flag
        }) {
            Text(text = "flag change")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HeightApiPreview() {
    HeightApiScreen()
}