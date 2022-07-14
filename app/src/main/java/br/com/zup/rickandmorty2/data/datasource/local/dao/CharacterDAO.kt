package br.com.zup.rickandmorty2.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.zup.rickandmorty2.data.datasource.remote.model.CharacterResult

@Dao
interface CharacterDAO {
    @Query("SELECT * FROM character ORDER BY name ASC")
    fun getAllCharacters(): List<CharacterResult>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAllCharactersDB(listCharacter : List<CharacterResult>)
}