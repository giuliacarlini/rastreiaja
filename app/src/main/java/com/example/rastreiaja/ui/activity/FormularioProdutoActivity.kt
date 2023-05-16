package com.example.rastreiaja.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.rastreiaja.R
import com.example.rastreiaja.dao.ProdutoDAO
import com.example.rastreiaja.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val salvar = findViewById<Button>(R.id.salvar)
        salvar.setOnClickListener(View.OnClickListener {
            val campoNome = findViewById<EditText>(R.id.produto_item_nome)
            val nome = campoNome.text.toString()

            val campoDescricao = findViewById<EditText>(R.id.produto_item_descricao)
            val descricao = campoDescricao.text.toString()

            val campoValor = findViewById<EditText>(R.id.produto_item_valor)
            val valorTexto = campoValor.text.toString();

            val valor = if (valorTexto.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valorTexto)
            }

            val produtoNovo = Produto(
                nome = nome,
                descricao = descricao,
                valor = valor
            )

            Log.i("FormularioProduto", "onCreate: $produtoNovo")
            val dao = ProdutoDAO()
            dao.adicionar(produtoNovo)
            Log.i("FormularioProduto", "onCreate: ${dao.buscarTodos()}")

            finish();
        })

    }
}