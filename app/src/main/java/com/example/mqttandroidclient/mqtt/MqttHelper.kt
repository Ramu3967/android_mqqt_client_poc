package com.example.mqttandroidclient.mqtt

import android.content.Context
import org.eclipse.paho.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.IMqttActionListener
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttMessage

class MqttHelper(context: Context) {
    private lateinit var mqttAndroidClient: MqttAndroidClient

    init {
        mqttAndroidClient = MqttAndroidClient(context, "fakeServer", "fakeClientId")
    }

    fun connect(username: String, password: String) {
        val options = MqttConnectOptions()
        options.userName = username
        options.password = password.toCharArray()
        mqttAndroidClient.connect(options)
    }

    fun subscribe(topic: String, qos: Int) {
        mqttAndroidClient.subscribe(topic, qos)
    }

    fun publish(topic: String, message: String, qos: Int) {
        val mqttMessage = MqttMessage()
        mqttMessage.payload = message.toByteArray()
        mqttMessage.qos = qos

        mqttAndroidClient.publish(topic, mqttMessage)
    }

    fun disconnect() {
        mqttAndroidClient.disconnect()
    }

    fun isConnected()= mqttAndroidClient.isConnected
}