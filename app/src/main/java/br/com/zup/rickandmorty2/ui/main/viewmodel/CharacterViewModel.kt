package br.com.zup.rickandmorty2.ui.main.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import br.com.zup.rickandmorty2.data.datasource.remote.model.CharacterResult
import br.com.zup.rickandmorty2.data.datasource.remote.RetrofitService
import br.com.zup.rickandmorty2.domain.usecase.CharacterUsecase
import br.com.zup.rickandmorty2.ui.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterViewModel(application: Application) : AndroidViewModel(application) {
    private val _characterResponse = MutableLiveData<ViewState<List<CharacterResult>>>()
    val characterResponse: LiveData<ViewState<List<CharacterResult>>> = _characterResponse
    private val characterUsecase = CharacterUsecase(application)

    fun getAllCharacter() {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    characterUsecase.getAllCharactersNetwork()
                }
                _characterResponse.value = response
            } catch (ex: Exception) {
                _characterResponse.value =
                    ViewState.Error(Throwable("Não foi possivel carregar a lista da internet"))
                Log.i("Error", "${ex.message}")
            }
        }
    }
}