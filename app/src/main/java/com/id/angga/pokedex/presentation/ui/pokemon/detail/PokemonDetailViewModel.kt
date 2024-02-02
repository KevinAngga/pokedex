package com.id.angga.pokedex.presentation.ui.pokemon.detail

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
class PokemonDetailViewModel @Inject constructor(private val useCase: PokemonListUseCase) : ViewModel() {
    var pokemonEntryId by mutableStateOf<String>("")
        private set

    var state by mutableStateOf(PokemonDetailUiState())

    fun addPokemon(newPokemonEntryId : String) {
        pokemonEntryId = newPokemonEntryId
    }

    fun getPokemonDetail() {
        viewModelScope.launch {
            when (val result = useCase.getPokemonDetail(pokemonEntryId)) {
                is Resource.Success -> {
                    if (result.data != null) {
                        state = state.copy(
                            pokemon = result.data,
                            isLoading = false,
                            error = null
                        )
                    }
                }

                is Resource.Error -> {
                    state = state.copy(
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }

}