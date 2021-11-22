package com.kharismarizqii.cocktail.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.kharismarizqii.cocktail.databinding.ItemCocktailBinding
import com.kharismarizqii.cocktail.domain.model.Cocktail
import com.kharismarizqii.core_cocktail.abstraction.BaseRecyclerViewAdapter
import com.kharismarizqii.core_cocktail.abstraction.BaseViewHolder

/**
 * Created by Kharisma Rizqi on 19/11/21
 * github.com/kharismarizqii
 */
class MainAdapter : BaseRecyclerViewAdapter<MainAdapter.MainViewHolder>() {

    private val listData: MutableList<Cocktail> = ArrayList()

    lateinit var onClick: (data: Cocktail) -> Unit

    fun submitList(newList: List<Cocktail>) {
        listData.clear()
        listData.addAll(newList)
        notifyDataSetChanged()
    }

    inner class MainViewHolder(itemView: ItemCocktailBinding) :
        BaseViewHolder<Cocktail, ItemCocktailBinding>(itemView) {
        override fun bind(data: Cocktail) {
            with(binding){
                Glide.with(itemView.context).load(data.strDrinkThumb).into(binding.ivCocktail)
                binding.tvTitle.text = data.strDrink
                root.setOnClickListener {
                    onClick.invoke(data)
                }
            }
        }
    }

    override val viewHolderInflater: (LayoutInflater, ViewGroup, Boolean) -> MainViewHolder
        get() = { layoutInflater: LayoutInflater, viewGroup: ViewGroup, b: Boolean ->
            MainViewHolder(ItemCocktailBinding.inflate(layoutInflater, viewGroup, b))
        }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    fun setOnClickData(onClick: (data: Cocktail) -> Unit) {
        this.onClick = onClick
    }
}