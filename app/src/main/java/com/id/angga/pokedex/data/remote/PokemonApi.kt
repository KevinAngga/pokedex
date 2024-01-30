package com.id.angga.pokedex.data.remote

import com.id.angga.pokedex.data.remote.pokemon.PokemonDetailResponseDto
import com.id.angga.pokedex.data.remote.pokemon.PokemonListResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
        const val PAGE_SIZE = 20
    }

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit : Int,
        @Query("offset") offset : Int
    ) : PokemonListResponseDto

    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(@Path("name") pokemonName: String) : PokemonDetailResponseDto
}