package com.kharismarizqii.cocktail.data.repository

import com.kharismarizqii.cocktail.data.remote.RemoteDataSource
import com.kharismarizqii.cocktail.data.remote.mapper.*
import com.kharismarizqii.cocktail.domain.model.Cocktail
import com.kharismarizqii.cocktail.domain.model.DetailCocktail
import com.kharismarizqii.cocktail.domain.model.FilterQuery
import com.kharismarizqii.cocktail.domain.repository.CocktailRepository
import com.kharismarizqii.core_cocktail.vo.Either
import javax.inject.Inject

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
class CocktailRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val listCocktailMapper: CocktailMapper,
    private val filterAlcoholicMapper: FilterAlcoholicMapper,
    private val filterCategoryMapper: FilterCategoryMapper,
    private val filterGlassMapper: FilterGlassMapper,
    private val detailCocktailMapper: DetailCocktailMapper,
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
        val response = remoteDataSource.filterCocktail(queries)
        return when(response){
            is Either.Success -> {
                Either.Success(listCocktailMapper.mapToDomain(response.body), response.code, response.message)
            }
            is Either.Failed -> {
                Either.Failed(response.failure)
            }
        }
    }

    override suspend fun getDetailCocktail(id: String): Either<Throwable, DetailCocktail> {
        val response = remoteDataSource.getDetailCocktail(id)
        return when(response) {
            is Either.Success -> {
                Either.Success(detailCocktailMapper.mapToDomain(response.body), response.code, response.message)
            }
            is Either.Failed -> {
                Either.Failed(response.failure)
            }
        }
    }

    override suspend fun getFilterAlcoholic(): Either<Throwable, List<FilterQuery>> {
        val response = remoteDataSource.getFilterAlcoholic()
        return when(response){
            is Either.Success -> {
                Either.Success(filterAlcoholicMapper.mapToDomain(response.body),response.code, response.message)
            }
            is Either.Failed -> {
                Either.Failed(response.failure)
            }
        }
    }

    override suspend fun getFilterGlass(): Either<Throwable, List<FilterQuery>> {
        val response = remoteDataSource.getFilterGlass()
        return when(response){
            is Either.Success -> {
                Either.Success(filterGlassMapper.mapToDomain(response.body),response.code, response.message)
            }
            is Either.Failed -> {
                Either.Failed(response.failure)
            }
        }
    }

    override suspend fun getFilterCategory(): Either<Throwable, List<FilterQuery>> {
        val response = remoteDataSource.getFilterCategory()
        return when(response){
            is Either.Success -> {
                Either.Success(filterCategoryMapper.mapToDomain(response.body),response.code, response.message)
            }
            is Either.Failed -> {
                Either.Failed(response.failure)
            }
        }
    }

}