package br.com.zup.rickandmorty2.ui.detalhe.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.rickandmorty2.data.datasource.remote.model.CharacterResult
import br.com.zup.rickandmorty2.databinding.FragmentDetailBinding
import br.com.zup.rickandmorty2.ui.*
import br.com.zup.rickandmorty2.ui.main.view.MainActivity
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actionBarAccess()
        getCharacterDetail()

    }

    private fun getCharacter(): CharacterResult? = arguments?.getParcelable(KEY)

    private fun getCharacterDetail() {
        val character = getCharacter()
        character?.let {
            Picasso.get().load(it.image).into(binding.ivDetailCharacter)
            binding.tvName.text = NAME + it.name
            binding.tvStatus.text = STATUS + it.status
            binding.tvSpecies.text = SPECIES + it.species
            binding.tvGender.text = GENDER + it.gender

            (activity as MainActivity).supportActionBar?.title = it.name
        }
    }

    private fun actionBarAccess() {
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}