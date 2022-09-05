package com.gsnipedev.netheve.ui.pages.register

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun CommonTextField(
    value: MutableState<String>,
    placeholder: String,
    icon: @Composable (() -> Unit)? = null,
    state: ScrollState
)
{
    val scope = rememberCoroutineScope()
    TextField(
        value = value.value, onValueChange = { value.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .onFocusEvent{
                if(it.isFocused){
                    scope.launch{
                        state.scrollTo(9999)
                    }
                }
            } ,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.secondary,
            textColor = Color.Black,
            focusedIndicatorColor = MaterialTheme.colors.primary,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(10.dp),
        leadingIcon = icon,
        placeholder = {
            Text(text = placeholder)
        },
    )
}