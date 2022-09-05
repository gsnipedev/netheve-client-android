package com.gsnipedev.netheve.ui.pages.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.kittinunf.fuel.core.Headers
import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import com.gsnipedev.netheve.models.Account.RegisterResponse
import com.gsnipedev.netheve.models.WebResponse
import com.gsnipedev.netheve.singletons.baseurl
import com.gsnipedev.netheve.ui.pages.login.NetheveBanner
import com.gsnipedev.netheve.ui.theme.NetheveTheme


@Composable
fun RegisterPage(localAuthNavController: NavController)
{
    val username = remember{ mutableStateOf("")}
    val password = remember{ mutableStateOf("")}
    val confirmationPassword = remember{ mutableStateOf("")}
    val email = remember{ mutableStateOf("")}
    val firstname = remember{ mutableStateOf("")}
    val lastname = remember{ mutableStateOf("")}
    val isPasswordShowing = remember {mutableStateOf(true) }
    val isConfirmationPasswordShowing = remember {mutableStateOf(true) }
    val localRegisterNavController = rememberNavController()
    val scroll = rememberScrollState()
    var registerResult = WebResponse(
        code = 404,
        status = "Not Found",
        data = RegisterResponse(
            error_message = "nothing"
        )
    )
    val registerErrorNotificationText = remember{ mutableStateOf(registerResult.data.error_message)}


    NetheveTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(state = scroll)
        ) {
            NetheveBanner(text = "Register")
            Text(text = registerErrorNotificationText.value)
            NavHost(navController = localRegisterNavController, startDestination = "First" )
            {
                composable("First")
                {
                    FirstRegisterForm(
                        username = username,
                        password = password,
                        isPasswordShowing = isPasswordShowing ,
                        confirmationPassword = confirmationPassword,
                        isConfirmationPasswordShowing = isConfirmationPasswordShowing,
                        state = scroll
                    )
                }
                composable("Second")
                {
                    SecondRegisterForm(email = email, firstname = firstname, lastname = lastname, state = scroll)
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp))
            {
                Button(
                    onClick = {
                        if( localRegisterNavController.currentBackStackEntry?.destination?.route == "Second")
                        {
                            localRegisterNavController.navigate("First")

                        }else localAuthNavController.navigate("LoginPage")

                    },
                    border = BorderStroke(2.dp, color = colors.primary),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colors.secondary,
                        contentColor = colors.primary
                    )
                ) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Go to Next Icon",
                    )
                    Text(text = "Back")
                }
                Button(
                    onClick = {
                        if(localRegisterNavController.currentBackStackEntry?.destination?.route == "First")
                        {
                            localRegisterNavController.navigate("Second")
                            {
                                popUpTo("First")
                            }
                        }else if(localRegisterNavController.currentBackStackEntry?.destination?.route == "Second")
                        {
                            val register = "${baseurl.urlhttp}/api/account/register".httpPost()
                                .header(Headers.CONTENT_TYPE, "application/json")
                                .body(body = """
                                    {
                                      "username": "${username.value}",
                                      "password": "${password.value}",
                                      "password_confirmation": "${confirmationPassword.value}",
                                      "email": "${email.value}",
                                      "firstname": "${firstname.value}",
                                      "lastname": "${lastname.value}"
                                    }
                                """.trimIndent())
                                .responseObject<WebResponse<RegisterResponse>>{_, _, result ->
                                    when(result){
                                        is Result.Success -> {
                                            registerResult = result.get()
                                        }
                                        else -> {
                                            //pass
                                        }
                                    }
                                }
                            register.join()
                            if(registerResult.data.error_message == "Account Created")
                            {
                                localAuthNavController.navigate("LoginPage")
                            }else{
                                registerErrorNotificationText.value = registerResult.data.error_message
                            }
                        }

                    },
                    border = BorderStroke(2.dp, color = colors.primary),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colors.primary,
                        contentColor = colors.secondary
                    ),
                ) {
                    Text(text = "Next")
                    Icon(
                        Icons.Default.ArrowForward,
                        contentDescription = "Go to Next Icon",
                    )
                }
            }
        }
    }
}

@Composable
fun RegisterPageTopBar()
{
    TopAppBar(
        title = { Text(text = "Register")},
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back Icon")
            }
        }
    )
}

