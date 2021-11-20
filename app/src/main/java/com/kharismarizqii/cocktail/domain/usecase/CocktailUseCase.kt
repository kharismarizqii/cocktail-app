package com.kharismarizqii.cocktail.domain.usecase

import com.kharismarizqii.cocktail.domain.model.Cocktail
import com.kharismarizqii.core_cocktail.vo.Either

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
interface CocktailUseCase {
    suspend fun getListCocktail(): Either<Throwable, List<Cocktail>>
    suspend fun searchCocktail(q: String): Either<Throwable, List<Cocktail>>
}