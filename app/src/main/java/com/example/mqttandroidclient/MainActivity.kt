package com.example.mqttandroidclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.mqttandroidclient.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val TAG = "my#MainActivity"
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: HomeViewModel

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

    private fun observeUiState() {
        lifecycleScope.launch{
            viewModel.resultState.collect{
                binding.ivFan.setSourceImage(it.fan)
                binding.ivTv.setSourceImage(it.tv)
                binding.ivLight.setSourceImage(it.light)
                handleError(it.error)
            }
        }
    }

    private fun View.setSourceImage(isTurnedOn: Boolean) {
        when (id) {
            R.id.iv_light -> this.setBackgroundResource(if (isTurnedOn) R.drawable.light_on else R.drawable.light_off)
            R.id.iv_tv -> this.setBackgroundResource(if (isTurnedOn) R.drawable.tv_on else R.drawable.tv_off)
            R.id.iv_fan -> this.setBackgroundResource(if (isTurnedOn) R.drawable.check_on else R.drawable.check_off)
        }
    }

    private fun handleError(error: Throwable?) {
        error?.message?.let {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
            Log.e(TAG, "handleError: $error")
        }
    }

}