package com.saradey.studio.ancient.egypt.features.onboarding.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.saradey.studio.ancient.egypt.R
import com.saradey.studio.ancient.egypt.databinding.FragmentOnboardingBinding
import com.saradey.studio.ancient.egypt.features.onboarding.models.OnboardingModel

class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {

    private val binding by viewBinding(FragmentOnboardingBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val window = requireActivity().window
        val controller = WindowCompat.getInsetsController(window, window.decorView)
        controller?.hide(WindowInsetsCompat.Type.statusBars())
        controller?.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }

    override fun onDestroy() {
        super.onDestroy()
        val window = requireActivity().window
        val controller = WindowCompat.getInsetsController(window, window.decorView)
        controller?.show(WindowInsetsCompat.Type.statusBars())
        controller?.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_BARS_BY_TOUCH
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
    }

    private fun FragmentOnboardingBinding.initUi() {
        txvSkip.setOnClickListener {

        }
    }
}