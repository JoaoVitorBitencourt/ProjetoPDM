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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetopdm.database.dao.ViagemDAO;
import com.example.projetopdm.database.model.Viagem;
import com.example.projetopdm.util.Shared;
import com.example.projetopdm.util.Viajantes;

public class Trip extends AppCompatActivity {

    private Button adicionarCustoViagemAerea, adicionarCustoRefeicao, adicionarCustoEntretenimento, adicionarCustoHospedagem, salvarViagem, adicionarCustoCombustivel;
    private TextView qtdadePessoas, duracaoViagem, custoCombustivelText, custoViagemAereaText, custoRefeicoesText, custoHospedagemText;
    private Shared shared = new Shared(Trip.this);
    public int teste;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            atualizar();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void atualizar() {
        custoCombustivelText = findViewById(R.id.custoCombustivelText);
        custoViagemAereaText = findViewById(R.id.custoViagemAereaText);
        custoRefeicoesText = findViewById(R.id.custoRefeicoesText);
        custoHospedagemText = findViewById(R.id.custoHospedagemText);

        qtdadePessoas.setText(shared.getString("qtdePessoas"));
        duracaoViagem.setText(shared.getString("qtdeDias"));
        custoCombustivelText.setText("R$ " + Math.floor(Float.toString(shared.getFloat("TotalCustoCombustivel")) == null ? 0.00f : shared.getFloat("TotalCustoCombustivel")* 100) /100);
        custoViagemAereaText.setText("R$ " + Math.floor(Float.toString(shared.getFloat("TotalCustoViagemAerea")) == null ? 0.00f : shared.getFloat("TotalCustoViagemAerea")* 100) /100);
        custoRefeicoesText.setText("R$ " + Math.floor(Float.toString(shared.getFloat("TotalCustoRefeicoes")) == null ? 0.00f : shared.getFloat("TotalCustoRefeicoes")* 100) /100);
        custoHospedagemText.setText("R$ " + Math.floor(Float.toString(shared.getFloat("TotalCustoHospedagem")) == null ? 0.00f : shared.getFloat("TotalCustoHospedagem")* 100) /100);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trip);

        qtdadePessoas = findViewById(R.id.qtdadePessoas);
        duracaoViagem = findViewById(R.id.duracaoViagem);
        adicionarCustoCombustivel = findViewById(R.id.AdicionarCustoCombustivel);
        adicionarCustoViagemAerea = findViewById(R.id.AdicionarCustoViagemAerea);
        adicionarCustoRefeicao = findViewById(R.id.AdicionarCustoRefeicoes);
        adicionarCustoHospedagem = findViewById(R.id.AdicionarCustoHospedagem);
        salvarViagem = findViewById(R.id.btnSalvarViagem);

        atualizar();

        adicionarCustoCombustivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Trip.this, Fuel.class), teste);
            }
        });

        adicionarCustoViagemAerea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Trip.this, Airfare.class), teste);
            }
        });

        adicionarCustoRefeicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Trip.this, Snack.class), teste);
            }
        });

        adicionarCustoHospedagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Trip.this, Accommodation.class), teste);
            }
        });

        salvarViagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
