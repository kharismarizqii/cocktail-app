package com.kharismarizqii.cocktail.di

import com.kharismarizqii.cocktail.ui.dialog.FilterDialogFragment
import com.kharismarizqii.cocktail.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */

@Singleton
@Component(
    modules = [UseCaseModule::class, NetworkModule::class, MapperModule::class, DataSourceModule::class, RepositoryModule::class, DispatcherModule::class]
)
interface ApplicationComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: FilterDialogFragment)
}