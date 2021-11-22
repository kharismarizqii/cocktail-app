package com.kharismarizqii.cocktail.ui.detail

import androidx.lifecycle.viewModelScope
import com.kharismarizqii.cocktail.domain.model.DetailCocktail
import com.kharismarizqii.cocktail.domain.usecase.CocktailUseCase
import com.kharismarizqii.core_cocktail.abstraction.BaseViewModel
import com.kharismarizqii.core_cocktail.dispatcher.DispatcherProvider
import com.kharismarizqii.core_cocktail.vo.Either
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Kharisma Rizqi on 22/11/21
 * github.com/kharismarizqii
 */
class DetailCocktailViewModel @Inject constructor(
    private val dispatchers : DispatcherProvider,
    private val cocktailUseCase: CocktailUseCase,
): BaseViewModel<DetailCocktailViewModel.DetailCocktailUiState>() {

    sealed class DetailCocktailUiState{
        data class Success(val data: DetailCocktail): DetailCocktailUiState()
        data class Failed(val message: String): DetailCocktailUiState()
    }

    fun getDetailCocktail(id: String){
        viewModelScope.launch(dispatchers.io) {
            val response = cocktailUseCase.getDetailCocktail(id)
            when(response){
                is Either.Success -> {
                    withContext(dispatchers.main){
                        _uiState.value = DetailCocktailUiState.Success(response.body)
                    }
                }
                is Either.Failed -> {
                    withContext(dispatchers.main){
                        _uiState.value = DetailCocktailUiState.Failed(response.failure.message.toString())
                    }
                }

            }
        }
    }
}