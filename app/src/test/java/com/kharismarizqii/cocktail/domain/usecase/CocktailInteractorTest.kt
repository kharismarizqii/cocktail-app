package com.kharismarizqii.cocktail.domain.usecase

import com.kharismarizqii.cocktail.domain.repository.CocktailRepository
import com.kharismarizqii.cocktail.helper.FakeCocktailRepository
import com.kharismarizqii.cocktail.utils.FakeData
import com.kharismarizqii.core_cocktail.vo.Either
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
class CocktailInteractorTest{
    lateinit var repository: CocktailRepository

    @Before
    fun setUp(){
        repository = FakeCocktailRepository()
    }

    @Test
    fun `Should return list cocktail when getListCocktail is called`(){
        runBlocking {
            val result = repository.getListCokctail()
            assertEquals(Either.Success(FakeData.listCocktailDomain, 200, "OK"), result)
        }
    }
}