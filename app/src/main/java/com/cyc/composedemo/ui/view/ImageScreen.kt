package com.cyc.composedemo.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyc.composedemo.R
import com.cyc.composedemo.ui.theme.ComposeTheme
import com.cyc.composedemo.ui.theme.bamboo500

@Composable
fun ImageScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 4.dp, top = 20.dp, end = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .width(100.dp)
                .height(200.dp)
                .background(ComposeTheme.colors.disable),
            painter = painterResource(id = R.drawable.image),
            contentDescription =null ,
            contentScale = ContentScale.Fit,
            alignment = Alignment.TopCenter)

        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription =null ,
            modifier = Modifier
                .padding(vertical = 20.dp)
                .clip(RoundedCornerShape(40.dp)))

        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription =null ,
            modifier = Modifier
                .padding(vertical = 20.dp)
                .clip(CircleShape),
            colorFilter = ColorFilter.tint(bamboo500, blendMode = BlendMode.Color),
        )

        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription =null ,
            modifier = Modifier
                .padding(vertical = 20.dp)
                .clip(CircleShape)
                .border(
                    width = 5.dp,
                    color = ComposeTheme.colors.secondary,
                    shape = CircleShape
                ))

    }
}

@Composable
@Preview(showSystemUi = true)
fun ImagePreView() {
    ImageScreen()
}