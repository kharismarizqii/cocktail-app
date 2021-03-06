package com.kharismarizqii.cocktail.helper

import com.kharismarizqii.cocktail.domain.model.Cocktail
import com.kharismarizqii.cocktail.domain.model.DetailCocktail
import com.kharismarizqii.cocktail.domain.model.FilterQuery
import com.kharismarizqii.cocktail.domain.repository.CocktailRepository
import com.kharismarizqii.cocktail.utils.FakeData
import com.kharismarizqii.core_cocktail.vo.Either

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
class FakeCocktailRepository: CocktailRepository {
    override suspend fun getListCokctail(): Either<Throwable, List<Cocktail>> {
        return Either.Success(FakeData.listCocktailDomain, 200, "OK")
    }

    override suspend fun searchCocktail(q: String): Either<Throwable, List<Cocktail>> {
        return Either.Success(FakeData.listCocktailDomain, 200, "OK")
    }

    override suspend fun filterCocktail(queries: Map<String, String>): Either<Throwable, List<Cocktail>> {
        return Either.Success(FakeData.listCocktailDomain, 200, "OK")
    }

    override suspend fun getDetailCocktail(id: String): Either<Throwable, DetailCocktail> {
        return Either.Success(FakeData.detailCocktailDomain, 200, "OK")
    }

    override suspend fun getFilterAlcoholic(): Either<Throwable, List<FilterQuery>> {
        return Either.Success(FakeData.filterDomain, 200, "OK")
    }

    override suspend fun getFilterGlass(): Either<Throwable, List<FilterQuery>> {
        return Either.Success(FakeData.filterDomain, 200, "OK")
    }

    override suspend fun getFilterCategory(): Either<Throwable, List<FilterQuery>> {
        return Either.Success(FakeData.filterDomain, 200, "OK")
    }
}