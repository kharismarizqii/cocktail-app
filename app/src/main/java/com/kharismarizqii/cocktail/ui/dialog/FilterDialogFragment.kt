package com.kharismarizqii.cocktail.ui.dialog

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kharismarizqii.cocktail.databinding.DialogFilterBinding
import com.kharismarizqii.cocktail.domain.model.CocktailFilter
import com.kharismarizqii.cocktail.domain.model.FilterData
import com.kharismarizqii.core_cocktail.abstraction.BaseFragmentDialogBinding

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
class FilterDialogFragment(
    private val filter: CocktailFilter,
    private val onFilter: (filter: CocktailFilter) -> Unit
) : BaseFragmentDialogBinding<DialogFilterBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogFilterBinding
        get() = { inflater, viewGroup, boolean ->
            DialogFilterBinding.inflate(inflater, viewGroup, boolean)
        }

    override fun setupView() {
        val fakeList = listOf(
            FilterData("Kharisma"),
            FilterData("The Beatles"),
            FilterData("Abcdefg"),
            FilterData("Kharisma"),
            FilterData("The Beatles"),
            FilterData("Abcdefg"),
            FilterData("Kharisma"),
            FilterData("The Beatles"),
            FilterData("Abcdefg"),
            FilterData("Kharisma"),
            FilterData("The Beatles"),
            FilterData("Abcdefg")
        )
        binding.filterAlcoholic.setOnClickFilterListener {
            setAlcoholicSpinner(fakeList)
        }
        binding.filterCategory.setOnClickFilterListener {
            setAlcoholicSpinner(fakeList)
        }
        binding.filterGlass.setOnClickFilterListener {
            setAlcoholicSpinner(fakeList)
        }
    }

    private fun setAlcoholicSpinner(listData: List<FilterData>) {
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
            //set final data
//            filter. = FilterData(
//                listData[position].id,
//                data
//            )
            binding.filterAlcoholic.setTextFilter(data)
            bottomDialogPartner.dismiss()
        }
    }

    companion object {
        fun build(
            filter: CocktailFilter,
            onFilter: (filter: CocktailFilter) -> Unit
        ) = FilterDialogFragment(filter, onFilter)
    }
}