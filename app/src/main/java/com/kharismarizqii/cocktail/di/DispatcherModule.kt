package com.kharismarizqii.cocktail.di

import com.kharismarizqii.cocktail.data.dispatcher.DispatcherProviderImpl
import com.kharismarizqii.core_cocktail.dispatcher.DispatcherProvider
import dagger.Module
import dagger.Provides

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */

@Module
class DispatcherModule {
    @Provides
    fun provideDisptacher(): DispatcherProvider = DispatcherProviderImpl()
}