package com.kharismarizqii.cocktail.ui.main

import android.content.res.Resources
import android.os.Build
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.view.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.kharismarizqii.cocktail.MyApplication
import com.kharismarizqii.cocktail.R
import com.kharismarizqii.cocktail.databinding.ActivityMainBinding
import com.kharismarizqii.cocktail.domain.model.CocktailFilter
import com.kharismarizqii.cocktail.ui.dialog.FilterDialogFragment
import com.kharismarizqii.cocktail.utils.extensions.setMarginTop
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
        setupTransparentStatusBar()
        viewModel.uiState.observe(this, this)
        setupCocktailList()
        setupSearchAction()
        setupFilterAction()
        viewModel.getListCocktail()
    }

    private fun setupTransparentStatusBar() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.statusBars())

            val currentSvMargin = binding.svCocktail.marginTop
            val currentRvPadding = binding.rvCocktail.paddingTop
            binding.svCocktail.setMarginTop(insets.top/2 + currentSvMargin)
            binding.rvCocktail.updatePadding(top = insets.top/2 + currentRvPadding)

            WindowInsetsCompat.CONSUMED
        }

    }

    private fun setupFilterAction() {
        with(binding) {
            svCocktail.setOnAdditionalButtonListener {
                FilterDialogFragment.build(CocktailFilter()) {

                }.show(supportFragmentManager, this@MainActivity.javaClass.name)
            }
        }
    }

    private fun setupSearchAction() {
        with(binding) {
            svCocktail.setOnQueryChangeListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    if (query != null) {
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