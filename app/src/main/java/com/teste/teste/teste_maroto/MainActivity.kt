package com.teste.teste.teste_maroto

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity() {
    //Metodo chamado ao iniciar a activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Avisando que essa classe vai receber o layout "Activity_main"
        setContentView(R.layout.activity_main)
        //Ao receber o click, ira chamar o metodo que ira trata-lo
        botao_Entrar.setOnClickListener{ cliqueBotao()}

        }

    //Função que cuidara de tratar o clique no botao
    fun cliqueBotao(){
        //Criando uma variavel que recebera o id do EditText, o valor digitado
        var nome = string_Usuario_Email.text.toString()
        var senha = espaco_Senha.text.toString()

        //Criando uma varivel que recebera a intencao do click botao
        var intent = Intent(this, Activity_Login::class.java)

        //Criando uma variavel que recebera os valores, e podera leva-la para outra tela
        var result = Bundle()
        //Indicando que essa variavel recebera tera a chave nome, e recebera o nome do usuario digitado
        result.putString("nome", nome)
        //Levando os parametros(Valores digitados) para outra tela
        intent.putExtras(result)

        if (nome == "aluno" && senha == "impacta"){
            //Chamando o metodo que ira abrir outra activity, mas que ira esperar um resultado
            startActivityForResult(intent, 1)
        }else{
            Toast.makeText(this, "Usuario ou Senha estao incorretos, por favor digite os dados corretamente.", Toast.LENGTH_SHORT).show()
        }

        //startActivityForResult(intent, 1)

    }
    //Sobrescrevendo metodo que ira retornar os valores na volta
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //Retornando os dados da activity destruida para a primeira tela
        Toast.makeText(this, data?.getStringExtra("resultado"), Toast.LENGTH_SHORT).show()
    }

    }




