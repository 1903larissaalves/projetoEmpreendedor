package com.larissa.treinodieta.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.larissa.treinodieta.R;
import com.larissa.treinodieta.dao.imcDAO;
import com.larissa.treinodieta.models.CalcularIMC;

import java.util.ArrayList;
import java.util.List;

public class PesoAvalicoesActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_peso_avaliacoes);
        setTitle(R.string.labelPesoAvaliacoes);

        listaPesoAvaliacoes();
    }

    private void listaPesoAvaliacoes(){
        final ListView listview = (ListView) findViewById(R.id.listaPesoAvaliacoes);
        imcDAO imcDAO = new imcDAO(this);

        List <CalcularIMC> calcular = imcDAO.buscarHistoricoIMC();
        imcDAO.close();

        if (calcular.size() > 0){
            ArrayAdapter<CalcularIMC> adapter = new ArrayAdapter<CalcularIMC>(this, android.R.layout.simple_list_item_1, calcular);
            ListView historicoIMC = (ListView) findViewById(R.id.listaPesoAvaliacoes);
            historicoIMC.setAdapter(adapter);
        } else {
            List<String> msgSemIMCCadastrado = new ArrayList<>();
            msgSemIMCCadastrado.add("Nenhum registro de IMC.");

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, msgSemIMCCadastrado);
            ListView historicoIMC = (ListView) findViewById(R.id.listaPesoAvaliacoes);
            historicoIMC.setAdapter(adapter);
        }
    }
}
