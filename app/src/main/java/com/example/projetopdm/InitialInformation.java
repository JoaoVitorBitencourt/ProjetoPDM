package com.example.projetopdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetopdm.util.Shared;

public class InitialInformation extends AppCompatActivity {

    private EditText qtdePessoas, qtdeDias, nomeViagem;
    private Button btnSalvar;
    Shared shared = new Shared(InitialInformation.this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initialinformation);

        qtdePessoas = findViewById(R.id.qtdePessoas);
        qtdeDias = findViewById(R.id.qtdeDias);
        nomeViagem = findViewById(R.id.nomeViagem);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(qtdePessoas.getText().toString().equals("") || qtdeDias.getText().toString().equals("") || nomeViagem.getText().toString().equals("")){
                    Toast.makeText(InitialInformation.this, "Os campos acima precisam ser preenchidos", Toast.LENGTH_SHORT).show();
                } else {
                    shared.put("qtdeDias", qtdeDias.getText().toString());
                    shared.put("qtdePessoas", qtdePessoas.getText().toString());
                    shared.put("nomeViagem", nomeViagem.getText().toString());
                    startActivity(new Intent(InitialInformation.this, Trip.class));
                }
            }
        });
    }
}
