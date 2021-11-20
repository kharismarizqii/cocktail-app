package com.kharismarizqii.cocktail.ui.main

import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kharismarizqii.cocktail.MyApplication
import com.kharismarizqii.cocktail.databinding.ActivityMainBinding
import com.kharismarizqii.core_cocktail.abstraction.BaseActivityBinding
import javax.inject.Inject

class MainActivity : BaseActivityBinding<ActivityMainBinding>(), Observer<MainViewModel.MainUiState> {

    @Inject
    lateinit var viewModel: MainViewModel

    private val adapter: MainAdapter by lazy {
        MainAdapter()
    }

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = { ActivityMainBinding.inflate(it) }

    override fun setupView() {
        (application as MyApplication).appComponent.inject(this)
        viewModel.uiState.observe(this, this)
        setupCocktailList()
        viewModel.getListCocktail()
    }

    private fun setupCocktailList() {
        with(binding){
            rvCocktail.setHasFixedSize(true)
            rvCocktail.layoutManager = LinearLayoutManager(this@MainActivity)
            rvCocktail.adapter = adapter
        }
    }

    override fun onChanged(t: MainViewModel.MainUiState?) {
        when(t){
            is MainViewModel.MainUiState.Success -> {
                adapter.submitList(t.listCocktail)
            }
            is MainViewModel.MainUiState.Failed -> {
                Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

}