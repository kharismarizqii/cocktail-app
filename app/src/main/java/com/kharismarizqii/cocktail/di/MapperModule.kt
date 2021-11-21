package com.kharismarizqii.cocktail.di

import com.kharismarizqii.cocktail.data.remote.mapper.CocktailMapper
import com.kharismarizqii.cocktail.data.remote.mapper.FilterAlcoholicMapper
import com.kharismarizqii.cocktail.data.remote.mapper.FilterCategoryMapper
import com.kharismarizqii.cocktail.data.remote.mapper.FilterGlassMapper
import dagger.Module
import dagger.Provides

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */

@Module
class MapperModule {
    @Provides
    fun provideCocktailMapper() = CocktailMapper()

    @Provides
    fun provideFilterAlcoholicMapper() = FilterAlcoholicMapper()

    @Provides
    fun provideFilterCategoryMapper() = FilterCategoryMapper()

    @Provides
    fun provideFilterGlassMapper() = FilterGlassMapper()
}