package com.gsnipedev.netheve.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PostsCardPreview()
{
    var openConfirmationDialog = remember{ mutableStateOf(false)}
    Card(elevation = 2.dp, modifier = Modifier
        .padding(horizontal = 10.dp)
        .fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Text(text = "Lorem Ipsum Dolor Sit Amet, adipsiccuy")
            Box() {
                PostsPreviewDropdownMenu(open = openConfirmationDialog)
            }
        }
    }
    if(openConfirmationDialog.value)
    {
        DeleteConfirmationAlert(openConfirmationDialog)
    }

}

@Composable
fun PostsPreviewDropdownMenu(open: MutableState<Boolean>)
{
    var expanded by remember{ mutableStateOf(false)}
    IconButton(onClick = { expanded = true }) {
        Icon(Icons.Default.Menu, contentDescription = "Options Menu")
    }
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier
            .padding(horizontal = 10.dp)
    ) {
        DropdownMenuItem(onClick = { /* Handle settings! */ }) {
            Icon(Icons.Default.LocationOn, contentDescription = "Lock Icon")
            Text("Visit")
        }
        DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
            Icon(Icons.Default.Lock, contentDescription = "Lock Icon")
            Text("Archive")
        }
        DropdownMenuItem(onClick = { open.value = true }) {
            Icon(Icons.Default.Delete, contentDescription = "Delete Icon")
            Text("Delete")
        }
    }

}

@Composable
fun DeleteConfirmationAlert(open: MutableState<Boolean>)
{

    AlertDialog(
        onDismissRequest = { open.value = false },
        title = { Text(text = "Are You Sure?") },
        text = { Text(text = "Are you sure want to delete this post?, this action cannot be undone") },
        confirmButton = {
            TextButton(onClick = { open.value = false  }) {
                Text(text = "Delete")
            }
        },
        dismissButton = {
            TextButton(onClick = { open.value = false  }) {
                Text(text = "Cancel")
            }
        }
    )

}



//@Preview(showBackground = true)
//@Composable
//fun Prev()
//{
//
//    NetheveTheme {
//        PostsCardPreview()
//    }
//}
