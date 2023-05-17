package com.example.rastreiaja.dao

import com.example.rastreiaja.model.Rastreio

class RastreioDAO {

    fun adicionar(rastreio: Rastreio) {
        rastreios.add(rastreio)
    }

    fun buscarTodos() : List<Rastreio> {
        return rastreios.toList()
    }

    companion object {
        private val rastreios = mutableListOf<Rastreio>()
    }
}