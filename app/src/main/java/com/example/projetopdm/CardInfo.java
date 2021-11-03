package com.example.projetopdm;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetopdm.database.dao.ViagemDAO;
import com.example.projetopdm.database.model.Viagem;
import com.example.projetopdm.util.Shared;

import java.text.DecimalFormat;

public class CardInfo extends AppCompatActivity {

    private TextView qtdeViajantes, qtdeDiasViagem, valorTotalViagem, valorPorPessoa;
    private ViagemDAO dao = new ViagemDAO(this);
    private Shared shared = new Shared(this);
    private Viagem model_viagem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardinfo);

        qtdeViajantes = findViewById(R.id.qtdeViajantes);
        qtdeDiasViagem = findViewById(R.id.duracaoViagem);
        valorTotalViagem = findViewById(R.id.valorTotal);
        valorPorPessoa = findViewById(R.id.valorPorPessoa);

        model_viagem = dao.SelectCard(getIntent().getLongExtra("IdViagem", 0));

        float valorTotal = model_viagem.getValor_total();

        qtdeViajantes.setText(Integer.toString(model_viagem.getQtde_pessoas()));
        qtdeDiasViagem.setText(Integer.toString(model_viagem.getQtde_dias()));
        valorTotalViagem.setText("R$" + new DecimalFormat("###,###,##0.00").format(valorTotal));
        valorPorPessoa.setText("R$" + new DecimalFormat("###,###,##0.00").format(model_viagem.getValor_total() / model_viagem.getQtde_pessoas()));
    }
}
