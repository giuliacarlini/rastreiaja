package com.example.rastreiaja.ui.recyclerview.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rastreiaja.R
import com.example.rastreiaja.databinding.ActivityListaRastreioBinding
import com.example.rastreiaja.databinding.RastreioItemBinding
import com.example.rastreiaja.model.Rastreio

class ListaRastreiosAdapter(
    private val context: Context,
    rastreios: List<Rastreio>,
    var quandoClicaNoItemListener: (rastreio: Rastreio) -> Unit = {}
    ) : RecyclerView.Adapter<ListaRastreiosAdapter.ViewHolder>() {

    private val localrastreios = rastreios.toMutableList()

    inner class ViewHolder(private val binding: RastreioItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var rastreio: Rastreio

        init {
            itemView.setOnClickListener {
                Log.i("ListaProdutosAdapter", "clicando no item")
                if(::rastreio.isInitialized) {
                    quandoClicaNoItemListener(rastreio)
                }
            }
        }

        fun vincula(rastreio: Rastreio) {
            this.rastreio = rastreio

            val descricao = binding.rastreioItemDescricao
            descricao.text = rastreio.descricao

            val codigo = binding.rastreioItemCodigo
            codigo.text = rastreio.codigo

            val status = binding.rastreioItemStatus
            status.text = "Aguardando postagem"

            val cidade = binding.rastreioItemCidade
            cidade.text = "Sorocaba/SP"

            val img = binding.rastreioItemImageview
            img.setBackgroundResource(R.drawable.ic_check_circle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = RastreioItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
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

