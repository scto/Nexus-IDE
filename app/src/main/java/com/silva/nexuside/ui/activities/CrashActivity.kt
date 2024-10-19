package com.silva.nexuside.ui.activities

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.activity.EdgeToEdge

import com.blankj.utilcode.util.DeviceUtils

import com.silva.nexuside.databinding.ActivityCrashBinding

class CrashActivity : AppCompatActivity() {

    private var _binding: ActivityCrashBinding? = null
    private var binding
        get() = _binding!!
        
    private val deviceInfo: String
        get() =
            StringBuilder("Device: ")
               .append(DeviceUtils.getModel())
               .append("\n")
               .append("SDK: ")
               .append(Build.VERSION.SDK_INT)
               .append("\n")
               .append("Android: ")
               .append(Build.VERSION.RELEASE)
               .append("\n")
               .append("Model: ")
               .append(Build.VERSION.INCREMENTAL)
               .append("\n")
               .toString()
                
    private val nexusInfo: String
        get() =
          StringBuilder("Version: ")
            .append(BuildConfig.VERSION_NAME)
            .append("\n")
            .append("Build Variant: ")
            .append(BuildConfig.BUILD_TYPE)
            .toString()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        EdgeToEdge.enable(this)
        super.onCreate(savedInstanceState)
        _binding = ActivityCrashBinding.inflate(getLayoutInflater())
        setContentView(binding.root)
        
        val error = buildString {
            append("$deviceInfo\n")
            append("$nexusInfo\n\n")
            append(intent.getStringExtra("key_extra_error"))
        }
        
        binding.log.text = error
        
        binding.copy.setOnClickListener {
            ClipboardUtils.copyText(error)
        }
        
    }
    
}