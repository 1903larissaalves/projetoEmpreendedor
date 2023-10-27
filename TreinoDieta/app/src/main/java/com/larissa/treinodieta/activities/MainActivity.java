package com.larissa.treinodieta.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.larissa.treinodieta.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.treinoDieta);
        //inserirUsuario("adm", String.valueOf(123));

        Button contadorCalorias = (Button) findViewById(R.id.btnContadorCalorias);
        Button calculoImc = (Button) findViewById(R.id.btnCalculoImc);
        Button medidasPessoa = (Button) findViewById(R.id.btnMedidas);
        Button HistoricoMedidas = (Button) findViewById(R.id.btnHistoricoMedidas);
        Button pesoAvaliacoes = (Button) findViewById(R.id.btnPesoAvaliacoes);
        Button opcaoExercicioDiario = (Button) findViewById(R.id.btnOpcaoExercicioDiario);
        Button opcaoControleSono = (Button) findViewById(R.id.btnControleSono);
        Button programacaoSemanalExercicio = (Button) findViewById(R.id.btnProgramacaoSemanalExercicio);
        Button perfilUsuario = (Button) findViewById(R.id.btnPerfilUsuario);


        contadorCalorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentContadorCalorias = new Intent(MainActivity.this, ContadorCaloriasActivity.class);
                startActivity(intentContadorCalorias);
            }
        });

        calculoImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCalculoImc = new Intent(MainActivity.this, CalculoImcActivity.class);
                startActivity(intentCalculoImc);
            }
        });

        medidasPessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMedidasPessoa = new Intent(MainActivity.this, MedidasPessoaActivity.class);
                startActivity(intentMedidasPessoa);
            }
        });

        HistoricoMedidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMedidasPessoa = new Intent(MainActivity.this, HistoricoMedidasActivity.class);
                startActivity(intentMedidasPessoa);
            }
        });

        pesoAvaliacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPesoAvaliacoes = new Intent(MainActivity.this, PesoAvalicoesActivity.class);
                startActivity(intentPesoAvaliacoes);
            }
        });

        opcaoExercicioDiario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentOpcaoExercicioDiario = new Intent(MainActivity.this, OpcaoExercicioDiarioActivity.class);
                startActivity(intentOpcaoExercicioDiario);
            }
        });

        opcaoControleSono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentControleSono = new Intent(MainActivity.this, ControleSonoActivity.class);
                startActivity(intentControleSono);
            }
        });
        programacaoSemanalExercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProgramacaoSemanalExercicio = new Intent(MainActivity.this, ProgramacaoSemanalExerciciosActivity.class);
                startActivity(intentProgramacaoSemanalExercicio);
            }
        });
        perfilUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPerfilUsuario = new Intent(MainActivity.this, PerfilUsuarioActivity.class);
                startActivity(intentPerfilUsuario);
            }
        });

    }
    //private void inserirUsuario(String nome,String senha){
    //  Usuario usuario = new Usuario();
    //usuario.setNome(nome);
    //usuario.setSenha(senha);

    //loginDao loginDao = new loginDao(this);
    //String resultado = loginDao.inserirUsuario(usuario);
    //Log.d("Resultado",resultado);
    // }
    // private void autenticarUsuario(String nome, String senha){
    //   Usuario usuario = new Usuario();
    // usuario.setNome(nome);
    //usuario.setSenha(senha);

    //loginDao loginDao = new loginDao(this);
    //String resultado = loginDao.autenticarUsuario(usuario);
    //Log.d("resultado", resultado);

    //}
}
