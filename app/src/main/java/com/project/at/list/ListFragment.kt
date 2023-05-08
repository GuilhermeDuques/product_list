package com.project.at.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.at.R
import com.project.at.adapters.RecyclerAdapter
import com.project.at.databinding.FragmentJogadorListBinding
import com.project.at.models.Jogador

class ListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private var _binding: FragmentJogadorListBinding? = null
    private val binding get() = _binding!!
    private lateinit var jogadors: MutableList<Jogador>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJogadorListBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel = ViewModelProvider(this, ListViewModelFactory()).get(ListViewModel::class.java)
        jogadors = viewModel.getProdutos()!!.toMutableList()

        binding.recyclerProdutosList.adapter = RecyclerAdapter(jogadors){
            findNavController().navigate(R.id.infoFragment, bundleOf(
                "id" to it
            ))
        }
        binding.recyclerProdutosList.layoutManager = LinearLayoutManager(requireContext())
        binding.floatingActionButton2.setOnClickListener {
            findNavController().navigate(R.id.produtoInsertFragment)
        }
        view.findViewById<Button>(R.id.button).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_produtoListFragment_to_recomendacoesFragment)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}