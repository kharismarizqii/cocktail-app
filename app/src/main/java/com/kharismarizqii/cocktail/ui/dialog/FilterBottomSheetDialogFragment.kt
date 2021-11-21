package com.kharismarizqii.cocktail.ui.dialog

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kharismarizqii.cocktail.R
import com.kharismarizqii.cocktail.databinding.BottomFilterListBinding
import com.kharismarizqii.cocktail.domain.model.FilterQuery
import com.kharismarizqii.cocktail.utils.extensions.dp
import com.kharismarizqii.core_cocktail.abstraction.BaseBottomDialogBinding
import com.kharismarizqii.widget.recyclerview.MarginItemDecoration

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
class FilterBottomSheetDialogFragment : BaseBottomDialogBinding<BottomFilterListBinding>() {

    private val adapter: FilterBottomSheetAdapter by lazy { FilterBottomSheetAdapter() }
    private var onClick: ((String, Int) -> Unit)? = null

    var title = ""

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> BottomFilterListBinding
        get() = { inflater, viewGroup, boolean ->
            BottomFilterListBinding.inflate(inflater, viewGroup, boolean)
        }

    override fun setupView() {
        binding.tvTitleFilter.text = title
        binding.recyclerBottomSheet.adapter = adapter
        binding.recyclerBottomSheet.addItemDecoration(MarginItemDecoration(spaceSize = 32.dp,leftMargin = 24.dp,rightMargin = 24.dp,bottomMargin = 16.dp))
    }

    override fun getTheme(): Int {
        return R.style.Theme_Cocktail_BottomSheetTheme
    }

    fun setOnClickItemListener(
        listData: List<FilterQuery>,
        titleDialog: String,
        onClick: (String, Int) -> Unit
    ) {
        setItemsFilter(listData)
        setTitleDialog(titleDialog)
        adapter.setOnClickItemListener { data, position -> onClick.invoke(data, position) }
        this.onClick = onClick
    }

    private fun setItemsFilter(listData: List<FilterQuery>) {
        val listFilter: MutableList<String> = mutableListOf()
        listData.forEach { listFilter.add(it.query) }
        adapter.submitList(listFilter)
    }


    fun setTitleDialog(title: String) {
        this.title = title
    }
}