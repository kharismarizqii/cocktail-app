package com.kharismarizqii.cocktail.utils

import com.kharismarizqii.cocktail.Faker
import com.kharismarizqii.cocktail.data.remote.response.*
import com.kharismarizqii.cocktail.domain.model.Cocktail
import com.kharismarizqii.cocktail.domain.model.DetailCocktail
import com.kharismarizqii.cocktail.domain.model.FilterQuery

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
object FakeData {
    val cocktailResponse = CocktailResponse.Drink(Faker.string, Faker.string, Faker.string)
    val listCocktailResponse =
        CocktailResponse(listOf(cocktailResponse, cocktailResponse, cocktailResponse))

    val cocktailDomain = Cocktail(Faker.string, Faker.string, Faker.string)
    val listCocktailDomain = listOf(cocktailDomain, cocktailDomain, cocktailDomain)

    val drinkDetailCocktailResponse = DetailCocktailResponse.Drink(
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string
    )
    val detailCocktailResponse = DetailCocktailResponse(listOf(drinkDetailCocktailResponse))

    val listIngredients = listOf<String>(
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string
    )
    val listMeasure = listOf<String>(
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string
    )
    val detailCocktailDomain = DetailCocktail(
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        Faker.string,
        listIngredients,
        listMeasure
    )

    val contentFilterAlcoholicResponse = FilterAlcoholicResponse.Drink(Faker.string)
    val filterAlcoholicResponse = FilterAlcoholicResponse(listOf(contentFilterAlcoholicResponse))

    val contentFilterCategoryResponse = FilterCategoryResponse.Drink(Faker.string)
    val filterCategoryResponse = FilterCategoryResponse(listOf(contentFilterCategoryResponse))

    val contentFilterGlassResponse = FilterGlassResponse.Drink(Faker.string)
    val filterGlassResponse = FilterGlassResponse(listOf(contentFilterGlassResponse))

    val filterQuery = FilterQuery(Faker.string)
    val filterDomain = listOf(filterQuery)
}