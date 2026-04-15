package com.caio.caiocardozo.partidabasquete_kotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConversorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        setContentView(R.layout.layout_conversor)

        val editReal = findViewById<EditText>(R.id.editReal)
        val btnConverter = findViewById<Button>(R.id.btnConverter)
        val txtResultado = findViewById<TextView>(R.id.txtResultadoDolar)

        btnConverter.setOnClickListener {
            val valorReal = editReal.text.toString().toDoubleOrNull()
            if (valorReal != null) {
                val cotacaoDolar = 5.10 // Valor exemplo
                val resultado = valorReal / cotacaoDolar
                txtResultado.text = "U$ ${String.format("%.2f", resultado)}"
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}