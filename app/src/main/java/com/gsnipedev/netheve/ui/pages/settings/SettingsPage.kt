package com.gsnipedev.netheve.ui.pages.settings

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SettingsPage()
{
    var state: Boolean = false
    if(isSystemInDarkTheme())
    {
        state = true
    }
    var darkModeOn: Boolean by remember{ mutableStateOf(state)}

    Column {
        SettingsBanner()
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp))
        {
            Column(modifier = Modifier.padding(10.dp),verticalArrangement = Arrangement.spacedBy(15.dp))
            {

                Row(horizontalArrangement = Arrangement.spacedBy(10.dp))
                {
                    Icon(Icons.Default.Done, contentDescription = "Logout Icon" )
                    Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Text(text = "Logout")
                            Switch(checked = darkModeOn, onCheckedChange = {darkModeOn = !darkModeOn}, colors = SwitchDefaults.colors())
                        }
                        Divider()
                    }
                }
            }
        }
    }
}

@Composable
fun SettingsBanner()
{
    Card()
    {
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)) {
            Text(text = "Settings", style = MaterialTheme.typography.h6, fontWeight = FontWeight.Bold)
        }
    }

}

fun darkModeHandler(isTurnedOn: MutableState<Boolean>)
{
    isTurnedOn.value = !isTurnedOn.value
    if(isTurnedOn.value)
    {
        /*TODO*/
    }
}