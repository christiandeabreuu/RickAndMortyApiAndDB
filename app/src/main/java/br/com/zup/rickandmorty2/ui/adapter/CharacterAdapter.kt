package br.com.zup.rickandmorty2.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.rickandmorty2.data.datasource.remote.model.CharacterResult
import br.com.zup.rickandmorty2.databinding.LayoutItemBinding
import com.squareup.picasso.Picasso

class CharacterAdapter(
    private var listaPersonagemRM: MutableList<CharacterResult>,
    private val clickDetail : (CharacterResult) -> Unit,
) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterAdapter.ViewHolder, position: Int) {
        val personagem = listaPersonagemRM[position]
        holder.receberRV(personagem)
        holder.binding.cvItem.setOnClickListener {
            clickDetail(personagem)
        }
    }

    override fun getItemCount() = listaPersonagemRM.size

    fun updateCharacterList(newList: MutableList<CharacterResult>) {
        listaPersonagemRM = newList
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun receberRV(characterResult: CharacterResult) {

            Picasso.get().load(characterResult.image)
                .into(binding.ivCharacterImg)
            binding.tvCharacterName.text = characterResult.name
        }
    }


}