package com.kharismarizqii.cocktail.di

import com.kharismarizqii.cocktail.data.dispatcher.DispatcherProviderImpl
import com.kharismarizqii.core_cocktail.dispatcher.DispatcherProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */

@Module
class DispatcherModule {
    @Singleton
    @Provides
    fun provideDisptacher(): DispatcherProvider = DispatcherProviderImpl()
}