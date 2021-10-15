package com.example.projetopdm;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {

    private EditText editNome, editUsuario, editSenha;
    private Button btn_cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        editNome=findViewById(R.id.editNome);
        editUsuario=findViewById(R.id.editNomeUsuario);
        editSenha=findViewById(R.id.editSenha);
        btn_cadastrar=findViewById(R.id.btn_cadastrar);
    }
}
