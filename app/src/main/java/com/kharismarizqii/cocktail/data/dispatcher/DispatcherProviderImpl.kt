package com.kharismarizqii.cocktail.data.dispatcher

import com.kharismarizqii.core_cocktail.dispatcher.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Created by Kharisma Rizqi on 19/11/21
 * github.com/kharismarizqii
 */
class DispatcherProviderImpl: DispatcherProvider {
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO
    override val main: CoroutineDispatcher
        get() = Dispatchers.Main
    override val default: CoroutineDispatcher
        get() = Dispatchers.Default
    override val unconfined: CoroutineDispatcher
        get() = Dispatchers.Unconfined
}