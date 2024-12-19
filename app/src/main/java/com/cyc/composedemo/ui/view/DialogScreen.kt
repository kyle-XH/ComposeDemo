package com.cyc.composedemo.ui.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.cyc.composedemo.R
import com.cyc.composedemo.ui.theme.ComposeTheme
import com.cyc.composedemo.ui.theme.bamboo500Alpha24
import com.cyc.composedemo.ui.theme.sunset500
import com.cyc.composedemo.ui.theme.white
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DialogScreen() {
    val scaffoldState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
//    val bottomSheetState = scaffoldState.bottomSheetState
    val coroutineScope = rememberCoroutineScope()
    Box (
        Modifier.height(300.dp)
    ){
        ModalBottomSheetLayout(
            modifier = Modifier.fillMaxSize(),
            sheetState = scaffoldState,
            sheetContent = {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .background(bamboo500Alpha24)
                    .height(300.dp),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "Bottom Sheet", style = ComposeTheme.typography.displayLarge)
                }
            },
            sheetShape = RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp),
        )
        {
            BackHandler(scaffoldState.isVisible) {
                coroutineScope.launch {
                    scaffoldState.hide()
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val dialogState = remember {
                    mutableStateOf(false)
                }
                Button(onClick = {
                    dialogState.value = true
                }) {
                    Text(text = "Show Dialog")
                }
                Button(onClick = {
                    coroutineScope.launch {
                        scaffoldState.show()
                    }
                }) {
                    Text(text = "Show Bottom Sheet")
                }
                if (dialogState.value) {
                    ConfirmCenterDialog(
                        dialogState,
                        title = "title",
                        content = "content",
                        negative = "cancel",
                        position = "confirm",
                        onNegativeClick = {
                            dialogState.value = false
                        },
                        onPositionClick = {
                            dialogState.value = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ConfirmCenterDialog(
    dialogState: MutableState<Boolean>,
    title: String? = null,
    content: String,
    negative: String,
    position: String,
    onNegativeClick: (() -> Unit)? = null,
    onPositionClick: (() -> Unit)? = null,
    onDismiss: (() -> Unit)? = null
) {
    Dialog(
        onDismissRequest = {
            dialogState.value = false
            onDismiss?.invoke()
        },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            securePolicy = SecureFlagPolicy.SecureOff
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = ComposeTheme.colors.bgPrimary,
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_account),
                contentDescription = "dialog icon",
                tint = sunset500,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            if (!title.isNullOrEmpty()) {
                Text(
                    text = title,
                    color = ComposeTheme.colors.textPrimary,
                    style = ComposeTheme.typography.titleMedium
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                text = content,
                color = ComposeTheme.colors.textSecondary,
                style = ComposeTheme.typography.bodySmall
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {
                val color = ComposeTheme.colors.textQuaternary
                Button(
                    onClick = {
                        onNegativeClick?.invoke()
                    },
                    border = BorderStroke(
                        1.dp, SolidColor(color)
                    ),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .height(40.dp)
                        .padding(end = 16.dp)
                ) {
                    Text(
                        text = negative,
                        color = ComposeTheme.colors.textSecondary
                    )
                }

                Button(
                    onClick = {
                        onPositionClick?.invoke()
                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ComposeTheme.colors.secondary,
                        disabledContainerColor = ComposeTheme.colors.disable,
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .height(40.dp)
                ) {
                    Text(
                        text = position,
                        color = white
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun DialogPreView() {
    DialogScreen()
}