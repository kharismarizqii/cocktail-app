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
    val strIngredient1: String,
    val strIngredient2: String,
    val strIngredient3: String,
    val strIngredient4: String,
    val strMeasure1: String,
    val strMeasure2: String,
    val strMeasure3: String,
    val strMeasure4: String,
)
