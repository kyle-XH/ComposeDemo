package com.cyc.composedemo.ui.gesture

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyc.composedemo.ui.theme.ComposeTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ClickableScreen() {
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val count = remember {
            mutableIntStateOf(0)
        }
        Box(
            modifier = Modifier
                .padding(top = 200.dp)
                .size(200.dp, 100.dp)
                .background(ComposeTheme.colors.secondary)
                .clickable {
                    count.intValue = count.intValue + 1
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "点击  ${count.intValue}",
                color = ComposeTheme.colors.textPrimary
            )
        }

        Spacer(modifier = Modifier.height(100.dp))

        val type = remember {
            mutableIntStateOf(0)
        }
        Box(
            modifier = Modifier
                .size(200.dp, 100.dp)
                .background(ComposeTheme.colors.secondary)
                .combinedClickable(
                    onClick = {
                        type.intValue = 1
                    },
                    onDoubleClick = {
                        type.intValue = 2
                    },
                    onLongClick = {
                        type.intValue = 3
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = when (type.intValue) {
                    1 -> "单击"
                    2 -> "双击"
                    3 -> "长按"
                    else -> "点击"
                },
                color = ComposeTheme.colors.textPrimary
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ClickablePreview() {
    ClickableScreen()
}

