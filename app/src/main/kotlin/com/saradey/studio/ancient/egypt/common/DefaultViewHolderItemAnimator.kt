package com.saradey.studio.ancient.egypt.common

import androidx.recyclerview.widget.RecyclerView

abstract class DefaultViewHolderItemAnimator : RecyclerView.ItemAnimator() {

    override fun animateDisappearance(
        viewHolder: RecyclerView.ViewHolder,
        preLayoutInfo: ItemHolderInfo,
        postLayoutInfo: ItemHolderInfo?
    ): Boolean = false

    override fun animateAppearance(
        viewHolder: RecyclerView.ViewHolder,
        preLayoutInfo: ItemHolderInfo?,
        postLayoutInfo: ItemHolderInfo
    ): Boolean = false

    override fun animatePersistence(
        viewHolder: RecyclerView.ViewHolder,
        preLayoutInfo: ItemHolderInfo,
        postLayoutInfo: ItemHolderInfo
    ): Boolean = false

    override fun animateChange(
        oldHolder: RecyclerView.ViewHolder,
        newHolder: RecyclerView.ViewHolder,
        preLayoutInfo: ItemHolderInfo,
        postLayoutInfo: ItemHolderInfo
    ): Boolean = false

    override fun runPendingAnimations() {}

    override fun endAnimation(item: RecyclerView.ViewHolder) {}

    override fun endAnimations() {}

    override fun isRunning(): Boolean = false
}