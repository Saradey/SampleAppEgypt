package com.saradey.studio.ancient.egypt.features.onboarding.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.saradey.studio.ancient.egypt.R
import com.saradey.studio.ancient.egypt.databinding.FragmentOnboardingBinding
import com.saradey.studio.ancient.egypt.features.onboarding.models.OnboardingModel
import com.saradey.studio.ancient.egypt.utils.StatusBarUtils

class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {

    private val binding by viewBinding(FragmentOnboardingBinding::bind)

    private var nextDotsIndicator = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtils.showStatusBar(requireActivity().window)
    }

    override fun onDestroy() {
        super.onDestroy()
        StatusBarUtils.hideStatusBar(requireActivity().window)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initViewPager()
        binding.initUi()
    }

    private fun FragmentOnboardingBinding.initViewPager() {
        val adapter = OnboardingAdapter()
        vp2Content.adapter = adapter
        adapter.models = mutableListOf(
            OnboardingModel(R.string.onboarding_text_first, R.drawable.onboarding_first),
            OnboardingModel(R.string.onboarding_text_second, R.drawable.onboarding_second),
            OnboardingModel(R.string.onboarding_text_third, R.drawable.onboarding_third)
        )
        vp2Content.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    if (nextDotsIndicator != position) {
                        nextDotsIndicator = position
                        dtiIndicator.nextPage = nextDotsIndicator + 1
                    }
                    if (position >= 2) {
                        txvNext.setText(R.string.get_started)
                    } else {
                        txvNext.setText(R.string.next)
                    }
                }
            }
        )
    }

    private fun FragmentOnboardingBinding.initUi() {
        txvSkip.setOnClickListener {
            //TODO переход на главный экран
        }
        txvNext.setOnClickListener {
            if (vp2Content.currentItem >= 2) {
                //TODO переход на главный экран
            } else {
                vp2Content.currentItem++
            }
        }
    }
}