package com.cyc.composedemo.ui.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyc.composedemo.ui.theme.ComposeTheme
import com.cyc.composedemo.ui.theme.sunset500
import com.cyc.composedemo.ui.theme.sunset500Alpha24

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarScreen() {
    Box(
        contentAlignment = Alignment.Center
    ) {
        TopAppBar(
            title = {
                Text(text = "Title")
            },
            navigationIcon = {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "",
                    modifier = Modifier.padding(horizontal = 16.dp),
                )
            },
            actions = {
                Icon(
                    Icons.Filled.Settings,
                    contentDescription = "",
                    modifier = Modifier.padding(horizontal = 16.dp),
                )
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = "",
                    modifier = Modifier.padding(horizontal = 16.dp),
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = sunset500Alpha24,
                navigationIconContentColor = sunset500,
                titleContentColor = ComposeTheme.colors.textPrimary,
                actionIconContentColor = ComposeTheme.colors.secondary
            ),
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun TopBarPreView() {
    TopBarScreen()
}