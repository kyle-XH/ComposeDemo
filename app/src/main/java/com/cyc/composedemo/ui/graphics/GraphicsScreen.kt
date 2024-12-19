package com.cyc.composedemo.ui.graphics

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyc.composedemo.ui.theme.ComposeTheme
import com.cyc.composedemo.ui.theme.sunset500

@Composable
fun GraphicsScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            contentAlignment = Alignment.Center
        ) {
            val radius = 200.dp
            val ringWidth = 30.dp
            val positionColor = ComposeTheme.colors.secondary
            val negativeColor = ComposeTheme.colors.tertiary
            Canvas(modifier = Modifier.size(radius)) {
                this.drawCircle(
                    brush = Brush.sweepGradient(
                        colors = listOf(positionColor, negativeColor, positionColor),
                        Offset(radius.toPx() / 2f, radius.toPx() / 2f),
                    ),
                    radius = radius.toPx() / 2,
                    style = Stroke(
                        width = ringWidth.toPx()
                    )
                )
            }
        }

        Divider(modifier = Modifier.padding(vertical = 40.dp))

        val color = ComposeTheme.colors.error
        val color2 = ComposeTheme.colors.secondary
        Card(
            modifier = Modifier
                .size(100.dp)
                .drawWithContent {
                    drawCircle(color, 18.dp.toPx() / 2, center = Offset(0f, 0f))
                    drawContent()
                    drawCircle(color2, 18.dp.toPx() / 2, center = Offset(drawContext.size.width, 0f))
                }
        ) {
            Image(
                imageVector = Icons.Filled.AccountBox,
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )
        }

        Divider(modifier = Modifier.padding(vertical = 40.dp))

        Card(
            modifier = Modifier
                .size(100.dp)
                .drawBehind {
                    drawCircle(color, 18.dp.toPx() / 2, center = Offset(drawContext.size.width, 0f))
                }
        ) {
            Image(
                imageVector = Icons.Filled.AccountBox,
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )
        }

        Divider(modifier = Modifier.padding(vertical = 40.dp))

        var borderColor by remember {
            mutableStateOf(color)
        }
        Card(
            modifier = Modifier
                .size(100.dp)
                .drawWithCache {
                    val path = Path().apply {
                        moveTo(0f, 0f)
                        relativeLineTo(100.dp.toPx(), 0f)
                        relativeLineTo(0f, 100.dp.toPx())
                        relativeLineTo(-100.dp.toPx(), 0f)
                        relativeLineTo(0f, -100.dp.toPx())
                    }
                    Log.d("GraphicsScreen","path create , 此处不会发生 Recompose")
                    onDrawWithContent {
                        Log.d("GraphicsScreen","drawContent , 此处会发生 Recompose")
                        drawContent()
                        drawPath(
                            path = path,
                            color = borderColor,
                            style = Stroke(width = 10f)
                        )
                    }
                }
        ) {
            Image(
                imageVector = Icons.Filled.AccountBox,
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = {
            Log.d("GraphicsScreen","button click")
            borderColor = if (borderColor == color){
                sunset500
            }else{
                color
            }
        }) {
            Text(text = "color change")
        }

        Spacer(modifier = Modifier.height(100.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun GraphicsPreview() {
    GraphicsScreen()
}