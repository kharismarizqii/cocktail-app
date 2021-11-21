package com.kharismarizqii.cocktail.ui.dialog

import androidx.lifecycle.viewModelScope
import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import com.kharismarizqii.cocktail.domain.model.FilterQuery
import com.kharismarizqii.cocktail.domain.usecase.CocktailUseCase
import com.kharismarizqii.core_cocktail.abstraction.BaseViewModel
import com.kharismarizqii.core_cocktail.dispatcher.DispatcherProvider
import com.kharismarizqii.core_cocktail.vo.Either
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
class FilterViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider,
    private val cocktailUseCase: CocktailUseCase,
) : BaseViewModel<FilterViewModel.FilterUiState>() {
    sealed class FilterUiState {
        data class FilterAlcoholicLoaded(val list: List<FilterQuery>) : FilterUiState()
        data class FilterCategoryLoaded(val list: List<FilterQuery>) : FilterUiState()
        data class FilterGlassLoaded(val list: List<FilterQuery>) : FilterUiState()

        data class FilterAlcoholicFailed(val message: String) : FilterUiState()
        data class FilterGlassFailed(val message: String) : FilterUiState()
        data class FilterCategoryFailed(val message: String) : FilterUiState()
    }

    fun getFilterAlcoholic() {
        viewModelScope.launch(dispatchers.io) {
            val response = cocktailUseCase.getFilterAlcoholic()
            when (response) {
                is Either.Success -> {
                    withContext(dispatchers.main) {
                        d { "Success: ${response.message}" }
                        _uiState.value = FilterUiState.FilterAlcoholicLoaded(response.body)
                    }
                }
                is Either.Failed -> {
                    withContext(dispatchers.main) {
                        e { "Success: ${response.failure.message}" }
                        _uiState.value =
                            FilterUiState.FilterAlcoholicFailed(response.failure.message.toString())
                    }
                }
            }
        }
    }

    fun getFilterGlass() {
        viewModelScope.launch(dispatchers.io) {
            val response = cocktailUseCase.getFilterGlass()
            when (response) {
                is Either.Success -> {
                    withContext(dispatchers.main) {
                        d { "Success: ${response.message}" }
                        _uiState.value = FilterUiState.FilterGlassLoaded(response.body)
                    }
                }
                is Either.Failed -> {
                    withContext(dispatchers.main) {
                        e { "Success: ${response.failure.message}" }
                        _uiState.value =
                            FilterUiState.FilterGlassFailed(response.failure.message.toString())
                    }
                }
            }
        }
    }

    fun getFilterCategory() {
        viewModelScope.launch(dispatchers.io) {
            val response = cocktailUseCase.getFilterCategory()
            when (response) {
                is Either.Success -> {
                    withContext(dispatchers.main) {
                        d { "Success: ${response.message}" }
                        _uiState.value = FilterUiState.FilterCategoryLoaded(response.body)
                    }
                }
                is Either.Failed -> {
                    withContext(dispatchers.main) {
                        e { "Success: ${response.failure.message}" }
                        _uiState.value =
                            FilterUiState.FilterCategoryFailed(response.failure.message.toString())
                    }
                }
            }
        }
    }
}