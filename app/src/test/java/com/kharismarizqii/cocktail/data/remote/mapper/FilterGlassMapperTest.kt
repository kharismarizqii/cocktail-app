package com.kharismarizqii.cocktail.data.remote.mapper

import com.kharismarizqii.cocktail.utils.FakeData
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created by Kharisma Rizqi on 22/11/21
 * github.com/kharismarizqii
 */
class FilterGlassMapperTest{

    lateinit var mapper: FilterGlassMapper

    @Before
    fun setUp(){
        mapper = FilterGlassMapper()
    }

    @Test
    fun `Should return domain when maping response to domain`(){
        val result = mapper.mapToDomain(FakeData.filterGlassResponse)
        assertEquals(FakeData.filterDomain, result)
    }
}