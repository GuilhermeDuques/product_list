package com.project.at.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.at.R
import com.project.at.models.Jogador

class RecyclerAdapter(
    private val jogadors: List<Jogador>,
    private val onClickEvent: (Long) -> Unit
) : RecyclerView.Adapter<RecyclerAdapter.ProdutosViewHolder>() {

        class ProdutosViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
                val textViewNome: TextView = itemView.findViewById(R.id.textViewRecycleViewProdutoNome)
                val textViewLoja: TextView = itemView.findViewById(R.id.textViewRecycleViewProdutoLoja)
                val textViewPreco: TextView = itemView.findViewById(R.id.textViewRecycleViewProdutoPreco)

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recycler_jogador, parent, false)
        return ProdutosViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        val produto = jogadors[position]
        holder.itemView.setOnClickListener{onClickEvent(produto.id)}
        holder.textViewNome.text = produto.nome
        holder.textViewLoja.text = produto.time
        holder.textViewPreco.text = produto.preco.toString()
    }

    override fun getItemCount() = jogadors.size

}