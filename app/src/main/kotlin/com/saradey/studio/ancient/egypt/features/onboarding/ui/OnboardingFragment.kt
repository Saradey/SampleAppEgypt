package com.saradey.studio.ancient.egypt.features.onboarding.ui

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.saradey.studio.ancient.egypt.R
import com.saradey.studio.ancient.egypt.common.AnimationListenerDefault
import com.saradey.studio.ancient.egypt.databinding.FragmentOnboardingBinding
import com.saradey.studio.ancient.egypt.features.onboarding.models.OnboardingModel
import com.saradey.studio.ancient.egypt.utils.StatusBarUtils

class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {

    private val binding by viewBinding(FragmentOnboardingBinding::bind)

    private val adapter = OnboardingAdapter()

    private var nextDotsIndicator = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtils.hideStatusBar(requireActivity().window)
    }

    override fun onDestroy() {
        super.onDestroy()
        StatusBarUtils.showStatusBar(requireActivity().window)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.initViewPager()
        binding.startAnimationScreen()
        binding.initUi()
    }

    private fun FragmentOnboardingBinding.initViewPager() {
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
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_splashFragment_to_mainMenuFragment)
        }
        txvNext.setOnClickListener {
            if (vp2Content.currentItem >= 2) {
                Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.action_splashFragment_to_mainMenuFragment)
            } else {
                vp2Content.currentItem++
            }
        }
    }

    private fun FragmentOnboardingBinding.startAnimationScreen() {
        lifecycleScope.launchWhenResumed {
            val animationBottom =
                AnimationUtils.loadAnimation(context, R.anim.bottom_onboarding_element_show)
            txvNext.startAnimation(animationBottom)
            dtiIndicator.startAnimation(animationBottom)
            txvNext.isEnabled = false
            animationBottom.setAnimationListener(object : AnimationListenerDefault() {
                override fun onAnimationEnd(animation: Animation?) {
                    txvNext.isEnabled = true
                }
            })
            val animationCenter =
                AnimationUtils.loadAnimation(context, R.anim.centre_onboarding_element_show)
            vp2Content.startAnimation(animationCenter)
            val animationTop =
                AnimationUtils.loadAnimation(context, R.anim.bottom_onboarding_element_show)
            txvSkip.startAnimation(animationTop)
            txvSkip.isEnabled = false
            animationTop.setAnimationListener(object : AnimationListenerDefault() {
                override fun onAnimationEnd(animation: Animation?) {
                    txvSkip.isEnabled = true
                }
            })
        }
    }
}