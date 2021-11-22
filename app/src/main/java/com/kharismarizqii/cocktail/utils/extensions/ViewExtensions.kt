package com.kharismarizqii.cocktail.utils.extensions

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.viewbinding.ViewBinding

/**
 * Created by Kharisma Rizqi on 21/11/21
 * github.com/kharismarizqii
 */

fun View.setMarginTop(marginTop: Int) {
    val menuLayoutParams = this.layoutParams as ViewGroup.MarginLayoutParams
    menuLayoutParams.setMargins(0, marginTop, 0, 0)
    this.layoutParams = menuLayoutParams
}

fun Activity.setupTransparentStatusBar(binding: ViewBinding, adjustment: (insets: Insets) -> Unit? = {}){
    WindowCompat.setDecorFitsSystemWindows(window, false)
    ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, windowInsets ->
        val insets = windowInsets.getInsets(WindowInsetsCompat.Type.statusBars())

        adjustment.invoke(insets)

        WindowInsetsCompat.CONSUMED
    }
}

fun enable(view: View) {
    with(view) {
        isFocusable = true
        isClickable = true
        isEnabled = true
    }
}

fun disable(view: View) {
    with(view) {
        isFocusable = false
        isClickable = false
        isEnabled = false
    }
}