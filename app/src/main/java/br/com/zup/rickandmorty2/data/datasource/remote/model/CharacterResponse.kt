package br.com.zup.rickandmorty2.data.datasource.remote.model


import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<CharacterResult>
)