package com.kharismarizqii.cocktail.di

import com.kharismarizqii.cocktail.data.remote.RemoteDataSource
import com.kharismarizqii.cocktail.data.remote.mapper.*
import com.kharismarizqii.cocktail.data.repository.CocktailRepositoryImpl
import com.kharismarizqii.cocktail.domain.repository.CocktailRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */

@Module
class RepositoryModule {
    @Provides
    fun provideCocktailRepository(
        remoteDataSource: RemoteDataSource,
        cocktailMapper: CocktailMapper,
        filterAlcoholicMapper: FilterAlcoholicMapper,
        filterCategoryMapper: FilterCategoryMapper,
        filterGlassMapper: FilterGlassMapper,
        detailCocktailMapper: DetailCocktailMapper,
    ): CocktailRepository = CocktailRepositoryImpl(
        remoteDataSource,
        cocktailMapper,
        filterAlcoholicMapper,
        filterCategoryMapper,
        filterGlassMapper,
        detailCocktailMapper,
    )
}