package com.kharismarizqii.cocktail.data.remote.mapper

import com.kharismarizqii.cocktail.data.remote.response.FilterAlcoholicResponse
import com.kharismarizqii.cocktail.domain.model.FilterQuery
import com.kharismarizqii.core_cocktail.abstraction.BaseResponseMapper

/**
 * Created by Kharisma Rizqi on 21/11/21
 * github.com/kharismarizqii
 */
class FilterAlcoholicMapper: BaseResponseMapper<FilterAlcoholicResponse, List<FilterQuery>> {
    override fun mapToDomain(raw: FilterAlcoholicResponse): List<FilterQuery> {
        val list = ArrayList<FilterQuery>()
        raw.drinks.map {
            list.add(FilterQuery(it.strAlcoholic))
        }
        return list
    }
}