package com.gsnipedev.netheve

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gsnipedev.netheve.screen.AuthScreen
import com.gsnipedev.netheve.screen.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val rootNavController = rememberNavController()
            NavHost(navController = rootNavController, startDestination = "accountAuth" )
            {
                composable("accountAuth", content = { AuthScreen(rootNavController = rootNavController) })
                composable("mainEvent", content = { MainScreen() })
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    val navController = rememberNavController()
//    NetheveTheme {
//        Scaffold(
//            bottomBar = { GBottomNavigationBar(navController)}
//        ) {
//            MainScreen(navController)
//        }
//    }
//}