package com.teste.teste.teste_maroto

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.teste.teste.teste_maroto.R.layout.activity_adicionar
import kotlinx.android.synthetic.main.activity_adicionar.*

open class ActivtyAdicionar : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(activity_adicionar)

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
            val add = Intent()
            add.putExtra("resultado2", "Voltoudoadd")
            setResult(Activity.RESULT_OK, add)
            finish()
            //startActivityForResult(intent, 2)

        }
        return super.onOptionsItemSelected(item)
    }

    fun addlista() {




     }

}