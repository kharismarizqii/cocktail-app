package com.kharismarizqii.cocktail.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
data class DetailCocktail(
    val idDrink: String,
    val strDrink: String,
    val strCategory: String,
    val strAlcoholic: String,
    val strGlass: String,
    val strInstructions: String,
    val strDrinkThumb: String,
    val listIngredients: List<String>,
    val listMeasure: List<String>
)
