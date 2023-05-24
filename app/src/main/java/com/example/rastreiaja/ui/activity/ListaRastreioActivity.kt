package com.example.rastreiaja.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.rastreiaja.dao.RastreioDAO
import com.example.rastreiaja.databinding.ActivityListaRastreioBinding
import com.example.rastreiaja.ui.recyclerview.adapter.ListaRastreiosAdapter


class ListaProdutosActivity : AppCompatActivity() {

    private val dao = RastreioDAO()
    private val adapter = ListaRastreiosAdapter(
        context = this,
        rastreios = dao.buscarTodos()
    );

    private val binding by lazy {
        ActivityListaRastreioBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configurarRecyclerView()
        configuraBotao()
    }

    override fun onResume() {
        super.onResume()

        adapter.atualiza(dao.buscarTodos())
    }

    private fun configuraBotao() {
        val fab = binding.floatingActionButton

        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configurarRecyclerView() {
        val recyclerView = binding.listaRastreioRecyclerview
        recyclerView.adapter = adapter

        adapter.quandoClicaNoItemListener = {
            val intent = Intent(this, RastreioDetalhamentoActivity::class.java)
            startActivity(intent)
        }
    }


}