package com.example.projetopdm;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import com.example.projetopdm.util.calculations;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Fuel extends AppCompatActivity {

    private EditText TotEstimadoKm, MediaKmL, CustoMedioL, TotalVeiculos;
    private TextView ValorTotal;
    private Switch switch1;
    private Button calcular, finalizar;
    private calculations calculos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fuel);

        TotEstimadoKm = findViewById(R.id.TotEstimadoKm);
        MediaKmL = findViewById(R.id.MediaKmL);
        CustoMedioL = findViewById(R.id.CustoMedioL);
        TotalVeiculos = findViewById(R.id.TotalVeiculos);
        ValorTotal = findViewById(R.id.ValorTot);
        switch1 = findViewById(R.id.switch1);
        calcular = findViewById(R.id.calcular);
        finalizar = findViewById(R.id.finalizar);
        calculos = new calculations();

        switch1.isChecked();

        TotEstimadoKm.getText();

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String total;

                total = calculos.custoCombustivel(Float.parseFloat(TotEstimadoKm.getText().toString()),
                                                  Float.parseFloat(MediaKmL.getText().toString()),
                                                  Float.parseFloat(CustoMedioL.getText().toString()),
                                                  Integer.parseInt(TotalVeiculos.getText().toString()));

                ValorTotal.setText(total);
            }

        });
    }
}