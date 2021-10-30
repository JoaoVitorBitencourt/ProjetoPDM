package com.example.projetopdm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetopdm.util.Calculations;
import com.example.projetopdm.util.Shared;

public class Accommodation extends AppCompatActivity {

    private EditText custoMedio, totalNoites, totalQuartos;
    private TextView valorTotal;
    private Button calcular, finalizar;
    private Calculations calculos;
    private float total;
    private Shared shared = new Shared(Accommodation.this);

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accommodation);

        custoMedio = findViewById(R.id.custoMedioPorNoite);
        totalNoites = findViewById(R.id.totalNoites);
        totalQuartos = findViewById(R.id.totalQuartos);
        valorTotal = findViewById(R.id.valorTotal);
        calcular = findViewById(R.id.calcular);
        finalizar = findViewById(R.id.finalizar);
        calculos = new Calculations();

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = calculos.custoHospedagem(
                        Float.parseFloat(custoMedio.getText().toString()),
                        Integer.parseInt(totalNoites.getText().toString()),
                        Integer.parseInt(totalQuartos.getText().toString())
                );

                valorTotal.setText("R$" + total);
            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shared.put("TotalCustoHospedagem", total);
                Intent hospedagem = new Intent();
                setResult(Activity.RESULT_OK, hospedagem);
                finish();
            }
        });
    }
}
