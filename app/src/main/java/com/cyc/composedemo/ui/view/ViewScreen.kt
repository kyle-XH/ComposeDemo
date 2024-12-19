package com.cyc.composedemo.ui.view

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
import com.cyc.composedemo.ui.theme.ComposeTheme


enum class ViewScreenEntry {
    ViewHome,
    Text,
    TextField,
    Button,
    Icon,
    Image,
    Card,
    Check,
    Dialog
}

@Composable
fun ViewScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ViewScreenEntry.ViewHome.name,
        modifier = Modifier
            .fillMaxSize()
    )
    {
        composable(route = ViewScreenEntry.ViewHome.name) {
            ViewHomeScreen(onClick = {
                navController.navigate(it)
            })
        }
        composable(route = ViewScreenEntry.Text.name) {
            TextScreen()
        }
        composable(route = ViewScreenEntry.TextField.name) {
            TextFieldScreen()
        }
        composable(route = ViewScreenEntry.Button.name) {
            ButtonScreen()
        }
        composable(route = ViewScreenEntry.Icon.name) {
            IconScreen()
        }
        composable(route = ViewScreenEntry.Image.name) {
            ImageScreen()
        }
        composable(route = ViewScreenEntry.Card.name) {
            CardScreen()
        }
        composable(route = ViewScreenEntry.Check.name) {
            CheckScreen()
        }
        composable(route = ViewScreenEntry.Dialog.name) {
            DialogScreen()
        }
    }
}

@Composable
fun ViewHomeScreen(
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
                onClick(ViewScreenEntry.Text.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Text")
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(ViewScreenEntry.TextField.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "TextField")
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(ViewScreenEntry.Button.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Button")
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(ViewScreenEntry.Icon.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Icon")
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(ViewScreenEntry.Image.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Image")
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(ViewScreenEntry.Card.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Card")
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(ViewScreenEntry.Check.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Check")
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = ComposeTheme.colors.primary
            ),
            onClick = {
                onClick(ViewScreenEntry.Dialog.name)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Dialog")
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ViewPreView() {
    ViewScreen()
}