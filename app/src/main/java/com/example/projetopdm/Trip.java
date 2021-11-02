package com.example.projetopdm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetopdm.adapter.EntretenimentoAdapter;
import com.example.projetopdm.database.dao.EntretenimentoDAO;
import com.example.projetopdm.database.dao.ViagemDAO;
import com.example.projetopdm.database.model.EntretenimentoModel;
import com.example.projetopdm.database.model.Viagem;
import com.example.projetopdm.util.Entretenimento;
import com.example.projetopdm.util.Shared;
import com.example.projetopdm.util.Viajantes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Trip extends AppCompatActivity {

    private Button adicionarCustoViagemAerea, adicionarCustoRefeicao, adicionarEntretenimento, adicionarCustoHospedagem, salvarViagem, adicionarCustoCombustivel;
    private TextView qtdadePessoas, duracaoViagem, custoCombustivelText, custoViagemAereaText, custoRefeicoesText, custoHospedagemText;
    private Shared shared = new Shared(Trip.this);
    public int teste;
    private ListView listaEntretenimento;
    private float Total_Airfare,Total_Accommodation, Total_Fuel, Total_Snack, Total_Valor_Viagem;
    private long id_user,id_viagem;
    private LayoutInflater layoutInflater;
    private ViagemDAO dao;
    private EntretenimentoDAO E_dao;
    private Set<Entretenimento> set;
    private List<String> listaNomes;
    private List<Entretenimento> Lista = new ArrayList<Entretenimento>();

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
        set = shared.getStringSet("ListaEntretenimento");

        if(set != null && set.size() != 0) {
            for(Entretenimento uri : set) {
                listaNomes.add(uri.getNome());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    R.layout.entertainment_row,
                    listaNomes);

            listaEntretenimento.setAdapter(adapter);
        }

        qtdadePessoas.setText(shared.getString("qtdePessoas"));
        duracaoViagem.setText(shared.getString("qtdeDias"));
        custoCombustivelText.setText("R$ " + Math.floor(Float.toString(shared.getFloat("TotalCustoCombustivel")) == null ? 0.00f : shared.getFloat("TotalCustoCombustivel")* 100) /100);
        custoViagemAereaText.setText("R$ " + Math.floor(Float.toString(shared.getFloat("TotalCustoViagemAerea")) == null ? 0.00f : shared.getFloat("TotalCustoViagemAerea")* 100) /100);
        custoRefeicoesText.setText("R$ " + Math.floor(Float.toString(shared.getFloat("TotalCustoRefeicoes")) == null ? 0.00f : shared.getFloat("TotalCustoRefeicoes")* 100) /100);
        custoHospedagemText.setText("R$ " + Math.floor(Float.toString(shared.getFloat("TotalCustoHospedagem")) == null ? 0.00f : shared.getFloat("TotalCustoHospedagem")* 100) /100);
        //listaEntretenimento.setAdapter(new EntretenimentoAdapter(Trip.this, new EntretenimentoDAO(this).Select(1)));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trip);

        dao=new ViagemDAO(Trip.this);
        E_dao= new EntretenimentoDAO(Trip.this);

        qtdadePessoas = findViewById(R.id.qtdadePessoas);
        duracaoViagem = findViewById(R.id.duracaoViagem);
        adicionarCustoCombustivel = findViewById(R.id.AdicionarCustoCombustivel);
        adicionarCustoViagemAerea = findViewById(R.id.AdicionarCustoViagemAerea);
        adicionarCustoRefeicao = findViewById(R.id.AdicionarCustoRefeicoes);
        adicionarCustoHospedagem = findViewById(R.id.AdicionarCustoHospedagem);
        salvarViagem = findViewById(R.id.btnSalvarViagem);
        listaEntretenimento = findViewById(R.id.listEntretenimento);
        adicionarEntretenimento = findViewById(R.id.adicionarEntretenimento);

        shared.put("ListaEntretenimento", null);

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

        adicionarEntretenimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Trip.this, Entertainment.class), teste);
            }
        });

        salvarViagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Viagem model= new Viagem();
                model=getViagemModel();
                if(dao.Insert(model)!=-1){
                    Viagem model_id=new Viagem();
                    EntretenimentoModel Ent_model = new EntretenimentoModel();
                    ArrayList<Viagem> viagem_model = new ArrayList<>();
                    viagem_model = (ArrayList<Viagem>) dao.Select(model.getIdusuario());
                    id_viagem = viagem_model.size()-1;

                    //-pegar a lista no shared e passar pro laço de repetição.

                    /*for(Entretenimento uri : Lista) {
                        Ent_model = set_Entretenimento(lista,id_viagem);
                        E_dao.Insert(Ent_model);
                    }*/


                    Toast.makeText(Trip.this, "Viagem cadastrada", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(Trip.this, "Erro ao cadastrar viagem!", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    private final Entretenimento getEntretenimentoModel(List lista){
        Entretenimento entretenimento = new Entretenimento();
            entretenimento.setNome();
            entretenimento.setValor();
            return entretenimento;
    }

    private final EntretenimentoModel set_Entretenimento(Entretenimento model, long id_viagem){
        EntretenimentoModel ent_model= new EntretenimentoModel();
        ent_model.setNome(model.getNome());
        ent_model.setValor_total(Float.parseFloat(model.getValor()));
        ent_model.setIdviagem(id_viagem);
        return ent_model;
    }


    private final Viagem getViagemModel(){
        Viagem viagem= new Viagem();
        Total_Airfare=(shared.getFloat("TotalCustoViagemAerea"));
        Total_Fuel=(shared.getFloat("TotalCustoCombustivel"));
        Total_Snack=(shared.getFloat("TotalCustoRefeicoes"));
        Total_Accommodation=(shared.getFloat("TotalCustoHospedagem"));
        Total_Valor_Viagem=0;
        id_user=(shared.getLong("ID"));

        viagem.setIdusuario(id_user);
        viagem.setTarifa_aerea(Total_Airfare);
        viagem.setRefeicoes(Total_Snack);
        viagem.setTotal_combustivel(Total_Fuel);
        viagem.setHospedagem(Total_Accommodation);
        viagem.setValor_total(Total_Valor_Viagem);
        viagem.setId_entretenimento(-1);
        return viagem;
    }


}
