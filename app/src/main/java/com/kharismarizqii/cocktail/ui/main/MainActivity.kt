package com.kharismarizqii.cocktail.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.view.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.kharismarizqii.cocktail.MyApplication
import com.kharismarizqii.cocktail.databinding.ActivityMainBinding
import com.kharismarizqii.cocktail.domain.model.Cocktail
import com.kharismarizqii.cocktail.domain.model.CocktailFilter
import com.kharismarizqii.cocktail.ui.detail.DetailCocktailActivity
import com.kharismarizqii.cocktail.ui.dialog.FilterDialogFragment
import com.kharismarizqii.cocktail.utils.extensions.setMarginTop
import com.kharismarizqii.cocktail.utils.extensions.setupTransparentStatusBar
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
        (application as MyApplication).appComponent.inject(this)

        setupTransparentStatusBar(binding) { insets ->
            binding.svCocktail.setMarginTop(insets.top + 63)
            binding.rvCocktail.updatePadding(top = insets.top + 226)
        }

        viewModel.uiState.observe(this, this)
        setupCocktailList()
        setupSearchAction()
        setupFilterAction()
        viewModel.getListCocktail()
    }

    private fun setupFilterAction() {
        with(binding) {
            svCocktail.setOnAdditionalButtonListener {
                FilterDialogFragment.build(filter, svCocktail.getQuery()) { pFilter, pQuery ->
                    filter = pFilter
                    query = pQuery
                    if (pQuery.isEmpty()) {
                        svCocktail.setQuery("")
                        if (filter.alcoholic == null && filter.category == null && filter.glass == null) {
                            viewModel.getListCocktail()
                            filterIndicator.visibility = View.GONE
                        } else {
                            viewModel.filterCocktail(filter)
                            filterIndicator.visibility = View.VISIBLE
                        }
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
                        if (filter.alcoholic == null && filter.category == null && filter.glass == null) {
                            viewModel.searchCocktail(query.toString())
                        } else {
                            val filteredList = list.filter {
                                it.strDrink.lowercase().contains(query.toString().lowercase())
                            }
                            if(filteredList.isEmpty()){
                                emptyLayout.root.visibility = View.VISIBLE
                            } else {
                                emptyLayout.root.visibility = View.INVISIBLE
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
            adapter.setOnClickData {
                val intent = Intent(this@MainActivity, DetailCocktailActivity::class.java)
                intent.putExtra(DetailCocktailActivity.EXTRA_ID, it.idDrink)
                startActivity(intent)
            }
        }
    }

    override fun onChanged(t: MainViewModel.MainUiState?) {
        when (t) {
            is MainViewModel.MainUiState.Success -> {
                binding.progressBar.visibility = View.INVISIBLE
                if(t.listCocktail.isEmpty()){
                    binding.rvCocktail.visibility = View.INVISIBLE
                    binding.emptyLayout.root.visibility = View.VISIBLE
                } else {
                    binding.rvCocktail.visibility = View.VISIBLE
                    binding.emptyLayout.root.visibility = View.INVISIBLE
                }

                list.clear()
                list.addAll(t.listCocktail)
                adapter.submitList(t.listCocktail)
                binding.rvCocktail.scrollToPosition(0)
            }
            is MainViewModel.MainUiState.Failed -> {
                binding.progressBar.visibility = View.INVISIBLE
                binding.rvCocktail.visibility = View.VISIBLE
                binding.emptyLayout.root.visibility = View.INVISIBLE
                Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
            }
            is MainViewModel.MainUiState.Loading -> {
                binding.progressBar.visibility = View.VISIBLE
                binding.rvCocktail.visibility = View.INVISIBLE
                binding.emptyLayout.root.visibility = View.INVISIBLE
            }
        }
    }

}