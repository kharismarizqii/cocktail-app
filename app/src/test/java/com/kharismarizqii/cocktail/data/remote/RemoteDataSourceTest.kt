package com.kharismarizqii.cocktail.data.remote

import com.kharismarizqii.cocktail.data.remote.service.ApiService
import com.kharismarizqii.cocktail.utils.FakeData
import com.kharismarizqii.core_cocktail.vo.Either
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Response

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
class RemoteDataSourceTest{
    lateinit var api: ApiService
    lateinit var remoteDataSource: RemoteDataSource
    @Before
    fun setUp(){
        api = mockk()
        coEvery { api.getListCocktail() } returns Response.success(FakeData.listCocktailResponse)
        coEvery { api.searchCocktail(any()) } returns Response.success(FakeData.listCocktailResponse)
        coEvery { api.filterCocktail(any()) } returns Response.success(FakeData.listCocktailResponse)
        coEvery { api.getFilterAlcoholic() } returns Response.success(FakeData.filterAlcoholicResponse)
        coEvery { api.getFilterCategory() } returns Response.success(FakeData.filterCategoryResponse)
        coEvery { api.getFilterGlass() } returns Response.success(FakeData.filterGlassResponse)
        coEvery { api.getDetailCocktail(any()) } returns Response.success(FakeData.detailCocktailResponse)
        remoteDataSource = RemoteDataSource(api)
    }

    @Test
    fun `Should return list cocktail response when getListCocktail() is called`(){
        runBlocking {
            val result = remoteDataSource.getListCocktail()
            assertEquals(Either.Success(FakeData.listCocktailResponse, 200, "OK"), result)
        }
    }

    @Test
    fun `Should return list cocktail response when searchCocktail() is called`(){
        runBlocking {
            val result = remoteDataSource.searchCocktail("martini")
            assertEquals(Either.Success(FakeData.listCocktailResponse, 200, "OK"), result)
        }
    }

    @Test
    fun `Should return list cocktail response when filterCocktail() is called`(){
        runBlocking {
            val result = remoteDataSource.filterCocktail(mapOf("a" to "alcoholic"))
            assertEquals(Either.Success(FakeData.listCocktailResponse, 200, "OK"), result)
        }
    }

    @Test
    fun `Should return filter alcoholic response when getFilterAlcoholic() is called`(){
        runBlocking {
            val result = remoteDataSource.getFilterAlcoholic()
            assertEquals(Either.Success(FakeData.filterAlcoholicResponse, 200, "OK"), result)
        }
    }

    @Test
    fun `Should return filter category response when getFilterCategory() is called`(){
        runBlocking {
            val result = remoteDataSource.getFilterCategory()
            assertEquals(Either.Success(FakeData.filterCategoryResponse, 200, "OK"), result)
        }
    }

    @Test
    fun `Should return filter glass response when getFilterGlass() is called`(){
        runBlocking {
            val result = remoteDataSource.getFilterGlass()
            assertEquals(Either.Success(FakeData.filterGlassResponse, 200, "OK"), result)
        }
    }

    @Test
    fun `Should return detail cocktail response when getDetailCocktail() is called`(){
        runBlocking {
            val result = remoteDataSource.getDetailCocktail("1234")
            assertEquals(Either.Success(FakeData.detailCocktailResponse, 200, "OK"), result)
        }
    }
}