package com.saradey.studio.ancient.egypt.features.onboarding.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.saradey.studio.ancient.egypt.R
import com.saradey.studio.ancient.egypt.databinding.ItemOnboardingBinding
import com.saradey.studio.ancient.egypt.features.onboarding.models.OnboardingModel

class OnboardingAdapter : RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    var models = mutableListOf<OnboardingModel>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        return OnboardingViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_onboarding,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.bind(models[position])
    }

    override fun getItemCount(): Int = models.size

    class OnboardingViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {

        private val binding by viewBinding(ItemOnboardingBinding::bind)

        fun bind(model: OnboardingModel) {
            binding.imvOnboarding.setImageResource(model.idImage)
            binding.txvOnboardingDescription.setText(model.textDescription)
        }
    }
}