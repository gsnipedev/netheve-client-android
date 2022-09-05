package com.gsnipedev.netheve.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gsnipedev.netheve.ui.pages.login.LoginPage
import com.gsnipedev.netheve.ui.pages.register.RegisterPage

@Composable
fun AuthScreen(rootNavController: NavHostController)
{
    val localNavController = rememberNavController()
    NavHost(navController = localNavController, startDestination = "LoginPage")
    {
        composable("LoginPage", content = { LoginPage(localNavController = localNavController, rootNavController = rootNavController) })
        composable("ForgotPasswordPage", content = { Text(text = "Recovery Page Here")})
        composable("RegisterPage", content = { RegisterPage(localAuthNavController = localNavController) })
    }
}



