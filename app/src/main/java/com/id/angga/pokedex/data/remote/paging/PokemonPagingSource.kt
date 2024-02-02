package com.id.angga.pokedex.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.id.angga.pokedex.data.remote.PokemonApi
import com.id.angga.pokedex.domain.pokemon.PokemonDetailResponse
import com.id.angga.pokedex.domain.pokemon.PokemonListItem
import com.id.angga.pokedex.domain.pokemon.PokemonListResponse
import com.id.angga.pokedex.domain.usecase.PokemonListUseCase

class PokemonPagingSource(
    private val useCase: PokemonListUseCase
) : PagingSource<Int, PokemonListItem>() {

    override fun getRefreshKey(state: PagingState<Int, PokemonListItem>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonListItem> {
        return try {
            val currPage = params.key ?: 0
            val data = useCase.getPokemonList(PokemonApi.PAGE_SIZE, currPage * PokemonApi.PAGE_SIZE)
            val pokemons = data.data?.results as List<PokemonListItem>
            LoadResult.Page(
                data = pokemons,
                prevKey = if (currPage == 0) null else currPage - 1,
                nextKey = if (currPage * PokemonApi.PAGE_SIZE == data.data.count) null else currPage + 1
            )
        } catch (e : Exception) {
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }
}