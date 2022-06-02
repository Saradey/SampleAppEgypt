package com.saradey.studio.ancient.egypt.utils

import android.graphics.Color
import android.os.Build
import android.view.*
import androidx.core.view.WindowCompat
import androidx.core.view.updateLayoutParams

object SystemComponentUtils {

    fun setupStatusBar(window: Window) {
        window.statusBarColor = Color.TRANSPARENT
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

    fun setupInsetsBottom(view: View) {
        view.setOnApplyWindowInsetsListener { v, insets ->
            val bottomMargin = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                insets.getInsets(WindowInsets.Type.navigationBars()).bottom
            } else {
                insets.systemWindowInsetBottom
            }
            v.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                this.bottomMargin = bottomMargin
            }
            insets
        }
    }

    fun setupTopInsetsMargin(view: View) {
        view.setOnApplyWindowInsetsListener { v, insets ->
            val topMargin = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                insets.getInsets(WindowInsets.Type.statusBars()).bottom
            } else {
                insets.systemWindowInsetTop
            }
            view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                this.topMargin = topMargin
            }
            insets
        }
    }
}