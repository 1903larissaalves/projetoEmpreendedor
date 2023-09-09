package com.larissa.treinodieta.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.larissa.treinodieta.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OpcaoExercicioDiarioActivity extends AppCompatActivity {
    private TextView textViewExercicio;
    private List<String> exercicios = new ArrayList<>();
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
        textViewExercicio = findViewById(R.id.textViewExercicio);

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

        textViewExercicio.setText(exercicios.get(random.nextInt(exercicios.size())));

    }
}
