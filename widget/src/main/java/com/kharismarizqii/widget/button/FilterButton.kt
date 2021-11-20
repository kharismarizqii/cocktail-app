package com.kharismarizqii.widget.button

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.kharismarizqii.widget.R

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */

class FilterButton : ConstraintLayout {

    private lateinit var tvFilter: TextView
    private lateinit var ivDropDown: ImageView
    private lateinit var ivBackground: ImageView

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context, attrs)
    }

    private fun initView(context: Context, attrs: AttributeSet?) {
        inflate(context, R.layout.button_filter, this)

        tvFilter = findViewById(R.id.tvFilter)
        ivDropDown = findViewById(R.id.ivDropdown)
        ivBackground = findViewById(R.id.ivBackground)

        val attribute = context.obtainStyledAttributes(attrs, R.styleable.FilterButton)

        val text = attribute.getText(R.styleable.FilterButton_textFilter)
        val background = attribute.getDrawable(R.styleable.FilterButton_backgroundFilter)


        tvFilter.text = text
        ivBackground.setImageDrawable(background)

        attribute.recycle()
    }


    fun setHideDropDown() {
        ivDropDown.visibility = View.INVISIBLE
    }

    fun setOnClickFilterListener(onClick: () -> Unit) {
        ivBackground.setOnClickListener { onClick() }
    }

    fun setTextFilter(text: String) {
        tvFilter.text = text
        tvFilter.setTextColor(ContextCompat.getColor(context, R.color.black))
        ivBackground.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                R.drawable.bg_filter_dropdown_on
            )
        )
    }

    fun setTextFilterOnly(text: String) {
        tvFilter.text = text
    }

    fun getText(): String {
        return tvFilter.text.toString()
    }


}