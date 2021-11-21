package com.kharismarizqii.cocktail.data.remote.service

import com.kharismarizqii.cocktail.data.remote.response.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

/**
 * Created by Kharisma Rizqi on 19/11/21
 * github.com/kharismarizqii
 */
interface ApiService {
    @GET("search.php?f=a")
    suspend fun getListCocktail(): Response<CocktailResponse>

    @GET("search.php")
    suspend fun searchCocktail(@Query("s") query: String): Response<CocktailResponse>

    @GET("filter.php")
    suspend fun filterCocktail(@QueryMap queries: Map<String, String>): Response<CocktailResponse>

    @GET("lookup.php")
    suspend fun getDetailCocktail(@Query("i") id: String): Response<DetailCocktailResponse>

    @GET("list.php?c=list")
    suspend fun getFilterCategory(): Response<FilterCategoryResponse>

    @GET("list.php?g=list")
    suspend fun getFilterGlass(): Response<FilterGlassResponse>

    @GET("list.php?a=list")
    suspend fun getFilterAlcoholic(): Response<FilterAlcoholicResponse>


}