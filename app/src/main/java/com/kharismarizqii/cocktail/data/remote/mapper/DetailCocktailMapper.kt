package com.kharismarizqii.cocktail.data.remote.mapper

import com.kharismarizqii.cocktail.data.remote.response.DetailCocktailResponse
import com.kharismarizqii.cocktail.domain.model.DetailCocktail
import com.kharismarizqii.core_cocktail.abstraction.BaseResponseMapper
import java.lang.IllegalArgumentException

/**
 * Created by Kharisma Rizqi on 22/11/21
 * github.com/kharismarizqii
 */
class DetailCocktailMapper: BaseResponseMapper<DetailCocktailResponse, DetailCocktail> {
    override fun mapToDomain(raw: DetailCocktailResponse): DetailCocktail {
        return if(raw.drinks.isNotEmpty()){
            val detail = raw.drinks[0]
            val listIngredients = ArrayList<String>()
            with(detail){
                strIngredient1?.let { listIngredients.add(it) }
                strIngredient2?.let { listIngredients.add(it) }
                strIngredient3?.let { listIngredients.add(it) }
                strIngredient4?.let { listIngredients.add(it) }
            }
            val listMeasure = ArrayList<String>()
            with(detail){
                strMeasure1?.let { listMeasure.add(it) }
                strMeasure2?.let { listMeasure.add(it) }
                strMeasure3?.let { listMeasure.add(it) }
                strMeasure4?.let { listMeasure.add(it) }
            }
            DetailCocktail(
                idDrink = detail.idDrink?:"",
                strDrink = detail.strDrink?:"",
                strCategory = detail.strCategory?:"",
                strAlcoholic = detail.strAlcoholic?:"",
                strGlass = detail.strGlass?:"",
                strInstructions = detail.strInstructions?:"",
                strDrinkThumb = detail.strDrinkThumb?:"",
                listIngredients = listIngredients,
                listMeasure = listMeasure
            )
        } else {
            throw IllegalArgumentException()
        }
    }
}