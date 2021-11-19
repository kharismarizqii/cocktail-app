package com.kharismarizqii.cocktail.ui.main

import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.kharismarizqii.cocktail.databinding.ActivityMainBinding
import com.kharismarizqii.core_cocktail.abstraction.BaseActivityBinding

class MainActivity : BaseActivityBinding<ActivityMainBinding>() {

    private val adapter: MainAdapter by lazy {
        MainAdapter()
    }

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = { ActivityMainBinding.inflate(it) }

    override fun setupView() {
        setupCocktailList()
    }

    private fun setupCocktailList() {
        with(binding){
            rvCocktail.setHasFixedSize(true)
            rvCocktail.layoutManager = LinearLayoutManager(this@MainActivity)
            rvCocktail.adapter = adapter
        }
    }

}