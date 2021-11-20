package com.kharismarizqii.cocktail.di

import com.kharismarizqii.cocktail.data.remote.RemoteDataSource
import com.kharismarizqii.cocktail.data.remote.service.ApiService
import dagger.Module
import dagger.Provides

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */

@Module
class DataSourceModule {
    @Provides
    fun provideRemoteDataSource(apiService: ApiService) = RemoteDataSource(apiService)
}