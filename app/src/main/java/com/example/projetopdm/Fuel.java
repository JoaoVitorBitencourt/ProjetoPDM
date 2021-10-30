package com.example.projetopdm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetopdm.database.dao.UsuarioDAO;
import com.example.projetopdm.database.dao.ViagemDAO;
import com.example.projetopdm.database.model.UsuarioModel;
import com.example.projetopdm.database.model.Viagem;
import com.example.projetopdm.util.Shared;
import com.example.projetopdm.util.calculations;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Fuel extends AppCompatActivity {

    private EditText TotEstimadoKm, MediaKmL, CustoMedioL, TotalVeiculos;
    private TextView ValorTotal;
    private Switch switch1;
    private String valorTot;
    private Button calcular, finalizar;
    private calculations calculos;
    private UsuarioModel model;
    private ViagemDAO dao;
    private ViagemDAO daoViagem;
    private float valor_combustivel_total;
    private long id_user;
    private Shared shared = new Shared(Fuel.this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fuel);
        dao = new ViagemDAO(Fuel.this);
        Viagem viagemModel = new Viagem();

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
                float total;

                total = calculos.custoCombustivel(Float.parseFloat(TotEstimadoKm.getText().toString()),
                                                  Float.parseFloat(MediaKmL.getText().toString()),
                                                  Float.parseFloat(CustoMedioL.getText().toString()),
                                                  Integer.parseInt(TotalVeiculos.getText().toString()));

                ValorTotal.setText("R$" + total);
                valorTot=Float.toString(total);
            }

        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float total;

                total = calculos.custoCombustivel(Float.parseFloat(TotEstimadoKm.getText().toString()),
                        Float.parseFloat(MediaKmL.getText().toString()),
                        Float.parseFloat(CustoMedioL.getText().toString()),
                        Integer.parseInt(TotalVeiculos.getText().toString()));

                shared.put("TotalCustoCombustivel", total);
                startActivity(new Intent(Fuel.this, Trip.class));
            }

        });
    }

}
