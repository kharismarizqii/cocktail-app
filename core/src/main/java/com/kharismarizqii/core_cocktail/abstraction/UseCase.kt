package com.kharismarizqii.core_cocktail.abstraction

import com.kharismarizqii.core_cocktail.exception.Failure
import com.kharismarizqii.core_cocktail.vo.Either

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
abstract class UseCase<out Type, in Param> where Type: Any {
    abstract suspend fun run(param: Param): Either<Failure, Type>

    object None
}