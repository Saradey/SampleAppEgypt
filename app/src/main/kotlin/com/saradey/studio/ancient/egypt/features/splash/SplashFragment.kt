package com.saradey.studio.ancient.egypt.features.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.saradey.studio.ancient.egypt.R
import kotlinx.coroutines.delay


class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launchWhenResumed {
            delay(DELAY_SPLASH)
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_splashFragment_to_onboardingFragment)
        }
    }

    companion object {
        private const val DELAY_SPLASH = 2000L
    }
}