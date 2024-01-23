package com.id.angga.pokedex.presentation.ui.pokemon.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.id.angga.pokedex.domain.pokemon.PokemonDetailResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel() {
    var pokemon by mutableStateOf<PokemonDetailResponse>(PokemonDetailResponse())
        private set

    fun addPokemon(newPokemon: PokemonDetailResponse) {
        pokemon = newPokemon
    }

}