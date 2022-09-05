package com.gsnipedev.netheve.models

data class WebResponse<T>(

    val code: Int,
    val status: String,
    val data: T

)
