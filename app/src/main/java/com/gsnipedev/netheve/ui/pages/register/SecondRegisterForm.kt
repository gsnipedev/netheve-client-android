package com.gsnipedev.netheve.ui.pages.register

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun SecondRegisterForm(
    email: MutableState<String>,
    firstname: MutableState<String>,
    lastname: MutableState<String>,
    state: ScrollState
)
{
    val currDensity = LocalDensity.current
    AnimatedVisibility(
        visible = true,
        enter = slideInHorizontally {
            with(currDensity) { -40.dp.roundToPx() }
        }
    )
    {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(20.dp)
        ) {
            CommonTextField(
                value = email,
                placeholder = "Email Address",
                icon = {
                    Icon(Icons.Default.Email, contentDescription = "Email Icon")
                },
                state = state
            )
            CommonTextField(
                value = firstname,
                placeholder = "Firstname",
                icon = {
                    Icon(Icons.Default.Person, contentDescription = "Email Icon")
                },
                state = state
            )
            CommonTextField(
                value = lastname,
                placeholder = "Lastname",
                icon = {
                    Icon(Icons.Default.Person, contentDescription = "Email Icon")
                },
                state = state
            )
        }
    }
}