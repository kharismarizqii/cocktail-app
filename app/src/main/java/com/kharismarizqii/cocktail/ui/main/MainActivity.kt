package com.kharismarizqii.cocktail.ui.main

import android.view.LayoutInflater
import com.kharismarizqii.cocktail.databinding.ActivityMainBinding
import com.kharismarizqii.core_cocktail.abstraction.BaseActivityBinding

class MainActivity : BaseActivityBinding<ActivityMainBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = { ActivityMainBinding.inflate(it) }

    override fun setupView() {

    }

}