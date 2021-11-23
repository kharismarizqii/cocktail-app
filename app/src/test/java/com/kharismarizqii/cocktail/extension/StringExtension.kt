package com.kharismarizqii.cocktail.extension

import com.kharismarizqii.cocktail.utils.extensions.spaceFormat
import com.kharismarizqii.cocktail.utils.extensions.underscoreFormat
import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * Created by Kharisma Rizqi on 23/11/21
 * github.com/kharismarizqii
 */
class StringExtension {
    @Test
    fun `Should return underscore string when underscoreFormat is called`(){
        val string = "android studio"
        val result = string.underscoreFormat()
        assertEquals("android_studio", result)
    }

    @Test
    fun `Should return space string when spaceFormat is called`(){
        val string = "android_studio"
        val result = string.spaceFormat()
        assertEquals("android studio", result)
    }
}