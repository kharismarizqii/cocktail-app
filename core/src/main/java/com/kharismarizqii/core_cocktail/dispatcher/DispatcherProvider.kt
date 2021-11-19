package com.kharismarizqii.core_cocktail.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by Kharisma Rizqi on 19/11/21
 * github.com/kharismarizqii
 */
interface DispatcherProvider {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}