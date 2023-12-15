package com.example.mqttandroidclient

data class ResultState(
    var fan: Boolean = false,
    var light: Boolean = false,
    var tv: Boolean = false,
    val error: Throwable? = null
)