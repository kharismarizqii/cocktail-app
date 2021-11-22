package com.kharismarizqii.cocktail.data.repository

import com.kharismarizqii.cocktail.data.remote.RemoteDataSource
import com.kharismarizqii.cocktail.data.remote.mapper.*
import com.kharismarizqii.cocktail.domain.repository.CocktailRepository
import com.kharismarizqii.cocktail.utils.FakeData
import com.kharismarizqii.core_cocktail.vo.Either
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
class CocktailRepositoryImplTest {
    lateinit var remoteDataSource: RemoteDataSource
    lateinit var listCocktailMapper: CocktailMapper
    lateinit var repository: CocktailRepository
    lateinit var filterAlcoholicMapper: FilterAlcoholicMapper
    lateinit var filterCategoryMapper: FilterCategoryMapper
    lateinit var filterGlassMapper: FilterGlassMapper
    lateinit var detailCocktailMapper: DetailCocktailMapper

    @Before
    fun setUp() {
        remoteDataSource = mockk()
        listCocktailMapper = mockk()
        filterAlcoholicMapper = mockk()
        filterCategoryMapper = mockk()
        filterGlassMapper = mockk()
        detailCocktailMapper = mockk()
        every { listCocktailMapper.mapToDomain(any()) } returns FakeData.listCocktailDomain
        every { filterAlcoholicMapper.mapToDomain(any()) } returns FakeData.filterDomain
        every { filterCategoryMapper.mapToDomain(any()) } returns FakeData.filterDomain
        every { filterGlassMapper.mapToDomain(any()) } returns FakeData.filterDomain
        every { detailCocktailMapper.mapToDomain(any()) } returns FakeData.detailCocktailDomain
        repository = CocktailRepositoryImpl(
            remoteDataSource,
            listCocktailMapper,
            filterAlcoholicMapper,
            filterCategoryMapper,
            filterGlassMapper,
            detailCocktailMapper
        )
    }

    @Test
    fun `Should return list cocktail when getListCocktail() is called`() {
        coEvery { remoteDataSource.getListCocktail() } returns Either.Success(
            FakeData.listCocktailResponse,
            200,
            "OK"
        )
        runBlocking {
            val result = repository.getListCokctail()
            assertEquals(Either.Success(FakeData.listCocktailDomain, 200, "OK"), result)
        }
    }

    @Test
    fun `Should return list cocktail when searchCocktail() is called`() {
        coEvery { remoteDataSource.searchCocktail(any()) } returns Either.Success(
            FakeData.listCocktailResponse,
            200,
            "OK"
        )
        runBlocking {
            val result = repository.searchCocktail("martini")
            assertEquals(Either.Success(FakeData.listCocktailDomain, 200, "OK"), result)
        }
    }

    @Test
    fun `Should return list cocktail when filterCocktail() is called`() {
        coEvery { remoteDataSource.filterCocktail(any()) } returns Either.Success(
            FakeData.listCocktailResponse,
            200,
            "OK"
        )
        runBlocking {
            val result = repository.filterCocktail(mapOf("c" to "alcoholic"))
            assertEquals(Either.Success(FakeData.listCocktailDomain, 200, "OK"), result)
        }
    }

    @Test
    fun `Should return list alcholic filter when getFilterAlcoholic() is called`() {
        coEvery { remoteDataSource.getFilterAlcoholic() } returns Either.Success(
            FakeData.filterAlcoholicResponse,
            200,
            "OK"
        )
        runBlocking {
            val result = repository.getFilterAlcoholic()
            assertEquals(Either.Success(FakeData.filterDomain, 200, "OK"), result)
        }
    }

    @Test
    fun `Should return list category filter when getFilterCategory() is called`() {
        coEvery { remoteDataSource.getFilterCategory() } returns Either.Success(
            FakeData.filterCategoryResponse,
            200,
            "OK"
        )
        runBlocking {
            val result = repository.getFilterCategory()
            assertEquals(Either.Success(FakeData.filterDomain, 200, "OK"), result)
        }
    }

    @Test
    fun `Should return list glass filter when getFilterGlass() is called`() {
        coEvery { remoteDataSource.getFilterGlass() } returns Either.Success(
            FakeData.filterGlassResponse,
            200,
            "OK"
        )
        runBlocking {
            val result = repository.getFilterGlass()
            assertEquals(Either.Success(FakeData.filterDomain, 200, "OK"), result)
        }
    }

    @Test
    fun `Should return detail cocktail domain when getDetailCocktail() is called`() {
        coEvery { remoteDataSource.getDetailCocktail(any()) } returns Either.Success(
            FakeData.detailCocktailResponse,
            200,
            "OK"
        )
        runBlocking {
            val result = repository.getDetailCocktail("1234")
            assertEquals(Either.Success(FakeData.detailCocktailDomain, 200, "OK"), result)
        }
    }
}