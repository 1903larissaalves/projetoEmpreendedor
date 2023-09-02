package com.larissa.treinodieta.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.larissa.treinodieta.R;
import com.larissa.treinodieta.dao.MedidasCorporalDao;
import com.larissa.treinodieta.helpers.MedidasCorporalHelper;
import com.larissa.treinodieta.models.MedidasCorporal;

public class MedidasPessoaActivity extends AppCompatActivity {

    private MedidasCorporalHelper medidasCorporalHelper;

    private Button salvar;

    private EditText antebracoE;
    private EditText antebracoD;
    private EditText bracoE;
    private EditText bracoD;
    private EditText cintura;
    private EditText quadril;
    private EditText pernaE;
    private EditText pernaD;
    private EditText peito;

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
            Intent i = new Intent(MedidasPessoaActivity.this, MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medidas_pessoa);
        setTitle(R.string.medidasCorporal);

        salvar = findViewById(R.id.btnSalvar);

        medidasCorporalHelper = new MedidasCorporalHelper(this);

        MedidasCorporalDao dao = new MedidasCorporalDao(this);

        MedidasCorporal ultimaMedida = dao.burcarMedidasCorporal();

        if (ultimaMedida != null){
            medidasCorporalHelper.preencherCampos(ultimaMedida);
        }

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MedidasCorporal medidas = medidasCorporalHelper.getMedidasCorporal();
                if (!validarCampos()){{
                    dao.inserirMedidasCorporal(medidas);
                    dao.close();
                    Toast.makeText(getApplicationContext(), R.string.salvoSucesso , Toast.LENGTH_SHORT).show();
                }}
            }
        });
    }

    public boolean validarCampos(){

        antebracoE = (EditText) findViewById(R.id.edtAntebracoE);
        antebracoD = (EditText) findViewById(R.id.edtAntebracoD);
        bracoE = (EditText) findViewById(R.id.edtBracoE);
        bracoD = (EditText) findViewById(R.id.edtBracoD);
        cintura = (EditText) findViewById(R.id.edtCintura);
        quadril = (EditText) findViewById(R.id.edtQuadril);
        pernaE = (EditText) findViewById(R.id.edtPernaE);
        pernaD = (EditText) findViewById(R.id.edtPernaD);
        peito = (EditText) findViewById(R.id.edtPeito);

        Boolean verificarCamposPreenchidos = false;

        String validaFieldAntebracoE = antebracoE.getText().toString();
        String validaFieldAntebracoD = antebracoD.getText().toString();
        String validaFieldBracoE = bracoE.getText().toString();
        String validaFieldBracoD = bracoD.getText().toString();
        String validaFieldCintura = cintura.getText().toString();
        String validaFieldQuadril = quadril.getText().toString();
        String validaFieldPernaE = pernaE.getText().toString();
        String validaFieldPernaD = pernaD.getText().toString();
        String validaFieldPeito = peito.getText().toString();


        if (validaFieldAntebracoE.equals("")){
            verificarCamposPreenchidos = true;
            antebracoE.setError("Preencha o campo Antebraço Esquerdo");
        }

        if (validaFieldAntebracoD.equals("")){
            verificarCamposPreenchidos = true;
            antebracoD.setError("Preencha o campo Antebraço Direito");
        }

        if (validaFieldBracoE.equals("")){
            verificarCamposPreenchidos = true;
            bracoE.setError("Preencha o campo Braço Esquerdo");
        }

        if (validaFieldBracoD.equals("")){
            verificarCamposPreenchidos = true;
            bracoD.setError("Preencha o campo Braço Direito");
        }

        if (validaFieldCintura.equals("")){
            verificarCamposPreenchidos = true;
            cintura.setError("Preencha o campo Cintura");
        }

        if (validaFieldQuadril.equals("")){
            verificarCamposPreenchidos = true;
            quadril.setError("Preencha o campo Quadril");
        }

        if (validaFieldPernaE.equals("")){
            verificarCamposPreenchidos = true;
            pernaE.setError("Preencha o campo perna Esqueda");
        }

        if (validaFieldPernaD.equals("")){
            verificarCamposPreenchidos = true;
            pernaD.setError("Preencha o campo  perna Direita");
        }

        if (validaFieldPeito.equals("")){
            verificarCamposPreenchidos = true;
            peito.setError("Preencha o campo peito");
        }

        return verificarCamposPreenchidos ;
    }

}
