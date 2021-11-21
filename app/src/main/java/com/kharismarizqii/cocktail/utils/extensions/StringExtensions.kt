package com.kharismarizqii.cocktail.utils.extensions

/**
 * Created by Kharisma Rizqi on 21/11/21
 * github.com/kharismarizqii
 */

fun String.underscoreFormat(): String{
    return this.replace(" ", "_")
}

fun String.spaceFormat(): String{
    return this.replace("_"," ")
}