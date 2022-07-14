package br.com.zup.rickandmorty2.domain.repository

import br.com.zup.rickandmorty2.data.datasource.local.dao.CharacterDAO
import br.com.zup.rickandmorty2.data.datasource.remote.RetrofitService
import br.com.zup.rickandmorty2.data.datasource.remote.model.CharacterResponse
import br.com.zup.rickandmorty2.data.datasource.remote.model.CharacterResult

class CharacterRepository(private val characterDAO: CharacterDAO) {

    suspend fun getAllCharacters(): List<CharacterResult> = characterDAO.getAllCharacters()

    suspend fun insertAllCharactersDB(listCharacter: List<CharacterResult>) =
        characterDAO.insertAllCharactersDB(listCharacter)

    suspend fun getAllCharactersNetwork(): CharacterResponse =
    RetrofitService.apiService.getAllCharactersNetwork()
}