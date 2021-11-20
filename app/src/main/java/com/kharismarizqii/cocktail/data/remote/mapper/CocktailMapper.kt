package com.kharismarizqii.cocktail.data.remote.mapper

import com.kharismarizqii.cocktail.data.remote.response.CocktailResponse
import com.kharismarizqii.cocktail.domain.model.Cocktail
import com.kharismarizqii.core_cocktail.abstraction.BaseResponseMapper

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
class CocktailMapper: BaseResponseMapper<CocktailResponse, List<Cocktail>> {
    override fun mapToDomain(raw: CocktailResponse): List<Cocktail> {
        return raw.drinks.map {
            Cocktail(
                idDrink = it.idDrink,
                strDrink = it.strDrink,
                strDrinkThumb = it.strDrinkThumb
            )
        }
    }
}