package com.example.rastreiaja.dao

import com.example.rastreiaja.model.Produto

class ProdutoDAO {

    fun adicionar(produto: Produto) {
        produtos.add(produto)
    }

    fun buscarTodos() : List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}