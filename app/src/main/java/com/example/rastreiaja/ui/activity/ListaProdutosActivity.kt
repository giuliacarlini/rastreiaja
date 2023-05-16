package com.example.rastreiaja.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.rastreiaja.R
import com.example.rastreiaja.dao.ProdutoDAO
import com.example.rastreiaja.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {

    private val dao = ProdutoDAO()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.buscarTodos());

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configurarRecyclerView()
    }

    override fun onResume() {
        super.onResume()

        adapter.atualiza(dao.buscarTodos())

        configuraBotao()
    }

    private fun configuraBotao() {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configurarRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.adapter = adapter;
    }

}