package com.kharismarizqii.core_cocktail.vo

/**
 * Created by Kharisma Rizqi on 19/11/21
 * github.com/kharismarizqii
 */
sealed class Either<out Failed, out Result> {
    data class Success<out R>(val body: R): Either<Nothing, R>()
    data class Error<out L>(val failure: L): Either<L, Nothing>()
}