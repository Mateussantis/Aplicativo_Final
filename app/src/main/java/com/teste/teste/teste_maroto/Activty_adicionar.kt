package com.teste.teste.teste_maroto

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_adicionar.*

open class Activty_adicionar : MainActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Adicionar Lista"

        var lista = arrayListOf<Int>()

        var numero = id_num.text.toString()

        botao_soma.setOnClickListener{addlista()}
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_adicionar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        val id = item?.itemId

        if (id == android.R.id.home) {
            finish()
            startActivityForResult(intent, 2)

        }
        return super.onOptionsItemSelected(item)
    }

    fun addlista() {

     }

}