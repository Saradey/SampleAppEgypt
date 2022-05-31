package com.saradey.studio.ancient.egypt.ui_kit

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.View

class DotIndicatorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : View(context, attrs, defStyleAttr) {

    init {
        background = ColorDrawable(Color.WHITE)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(context.dpToPx(WIDTH_DP), context.dpToPx(HEIGHT_DP))
    }

    companion object {
        private const val WIDTH_DP = 45
        private const val HEIGHT_DP = 10
    }
}