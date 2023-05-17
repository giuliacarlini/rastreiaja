package com.example.rastreiaja.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.rastreiaja.R
import com.example.rastreiaja.dao.RastreioDAO
import com.example.rastreiaja.model.Rastreio

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val salvar = findViewById<Button>(R.id.form_button_salvar)
        salvar.setOnClickListener(View.OnClickListener {
            val campoDescricao = findViewById<EditText>(R.id.form_item_descricao)
            val descricao = campoDescricao.text.toString()

            val campoCodigo = findViewById<EditText>(R.id.form_item_codigo)
            val codigo = campoCodigo.text.toString()

            val rastreioNovo = Rastreio(
                descricao = descricao,
                codigo = codigo
            )

            Log.i("FormularioProduto", "onCreate: $rastreioNovo")

            val dao = RastreioDAO()
            dao.adicionar(rastreioNovo)

            Log.i("FormularioProduto", "onCreate: ${dao.buscarTodos()}")

            finish();
        })

    }
}