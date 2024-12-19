package com.cyc.composedemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cyc.composedemo.data.ThemeState
import com.cyc.composedemo.ui.HomeScreen
import com.cyc.composedemo.ui.animation.AnimationScreen
import com.cyc.composedemo.ui.gesture.GestureScreen
import com.cyc.composedemo.ui.graphics.GraphicsScreen
import com.cyc.composedemo.ui.layout.LayoutScreen
import com.cyc.composedemo.ui.theme.ComposeTheme
import com.cyc.composedemo.ui.ThemeScreen
import com.cyc.composedemo.ui.view.ViewScreen

enum class ComposeScreen {
    Home,
    View,
    Layout,
    Animation,
    Theme,
    Gesture,
    Graphics
}

@Composable
fun ComposeDemoApp(
    themeState: ThemeState,
    onModeChange: (ThemeState.Mode) -> Unit,
    onColorPalletChange: (ThemeState.ColorPallet) -> Unit,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ComposeScreen.Home.name,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(ComposeTheme.colors.surface)
    )
    {
        composable(route = ComposeScreen.Home.name) {
            HomeScreen(onClick = {
                navController.navigate(it)
            })
        }
        composable(route = ComposeScreen.View.name) {
            ViewScreen()
        }
        composable(route = ComposeScreen.Layout.name) {
            LayoutScreen()
        }
        composable(route = ComposeScreen.Animation.name) {
            AnimationScreen()
        }
        composable(route = ComposeScreen.Theme.name) {
            ThemeScreen(
                themeState = themeState,
                onModeChange = onModeChange,
                onColorPalletChange = onColorPalletChange
            )
        }
        composable(route = ComposeScreen.Gesture.name) {
            GestureScreen()
        }
        composable(route = ComposeScreen.Graphics.name) {
            GraphicsScreen()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomePreview(){
    ComposeDemoApp(
        themeState = ThemeState(),
        onModeChange = {},
        onColorPalletChange = {}
    )
}