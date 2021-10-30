package com.example.projetopdm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetopdm.util.Calculations;
import com.example.projetopdm.util.Shared;

public class Snack extends AppCompatActivity {

    private EditText refeicoesPorDia, custoEstimadoRefeicao;
    private Button calcular, finalizar;
    private Calculations calculos;
    private Shared shared = new Shared(Snack.this);
    private TextView valorTotal;
    private float total;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snack);

        refeicoesPorDia = findViewById(R.id.refeicoesPorDia);
        custoEstimadoRefeicao = findViewById(R.id.custoEstimadoRefeicao);
        calcular = findViewById(R.id.calcular);
        finalizar = findViewById(R.id.finalizar);
        valorTotal = findViewById(R.id.valorTotal);
        calculos = new Calculations();

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = calculos.custoRefeicoes(
                        Integer.parseInt(refeicoesPorDia.getText().toString()),
                        Integer.parseInt(shared.getString("qtdePessoas")),
                        Float.parseFloat(custoEstimadoRefeicao.getText().toString()),
                        Integer.parseInt(shared.getString("qtdeDias"))
                );

                valorTotal.setText("R$" + total);
            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shared.put("TotalCustoRefeicoes", total);
                Intent refeicao = new Intent();
                setResult(Activity.RESULT_OK, refeicao);
                finish();
            }
        });
    }
}
