package com.kharismarizqii.cocktail.data.remote

import com.kharismarizqii.cocktail.data.remote.response.CocktailResponse
import com.kharismarizqii.cocktail.data.remote.service.ApiService
import com.kharismarizqii.core_cocktail.vo.Either
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Kharisma Rizqi on 19/11/21
 * github.com/kharismarizqii
 */
class RemoteDataSource @Inject constructor(private val api: ApiService) {
    suspend fun getListCocktail(): Either<Throwable, CocktailResponse> = request {
        api.getListCocktail()
    }
    suspend fun searchCocktail(q: String): Either<Throwable, CocktailResponse> = request {
        api.searchCocktail(q)
    }

    suspend fun filterCocktail(queries: Map<String, String>) = request {
        api.filterCocktail(queries)
    }

    suspend fun getDetailCocktail(id: String) = request {
        api.getDetailCocktail(id)
    }



    suspend fun <T> request(apiCall: suspend () -> Response<T>): Either<Throwable, T> {
        return try {
            val response = apiCall.invoke()
            when {
                response.isSuccessful -> Either.Success(
                    response.body()!!,
                    response.code(),
                    response.message()
                )
                else -> Either.Failed(Throwable("\"Unknown error from server\""))
            }
        } catch (t: Throwable) {
            Either.Failed(t)
        }
    }
}