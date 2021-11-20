package com.kharismarizqii.cocktail.ui.main

import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.kharismarizqii.cocktail.MyApplication
import com.kharismarizqii.cocktail.databinding.ActivityMainBinding
import com.kharismarizqii.cocktail.domain.model.CocktailFilter
import com.kharismarizqii.cocktail.ui.dialog.FilterDialogFragment
import com.kharismarizqii.core_cocktail.abstraction.BaseActivityBinding
import javax.inject.Inject

class MainActivity : BaseActivityBinding<ActivityMainBinding>(),
    Observer<MainViewModel.MainUiState> {

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
        setupSearchAction()
        setupFilterAction()
        viewModel.getListCocktail()
    }

    private fun setupFilterAction() {
        with(binding){
            svCocktail.setOnAdditionalButtonListener {
                FilterDialogFragment.build(CocktailFilter()){

                }.show(supportFragmentManager, this@MainActivity.javaClass.name)
            }
        }
    }

    private fun setupSearchAction() {
        with(binding) {
            svCocktail.setOnQueryChangeListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    if(query!=null){
                        viewModel.searchCocktail(query.toString())
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })
        }
    }

    private fun setupCocktailList() {
        with(binding) {
            rvCocktail.setHasFixedSize(true)
            rvCocktail.layoutManager = GridLayoutManager(this@MainActivity, 2)
            rvCocktail.adapter = adapter
        }
    }

    override fun onChanged(t: MainViewModel.MainUiState?) {
        when (t) {
            is MainViewModel.MainUiState.Success -> {
                adapter.submitList(t.listCocktail)
            }
            is MainViewModel.MainUiState.Failed -> {
                Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

}