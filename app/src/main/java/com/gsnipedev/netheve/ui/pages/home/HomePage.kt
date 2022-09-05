package com.gsnipedev.netheve.ui.pages.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gsnipedev.netheve.R
import com.gsnipedev.netheve.models.PostsCard.PostCardResponseModel
import com.gsnipedev.netheve.ui.components.PublicPostsCard
import java.util.*


@Composable
fun HomePage()
{
    val dummy = PostCardResponseModel(
        username = "Andika",
        textContent = "Keren cuy aplikasi nya",
        likesCount = 1,
        commentsCount = 1,
        sharedCount = 1,
        postedAt = Date(),
        displayInfo = "Well Known Programmer"
    )
    Column(modifier = Modifier.verticalScroll(enabled = true, state = rememberScrollState())) {
        PublicStories()
        FormPostContainer()
        Divider(modifier = Modifier.padding(10.dp))
        PublicPostsCard(dummy)
    }
}

@Composable
fun FormPostMain()
{
    Row(modifier = Modifier
        .fillMaxWidth(1f)
        .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        IconButton(onClick = { /**/ }) {
            Icon(Icons.Default.Person, contentDescription = "")
        }
        TextButton(
            onClick = { /*TODO*/ },
            border = BorderStroke(1.dp, Color.Black),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Post Something")
        }
    }
}

@Composable
fun FormPostContainer()
{
    Card(elevation = 2.dp, modifier = Modifier.padding(10.dp)) {
        Box(modifier = Modifier.padding(0.dp))
        {
            Column(verticalArrangement = Arrangement.Center) {
                FormPostMain()
                Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth(1f)) {

                    TextButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(id = R.drawable.outline_image_24), contentDescription = "")
                    }
                    TextButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(id = R.drawable.outline_smart_display_24), contentDescription = "")
                    }
                    TextButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(id = R.drawable.outline_insert_invitation_24), contentDescription = "")
                    }
                    TextButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(id = R.drawable.outline_article_24), contentDescription = "")
                    }

                }
            }
        }
    }
}

@Composable
fun PublicStories()
{
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(start = 10.dp))
    {
        item {
            MyStoryContainer()
        }
        items(5) { cuy ->
            StoryContainer()
        }
    }
}

@Composable
fun StoryContainer()
{
    Card(
        Modifier
            .height(200.dp)
            .width(130.dp)
            .shadow(elevation = 4.dp),
    )
    {
        Surface(
            modifier = Modifier.padding(10.dp)
        )
        {
            Text(text = "Cuy")
        }
    }
}

@Composable
fun MyStoryContainer()
{
    Card(
        Modifier
            .height(200.dp)
            .width(130.dp)
            .shadow(elevation = 4.dp),
    )
    {
        Surface(
            modifier = Modifier.padding(10.dp)
        )
        {
            Text(text = "+")
        }
    }
}
