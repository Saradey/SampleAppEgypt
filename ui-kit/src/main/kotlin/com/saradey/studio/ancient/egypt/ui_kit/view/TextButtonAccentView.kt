package com.saradey.studio.ancient.egypt.ui_kit.view

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.saradey.studio.ancient.egypt.ui_kit.R
import com.saradey.studio.ancient.egypt.ui_kit.extensions.dpToPx

class TextButtonAccentView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private val padding = context.dpToPx(PADDING)

    init {
        setTextAppearance(R.style.Text_AccentTextColor_CormorantSemibold_26)
        clipToOutline = true
        setPadding(padding, padding, padding, padding)
        setBackgroundResource(R.drawable.background_white_text_rectangle_round)
        gravity = Gravity.CENTER
        val typedForeground = TypedValue()
        context.theme.resolveAttribute(
            android.R.attr.selectableItemBackground,
            typedForeground,
            true
        )
        foreground = ContextCompat.getDrawable(context, typedForeground.resourceId)
    }

    companion object {
        private const val PADDING = 8
    }
}