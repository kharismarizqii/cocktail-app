package com.kharismarizqii.cocktail.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.kharismarizqii.cocktail.MyApplication
import com.kharismarizqii.cocktail.databinding.DialogFilterBinding
import com.kharismarizqii.cocktail.domain.model.CocktailFilter
import com.kharismarizqii.cocktail.domain.model.FilterQuery
import com.kharismarizqii.cocktail.utils.extensions.disable
import com.kharismarizqii.cocktail.utils.extensions.enable
import com.kharismarizqii.core_cocktail.abstraction.BaseFragmentDialogBinding
import javax.inject.Inject

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
class FilterDialogFragment(
    private val filter: CocktailFilter,
    private val onFilter: (filter: CocktailFilter) -> Unit
) : BaseFragmentDialogBinding<DialogFilterBinding>(), Observer<FilterViewModel.FilterUiState> {

    @Inject
    lateinit var viewModel: FilterViewModel

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogFilterBinding
        get() = { inflater, viewGroup, boolean ->
            DialogFilterBinding.inflate(inflater, viewGroup, boolean)
        }

    override fun onAttach(context: Context) {
        (context.applicationContext as MyApplication).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun setupView() {
        disableAllFilter()
        viewModel.uiState.observe(viewLifecycleOwner, this)
        viewModel.getFilterAlcoholic()
        viewModel.getFilterCategory()
        viewModel.getFilterGlass()

        with(binding){
            btnClose.setOnClickListener { dismiss() }
            btnApplyFilter.setOnClickListener {
//                onFilter.invoke(filter)
                dismiss()
            }
        }
    }

    private fun disableAllFilter() {
        disable(binding.filterAlcoholic)
        disable(binding.filterCategory)
        disable(binding.filterGlass)
    }

    private fun setAlcoholicSpinner(listData: List<FilterQuery>) {
        //init dialog
        val bottomDialogPartner = FilterBottomSheetDialogFragment()
        bottomDialogPartner.show(
            childFragmentManager,
            FilterBottomSheetDialogFragment::class.java.simpleName
        )

        bottomDialogPartner.setOnClickItemListener(
            listData = listData,
            titleDialog = "Alcoholic"
        ) { data, position ->
            binding.filterAlcoholic.setTextFilter(data)
            bottomDialogPartner.dismiss()
        }
    }

    private fun setGlassSpinner(listData: List<FilterQuery>) {
        //init dialog
        val bottomDialogPartner = FilterBottomSheetDialogFragment()
        bottomDialogPartner.show(
            childFragmentManager,
            FilterBottomSheetDialogFragment::class.java.simpleName
        )

        bottomDialogPartner.setOnClickItemListener(
            listData = listData,
            titleDialog = "Glass"
        ) { data, position ->
            binding.filterGlass.setTextFilter(data)
            bottomDialogPartner.dismiss()
        }
    }

    private fun setCategorySpinner(listData: List<FilterQuery>) {
        //init dialog
        val bottomDialogPartner = FilterBottomSheetDialogFragment()
        bottomDialogPartner.show(
            childFragmentManager,
            FilterBottomSheetDialogFragment::class.java.simpleName
        )

        bottomDialogPartner.setOnClickItemListener(
            listData = listData,
            titleDialog = "Category"
        ) { data, position ->
            binding.filterCategory.setTextFilter(data)
            bottomDialogPartner.dismiss()
        }
    }

    companion object {
        fun build(
            filter: CocktailFilter,
            onFilter: (filter: CocktailFilter) -> Unit
        ) = FilterDialogFragment(filter, onFilter)
    }

    override fun onChanged(t: FilterViewModel.FilterUiState?) {
        when(t){
            is FilterViewModel.FilterUiState.FilterAlcoholicLoaded -> {
                enable(binding.filterAlcoholic)
                binding.filterAlcoholic.setOnClickFilterListener {
                    setAlcoholicSpinner(t.list)
                }
            }
            is FilterViewModel.FilterUiState.FilterCategoryLoaded -> {
                enable(binding.filterCategory)
                binding.filterCategory.setOnClickFilterListener {
                    setCategorySpinner(t.list)
                }
            }

            is FilterViewModel.FilterUiState.FilterGlassLoaded -> {
                enable(binding.filterGlass)
                binding.filterGlass.setOnClickFilterListener {
                    setGlassSpinner(t.list)
                }
            }
            is FilterViewModel.FilterUiState.FilterAlcoholicFailed -> {
                Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
            }

            is FilterViewModel.FilterUiState.FilterCategoryFailed -> {
                Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
            }

            is FilterViewModel.FilterUiState.FilterGlassFailed -> {
                Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
            }

        }
    }
}