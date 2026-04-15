package com.caio.caiocardozo.partidabasquete_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Botão para abrir o Placar
        findViewById<Button>(R.id.btnAbrirBasquete).setOnClickListener {
            startActivity(Intent(this, BasqueteActivity::class.java))
        }

        // Botão para abrir a Calculadora
        findViewById<Button>(R.id.btnAbrirCalculadora).setOnClickListener {
            startActivity(Intent(this, CalculadoraActivity::class.java))
        }

        // Botão para abrir o Conversor
        findViewById<Button>(R.id.btnAbrirConversor).setOnClickListener {
            startActivity(Intent(this, ConversorActivity::class.java))
        }
    }
}