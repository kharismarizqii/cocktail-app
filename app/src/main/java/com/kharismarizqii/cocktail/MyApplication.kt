package com.kharismarizqii.cocktail

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.kharismarizqii.cocktail.di.DaggerApplicationComponent

/**
 * Created by Kharisma Rizqi on 19/11/21
 * github.com/kharismarizqii
 */
class MyApplication: Application() {
    val appComponent = DaggerApplicationComponent.create()
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}