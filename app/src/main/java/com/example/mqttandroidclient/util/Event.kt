package com.example.mqttandroidclient.util

sealed class Event{
    data class DeviceEvent(val input: String): Event()
    data class StatusEvent(val input: String): Event()
}