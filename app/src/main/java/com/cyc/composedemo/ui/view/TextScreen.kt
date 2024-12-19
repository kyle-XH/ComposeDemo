package com.cyc.composedemo.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyc.composedemo.ui.theme.ComposeTheme

@Composable
fun TextScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 4.dp, top = 20.dp, end = 5.dp)
    ) {
        Text(
            text = "Compose World",
            style = ComposeTheme.typography.displayLarge,
            color = ComposeTheme.colors.textPrimary
        )
        Text(
            text = "Compose World",
            style = ComposeTheme.typography.displayMedium,
            color = ComposeTheme.colors.textPrimary
        )
        Text(
            text = "Compose World",
            style = ComposeTheme.typography.displaySmall,
            color = ComposeTheme.colors.textPrimary
        )

        Divider(modifier = Modifier.padding(vertical = 20.dp))

        Text(
            text = "Compose World",
            fontSize = 30.sp,
            fontWeight = FontWeight.W700,
            letterSpacing = 5.sp,
            color = ComposeTheme.colors.textPrimary
        )
        Text(
            text = "Compose World",
            fontSize = 30.sp,
            fontWeight = FontWeight.W700,
            letterSpacing = 0.sp,
            color = ComposeTheme.colors.textPrimary
        )
        Text(
            text = "Compose World",
            fontSize = 30.sp,
            fontWeight = FontWeight.W700,
            letterSpacing = 0.sp,
            fontFamily = FontFamily.Serif,
            color = ComposeTheme.colors.textPrimary
        )

        Divider(modifier = Modifier.padding(vertical = 20.dp))

        Text(
            text = "Welcome Compose World !".repeat(3),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = ComposeTheme.colors.textPrimary
        )

        Divider(modifier = Modifier.padding(vertical = 20.dp))

        Text(
            text = "Compose World",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Left,
            color = ComposeTheme.colors.textPrimary
        )
        Text(
            text = "Compose World",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = ComposeTheme.colors.textPrimary
        )
        Text(
            text = "Compose World",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Right,
            color = ComposeTheme.colors.textPrimary
        )

        Divider(modifier = Modifier.padding(vertical = 20.dp))

        Text(
            text = "Welcome Compose World".repeat(5),
            lineHeight = 10.sp,
            color = ComposeTheme.colors.textPrimary
        )
        Text(
            text = "Welcome Compose World".repeat(5),
            lineHeight = 20.sp,
            color = ComposeTheme.colors.textPrimary
        )

        Divider(modifier = Modifier.padding(vertical = 20.dp))

        Text(
            text = buildAnnotatedString {
                append("Welcome Compose World !")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = ComposeTheme.colors.secondary,
                        shadow = Shadow(color = Color.Gray, blurRadius = 25f)
                    )
                ) {
                    append(" Jump ")
                }
            },
            color = ComposeTheme.colors.textPrimary
        )

    }
}

@Composable
@Preview(showSystemUi = true)
fun TextPreView() {
    TextScreen()
}