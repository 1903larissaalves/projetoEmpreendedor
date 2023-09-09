package com.larissa.treinodieta.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.larissa.treinodieta.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OpcaoExercicioDiarioActivity extends AppCompatActivity {

    private TextView txtEcerciciosDiarios;
    private List<String> exercicios = new ArrayList<>();
    private Button btnExercicio;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater =  getMenuInflater();
        mMenuInflater.inflate(R.menu.voltar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_voltar) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcao_exercicio_diario);
        setTitle(R.string.labelOpcaoExercicioDiario);
        txtEcerciciosDiarios = findViewById(R.id.txtEcerciciosDiarios);
        btnExercicio = findViewById((R.id.btnExercicio));

        btnExercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opcaoExercicioDiario();
            }
        });
    }

    private void opcaoExercicioDiario(){
        Random random = new Random();
        exercicios.add("Alongar Costas");
        exercicios.add("Alongar Pernas");
        exercicios.add("Alongar Pescoço");
        exercicios.add("Alongar Braços");
        exercicios.add("Rotações de Ombros");
        exercicios.add("Flexão de Quadril em pé");
        exercicios.add("Alongamento de Panturrilha");
        exercicios.add("Agachamento Profundo");
        exercicios.add("Estiramento de Peitoral");
        exercicios.add("Rotações de Tornozelo");

        txtEcerciciosDiarios.setText(exercicios.get(random.nextInt(exercicios.size())));
    }



}
