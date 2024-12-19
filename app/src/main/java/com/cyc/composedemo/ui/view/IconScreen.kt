package com.cyc.composedemo.ui.view

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.twotone.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyc.composedemo.R
import com.cyc.composedemo.ui.theme.ComposeTheme
import kotlin.math.roundToInt

@Composable
fun IconScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 4.dp, top = 20.dp, end = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "",
            tint = Color.Unspecified
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            // tint = Color.Unspecified
        )
        Icon(
            bitmap = ImageBitmap.imageResource(id = R.drawable.ic_account),
            contentDescription = null,
           // tint = Color.Unspecified
        )

        Divider(modifier = Modifier.padding(vertical = 20.dp))
        Icon(
            imageVector = Icons.Filled.CheckCircle,
            contentDescription = null,
            tint = ComposeTheme.colors.primary,
            modifier = Modifier
                .padding(vertical = 20.dp)
                .size(50.dp, 50.dp)
        )
        Icon(
            imageVector = Icons.Outlined.CheckCircle,
            contentDescription = null,
            tint = ComposeTheme.colors.primary,
            modifier = Modifier
                .padding(vertical = 20.dp)
                .size(50.dp, 50.dp)
        )
        Icon(
            imageVector = Icons.Rounded.CheckCircle,
            contentDescription = null,
            tint = ComposeTheme.colors.primary,
            modifier = Modifier
                .padding(vertical = 20.dp)
                .size(50.dp, 50.dp)
        )
        Icon(
            imageVector = Icons.TwoTone.CheckCircle,
            contentDescription = null,
            tint = ComposeTheme.colors.primary,
            modifier = Modifier
                .padding(vertical = 20.dp)
                .size(50.dp, 50.dp)
        )

    }
}

@Composable
@Preview(showSystemUi = true)
fun IconPreView() {
    IconScreen()
}