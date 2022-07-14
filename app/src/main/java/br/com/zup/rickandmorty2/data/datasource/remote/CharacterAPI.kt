package br.com.zup.rickandmorty2.data.datasource.remote

import br.com.zup.rickandmorty2.data.datasource.remote.model.CharacterResponse
import retrofit2.http.GET

interface CharacterAPI {
    @GET("character")
    suspend fun getAllCharactersNetwork(): CharacterResponse
}