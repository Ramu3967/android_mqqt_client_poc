package com.example.mqttandroidclient.mqtt

import android.content.Context
import org.eclipse.paho.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.IMqttActionListener
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttMessage

// removing context as cons param
class MqttHelper(
    private val mqttAndroidClient: MqttAndroidClient
) {

    fun initializeCallbackListener(callbackListener: MqttCallback){
        mqttAndroidClient.setCallback(object: MqttCallback {
            override fun connectionLost(cause: Throwable?) {
                callbackListener.connectionLost(cause)
            }

            override fun messageArrived(topic: String?, message: MqttMessage?) {
                callbackListener.messageArrived(topic, message)
            }

            override fun deliveryComplete(token: IMqttDeliveryToken?) {
                callbackListener.deliveryComplete(token)
            }
        })
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