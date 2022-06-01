package com.saradey.studio.ancient.egypt.ui_kit

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat

@SuppressLint("ResourceType")
class TextButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private val padding = context.dpToPx(PADDING)

    init {
        setTextAppearance(R.style.Text_CormorantSemibold_18)
        clipToOutline = true
        setBackgroundResource(R.drawable.text_rectangle_round)
        setPadding(padding, padding, padding, padding)
        val typedColor = TypedValue()
        context.theme.resolveAttribute(R.attr.text_color, typedColor, true)
        setTextColor(ContextCompat.getColor(context, typedColor.resourceId))
        val typedForeground = TypedValue()
        context.theme.resolveAttribute(
            android.R.attr.selectableItemBackground,
            typedForeground,
            true
        )
        foreground = ContextCompat.getDrawable(context, typedForeground.resourceId)
    }

    companion object {
        private const val PADDING = 4
    }
}