package com.saradey.studio.ancient.egypt.features.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.saradey.studio.ancient.egypt.R
import com.saradey.studio.ancient.egypt.databinding.FragmentMainMenuBinding

class MainMenuFragment : Fragment(R.layout.fragment_main_menu) {

    private val binding: FragmentMainMenuBinding by viewBinding(FragmentMainMenuBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnMenu.setOnApplyWindowInsetsListener(null)
    }
}