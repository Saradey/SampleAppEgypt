package com.saradey.studio.ancient.egypt.features.onboarding.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnboardingModel(
    @StringRes val textDescription: Int,
    @DrawableRes val idImage: Int
)