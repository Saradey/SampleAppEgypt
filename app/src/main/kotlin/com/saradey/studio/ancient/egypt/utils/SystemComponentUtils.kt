package com.saradey.studio.ancient.egypt.utils

import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowInsets
import android.widget.FrameLayout
import androidx.core.view.WindowCompat

object SystemComponentUtils {

    private var insetsSetup = false

    fun setupStatusBar(window: Window) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.R) {
            window.statusBarColor = Color.TRANSPARENT
            WindowCompat.getInsetsController(window, window.decorView)?.let { controller ->
                controller.isAppearanceLightStatusBars = false
            }
        }
    }

    fun setupInsets(navHostFragment: ViewGroup) {
        navHostFragment.setOnApplyWindowInsetsListener { v, insets ->
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