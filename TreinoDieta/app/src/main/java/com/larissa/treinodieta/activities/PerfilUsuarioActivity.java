package com.larissa.treinodieta.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.larissa.treinodieta.R;
import com.larissa.treinodieta.dao.PerfilUsuarioDao;
import com.larissa.treinodieta.models.PerfilUsuario;

public class PerfilUsuarioActivity extends AppCompatActivity {

    private EditText editEmail,editsenha;
    private Spinner spinnerTipoPerfil;

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

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        setTitle(R.string.labelPerfilUsuario);

        editsenha = findViewById(R.id.editTextSenha);
        editEmail = findViewById(R.id.EditTextEmailLogin);
        spinnerTipoPerfil = findViewById(R.id.SpinnerTipoPerfil);
        Button btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                salvar();
            }
        });
    }

    private void salvar() {
        if (!this.validaCamposObrigatorios()) { return; }

        PerfilUsuarioDao dao = new PerfilUsuarioDao(this);
        PerfilUsuario perfilUsuario = new PerfilUsuario();
        String senha = editsenha.getText().toString();
        String email = editEmail.getText().toString();
        String tipoPerfil = spinnerTipoPerfil.getSelectedItem().toString();

        perfilUsuario.setEmail(email);
        perfilUsuario.setSenha(senha);
        perfilUsuario.setTipousuario(tipoPerfil);

        dao.inserirUsuario(perfilUsuario);
        dao.close();
        Toast.makeText(getApplicationContext(), R.string.salvoSucesso , Toast.LENGTH_SHORT).show();
        limpar();
    }

    private boolean validaCamposObrigatorios() {
        boolean verificarCamposPreenchidos = true;

        String emailValue = editEmail.getText().toString();
        String senhaValue = editsenha.getText().toString();
        int tipoPerfilPosition = spinnerTipoPerfil.getSelectedItemPosition();

        if (emailValue.isEmpty()) {
            verificarCamposPreenchidos = false;
            editEmail.setError("Esse campo é obrigatório");
        }
        if (senhaValue.isEmpty()){
           verificarCamposPreenchidos = false;
           editsenha.setError("esse campo é obrigatório");
        }
        if (tipoPerfilPosition == 0) {
            verificarCamposPreenchidos = false;
            Toast.makeText(getApplicationContext(), "Selecione o tipo de perfil" , Toast.LENGTH_SHORT).show();
        }

        return verificarCamposPreenchidos;
    }

    private void limpar(){
        editEmail.setText("");
        editsenha.setText("");
        spinnerTipoPerfil.setSelection(0);
    }
}
