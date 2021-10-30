package com.example.projetopdm;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetopdm.database.dao.ViagemDAO;
import com.example.projetopdm.database.model.Viagem;
import com.example.projetopdm.util.Shared;
import com.example.projetopdm.util.Calculations;

public class Airfare extends AppCompatActivity {

    private EditText CustoPessoa, AluguelVeic;
    private TextView Valor_Total;
    private Button calcular, finalizar;
    private Shared shared = new Shared(Airfare.this);
    private float total;
    private Calculations calculos;

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.airfare);

        CustoPessoa=findViewById(R.id.editCustoEstPess);
        AluguelVeic=findViewById(R.id.editAluguelVeic);
        calcular = findViewById(R.id.calcular);
        finalizar = findViewById(R.id.finalizar);
        Valor_Total=findViewById(R.id.TextViewTotal);
        calculos = new Calculations();

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = calculos.custoTarifaAerea(
                        Float.parseFloat(CustoPessoa.getText().toString()),
                        Integer.parseInt(shared.getString("qtdePessoas")),
                        Float.parseFloat(AluguelVeic.getText().toString())
                );

                Valor_Total.setText("R$ "+total);
            }

        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shared.put("TotalCustoViagemAerea", total);
                Intent viagemAerea = new Intent();
                setResult(Activity.RESULT_OK, viagemAerea);
                finish();
            }
        });

    }

}

//