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
import com.larissa.treinodieta.dao.CaloriasDiariasDao;
import com.larissa.treinodieta.models.CaloriasDiarias;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContadorCaloriasActivity extends AppCompatActivity {

    private EditText editCaloriasDiarias;
    private EditText editCaloriasConsumidas;
    private TextView txtResultado;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater =  getMenuInflater();
        mMenuInflater.inflate(R.menu.menu, menu);
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
        setContentView(R.layout.activity_contador_calorias);
        setTitle(R.string.contadorCalorias);

        CaloriasDiariasDao dao = new CaloriasDiariasDao(this);
        String dataAtual = getDataAtual();

        editCaloriasDiarias = findViewById(R.id.edtCaloriasDiarias);
        editCaloriasConsumidas = findViewById(R.id.edtCaloriasConsumidas);
        txtResultado = findViewById(R.id.txtResultado);
        Button btnCalcular = findViewById(R.id.btnCalcular);

        CaloriasDiarias caloriasDiariasSalvas = dao.buscarCaloriasDiarias(dataAtual);

        if (caloriasDiariasSalvas != null){
            resetarCampos(caloriasDiariasSalvas);
        }

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular(dao, caloriasDiariasSalvas);
            }
        });
    }

    private String getDataAtual() {
        Date dataAtual = new Date();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");
        String dataFormatada = formatoData.format(dataAtual);
        return dataFormatada.toString();
    }

    private void calcular(CaloriasDiariasDao dao, CaloriasDiarias caloriasDiariasSalvas) {
        String caloriasDiariasStr = editCaloriasDiarias.getText().toString();
        String caloriasConsumidasStr = editCaloriasConsumidas.getText().toString();

        if (!this.validaCamposObrigatorios()) { return; }

        try {
            float caloriasDiarias = Float.parseFloat(caloriasDiariasStr);
            float caloriasConsumidas = Float.parseFloat(caloriasConsumidasStr);
            float caloriasDisponiveis = caloriasDiarias - caloriasConsumidas;

            CaloriasDiarias caloriasDiariasAtuais = new CaloriasDiarias();

            caloriasDiariasAtuais.setCaloriasDisponiveis(caloriasDisponiveis);
            caloriasDiariasAtuais.setData(getDataAtual());

            if (caloriasDiariasSalvas != null) {
                caloriasDiariasAtuais.setId(caloriasDiariasAtuais.getId());
                dao.atualizarCaloriasDiarias(caloriasDiariasAtuais);

            } else {
                dao.inserirCaloriasDiarias(caloriasDiariasAtuais);
            }

            txtResultado.setText("Calorias disponíveis: " + String.format("%.2f", caloriasDisponiveis));
            resetarCampos(caloriasDiariasAtuais);

        } catch (NumberFormatException e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Por favor, insira valores numéricos válidos.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) { dialog.dismiss(); }
                    })
                    .show();
        }
    }

    private void resetarCampos(CaloriasDiarias caloriasDiariasAtuais) {
        editCaloriasDiarias.setText(caloriasDiariasAtuais.getCaloriasDisponiveis().toString());
        editCaloriasConsumidas.setText("");
    }

    private boolean validaCamposObrigatorios() {
        boolean verificarCamposPreenchidos = true;

        EditText[] fields = {
                editCaloriasDiarias,
                editCaloriasConsumidas
        };

        for (EditText field : fields) {
            String FieldValue = field.getText().toString();

            if (FieldValue.isEmpty()) {
                verificarCamposPreenchidos = false;
                field.setError("Esse campo é obrigatório");
            }
        }

        return verificarCamposPreenchidos;
    }
}
