package com.kharismarizqii.cocktail.data.repository

import com.kharismarizqii.cocktail.data.remote.RemoteDataSource
import com.kharismarizqii.cocktail.data.remote.mapper.CocktailMapper
import com.kharismarizqii.cocktail.domain.repository.CocktailRepository
import com.kharismarizqii.cocktail.utils.FakeData
import com.kharismarizqii.core_cocktail.vo.Either
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
class CocktailRepositoryImplTest{
    lateinit var remoteDataSource: RemoteDataSource
    lateinit var listCocktailMapper: CocktailMapper
    lateinit var repository: CocktailRepository

    @Before
    fun setUp(){
        remoteDataSource = mockk()
        listCocktailMapper = mockk()
        every { listCocktailMapper.mapToDomain(any()) } returns FakeData.listCocktailDomain
    }

    @Test
    fun `Should return list cocktail when getListCocktail() is called`(){
        coEvery { remoteDataSource.getListCocktail() } returns Either.Success(FakeData.listCocktailResponse, 200, "OK")
        repository = CocktailRepositoryImpl(remoteDataSource, listCocktailMapper)
        runBlocking {
            val result = repository.getListCokctail()
            assertEquals(Either.Success(FakeData.listCocktailDomain, 200, "OK"), result)
        }
    }
}