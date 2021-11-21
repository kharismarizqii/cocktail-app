package com.kharismarizqii.cocktail.data.remote.mapper

import com.kharismarizqii.cocktail.data.remote.response.FilterGlassResponse
import com.kharismarizqii.cocktail.domain.model.FilterQuery
import com.kharismarizqii.core_cocktail.abstraction.BaseResponseMapper

/**
 * Created by Kharisma Rizqi on 21/11/21
 * github.com/kharismarizqii
 */
class FilterGlassMapper: BaseResponseMapper<FilterGlassResponse, List<FilterQuery>> {
    override fun mapToDomain(raw: FilterGlassResponse): List<FilterQuery> {
        val list = ArrayList<FilterQuery>()
        raw.drinks.map {
            list.add(FilterQuery(it.strGlass))
        }
        return list
    }
}