package com.saradey.studio.ancient.egypt.features.splash

import android.graphics.drawable.Animatable2
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import com.saradey.studio.ancient.egypt.R
import com.saradey.studio.ancient.egypt.databinding.FragmentSplashBinding
import com.saradey.studio.ancient.egypt.utils.StatusBarUtils
import kotlinx.coroutines.delay


class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val binding by viewBinding(FragmentSplashBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (binding.imvSplash.drawable as AnimatedVectorDrawable).start()
        val animated = (binding.imvSplash.drawable as AnimatedVectorDrawable)
        animated.registerAnimationCallback(
            object : Animatable2.AnimationCallback() {
                override fun onAnimationEnd(drawable: Drawable?) {
                    Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                        .navigate(R.id.action_splashFragment_to_onboardingFragment)
                }
            }
        )
    }
}