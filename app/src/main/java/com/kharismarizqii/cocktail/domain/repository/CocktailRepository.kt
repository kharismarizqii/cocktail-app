package com.kharismarizqii.cocktail.domain.repository

import com.kharismarizqii.cocktail.domain.model.Cocktail
import com.kharismarizqii.cocktail.domain.model.DetailCocktail
import com.kharismarizqii.cocktail.domain.model.FilterQuery
import com.kharismarizqii.core_cocktail.vo.Either

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
interface CocktailRepository {
    suspend fun getListCokctail(): Either<Throwable,List<Cocktail>>
    suspend fun searchCocktail(q: String): Either<Throwable, List<Cocktail>>
    suspend fun filterCocktail(queries: Map<String, String>): Either<Throwable, List<Cocktail>>
    suspend fun getDetailCocktail(id: String): Either<Throwable, DetailCocktail>
    suspend fun getFilterAlcoholic(): Either<Throwable, List<FilterQuery>>
    suspend fun getFilterGlass(): Either<Throwable, List<FilterQuery>>
    suspend fun getFilterCategory(): Either<Throwable, List<FilterQuery>>
}