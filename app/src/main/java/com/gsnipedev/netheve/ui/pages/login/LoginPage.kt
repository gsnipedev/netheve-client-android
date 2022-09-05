package com.gsnipedev.netheve.ui.pages.login

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.github.kittinunf.fuel.core.Headers
import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import com.gsnipedev.netheve.models.Account.LoginResponse
import com.gsnipedev.netheve.models.WebResponse
import com.gsnipedev.netheve.singletons.baseurl
import com.gsnipedev.netheve.ui.theme.Beige700
import com.gsnipedev.netheve.ui.theme.NetheveTheme
import com.gsnipedev.netheve.ui.theme.Razmataz500
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoginPage(localNavController: NavHostController, rootNavController: NavController)
{
    var username by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    var warningText by remember{ mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    val bringToView = BringIntoViewRequester()
    val localFocus = LocalFocusManager.current
    var res: WebResponse<LoginResponse> = WebResponse(
        code = 0,
        status = "null",
        data = LoginResponse("null")
    )
    NetheveTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState(), true)
        )
        {
            NetheveBanner("Login")
            Text(text = warningText)
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(text = "Username") },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = "") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .onFocusEvent {
                        if (it.isFocused) {
                            coroutineScope.launch {
                                bringToView.bringIntoView()
                            }
                        }
                    }
                    .shadow(elevation = 5.dp, clip = true, shape = RoundedCornerShape(30.dp)),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    backgroundColor = Beige700,
                ),

                )
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "") },
                shape = RoundedCornerShape(30.dp),
                trailingIcon = { Icon(Icons.Default.Done, "Hide/show password") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .onFocusEvent {
                        if (it.isFocused) {
                            coroutineScope.launch {
                                bringToView.bringIntoView()
                            }
                        }
                    }
                    .shadow(elevation = 5.dp, clip = true, shape = RoundedCornerShape(30.dp)),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    backgroundColor = Beige700,
                ),
            )
            Text(
                text = "Forgot your password?",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                textAlign = TextAlign.End
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .bringIntoViewRequester(bringToView)
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(30.dp),
                onClick = {
                    localFocus.clearFocus()
                    val login = "${baseurl.urlhttp}/api/account/login".httpPost()
                        .header(Headers.CONTENT_TYPE, "application/json")
                        .body(
                            """
                    {
                        "username":"$username",
                        "password":"$password"
                    }
                """.trimIndent()
                        )
                        .responseObject<WebResponse<LoginResponse>> { _, _, result ->
                            when(result){
                                is Result.Success -> {
                                    res = result.get()
                                }
                                else -> {
                                    //pass
                                }
                            }
                        }
                    login.join()
                    if (res.data.error_message == "Logged In") rootNavController.navigate("mainEvent")
                    else warningText = res.data.error_message

                }) {
                Text(text = "Login")
            }
            TextButton(onClick = {
                localNavController.navigate("RegisterPage")
            }) {
                Text(text = "Dont have an Account? Register here")
            }
        }
    }

}

@Composable
fun NetheveBanner(text: String)
{
    Box(modifier = Modifier
        .height(300.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(bottomStart = 70.dp))
        .background(color = Razmataz500))
    {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(text = text, fontSize = 30.sp, color = MaterialTheme.colors.secondary)
        }
    }

}