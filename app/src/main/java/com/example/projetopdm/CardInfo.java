package com.example.projetopdm;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetopdm.adapter.EntretenimentoAdapter;
import com.example.projetopdm.database.dao.EntretenimentoDAO;
import com.example.projetopdm.database.dao.ViagemDAO;
import com.example.projetopdm.database.model.EntretenimentoModel;
import com.example.projetopdm.database.model.Viagem;
import com.example.projetopdm.util.Entretenimento;
import com.example.projetopdm.util.Shared;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CardInfo extends AppCompatActivity {

    private TextView qtdeViajantes, qtdeDiasViagem, valorTotalViagem, valorPorPessoa;
    private ViagemDAO viagemDao = new ViagemDAO(this);
    private EntretenimentoDAO entretenimentoDao = new EntretenimentoDAO(this);
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
        ListView listaEntretenimento = findViewById(R.id.listEntretenimento);
        Entretenimento model;

        model_viagem = viagemDao.SelectCard(getIntent().getLongExtra("IdViagem", 0));
        List<EntretenimentoModel> listaModel = entretenimentoDao.Select(getIntent().getLongExtra("IdViagem", 0));

        if (listaModel != null) {
            List<Entretenimento> listaModelStrig = new ArrayList<>();

            for (EntretenimentoModel entretenimentoModel : listaModel) {
                model = new Entretenimento();
                model.setNome(entretenimentoModel.getNome());
                model.setValor(Float.toString(entretenimentoModel.getValor_total()));
                listaModelStrig.add(model);
            }

            listaEntretenimento.setAdapter(new EntretenimentoAdapter(this, listaModelStrig));
        }

        float valorTotal = model_viagem.getValor_total();

        qtdeViajantes.setText(Integer.toString(model_viagem.getQtde_pessoas()));
        qtdeDiasViagem.setText(Integer.toString(model_viagem.getQtde_dias()));
        valorTotalViagem.setText("R$" + new DecimalFormat("###,###,##0.00").format(valorTotal));
        valorPorPessoa.setText("R$" + new DecimalFormat("###,###,##0.00").format(model_viagem.getValor_total() / model_viagem.getQtde_pessoas()));
    }
}
