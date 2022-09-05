package com.gsnipedev.netheve.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gsnipedev.netheve.R
import com.gsnipedev.netheve.models.PostsCard.PostCardResponseModel
import com.gsnipedev.netheve.ui.theme.NetheveTheme


@Composable
fun PublicPostsCard(data: PostCardResponseModel)
{
    Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
        Card(elevation = 2.dp, modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(20.dp)) {
                PostCardIdentity(data.username, data.displayInfo)
                PostCardContent(data.textContent)
            }
        }
        Box(modifier = Modifier.padding(horizontal = 20.dp))
        {
            Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
                PostCardActions()
                PostCardComment()
                Text(text = "8 days ago", fontSize = 15.sp )
            }
        }
    }

}

@Composable
fun PostCardIdentity(username: String, displayInfo: String)
{
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(Icons.Default.Person, contentDescription = "")
        Column(modifier = Modifier.padding(horizontal = 0.dp)) {
            Text(text = username)
            Text(text = displayInfo, color = Color.LightGray)
        }
    }
}

@Composable
fun PostCardContent(textContent: String)
{
    var gen = LoremIpsum(500)
    var localMaxLines by remember{ mutableStateOf(10)}
    var shouldShowMore: Boolean by remember{ mutableStateOf(false)}
    Box(modifier = Modifier.padding(horizontal = 0.dp)){
        Column {
            Text(
                text = textContent,
                maxLines = localMaxLines, overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Justify
            )
//            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
//                TextButton(onClick = { localMaxLines+=10 }) {
//                    Text(text = "Show More")
//                }
//            }

        }

    }
}

@Composable
fun PostCardActions()
{
    Row(
        horizontalArrangement = Arrangement.spacedBy(25.dp),
        modifier = Modifier.fillMaxWidth(),

    ) {

        Icon(painter = painterResource(id = R.drawable.outline_thumb_up_24), "Like Icon")
        Icon(painter = painterResource(id = R.drawable.outline_chat_bubble_outline_24), "Comment Icon")
        Icon(painter = painterResource(id = R.drawable.outline_share_24), "Send Icon")
        Icon(painter = painterResource(id = R.drawable.outline_send_24), "Share Icon")

    }
}

@Composable
fun PostCardComment()
{
    Column( verticalArrangement = Arrangement.spacedBy(10.dp))
    {
        PostCardCommentTriggerButton()
    }
}

@Composable
fun PostCardCommentTriggerButton()
{
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.Person, contentDescription = "Profile Icon" )
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Leave a comment as Nickname")
        }
    }
//    TextField(
//        value = text, onValueChange = {text = it},
//        modifier = Modifier.fillMaxWidth(),
//        colors = TextFieldDefaults.textFieldColors(
//            focusedIndicatorColor = Color.Transparent,
//            unfocusedIndicatorColor = Color.Transparent,
//            backgroundColor = MaterialTheme.colors.secondary,
//        ),
//        shape = RoundedCornerShape(8.dp),
//        placeholder = { Text(text = "Leave a Comment")},
//        trailingIcon = { Icon(Icons.Default.ExitToApp, contentDescription = "icon" ) }
//    )
}

@Composable
fun PostCardPublicComments()
{

}

//@Preview(showBackground = true)
//@Composable
//fun prev()
//{
//    NetheveTheme {
//        PublicPostsCard()
//    }
//}
