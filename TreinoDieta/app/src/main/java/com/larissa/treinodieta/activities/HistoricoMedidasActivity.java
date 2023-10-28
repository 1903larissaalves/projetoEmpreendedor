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
import com.larissa.treinodieta.dao.MedidasCorporalDao;
import com.larissa.treinodieta.models.MedidasCorporal;

import java.util.ArrayList;
import java.util.List;

public class HistoricoMedidasActivity extends AppCompatActivity {

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
        if (id == R.id.menu_logout) {
            Intent i = new Intent(this, ActivityLogin.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_medidas);
        setTitle(R.string.labelHistoricoMedidas);

        listaHistoricoMedidas();
    }

    private void listaHistoricoMedidas(){
        final ListView listview = (ListView) findViewById(R.id.listaHistoricoMedidas);
        MedidasCorporalDao medidasCorporalDao = new MedidasCorporalDao(this);

        List<MedidasCorporal> medidasCorporal = medidasCorporalDao.buscarHistoricoMedidasCorporal();
        medidasCorporalDao.close();

        if (medidasCorporal.size() > 0) {
            ArrayAdapter<MedidasCorporal> adapter = new ArrayAdapter<MedidasCorporal>(this, android.R.layout.simple_list_item_1, medidasCorporal);
            ListView historicoMedidas = (ListView) findViewById(R.id.listaHistoricoMedidas);
            historicoMedidas.setAdapter(adapter);
        } else {
            List<String> msgSemMedidaCadastrada = new ArrayList<>();
            msgSemMedidaCadastrada.add("Nenhuma medida cadastrada.");

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, msgSemMedidaCadastrada);
            ListView historicoMedidas = (ListView) findViewById(R.id.listaHistoricoMedidas);
            historicoMedidas.setAdapter(adapter);
        }
    }
}
