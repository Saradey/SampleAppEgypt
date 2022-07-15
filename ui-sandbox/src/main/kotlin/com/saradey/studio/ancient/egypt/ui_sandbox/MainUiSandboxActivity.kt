package com.saradey.studio.ancient.egypt.ui_sandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.saradey.studio.ancient.egypt.ui_sandbox.databinding.ActivityMainUiSandboxBinding

class MainUiSandboxActivity : AppCompatActivity() {

    private val binding: ActivityMainUiSandboxBinding by viewBinding(
        ActivityMainUiSandboxBinding::bind
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_ui_sandbox)
        binding.txvSample.setOnClickListener {}
        binding.txvSkip.setOnClickListener {}
    }
}