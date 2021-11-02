package com.example.projetopdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Trip extends AppCompatActivity {

    private Button adicionarCustoViagemAerea, adicionarCustoRefeicao, adicionarEntretenimento, adicionarCustoHospedagem, salvarViagem, adicionarCustoCombustivel;
    private TextView qtdadePessoas, duracaoViagem, custoCombustivelText, custoViagemAereaText, custoRefeicoesText, custoHospedagemText;
    private Shared shared = new Shared(Trip.this);
    public int returnActivity, qtdeDias, qtdePessoas;
    private ListView listaEntretenimento;
    private float Total_Airfare,Total_Accommodation, Total_Fuel, Total_Snack, Total_Valor_Viagem;
    private long id_user,id_viagem;
    private ViagemDAO dao;
    private List<Viagem> model_viagem;
    private EntretenimentoDAO E_dao;
    private List<Entretenimento> Lista = new ArrayList<Entretenimento>();
    private Set<String> set;
    private List<Entretenimento> listaModel = new ArrayList<Entretenimento>();
    Gson gson = new Gson();
    List<String> list;
    private float totalEntretenimento = 0.00f;

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
            list = new ArrayList<String>(set);

            //for(int i = 0; i < list.size(); i++) {
            for(String entretenimentoJson : list) {
                Entretenimento entretenimento = gson.fromJson(entretenimentoJson, Entretenimento.class);
                listaModel.add(entretenimento);
            }

            listaEntretenimento.setAdapter(new EntretenimentoAdapter(this, listaModel));
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

        Viagem model_id = new Viagem();
        EntretenimentoModel Ent_model = new EntretenimentoModel();


        qtdadePessoas = findViewById(R.id.qtdadePessoas);
        duracaoViagem = findViewById(R.id.duracaoViagem);
        adicionarCustoCombustivel = findViewById(R.id.AdicionarCustoCombustivel);
        adicionarCustoViagemAerea = findViewById(R.id.AdicionarCustoViagemAerea);
        adicionarCustoRefeicao = findViewById(R.id.AdicionarCustoRefeicoes);
        adicionarCustoHospedagem = findViewById(R.id.AdicionarCustoHospedagem);
        salvarViagem = findViewById(R.id.btnSalvarViagem);
        listaEntretenimento = findViewById(R.id.listEntretenimento);
        adicionarEntretenimento = findViewById(R.id.adicionarEntretenimento);

        shared.put("ListaEntretenimento", new HashSet<>());

        atualizar();

        adicionarCustoCombustivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Trip.this, Fuel.class), returnActivity);
            }
        });

        adicionarCustoViagemAerea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Trip.this, Airfare.class), returnActivity);
            }
        });

        adicionarCustoRefeicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Trip.this, Snack.class), returnActivity);
            }
        });

        adicionarCustoHospedagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Trip.this, Accommodation.class), returnActivity);
            }
        });

        adicionarEntretenimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Trip.this, Entertainment.class), returnActivity);
            }
        });

        salvarViagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Viagem model= new Viagem();
                model=getViagemModel();
                if(dao.Insert(model)!=-1){

                    model_viagem = dao.Select(model.getIdusuario());
                    id_viagem = model_viagem.size()-1;

                    //-pegar a lista no shared e passar pro laço de repetição.

                    /*for(Entretenimento uri : Lista) {
                        Ent_model = set_Entretenimento(id_viagem);
                        E_dao.Insert(Ent_model);
                    }*/

                    Toast.makeText(Trip.this, "Viagem cadastrada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Trip.this, "Erro ao cadastrar viagem!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    private final Entretenimento getEntretenimentoModel(){
        Entretenimento entretenimento = new Entretenimento();
       // entretenimento.setNome();
        //entretenimento.setValor();
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
        for(Entretenimento model : listaModel){
            totalEntretenimento += Float.parseFloat(model.getValor());
        }
        Viagem viagem= new Viagem();
        Total_Airfare=(shared.getFloat("TotalCustoViagemAerea"));
        Total_Fuel=(shared.getFloat("TotalCustoCombustivel"));
        Total_Snack=(shared.getFloat("TotalCustoRefeicoes"));
        Total_Accommodation=(shared.getFloat("TotalCustoHospedagem"));
        Total_Valor_Viagem=Total_Airfare + Total_Fuel + Total_Snack + Total_Accommodation + totalEntretenimento;
        qtdeDias=Integer.parseInt(shared.getString("qtdeDias"));
        qtdePessoas=Integer.parseInt(shared.getString("qtdePessoas"));
        id_user=(shared.getLong("ID"));

        viagem.setIdusuario(id_user);
        viagem.setTarifa_aerea(Total_Airfare);
        viagem.setRefeicoes(Total_Snack);
        viagem.setTotal_combustivel(Total_Fuel);
        viagem.setHospedagem(Total_Accommodation);
        viagem.setValor_total(Total_Valor_Viagem);
        viagem.setQtde_pessoas(qtdePessoas);
        viagem.setQtde_dias(qtdeDias);
        viagem.setId_entretenimento(-1);
        return viagem;
    }
}
