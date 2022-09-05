package com.gsnipedev.netheve.ui.pages.register

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.gsnipedev.netheve.R

@Composable
fun PasswordTextField(
    value: MutableState<String>,
    placeholder: String,
    icon: @Composable (() -> Unit)? = null,
    isShowing: MutableState<Boolean>,
)
{
    val visibilityIconState = mapOf(
        true to R.drawable.outline_visibility_24,
        false to R.drawable.outline_visibility_off_24,
    )
    TextField(
        value = value.value, onValueChange = { value.value = it },
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = if (isShowing.value) PasswordVisualTransformation() else VisualTransformation.None,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.secondary,
            textColor = Color.Black,
            focusedIndicatorColor = MaterialTheme.colors.primary,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(10.dp),
        leadingIcon = icon,
        trailingIcon = {
            IconButton(onClick = {
                isShowing.value = !isShowing.value
            }) {
                Icon(
                    painterResource(visibilityIconState[isShowing.value]!!),
                    contentDescription = "Show Password Visibility"
                )
            }
        },
        placeholder = {
            Text(text = placeholder)
        },
    )
}