package com.kharismarizqii.core_cocktail.abstraction

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import java.lang.IllegalArgumentException

/**
 * Created by Kharisma Rizqi on 19/11/21
 * github.com/kharismarizqii
 */
abstract class BaseActivityBinding<T: ViewBinding>: AppCompatActivity() {
    private var _binding: T? = null

    protected abstract val bindingInflater: (LayoutInflater) -> T

    protected val binding: T
        get(){
            if(_binding == null){
                throw IllegalArgumentException("ViewBinding is not initalized yet")
            }
            return _binding!!
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        setupView()
    }

    protected abstract fun setupView()

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}