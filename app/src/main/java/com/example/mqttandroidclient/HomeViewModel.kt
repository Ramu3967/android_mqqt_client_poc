package com.example.mqttandroidclient

import androidx.lifecycle.ViewModel
import com.example.mqttandroidclient.mqtt.MqttHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mqttHelper: MqttHelper
): ViewModel() {
    companion object{
        const val TAG = "my#homeViewModel"
    }
}