package com.gsnipedev.netheve.ui.pages.register

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FirstRegisterForm(
    username: MutableState<String>,
    password: MutableState<String>,
    isPasswordShowing: MutableState<Boolean>,
    confirmationPassword: MutableState<String>,
    isConfirmationPasswordShowing: MutableState<Boolean>,
    state: ScrollState

)
{
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(20.dp)
    ) {
        CommonTextField(
            value = username, placeholder = "Username", icon = {
                Icon(
                    Icons.Default.Person,
                    contentDescription = "Person Icon for Account"
                )
            },
            state = state
        )
        PasswordTextField(
            value = password,
            placeholder = "Password",
            isShowing = isPasswordShowing,
            icon = { Icon(Icons.Default.Lock, contentDescription = "Password Lock Icon") }
        )
        PasswordTextField(
            value = confirmationPassword,
            placeholder = "Confirm Password",
            isShowing = isConfirmationPasswordShowing,
            icon = { Icon(Icons.Default.Lock, contentDescription = "Password Lock Icon") }
        )
    }
}