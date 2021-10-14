package com.example.projetopdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText editNomeUsuario, editSenhaUsuario;
    private Button btnEntrar, btnCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Intent Cadastro = new Intent(Login.this, Registration.class);
        Intent Viagens = new Intent(Login.this, Trips.class);

        editNomeUsuario = findViewById(R.id.editNomeUsuario);
        editSenhaUsuario = findViewById(R.id.editSenhaUsuario);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnCadastro = findViewById(R.id.btnCadastro);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(Cadastro);
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(Viagens);
            }
        });
    }
}