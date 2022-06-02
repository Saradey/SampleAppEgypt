package com.saradey.studio.ancient.egypt.common

import android.view.animation.Animation

abstract class AnimationListenerDefault : Animation.AnimationListener {

    override fun onAnimationStart(animation: Animation?) {}

    override fun onAnimationEnd(animation: Animation?) {}

    override fun onAnimationRepeat(animation: Animation?) {}
}