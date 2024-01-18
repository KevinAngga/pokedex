package com.id.angga.pokedex.data.remote

import com.id.angga.pokedex.data.remote.pokemon.PokemonDetailDto
import com.id.angga.pokedex.data.remote.pokemon.PokemonListResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }

    @GET("pokemon?limit=25")
    suspend fun getPokemonList() : PokemonListResponseDto

    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(@Path("name") pokemonName: String) : PokemonDetailDto
}