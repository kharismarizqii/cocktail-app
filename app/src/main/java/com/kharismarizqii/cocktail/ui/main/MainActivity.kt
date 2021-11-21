package com.kharismarizqii.cocktail.ui.main

import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.view.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.kharismarizqii.cocktail.MyApplication
import com.kharismarizqii.cocktail.databinding.ActivityMainBinding
import com.kharismarizqii.cocktail.domain.model.Cocktail
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

    private var filter = CocktailFilter()
    private var query: String = ""
    private val list: ArrayList<Cocktail> = ArrayList()

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = { ActivityMainBinding.inflate(it) }


    override fun setupView() {
        setupTransparentStatusBar()
        (application as MyApplication).appComponent.inject(this)
        viewModel.uiState.observe(this, this)
        setupCocktailList()
        setupSearchAction()
        setupFilterAction()
        viewModel.getListCocktail()
    }

    private fun setupTransparentStatusBar() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.statusBars())

            binding.svCocktail.setMarginTop(insets.top + 63)
            binding.rvCocktail.updatePadding(top = insets.top + 226)

            WindowInsetsCompat.CONSUMED
        }

    }

    private fun setupFilterAction() {
        with(binding) {
            svCocktail.setOnAdditionalButtonListener {
                FilterDialogFragment.build(filter, svCocktail.getQuery()) { pFilter, pQuery ->
                    filter = pFilter
                    query = pQuery
                    if(pQuery.isEmpty()) {
                        viewModel.filterCocktail(filter)
                    } else {
                        viewModel.filterWithSearch(filter, pQuery)
                    }
                }.show(supportFragmentManager, this@MainActivity.javaClass.name)
            }
        }
    }

    private fun setupSearchAction() {
        with(binding) {
            svCocktail.setOnQueryChangeListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    if (query != null) {
                        if(filter.alcoholic==null && filter.category==null && filter.glass==null){
                            viewModel.searchCocktail(query.toString())
                        } else {
                            val filteredList = list.filter {
                                it.strDrink.lowercase().contains(query.toString().lowercase())
                            }
                            adapter.submitList(filteredList)
                        }
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
                list.clear()
                list.addAll(t.listCocktail)
                adapter.submitList(t.listCocktail)
            }
            is MainViewModel.MainUiState.Failed -> {
                Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

}