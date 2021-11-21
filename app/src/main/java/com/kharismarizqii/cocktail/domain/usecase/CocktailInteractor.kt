package com.kharismarizqii.cocktail.domain.usecase

import com.kharismarizqii.cocktail.domain.model.Cocktail
import com.kharismarizqii.cocktail.domain.model.CocktailFilter
import com.kharismarizqii.cocktail.domain.model.FilterQuery
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

    override suspend fun searchCocktail(q: String): Either<Throwable, List<Cocktail>> {
        return repository.searchCocktail(q)
    }

    override suspend fun filterCocktail(filter: CocktailFilter): Either<Throwable, List<Cocktail>> {
        val queries = HashMap<String, String>()
        filter.alcoholic?.let { queries.put("a", it) }
        filter.category?.let { queries.put("c", it) }
        filter.glass?.let { queries.put("g", it) }

        return repository.filterCocktail(queries)
    }

    override suspend fun getFilterAlcoholic(): Either<Throwable, List<FilterQuery>> {
        return repository.getFilterAlcoholic()
    }

    override suspend fun getFilterGlass(): Either<Throwable, List<FilterQuery>> {
        return repository.getFilterGlass()
    }

    override suspend fun getFilterCategory(): Either<Throwable, List<FilterQuery>> {
        return repository.getFilterCategory()
    }
}