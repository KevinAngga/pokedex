package com.id.angga.pokedex.di

import com.id.angga.pokedex.data.remote.PokemonApi
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonDetailMapper
import com.id.angga.pokedex.data.remote.mappers.pokemon.PokemonListResponseMapper
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
        pokemonListResponseMapper: PokemonListResponseMapper,
        pokemonDetailMapper: PokemonDetailMapper,
    ): PokemonRepository {
        return PokemonRepositoryImpl(
            pokemonApi,
            pokemonListResponseMapper, pokemonDetailMapper
        )
    }
}