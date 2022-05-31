package com.saradey.studio.ancient.egypt.ui_kit

import android.content.Context
import android.util.TypedValue

fun Context.dpToPx(dp: Int): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
        resources.displayMetrics
    ).toInt()
}