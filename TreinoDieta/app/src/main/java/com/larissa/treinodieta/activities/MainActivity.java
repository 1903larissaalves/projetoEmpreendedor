package com.larissa.treinodieta.activities;

import android.content.Intent;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.larissa.treinodieta.R;
import com.larissa.treinodieta.dao.PerfilUsuarioDao;

public class MainActivity extends AppCompatActivity {
    PerfilUsuarioDao dbRegistro;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater =  getMenuInflater();
        mMenuInflater.inflate(R.menu.sair, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_logout) {
            Intent i = new Intent(this, ActivityLogin.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.treinoDieta);

        dbRegistro = new PerfilUsuarioDao(this);

        Button contadorCalorias = (Button) findViewById(R.id.btnContadorCalorias);
        Button calculoImc = (Button) findViewById(R.id.btnCalculoImc);
        Button medidasPessoa = (Button) findViewById(R.id.btnMedidas);
        Button HistoricoMedidas = (Button) findViewById(R.id.btnHistoricoMedidas);
        Button pesoAvaliacoes = (Button) findViewById(R.id.btnPesoAvaliacoes);
        Button opcaoExercicioDiario = (Button) findViewById(R.id.btnOpcaoExercicioDiario);
        Button opcaoControleSono = (Button) findViewById(R.id.btnControleSono);
        Button programacaoSemanalExercicio = (Button) findViewById(R.id.btnProgramacaoSemanalExercicio);
        Button perfilUsuario = (Button) findViewById(R.id.btnPerfilUsuario);

        if (!dbRegistro.verificarAdminLogado()) {
            perfilUsuario.setVisibility(View.GONE);
        }

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

}
