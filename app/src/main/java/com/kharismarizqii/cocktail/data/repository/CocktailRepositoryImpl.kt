package com.kharismarizqii.cocktail.data.repository

import com.kharismarizqii.cocktail.data.remote.RemoteDataSource
import com.kharismarizqii.cocktail.data.remote.mapper.CocktailMapper
import com.kharismarizqii.cocktail.domain.model.Cocktail
import com.kharismarizqii.cocktail.domain.model.DetailCocktail
import com.kharismarizqii.cocktail.domain.repository.CocktailRepository
import com.kharismarizqii.core_cocktail.vo.Either
import javax.inject.Inject

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
class CocktailRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val listCocktailMapper: CocktailMapper
): CocktailRepository {
    override suspend fun getListCokctail(): Either<Throwable, List<Cocktail>> {
        val response = remoteDataSource.getListCocktail()
        return when(response){
            is Either.Failed -> {
                Either.Failed(response.failure)
            }
            is Either.Success -> {
                Either.Success(listCocktailMapper.mapToDomain(response.body), response.code, response.message)
            }
        }
    }

    override suspend fun searchCocktail(q: String): Either<Throwable, List<Cocktail>> {
        val response = remoteDataSource.searchCocktail(q)
        return when(response){
            is Either.Success -> {
                Either.Success(listCocktailMapper.mapToDomain(response.body), response.code, response.message)
            }
            is Either.Failed -> {
                Either.Failed(response.failure)
            }
        }
    }

    override suspend fun filterCocktail(queries: Map<String, String>): Either<Throwable, List<Cocktail>> {
        TODO("Not yet implemented")
    }

    override suspend fun getDetailCocktail(id: String): Either<Throwable, DetailCocktail> {
        TODO("Not yet implemented")
    }

}