package com.cyc.composedemo.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyc.composedemo.ui.theme.ComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 4.dp, top = 20.dp, end = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var text by remember {
            mutableStateOf("")
        }
        var passwordHide by remember { mutableStateOf(true) }
        TextField(
            value = text,
            onValueChange = {
                text = it
            }
        )
        Divider(modifier = Modifier.padding(vertical = 20.dp))

        OutlinedTextField(value = text, onValueChange = {
            text = it
        })

        Divider(modifier = Modifier.padding(vertical = 20.dp))

        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            singleLine = true
        )
        Divider(modifier = Modifier.padding(vertical = 20.dp))

        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = {
                Text(text = "Phone")
            },
            placeholder = {
                Text(text = "请输入")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Call, contentDescription = "")
            },
            isError = true
        )
        Divider(modifier = Modifier.padding(vertical = 20.dp))

        TextField(
            value = text,
            singleLine = true,
            onValueChange = {
                text = it
            },
            leadingIcon = {
                Text(text = "密码:", modifier = Modifier.padding(start = 16.dp))
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        passwordHide = !passwordHide
                    })
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = ComposeTheme.colors.textPrimary,
                containerColor = ComposeTheme.colors.input,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .height(60.dp),
            visualTransformation = if (passwordHide) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            }
        )

        Divider(modifier = Modifier.padding(vertical = 20.dp))


        BasicTextField(
            singleLine = true,
            value = text,
            onValueChange = {
                text = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(horizontal = 24.dp)
                .background(color = ComposeTheme.colors.input, shape = RoundedCornerShape(24.dp))
                .padding(horizontal = 16.dp),
            visualTransformation = if (passwordHide) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
        ) { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "")
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    innerTextField()
                }
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        passwordHide = !passwordHide
                    })
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun TextFieldPreView() {
    TextFieldScreen()
}