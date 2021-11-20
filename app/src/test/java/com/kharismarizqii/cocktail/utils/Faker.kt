package com.kharismarizqii.cocktail

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
interface IFaker{
    val string: String
    val int: Int
    val boolean: Boolean
}

object Faker: IFaker{
    override val string: String
        get() = "faker"
    override val int: Int
        get() = 123
    override val boolean: Boolean
        get() = true

}