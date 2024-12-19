package com.cyc.composedemo.ui.animation

import android.graphics.drawable.AnimatedVectorDrawable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.VectorConverter
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cyc.composedemo.ui.theme.ComposeTheme
import com.cyc.composedemo.ui.theme.ComposeTheme.colors


enum class AnimationScreenEntry {
    HOME,
    LowApi,
    AnimationSpec,
    HeightApi,
}

@Composable
fun AnimationScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AnimationScreenEntry.HOME.name,
        modifier = Modifier
            .fillMaxSize()
    )
    {
        composable(route = AnimationScreenEntry.HOME.name) {
            LayoutHomeScreen(onClick = {
                navController.navigate(it)
            })
        }
        composable(route = AnimationScreenEntry.LowApi.name) {
            LowApiScreen()
        }
        composable(route = AnimationScreenEntry.AnimationSpec.name) {
            SpecScreen()
        }
        composable(route = AnimationScreenEntry.HeightApi.name) {
            HeightApiScreen()
        }
    }
}


@Composable
fun LayoutHomeScreen(
    onClick: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(AnimationScreenEntry.LowApi.name)
            },
            modifier = Modifier.width(250.dp)
        ) {
            Text(text = "低级别API")
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(AnimationScreenEntry.AnimationSpec.name)
            },
            modifier = Modifier.width(250.dp)
        ) {
            Text(text = "AnimationSpec 动画规格")
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(AnimationScreenEntry.HeightApi.name)
            },
            modifier = Modifier.width(250.dp)
        ) {
            Text(text = "高级版API")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AnimationPreview() {
    AnimationScreen()
}