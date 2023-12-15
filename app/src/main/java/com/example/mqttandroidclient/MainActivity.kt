package com.example.mqttandroidclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import com.example.mqttandroidclient.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = "my#MainActivity"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupUI()
    }

    private fun setupUI() {
        binding.spDevice.spinnerSetupUtil(isDeviceEvent = true)
        binding.spStatus.spinnerSetupUtil(isDeviceEvent = false)
    }

    private fun Spinner.spinnerSetupUtil(isDeviceEvent: Boolean){
        onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                p1: View?,
                position: Int,
                p3: Long
            ) {
                TODO("Not yet implemented")
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

}