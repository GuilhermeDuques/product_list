package com.project.at.insert

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.project.at.databinding.FragmentJogadorInsertBinding

class InsertFragment : Fragment() {

    private lateinit var viewModel: InsertViewModel
    private var _binding: FragmentJogadorInsertBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJogadorInsertBinding.inflate(inflater,container,false)

        val view = binding.root

        viewModel = ViewModelProvider(this).get(InsertViewModel::class.java)

        binding.fabProdutoInsertSave.setOnClickListener {
            val nome = binding.editTextProdutoInsertNome.text.toString()
            val loja = binding.editTextProdutoInsertLoja.text.toString()
            val preco = binding.editTextProdutoInsertPreO.text.toString().toDouble()
            viewModel.inserirProduto(nome, loja, preco)
            findNavController().popBackStack()
        }

        return view
    }
}