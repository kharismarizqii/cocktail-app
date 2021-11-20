package com.kharismarizqii.cocktail.domain.usecase

import com.kharismarizqii.cocktail.domain.model.Cocktail
import com.kharismarizqii.cocktail.domain.repository.CocktailRepository
import com.kharismarizqii.core_cocktail.vo.Either

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
class CocktailInteractor(
    private val repository: CocktailRepository
): CocktailUseCase {
    override suspend fun getListCocktail(): Either<Throwable, List<Cocktail>> {
        return repository.getListCokctail()
    }
}