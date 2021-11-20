package com.kharismarizqii.cocktail.ui.dialog

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kharismarizqii.cocktail.databinding.ItemFilterBottomDialogBinding
import com.kharismarizqii.core_cocktail.abstraction.BaseRecyclerViewAdapter
import com.kharismarizqii.core_cocktail.abstraction.BaseViewHolder

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
class FilterBottomSheetAdapter: BaseRecyclerViewAdapter<FilterBottomSheetAdapter.Holder>(){

    private var listData = mutableListOf<String>()
    private var onClick :((String,Int) -> Unit)? = null

    fun submitList(newList : List<String>){
        listData.clear()
        listData.addAll(newList)
        notifyDataSetChanged()
    }

    override val viewHolderInflater: (LayoutInflater, ViewGroup, Boolean) -> Holder
        get() = {layoutInflater, viewGroup, b ->
            Holder(ItemFilterBottomDialogBinding.inflate(layoutInflater,viewGroup,b))
        }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindWithPosition(data = listData[position],position)
    }

    inner class Holder (itemView: ItemFilterBottomDialogBinding) :
        BaseViewHolder<String, ItemFilterBottomDialogBinding>(itemView){
        override fun bind(data: String) {

        }

        override fun bindWithPosition(data: String, position: Int) {
            super.bindWithPosition(data, position)
            binding.tvArrayFilter.text = data
            binding.root.setOnClickListener {
                onClick?.invoke(data,position)
            }
        }

    }

    fun setOnClickItemListener(onClick: (String,Int)  -> Unit){
        this.onClick = onClick
    }
    override fun getItemCount(): Int {
        return listData.size
    }
}