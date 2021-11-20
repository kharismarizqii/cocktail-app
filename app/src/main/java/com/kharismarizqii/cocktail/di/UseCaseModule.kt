package com.kharismarizqii.cocktail.di

import com.kharismarizqii.cocktail.domain.repository.CocktailRepository
import com.kharismarizqii.cocktail.domain.usecase.CocktailInteractor
import com.kharismarizqii.cocktail.domain.usecase.CocktailUseCase
import dagger.Module
import dagger.Provides

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */

@Module
class UseCaseModule {
    @Provides
    fun provideCocktailUseCase(
        repository: CocktailRepository
    ): CocktailUseCase = CocktailInteractor(repository)
}