package com.gsnipedev.netheve.ui.pages.profile

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gsnipedev.netheve.ui.theme.DarkColorPalette
import com.gsnipedev.netheve.ui.theme.LightColorPalette

@Composable
fun ProfilePage()
{
    val navController = rememberNavController()
    Column {
        ProfilePageTopSectionContainer(navController)
        ProfilePageContentContainer(navController)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun Myprev()
//{
//    NetheveTheme() {
//        ProfilePage()
//    }
//
//}

@Composable
fun ProfilePageTopSectionContainer(navController: NavHostController)
{
    var selectedTab by remember{ mutableStateOf(0)}
    var surfaceColor: Color = LightColorPalette.primary
    if(isSystemInDarkTheme()) surfaceColor = DarkColorPalette.primary

    Surface(elevation = 8.dp, color = surfaceColor) {
        Box()
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    Icons.Default.Person,
                    contentDescription = "Profile Picture",
                    Modifier.size(150.dp)
                )
                Text(text = "Andika Wahyudi", style = MaterialTheme.typography.h5, fontWeight = FontWeight.Bold)
                Text(text = "Software Maniax/Tech Enthusiast", modifier = Modifier.padding(bottom = 25.dp))
                TabRow(selectedTabIndex = selectedTab)
                {
                    Tab(
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0; navController.navigate("Posts") },
                        text = { Text(text = "Posts")},
                    )
                    Tab(
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1; navController.navigate("Notifications") },
                        text = { Text(text = "Notifications")}
                    )
                    Tab(selected = selectedTab == 2,
                        onClick = { selectedTab = 2; navController.navigate("Accounts") },
                        text = { Text(text = "Accounts")},
                    )
                }
            }
        }
    }
}

@Composable
fun ProfilePageContentContainer(navController: NavHostController)
{
    NavHost(navController = navController, startDestination = "Posts" )
    {
        composable("Posts", content =  { ProfilePagePosts() })
        composable("Notifications", content =  { Text(text = "Notifications Here") })
        composable("Accounts", content =  { Text(text = "Account Here")})
    }
}

