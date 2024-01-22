package com.id.angga.pokedex.di

import com.id.angga.pokedex.data.remote.PokemonApi
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonDetailMapImpl
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonListResponseMapImpl
import com.id.angga.pokedex.data.repository.PokemonRepositoryImpl
import com.id.angga.pokedex.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun providePokemonRepository(
        pokemonApi: PokemonApi,
        pokemonListResponseMapImpl: PokemonListResponseMapImpl,
        pokemonDetailMapImpl: PokemonDetailMapImpl,
    ): PokemonRepository {
        return PokemonRepositoryImpl(
            pokemonApi,
            pokemonListResponseMapImpl, pokemonDetailMapImpl
        )
    }
}