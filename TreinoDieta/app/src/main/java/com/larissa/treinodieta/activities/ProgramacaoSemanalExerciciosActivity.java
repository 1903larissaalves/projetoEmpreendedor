package com.larissa.treinodieta.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.larissa.treinodieta.R;
import com.larissa.treinodieta.adapters.ExercicioSemanalViewPagerAdapter;
import com.larissa.treinodieta.dao.ExercicioSemanalDao;
import com.larissa.treinodieta.models.ExercicioSemanal;

import java.util.List;

public class ProgramacaoSemanalExerciciosActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ExercicioSemanalViewPagerAdapter adapter;
    private TabLayout tabLayout;
    private Button randomizarExercicios;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.voltar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
        setContentView(R.layout.activity_programacao_semanal_exercicios);
        setTitle(R.string.labelProgramacaoSemanalExerciciosSmall);
        randomizarExercicios = findViewById(R.id.btnRandomizarExercicios);

        List<ExercicioSemanal> exerciciosSemanal = listaExerciciosSemanal();

        viewPager = findViewById(R.id.pager);

        adapter = new ExercicioSemanalViewPagerAdapter(getSupportFragmentManager(), exerciciosSemanal);
        viewPager.setAdapter(adapter);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        randomizarExercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Exercicios Alterados. Saia da tela e entre novamente para atualizar.", Toast.LENGTH_LONG).show();
                randomizarExercicios(exerciciosSemanal);
            }
        });
    }

    private List<ExercicioSemanal> listaExerciciosSemanal() {
        ExercicioSemanalDao dao = new ExercicioSemanalDao(this);
        List<ExercicioSemanal> exercicios = dao.buscarExercicioSemanal();
        dao.close();

        return exercicios;
    }

    private void randomizarExercicios(List<ExercicioSemanal> exerciciosSemanal) {
        ExercicioSemanalDao dao = new ExercicioSemanalDao(this);
        dao.randomizarExercicioAtual(exerciciosSemanal);
        dao.close();
    }
}