package com.larissa.treinodieta.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.larissa.treinodieta.R;
import com.larissa.treinodieta.adapters.ExercicioSemanalViewPagerAdapter;

public class ProgramacaoSemanalExerciciosActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ExercicioSemanalViewPagerAdapter adapter;
    private TabLayout tabLayout;

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

        viewPager = findViewById(R.id.pager);
        adapter = new ExercicioSemanalViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}