package com.saradey.studio.ancient.egypt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.saradey.studio.ancient.egypt.databinding.ActivityMainBinding
import com.saradey.studio.ancient.egypt.utils.SystemComponentUtils

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SystemComponentUtils.setupStatusBar(window)
        SystemComponentUtils.setupInsets(binding.navHostFragment)
    }
}