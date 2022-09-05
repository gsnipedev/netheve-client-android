package com.gsnipedev.netheve.ui.pages.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gsnipedev.netheve.ui.components.PostsCardPreview

@Composable
fun ProfilePagePosts()
{
    Column(
        Modifier.verticalScroll(rememberScrollState(), true),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        for(i in 1..10)
        {
            PostsCardPreview()
        }
    }
}