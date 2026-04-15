package com.caio.caiocardozo.partidabasquete_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import android.widget.Toast

class BasqueteActivity : AppCompatActivity() {

    private var pontuacaoTimeA: Int = 0
    private var pontuacaoTimeB: Int = 0

    private lateinit var pTimeA: TextView
    private lateinit var pTimeB: TextView

    private lateinit var clock: Chronometer
    private var tempoPausado: Long = 0
    private var isPausado: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_basquete)

        pTimeA = findViewById(R.id.placarTimeA)
        pTimeB = findViewById(R.id.placarTimeB)

        val bTresPontosTimeA: Button = findViewById(R.id.tresPontosA)
        val bDoisPontosTimeA: Button = findViewById(R.id.doisPontosA)
        val bTLivreTimeA: Button = findViewById(R.id.tiroLivreA)
        val bTresPontosTimeB: Button = findViewById(R.id.tresPontosB)
        val bDoisPontosTimeB: Button = findViewById(R.id.doisPontosB)
        val bTLivreTimeB: Button = findViewById(R.id.tiroLivreB)
        val bPausar: Button = findViewById(R.id.pausarPartida)
        val bContinuar: Button = findViewById(R.id.continuarPartida)
        val bReiniciar: Button = findViewById(R.id.reiniciarPartida)

        clock = findViewById(R.id.clock)
        clock.start()



        bTresPontosTimeA.setOnClickListener { adicionarPontos(3, "A") }

        bDoisPontosTimeA.setOnClickListener { adicionarPontos(2, "A") }

        bTLivreTimeA.setOnClickListener { adicionarPontos(1, "A") }

        bTresPontosTimeB.setOnClickListener { adicionarPontos(3, "B") }

        bDoisPontosTimeB.setOnClickListener { adicionarPontos(2, "B") }

        bTLivreTimeB.setOnClickListener { adicionarPontos(1, "B") }

        bPausar.setOnClickListener( { pausarPartida() } )

        bContinuar.setOnClickListener( { continuarPartida() })

        bReiniciar.setOnClickListener { reiniciarPartida() }


    }

    fun adicionarPontos(pontos: Int, time: String) {
        if (isPausado) {
            Toast.makeText(this, "Não é possível adicionar pontos com o tempo pausado", Toast.LENGTH_SHORT).show()
            return
        }

        if (time == "A") {
            pontuacaoTimeA += pontos

        } else {
            pontuacaoTimeB += pontos

        }
        atualizaPlacar(time)
    }

    fun atualizaPlacar(time: String) {
        if (time == "A") {
            pTimeA.text = pontuacaoTimeA.toString()
        } else {
            pTimeB.text = pontuacaoTimeB.toString()
        }
    }

    fun pausarPartida() {
        isPausado = true
        tempoPausado = SystemClock.elapsedRealtime() - clock.base
        clock.stop()
    }

    fun continuarPartida() {
        isPausado = false
        clock.base = SystemClock.elapsedRealtime() - tempoPausado
        clock.start()
    }

    fun reiniciarPartida() {
        pontuacaoTimeA = 0
        pTimeA.text = pontuacaoTimeA.toString()
        pontuacaoTimeB = 0
        pTimeB.text = pontuacaoTimeB.toString()

        tempoPausado = 0
        isPausado = false
        clock.stop()
        clock.base = SystemClock.elapsedRealtime()
        clock.start()

        Toast.makeText(this, "Placar reiniciado", Toast.LENGTH_SHORT).show()

    }
}
