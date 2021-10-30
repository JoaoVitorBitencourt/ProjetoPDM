package com.example.projetopdm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.projetopdm.database.dao.ViagemDAO;
import com.example.projetopdm.database.model.UsuarioModel;
import com.example.projetopdm.database.model.Viagem;
import com.example.projetopdm.util.Shared;
import com.example.projetopdm.util.Calculations;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Fuel extends AppCompatActivity {

    private EditText TotEstimadoKm, MediaKmL, CustoMedioL, TotalVeiculos;
    private TextView ValorTotal;
    private Button calcular, finalizar;
    private Calculations calculos;
    private Shared shared = new Shared(Fuel.this);
    private float total;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fuel);

        TotEstimadoKm = findViewById(R.id.TotEstimadoKm);
        MediaKmL = findViewById(R.id.MediaKmL);
        CustoMedioL = findViewById(R.id.CustoMedioL);
        TotalVeiculos = findViewById(R.id.TotalVeiculos);
        ValorTotal = findViewById(R.id.ValorTot);
        calcular = findViewById(R.id.calcular);
        finalizar = findViewById(R.id.finalizar);
        calculos = new Calculations();

        TotEstimadoKm.getText();

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = calculos.custoCombustivel(Float.parseFloat(TotEstimadoKm.getText().toString()),
                                                  Float.parseFloat(MediaKmL.getText().toString()),
                                                  Float.parseFloat(CustoMedioL.getText().toString()),
                                                  Integer.parseInt(TotalVeiculos.getText().toString()));

                ValorTotal.setText("R$" + total);
            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shared.put("TotalCustoCombustivel", total);
                Intent combustivel = new Intent();
                setResult(Activity.RESULT_OK, combustivel);
                finish();
            }
        });
    }

}
