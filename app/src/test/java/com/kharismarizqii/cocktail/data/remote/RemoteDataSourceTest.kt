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
}