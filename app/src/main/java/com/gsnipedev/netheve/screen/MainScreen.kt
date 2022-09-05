package com.gsnipedev.netheve.screen

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gsnipedev.netheve.RootScreen
import com.gsnipedev.netheve.ui.components.GBottomNavigationBar
import com.gsnipedev.netheve.ui.pages.home.HomePage
import com.gsnipedev.netheve.ui.pages.profile.ProfilePage
import com.gsnipedev.netheve.ui.pages.settings.SettingsPage
import com.gsnipedev.netheve.ui.theme.NetheveTheme

@Composable
fun MainScreen()
{
    val navController = rememberNavController()
    NetheveTheme {
        Scaffold(
            bottomBar = { GBottomNavigationBar(navController) },
            floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Add, contentDescription = "")
                }
            }
        ) {
            NavHost(navController = navController, startDestination = RootScreen.HomePage.route )
            {
                composable(RootScreen.HomePage.route, content = { HomePage() })
                composable(RootScreen.ProfilePage.route, content = { ProfilePage() })
                composable(RootScreen.SettingsPage.route, content = { SettingsPage() })
            }
        }
    }

}


