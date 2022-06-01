package com.saradey.studio.ancient.egypt.ui_kit

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

class DotIndicatorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : View(context, attrs, defStyleAttr) {

    var nextPage = 1
        set(value) {
            field = value
            invalidate()
        }

    private val heightPixel = context.dpToPx(HEIGHT_DP)
    private val radiusDot = context.dpToPx(RADIUS).toFloat()
    private val widthPixel = context.dpToPx(
        (RADIUS * 5) * 3
    )
    private val paintActivatedDot = Paint().apply {
        isAntiAlias = true
        color = Color.WHITE
    }
    private val paintDot = Paint().apply {
        isAntiAlias = true
        color = ContextCompat.getColor(context, R.color.white_alpha)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(widthPixel, heightPixel)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (dot in 1..3) {
            if (nextPage == dot) {
                canvas.drawCircle(
                    dot * (radiusDot * 4),
                    heightPixel / 2f,
                    radiusDot,
                    paintActivatedDot
                )
            } else {
                canvas.drawCircle(
                    dot * (radiusDot * 4),
                    heightPixel / 2f,
                    radiusDot,
                    paintDot
                )
            }
        }
    }

    companion object {
        private const val HEIGHT_DP = 20

        private const val RADIUS = 4
    }
}