package com.example.mqttandroidclient

data class ResultState(
    var fan: Boolean = false,
    var light: Boolean = false,
    var tv: Boolean = false,
    val error: Throwable? = null
){
    fun handleAllDevices(status: Boolean) = this.copy(
        fan = status, light = status, tv = status
    )

    fun handleFan(status: Boolean) = this.copy(fan = status)

    fun handleLight(status: Boolean) = this.copy(light = status)

    fun handleTv(status: Boolean) = this.copy(tv = status)

    fun handleError(error: Throwable?) = this.copy(error = error)
}