package com.example.mqttandroidclient

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mqttandroidclient.mqtt.MqttHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.eclipse.paho.client.mqttv3.IMqttActionListener
import org.eclipse.paho.client.mqttv3.IMqttToken
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mqttHelper: MqttHelper
): ViewModel() {
    companion object{
        const val TAG = "my#homeViewModel"
    }

    init {
        connectToBroker()
    }

    private val statusDevice = MutableStateFlow("")
    private val statusOnOff = MutableStateFlow("")
    private val _resultState = MutableStateFlow(ResultState())
    val resultState: StateFlow<ResultState> get() = _resultState

    private val connectCallback = object: IMqttActionListener {
        override fun onSuccess(asyncActionToken: IMqttToken?) {
            Log.d(TAG, "onSuccess: successfully connected to the broker")
            // on successful connection
            subscribeToTopics()
        }

        override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
            Log.d(TAG, "onFailure: failed to connect to the broker")
            _resultState.update { it.handleError(exception) }
        }
    }

    private fun subscribeToTopics() {

    }

    private fun connectToBroker(){
    }

    override fun onCleared() {
        super.onCleared()
        mqttHelper.disconnect()
    }
}