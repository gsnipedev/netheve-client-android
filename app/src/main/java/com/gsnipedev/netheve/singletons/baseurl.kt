package com.gsnipedev.netheve.singletons

object baseurl {
    private val url = "192.168.43.151"
    private val port = 1337

    val urlhttp: String = "http://$url:$port"
    val urlhttps: String = "https://$url:$port"
}