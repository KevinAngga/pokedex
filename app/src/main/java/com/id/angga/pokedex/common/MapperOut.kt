package com.id.angga.pokedex.common

interface MapperOut<From, To> {
    fun mapFrom(from: From) : To
}