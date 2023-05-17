package com.example.rastreiaja.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rastreiaja.R
import com.example.rastreiaja.model.Rastreio

class ListaProdutosAdapter(private val context: Context, rastreios: List<Rastreio>
    ) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val localrastreios = rastreios.toMutableList();

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincula(rastreio: Rastreio) {

            val descricao = itemView.findViewById<TextView>(R.id.rastreio_item_descricao)
            descricao.text = rastreio.descricao

            val codigo = itemView.findViewById<TextView>(R.id.rastreio_item_codigo)
            codigo.text = rastreio.codigo

            val status = itemView.findViewById<TextView>(R.id.rastreio_item_status)
            status.text = "Aguardando postagem"

            val cidade = itemView.findViewById<TextView>(R.id.rastreio_item_cidade)
            cidade.text = "Sorocaba/SP"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.rastreio_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = localrastreios.size;

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rastreio = localrastreios[position]

        holder.vincula(rastreio)
    }

    fun atualiza(rastreios1: List<Rastreio>) {
        this.localrastreios.clear()
        this.localrastreios.addAll(rastreios1)
        notifyDataSetChanged()
    }

}

