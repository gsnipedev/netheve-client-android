package com.gsnipedev.netheve

sealed class RootScreen(val route: String)
{
    object HomePage: RootScreen("Home")
    object ProfilePage: RootScreen("Profile")
    object LoginPage: RootScreen("Login")
    object SettingsPage: RootScreen("Settings")
}
