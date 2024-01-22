package com.id.angga.pokedex.presentation.ui.pokemon

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.id.angga.pokedex.domain.usecase.PokemonListUseCase
import com.id.angga.pokedex.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val useCase: PokemonListUseCase) : ViewModel() {

    var state by mutableStateOf(PokemonUiState())
        private set

    fun getListOfPokemon() {
        viewModelScope.launch {
            when( val result = useCase.getPokemonList()) {
                is Resource.Success -> {
                    Log.e("sukses", "sukses")
                    state = state.copy(
                        pokemons = result.data ?: emptyList(),
                        isLoading = false,
                        error = null
                    )
                }

                is Resource.Error -> {
                    Log.e("error", ""+result.message)
                    state = state.copy(
                        isLoading = false,
                        error = result.message
                    )
                }
            }

        }
    }

    fun getPokemonDetail() {
        viewModelScope.launch {
            when (val result = useCase.getPokemonDetail("bulbasaur")) {
                is Resource.Success -> {
                    Log.e("sukses detail", ""+result.data?.weight)
                }

                is Resource.Error -> {
                    Log.e("error detail", ""+result.message)
                }
            }
        }
    }


}