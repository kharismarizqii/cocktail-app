package com.kharismarizqii.cocktail.ui.main

import androidx.lifecycle.viewModelScope
import com.github.ajalt.timberkt.d
import com.kharismarizqii.cocktail.domain.model.Cocktail
import com.kharismarizqii.cocktail.domain.model.CocktailFilter
import com.kharismarizqii.cocktail.domain.usecase.CocktailUseCase
import com.kharismarizqii.core_cocktail.abstraction.BaseViewModel
import com.kharismarizqii.core_cocktail.dispatcher.DispatcherProvider
import com.kharismarizqii.core_cocktail.vo.Either
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

/**
 * Created by Kharisma Rizqi on 20/11/21
 * github.com/kharismarizqii
 */
class MainViewModel @Inject constructor(
    private val dispatcher: DispatcherProvider,
    private val cocktailUseCase: CocktailUseCase
) : BaseViewModel<MainViewModel.MainUiState>() {
    sealed class MainUiState {
        data class Success(val listCocktail: List<Cocktail>): MainUiState()
        data class Failed(val message: String): MainUiState()
        object Loading: MainUiState()
    }

    fun getListCocktail() {
        _uiState.value = MainUiState.Loading
        viewModelScope.launch(dispatcher.io) {
            val response = cocktailUseCase.getListCocktail()
            when(response){
                is Either.Success -> {
                    withContext(dispatcher.main){
                        d{"Success: ${response.message}"}
                        _uiState.value = MainUiState.Success(response.body)
                    }
                }
                is Either.Failed -> {
                    withContext(dispatcher.main){
                        d{"Failed: ${response.failure.message}"}
                        _uiState.value = MainUiState.Failed(response.failure.message.toString())
                    }
                }
            }
        }
    }

    fun searchCocktail(q: String){
        _uiState.value = MainUiState.Loading
        viewModelScope.launch(dispatcher.io) {
            val response = cocktailUseCase.searchCocktail(q)
            when(response){
                is Either.Success -> {
                    withContext(dispatcher.main){
                        d{"Success: ${response.message}"}
                        _uiState.value = MainUiState.Success(response.body)
                    }
                }
                is Either.Failed -> {
                    withContext(dispatcher.main){
                        d{"Failed: ${response.failure.message}"}
                        _uiState.value = MainUiState.Failed(response.failure.message.toString())
                    }
                }
            }
        }
    }

    fun filterCocktail(filter: CocktailFilter){
        _uiState.value = MainUiState.Loading
        viewModelScope.launch(dispatcher.io) {
            val response = cocktailUseCase.filterCocktail(filter)
            when(response){
                is Either.Success -> {
                    withContext(dispatcher.main){
                        d{"Success: ${response.message}"}
                        _uiState.value = MainUiState.Success(response.body)
                    }
                }
                is Either.Failed -> {
                    withContext(dispatcher.main){
                        d{"Failed: ${response.failure.message}"}
                        _uiState.value = MainUiState.Failed(response.failure.message.toString())
                    }
                }
            }
        }
    }

    fun filterWithSearch(filter: CocktailFilter, query: String){
        _uiState.value = MainUiState.Loading
        viewModelScope.launch(dispatcher.io) {
            val response = cocktailUseCase.filterCocktail(filter)
            when(response){
                is Either.Success -> {
                    withContext(dispatcher.main){
                        d{"Success: ${response.message}"}
                        val list = response.body.filter {
                            it.strDrink.lowercase().contains(query)
                        }
                        _uiState.value = MainUiState.Success(list)
                    }
                }
                is Either.Failed -> {
                    withContext(dispatcher.main){
                        d{"Failed: ${response.failure.message}"}
                        _uiState.value = MainUiState.Failed(response.failure.message.toString())
                    }
                }
            }
        }
    }
}