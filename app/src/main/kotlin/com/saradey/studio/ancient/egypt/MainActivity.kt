package com.saradey.studio.ancient.egypt

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.FrameLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.updateLayoutParams
import by.kirich1409.viewbindingdelegate.viewBinding
import com.saradey.studio.ancient.egypt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)

    private var insetsSetup = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupStatusBar()
        binding.setupInsets()
    }

    private fun setupStatusBar() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = Color.TRANSPARENT
        WindowCompat.getInsetsController(window, window.decorView)?.let { controller ->
            controller.isAppearanceLightStatusBars = false
        }
    }

    private fun ActivityMainBinding.setupInsets() {
        root.setOnApplyWindowInsetsListener { v, insets ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                v.y = insets.getInsets(WindowInsets.Type.statusBars()).top.toFloat()
                updateHeight(
                    v,
                    insets.getInsets(WindowInsets.Type.statusBars()).top,
                    insets.getInsets(WindowInsets.Type.navigationBars()).bottom
                )
            } else {
                v.y = insets.systemWindowInsetTop.toFloat()
                updateHeight(
                    v,
                    insets.systemWindowInsetTop,
                    insets.systemWindowInsetBottom
                )
            }
            insets
        }
    }

    private fun updateHeight(view: View, statusBarHeight: Int, navigationBarHeight: Int) {
        if (!insetsSetup) {
            insetsSetup = true
            view.post {
                val param = FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                val newH = view.height - (statusBarHeight + navigationBarHeight)
                param.height = newH
                view.layoutParams = param
            }
        }
    }
}