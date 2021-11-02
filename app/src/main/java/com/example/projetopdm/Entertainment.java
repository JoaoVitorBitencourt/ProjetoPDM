package com.example.projetopdm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetopdm.util.Entretenimento;
import com.example.projetopdm.util.Shared;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Entertainment extends AppCompatActivity {

    private EditText nome, valor;
    private Button adicionar, finalizar;
    private Shared shared = new Shared(Entertainment.this);
    private Set<String> set;
    private List<String> Lista = new ArrayList<String>();
    Gson gson = new Gson();

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entertainment);

        nome = findViewById(R.id.nome);
        valor = findViewById(R.id.valor);
        adicionar = findViewById(R.id.adicionar);
        finalizar = findViewById(R.id.finalizar);
        set = shared.getStringSet("ListaEntretenimento");

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(set == null || set.size() == 0) {
                    set = new HashSet<String>();
                    Lista.addAll(set);
                }


                Entretenimento model = new Entretenimento();

                model.setNome(nome.getText().toString());
                model.setValor(valor.getText().toString());
                Lista.add(gson.toJson(model));

                for(String uri : Lista) {
                    set.add(uri);
                }
                shared.put("ListaEntretenimento", set);
            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent entretenimento = new Intent();
                setResult(Activity.RESULT_OK, entretenimento);
                finish();
            }
        });

        /*
        //Retrieve the values
        Set<String> set = myScores.getStringSet("key", null);

        //Set the values
        Set<String> set = new HashSet<String>();
        set.addAll(listOfExistingScores);
        scoreEditor.putStringSet("key", set);
        scoreEditor.commit();
         */
    }
}
