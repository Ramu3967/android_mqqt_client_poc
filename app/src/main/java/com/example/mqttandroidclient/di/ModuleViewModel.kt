package com.example.mqttandroidclient.di

import android.content.Context
import com.example.mqttandroidclient.mqtt.MqttHelper
import com.example.mqttandroidclient.util.MqttServerConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.eclipse.paho.android.service.MqttAndroidClient

@Module
@InstallIn(SingletonComponent::class)
object ModuleViewModel {

    @Provides
    fun provideMqttAndroidClient(@ApplicationContext context: Context) =
        MqttAndroidClient(context, MqttServerConstants.serverUri, MqttServerConstants.clientId)

    @Provides
    fun provideMqttHelper(
        mqttAndroidClient: MqttAndroidClient
    ): MqttHelper = MqttHelper(mqttAndroidClient)
}