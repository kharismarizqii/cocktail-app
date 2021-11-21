package com.kharismarizqii.cocktail.utils.extensions

import android.view.View
import android.view.ViewGroup

/**
 * Created by Kharisma Rizqi on 21/11/21
 * github.com/kharismarizqii
 */

fun View.setMarginTop(marginTop: Int) {
    val menuLayoutParams = this.layoutParams as ViewGroup.MarginLayoutParams
    menuLayoutParams.setMargins(0, marginTop, 0, 0)
    this.layoutParams = menuLayoutParams
}