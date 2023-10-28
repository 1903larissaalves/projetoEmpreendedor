package com.larissa.treinodieta.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.larissa.treinodieta.R;
import com.larissa.treinodieta.dao.PerfilUsuarioDao;

public class ActivityLogin extends AppCompatActivity {
    PerfilUsuarioDao dbRegistro;
    EditText editTextUsuario, editTextSenha;
    Button btnLogin,btnRegistro;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_login);

        dbRegistro = new PerfilUsuarioDao(this);
        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextSenha = findViewById(R.id.editTextSenha);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean loginId = dbRegistro.checkNomeUsuario(editTextUsuario.getText().toString(), editTextSenha.getText().toString());
                if (loginId){
                    dbRegistro.setarUsuarioLogado(editTextUsuario.getText().toString());

                    Intent intent = new Intent(ActivityLogin.this, MainActivity.class);
                    startActivity(intent);
                }else
                    Toast.makeText(ActivityLogin.this, "Login falhou!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}