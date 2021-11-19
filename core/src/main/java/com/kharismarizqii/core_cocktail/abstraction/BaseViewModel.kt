package com.kharismarizqii.core_cocktail.abstraction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Kharisma Rizqi on 19/11/21
 * github.com/kharismarizqii
 */
abstract class BaseViewModel<T>: ViewModel() {
    protected val _uiState: MutableLiveData<T> = MutableLiveData()

    val uiState: LiveData<T>
        get() = _uiState
}