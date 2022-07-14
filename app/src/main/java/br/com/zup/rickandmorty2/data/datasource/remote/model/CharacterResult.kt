package br.com.zup.rickandmorty2.data.datasource.remote.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "character")
@Parcelize
data class CharacterResult(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Int,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("species")
    val species: String,

    @SerializedName("status")
    val status: String,
) : Parcelable