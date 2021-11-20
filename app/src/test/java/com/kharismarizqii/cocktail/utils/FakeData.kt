package com.kharismarizqii.cocktail.utils

import com.kharismarizqii.cocktail.Faker
import com.kharismarizqii.cocktail.data.remote.response.CocktailResponse
import com.kharismarizqii.cocktail.domain.model.Cocktail

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
object FakeData {
    val cocktailResponse = CocktailResponse.Drink(Faker.string, Faker.string, Faker.string)
    val listCocktailResponse = CocktailResponse(listOf(cocktailResponse, cocktailResponse, cocktailResponse))

    val cocktailDomain = Cocktail(Faker.string, Faker.string, Faker.string)
    val listCocktailDomain = listOf(cocktailDomain, cocktailDomain, cocktailDomain)
}