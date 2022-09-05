package com.gsnipedev.netheve.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.gsnipedev.netheve.RootScreen

@Composable
fun GBottomNavigationBar(navController: NavController){
    var selectedItem by remember { mutableStateOf(1)}
    BottomNavigation {
        BottomNavigationItem(
            selected = selectedItem == 1,
            onClick = { selectedItem = 1; navController.navigate(RootScreen.HomePage.route) },
            label = { Text(text = "Home")},
            icon = { Icon(Icons.Default.Home, contentDescription = "Home Icon")}
        )
        BottomNavigationItem(
            selected = selectedItem == 2,
            onClick = { selectedItem = 2; navController.navigate(RootScreen.ProfilePage.route) },
            label = { Text(text = "Profile")},
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile Icon")}
        )
        BottomNavigationItem(
            selected = selectedItem == 3,
            onClick = { selectedItem = 3; navController.navigate(RootScreen.SettingsPage.route) },
            label = { Text(text = "Settings")},
            icon = { Icon(Icons.Default.Settings, contentDescription = "Settings Icon")}
        )
    }
}