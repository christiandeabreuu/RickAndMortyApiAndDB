package br.com.zup.rickandmorty2.domain.usecase

import android.app.Application
import br.com.zup.rickandmorty2.data.datasource.local.CharacterDatabase
import br.com.zup.rickandmorty2.data.datasource.local.dao.CharacterDAO
import br.com.zup.rickandmorty2.data.datasource.remote.model.CharacterResult
import br.com.zup.rickandmorty2.domain.repository.CharacterRepository
import br.com.zup.rickandmorty2.ui.viewstate.ViewState

class CharacterUsecase (application: Application) {
    private val characterDAO = CharacterDatabase.getDatabase(application).characterDAO()
    private val characterRepository = CharacterRepository(characterDAO)

    private suspend fun getAllCharacters(): ViewState<List<CharacterResult>>{
        return try {
            val character = characterRepository.getAllCharacters()
            ViewState.Success(character)
        }catch (ex:Exception){
            ViewState.Error(Exception("Não foi possivel carregar a lista"))
        }
    }
    suspend fun getAllCharactersNetwork(): ViewState<List<CharacterResult>>{
        return try {
            val response = characterRepository.getAllCharactersNetwork()
                characterRepository.insertAllCharactersDB(response.results)
            ViewState.Success(response.results)
        }catch (ex:Exception){
            getAllCharacters()
        }
    }
}