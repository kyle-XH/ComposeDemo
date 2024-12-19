package com.cyc.composedemo.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cyc.composedemo.ui.theme.ComposeTheme


enum class LayoutScreenEntry {
    LayoutHome,
    Box,
    Row,
    Column,
    FlowLayout,
    Scaffold,
    Surface,
    Spacer,
    TopAppBar,
    BottomNavigation,
    Page,
    List
}

@Composable
fun LayoutScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = LayoutScreenEntry.LayoutHome.name,
        modifier = Modifier
            .fillMaxSize()
    )
    {
        composable(route = LayoutScreenEntry.LayoutHome.name) {
            LayoutHomeScreen(onClick = {
                navController.navigate(it)
            })
        }
        composable(route = LayoutScreenEntry.Box.name) {
            BoxScreen()
        }
        composable(route = LayoutScreenEntry.Row.name) {
            RowScreen()
        }
        composable(route = LayoutScreenEntry.Column.name) {
            ColumnScreen()
        }
        composable(route = LayoutScreenEntry.FlowLayout.name) {
            FlowScreen()
        }
        composable(route = LayoutScreenEntry.Scaffold.name) {
            ScaffoldScreen()
        }
        composable(route = LayoutScreenEntry.Surface.name) {
            SurfaceScreen()
        }
        composable(route = LayoutScreenEntry.Spacer.name) {
            SpacerScreen()
        }
        composable(route = LayoutScreenEntry.TopAppBar.name) {
            TopBarScreen()
        }
        composable(route = LayoutScreenEntry.BottomNavigation.name) {
            BottomNavigationScreen()
        }
        composable(route = LayoutScreenEntry.Page.name) {
            PageScreen()
        }
        composable(route = LayoutScreenEntry.List.name) {
            ListScreen()
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
                onClick(LayoutScreenEntry.Box.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Box")
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(LayoutScreenEntry.Row.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Row")
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(LayoutScreenEntry.Column.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Column")
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(LayoutScreenEntry.FlowLayout.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "FlowLayout")
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(LayoutScreenEntry.Surface.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Surface")
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(LayoutScreenEntry.Spacer.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Spacer")
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(LayoutScreenEntry.TopAppBar.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "TopAppBar")
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(LayoutScreenEntry.BottomNavigation.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "BottomNavigation")
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(LayoutScreenEntry.Page.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Page")
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(LayoutScreenEntry.Scaffold.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Scaffold")
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(LayoutScreenEntry.List.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "List")
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun LayoutPreView() {
    LayoutScreen()
}