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
import com.larissa.treinodieta.dao.ExercicioDiarioDao;
import com.larissa.treinodieta.models.ExercicioDiario;
import com.larissa.treinodieta.models.MedidasCorporal;

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

        List<ExercicioDiario> exerciciosDiario = listaExercicioDiario();

        btnExercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opcaoExercicioDiario(exerciciosDiario);
            }
        });
    }

    private List<ExercicioDiario> listaExercicioDiario() {
        ExercicioDiarioDao dao = new ExercicioDiarioDao(this);

        List<ExercicioDiario> exercicioDiarios = dao.buscarExerciciosDiario();
        dao.close();

        return exercicioDiarios;
    }

    private void opcaoExercicioDiario(List<ExercicioDiario> exercicioDiarios){
        Random random = new Random();

        txtEcerciciosDiarios.setText(exercicioDiarios.get(random.nextInt(exercicioDiarios.size())).getExercicio());
    }



}
