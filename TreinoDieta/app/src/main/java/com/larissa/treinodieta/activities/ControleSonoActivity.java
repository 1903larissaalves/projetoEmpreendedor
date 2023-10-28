package com.larissa.treinodieta.activities;

import android.content.DialogInterface;

import android.content.Intent;

import android.os.Bundle;

import android.support.v7.app.AlertDialog;

import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.larissa.treinodieta.R;
import com.larissa.treinodieta.dao.ControleSonoDao;
import com.larissa.treinodieta.models.ControleSono;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ControleSonoActivity extends AppCompatActivity {

    private EditText edtHorasDiarias;
    private EditText edtHorasDormidas;
    private TextView txtResultado;

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
        if (id == R.id.menu_logout) {
            Intent i = new Intent(this, ActivityLogin.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controle_sono);
        setTitle(R.string.labelControleSono);

        ControleSonoDao dao = new ControleSonoDao(this);
        String dataAtual = getDataAtual();

        edtHorasDiarias = findViewById(R.id.edtHorasDiarias);
        edtHorasDormidas = findViewById(R.id.edtHorasDormidas);
        txtResultado = findViewById(R.id.txtResultado);

        Button btnCalcular = findViewById(R.id.btnCalcular);

        ControleSono ControleSonoSalvo = dao.buscarTempoDisponiveisSono(dataAtual);

        if (ControleSonoSalvo != null){
            resetarCampos(ControleSonoSalvo);
        }

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular(dao, ControleSonoSalvo);
            }
        });

    }

    private void calcular(ControleSonoDao dao, ControleSono controleSonoSalvo) {
        String horasDiariasStr = edtHorasDiarias.getText().toString();
        String horasDormidasStr = edtHorasDormidas.getText().toString();

        if (!this.validaCamposObrigatorios()) {
            return;
        }

        try {
            float horasDiarias = Float.parseFloat(horasDiariasStr);
            float horasDormidas = Float.parseFloat(horasDormidasStr);
            float tempoDisponiveis = horasDiarias - horasDormidas;

            ControleSono ControleSonoHorasDiponiveis = new ControleSono();

            ControleSonoHorasDiponiveis.setTempoDisponiveisSono(tempoDisponiveis);
            ControleSonoHorasDiponiveis.setData(getDataAtual());

            if (controleSonoSalvo != null) {
                ControleSonoHorasDiponiveis.setId(controleSonoSalvo.getId());
                dao.atualizarControleSono(ControleSonoHorasDiponiveis);

            } else {
                dao.inserirControleSono(ControleSonoHorasDiponiveis);
            }

            txtResultado.setText(String.format("Tempo de sono diponível: %.2f", ControleSonoHorasDiponiveis.getTempoDisponiveisSono()));
            resetarCampos(ControleSonoHorasDiponiveis);

        } catch (NumberFormatException e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Insira valores válidos.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) { dialog.dismiss(); }
                    }).show();
        }
    }

    private String getDataAtual() {
        Date dataAtual = new Date();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");
        String dataFormatada = formatoData.format(dataAtual);
        return dataFormatada.toString();
    }

    private void resetarCampos(ControleSono TempoDisponivelSono) {
        edtHorasDiarias.setText(TempoDisponivelSono.getTempoDisponiveisSono().toString());
        edtHorasDormidas.setText("");
    }

    private boolean validaCamposObrigatorios() {
        boolean verificarCamposPreenchidos = true;

        EditText[] fields = {
                edtHorasDiarias,
                edtHorasDormidas
        };

        for (EditText field : fields) {
            String FieldValue = field.getText().toString();

            if (FieldValue.isEmpty()) {
                verificarCamposPreenchidos = false;
                field.setError("Campo Obrigatório!");
            }
        }

        return verificarCamposPreenchidos;
    }

}
