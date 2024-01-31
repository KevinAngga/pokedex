package com.id.angga.pokedex.presentation.ui.pokemon

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.id.angga.pokedex.data.remote.PokemonApi
import com.id.angga.pokedex.data.remote.paging.PokemonPagingSource
import com.id.angga.pokedex.domain.pokemon.PokemonDetailResponse
import com.id.angga.pokedex.domain.usecase.PokemonListUseCase
import com.id.angga.pokedex.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val useCase: PokemonListUseCase) : ViewModel() {

    var state by mutableStateOf(PokemonUiState())
        private set

    private var currPage = 0
    var endReach = mutableStateOf(false)

    private val _isReady= MutableStateFlow(false)
    val isReady = _isReady.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000L)
        }
    }

    private var pokemons : MutableList<PokemonDetailResponse> = mutableListOf()

    val page = Pager(
        config = PagingConfig(pageSize = 20, prefetchDistance = 5),
        pagingSourceFactory = {
            PokemonPagingSource(useCase)
        }
    ).flow.cachedIn(viewModelScope)

    fun getListOfPokemon() {
        viewModelScope.launch {
            when(val result = useCase.getPokemonList(PokemonApi.PAGE_SIZE,
                currPage * PokemonApi.PAGE_SIZE)) {
                is Resource.Success -> {
                    Log.e("sukses", "sukses")
                    pokemons += result.data?.pokemonList as MutableList<PokemonDetailResponse>
                    endReach.value = currPage * PokemonApi.PAGE_SIZE >= result.data!!.totalCount
                    state = state.copy(
                        pokemons = pokemons.sortedBy { it.id },
                        isLoading = false,
                        error = null
                    )
                    currPage++
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