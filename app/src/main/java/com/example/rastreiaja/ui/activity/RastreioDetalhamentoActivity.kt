package com.example.rastreiaja.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rastreiaja.databinding.ActivityListaRastreioBinding
import com.example.rastreiaja.databinding.ActivityRastreioDetalhamentoBinding


class RastreioDetalhamentoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityRastreioDetalhamentoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


}