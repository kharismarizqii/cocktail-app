package com.kharismarizqii.cocktail.data.remote.mapper

import com.kharismarizqii.cocktail.data.remote.response.FilterCategoryResponse
import com.kharismarizqii.cocktail.domain.model.FilterQuery
import com.kharismarizqii.core_cocktail.abstraction.BaseResponseMapper

/**
 * Created by Kharisma Rizqi on 21/11/21
 * github.com/kharismarizqii
 */
class FilterCategoryMapper: BaseResponseMapper<FilterCategoryResponse, List<FilterQuery>> {
    override fun mapToDomain(raw: FilterCategoryResponse): List<FilterQuery> {
        val list = ArrayList<FilterQuery>()
        raw.drinks.map {
            list.add(FilterQuery(it.strCategory))
        }
        return list
    }
}