package com.cyc.composedemo.ui.gesture

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cyc.composedemo.ui.layout.BoxScreen
import com.cyc.composedemo.ui.layout.ColumnScreen
import com.cyc.composedemo.ui.layout.FlowScreen
import com.cyc.composedemo.ui.layout.RowScreen
import com.cyc.composedemo.ui.layout.ScaffoldScreen
import com.cyc.composedemo.ui.layout.SpacerScreen
import com.cyc.composedemo.ui.layout.SurfaceScreen
import com.cyc.composedemo.ui.theme.ComposeTheme


enum class GestureScreenEntry {
    GestureHome,
    Clickable,
    Draggable,
    Swipeable,
    Transformer,
    Scrollable,
}

@Composable
fun GestureScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = GestureScreenEntry.GestureHome.name,
        modifier = Modifier
            .fillMaxSize()
    )
    {
        composable(route = GestureScreenEntry.GestureHome.name) {
            GestureHomeScreen(onClick = {
                navController.navigate(it)
            })
        }
        composable(route = GestureScreenEntry.Clickable.name) {
            ClickableScreen()
        }
        composable(route = GestureScreenEntry.Draggable.name) {
            DraggableScreen()
        }
        composable(route = GestureScreenEntry.Swipeable.name) {
            SwipeableScreen()
        }
        composable(route = GestureScreenEntry.Transformer.name) {
            TransformerScreen()
        }
        composable(route = GestureScreenEntry.Scrollable.name) {
            ScrollableScreen()
        }
    }
}

@Composable
fun GestureHomeScreen(
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
                onClick(GestureScreenEntry.Clickable.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Clickable")
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(GestureScreenEntry.Draggable.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Draggable")
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(GestureScreenEntry.Swipeable.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Swipeable")
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(GestureScreenEntry.Transformer.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Transformer")
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(GestureScreenEntry.Scrollable.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Scrollable")
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun GesturePreView() {
    GestureScreen()
}