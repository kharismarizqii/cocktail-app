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
            val listIngredients: List<String> = createIngredientsList(detail)
            val listMeasure: List<String> = createMeasureList(detail)

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

    private fun createMeasureList(detail: DetailCocktailResponse.Drink): List<String> {
        val listMeasure = ArrayList<String>()
        with(detail){
            strMeasure1?.let { listMeasure.add(it) }
            strMeasure2?.let { listMeasure.add(it) }
            strMeasure3?.let { listMeasure.add(it) }
            strMeasure4?.let { listMeasure.add(it) }
            strMeasure5?.let { listMeasure.add(it) }
            strMeasure6?.let { listMeasure.add(it) }
            strMeasure7?.let { listMeasure.add(it) }
            strMeasure8?.let { listMeasure.add(it) }
            strMeasure9?.let { listMeasure.add(it) }
            strMeasure10?.let { listMeasure.add(it) }
            strMeasure11?.let { listMeasure.add(it) }
            strMeasure12?.let { listMeasure.add(it) }
            strMeasure13?.let { listMeasure.add(it) }
            strMeasure14?.let { listMeasure.add(it) }
            strMeasure15?.let { listMeasure.add(it) }
        }
        return listMeasure
    }

    private fun createIngredientsList(detail: DetailCocktailResponse.Drink): List<String> {
        val listIngredients = ArrayList<String>()
        with(detail){
            strIngredient1?.let { listIngredients.add(it) }
            strIngredient2?.let { listIngredients.add(it) }
            strIngredient3?.let { listIngredients.add(it) }
            strIngredient4?.let { listIngredients.add(it) }
            strIngredient5?.let { listIngredients.add(it) }
            strIngredient6?.let { listIngredients.add(it) }
            strIngredient7?.let { listIngredients.add(it) }
            strIngredient8?.let { listIngredients.add(it) }
            strIngredient9?.let { listIngredients.add(it) }
            strIngredient10?.let { listIngredients.add(it) }
            strIngredient11?.let { listIngredients.add(it) }
            strIngredient12?.let { listIngredients.add(it) }
            strIngredient13?.let { listIngredients.add(it) }
            strIngredient14?.let { listIngredients.add(it) }
            strIngredient15?.let { listIngredients.add(it) }
        }
        return listIngredients
    }
}