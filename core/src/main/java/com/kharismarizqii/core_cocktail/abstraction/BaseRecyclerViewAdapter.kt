package com.kharismarizqii.core_cocktail.abstraction

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Kharisma Rizqi on 19/11/21
 * github.com/kharismarizqii
 */
abstract class BaseRecyclerViewAdapter<ViewHolder: RecyclerView.ViewHolder>: RecyclerView.Adapter<ViewHolder>() {
    protected abstract val viewHolderInflater: (LayoutInflater, ViewGroup, Boolean) -> ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return viewHolderInflater.invoke(LayoutInflater.from(parent.context), parent, false)
    }
}