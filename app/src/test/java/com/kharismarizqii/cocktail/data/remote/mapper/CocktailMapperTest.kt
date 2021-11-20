package com.kharismarizqii.cocktail.data.remote.mapper

import com.kharismarizqii.cocktail.utils.FakeData
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
class CocktailMapperTest{
    lateinit var mapper: CocktailMapper

    @Before
    fun setUp(){
        mapper = CocktailMapper()
    }
    @Test
    fun `Should return domain when maping response to domain`(){
        val result = mapper.mapToDomain(FakeData.listCocktailResponse)
        assertEquals(FakeData.listCocktailDomain, result)
    }
}