package com.gsnipedev.netheve

sealed class ProfileNestedScreen(val route: String)
{
    object Posts: ProfileNestedScreen("Posts")
    object Notifications: ProfileNestedScreen("Notification")
    object Accounts: ProfileNestedScreen("Accounts")
}
