package com.teste.teste.teste_maroto

import android.app.ActionBar
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import android.widget.ToggleButton
import com.teste.teste.teste_maroto.R.string.drawer_abrir
import com.teste.teste.teste_maroto.R.string.drawer_fechar
import kotlinx.android.synthetic.main.activity__login.*

open class  ActivityLogin : MainActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_disciplina->{
                val nav = Intent(this, ActivityNav::class.java)
                startActivity(nav)
            }
            R.id.config_disciplina->{
                val con = Intent(this, ActivityConfig::class.java)
                startActivity(con)
            }
            R.id.forum_disciplina->{
                val forum = Intent(this, ActivityNav::class.java)
                startActivity(forum)
            }
            R.id.localizar_disciplina->{
                val localiza = Intent(this, ActivityLocalizar::class.java)
                startActivity(localiza)
            }
            R.id.msg_disciplina->{
                val chats = Intent(this, ActivityChat::class.java)
                startActivity(chats)
            }
        }
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }

    //Teria que receber uma toolbar, nao uma  ActionBar... Nao consegui fazer o botao aparecer, MAS é possivel puxar o menu arrastando a tela

   /* fun configuraMenuLateral(){
        val actionBar = actionBar
        val layoutMenuLateral = layoutMenuLateral

        var toggle = ActionBarDrawerToggle(this, layoutMenuLateral, actionBar, R.string.drawer_abrir, R.string.drawer_fechar)
        layoutMenuLateral.addDrawerListener(toggle)
        toggle.syncState()

        val navegationView = menu_tela_inicial
        navegationView.setNavigationItemSelectedListener(this)

    } */

    var nome:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity__login)

        //Colocando o valor da action bar como verdadeiro, para inicar ela
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Esse titulo para a action bar é OBRIGATORIO
        supportActionBar?.title = "Segunda Tela"

        botao_matematica.setOnClickListener{matematica()}
        botao_geografia.setOnClickListener{geografia()}
        botao_historia.setOnClickListener{historia()}
        botao_voltar.setOnClickListener{cliqueBotao2()}

        //Variavel que recebe os dados acoplados ao bundle "Result"
        val args = intent.extras

        //Variavel que recebe a chave nome, com os dados do nome
        nome = args.getString("nome")

        //Retornando informacao para saber que os dados foram enviados com sucesso
        Toast.makeText(this, "Voce enviou o parametro $nome", Toast.LENGTH_SHORT).show()

        //configuraMenuLateral()
    }

    fun matematica(){
        supportActionBar?.title = "Matematica"
    }
    fun geografia(){
        supportActionBar?.title = "Geografia"
    }
    fun historia(){
        supportActionBar?.title = "Historia"
    }
    fun cliqueBotao2(){
        intent = Intent()

        //Colocando os dados na variavel resultado para retornar na volta
        intent.putExtra("resultado", "Saida do app")

        //O resultado vai retornar para a activity atraves da intencao
        setResult(Activity.RESULT_OK, intent)
        Toast.makeText(this, "Você voltou para a tela inicial $nome", Toast.LENGTH_SHORT).show()
        finish()
    }
    //Sobrescrevendo a funcao para chamar a action bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)
        (menu?.findItem(R.id.id_buscar)?.actionView as SearchView).setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                // ação enquanto está digitando
                return false
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                // ação  quando terminou de buscar e enviou
                return false
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        val id = item?.itemId

        if (id == R.id.id_buscar){
            Toast.makeText(this, "Clicou no botão buscar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.id_compartilhar) {
            Toast.makeText(this, "Clicou no botão compartilhar", Toast.LENGTH_SHORT).show()

        } else if (id == android.R.id.home){
            Toast.makeText(this, "Clicou no botão voltar $nome", Toast.LENGTH_SHORT).show()
            finish()
        } else if (id == R.id.id_adicionar){
            val add = Intent(this, ActivtyAdicionar::class.java)
            startActivityForResult(add, 2)
        } else if (id == R.id.id_configuracoes){
            val config = Intent(this, ActivityConfig::class.java)
            startActivity(config)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        Toast.makeText(this, data?.getStringExtra("resultado2"), Toast.LENGTH_SHORT).show()
    }

    }




