package com.project.at.info

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.at.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: InfoViewModel
    private  var id: Long? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoBinding.inflate(inflater,container,false)
        val view = binding.root

        id = arguments?.getLong("id")

        if (id != null){
            viewModel = ViewModelProvider(this, InfoViewModelFactory(id!!)).get(InfoViewModel::class.java)

            viewModel.jogador.observe(viewLifecycleOwner){
                binding.progressBar.visibility = View.GONE
                binding.tvInfoNome.text = it?.nome
                binding.tvInfoTime.text = it?.time
                binding.tvInfoPreco.text = it?.preco.toString()
            }
        }
        return view
    }
}