package com.kharismarizqii.cocktail.utils.extensions

import android.content.res.Resources

/**
 * Created by Kharisma Rizqi on 21/11/21
 * github.com/kharismarizqii
 */

val Int.dp : Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()