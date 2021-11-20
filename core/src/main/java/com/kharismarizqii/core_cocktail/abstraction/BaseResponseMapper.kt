package com.kharismarizqii.core_cocktail.abstraction

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
interface BaseResponseMapper<Raw, Domain> {
    fun mapToDomain(raw: Raw): Domain
}