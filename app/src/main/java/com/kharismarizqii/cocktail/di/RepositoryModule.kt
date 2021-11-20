package com.kharismarizqii.cocktail.di

import com.kharismarizqii.cocktail.data.remote.RemoteDataSource
import com.kharismarizqii.cocktail.data.remote.mapper.CocktailMapper
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
        mapper: CocktailMapper
    ): CocktailRepository = CocktailRepositoryImpl(remoteDataSource, mapper)
}