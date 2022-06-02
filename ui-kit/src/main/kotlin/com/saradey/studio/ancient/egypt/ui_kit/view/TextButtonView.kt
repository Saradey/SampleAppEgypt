package com.saradey.studio.ancient.egypt.ui_kit.view

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.saradey.studio.ancient.egypt.ui_kit.R
import com.saradey.studio.ancient.egypt.ui_kit.extensions.dpToPx

class TextButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private val padding = context.dpToPx(PADDING)

    init {
        setTextAppearance(R.style.Text_MainTextColor_CormorantSemibold_18)
        clipToOutline = true
        setBackgroundResource(R.drawable.background_text_rectangle_round)
        setPadding(padding, padding, padding, padding)
        val typedForeground = TypedValue()
        context.theme.resolveAttribute(
            android.R.attr.selectableItemBackground,
            typedForeground,
            true
        )
        foreground = ContextCompat.getDrawable(context, typedForeground.resourceId)
        gravity = Gravity.CENTER
    }

    companion object {
        private const val PADDING = 4
    }
}