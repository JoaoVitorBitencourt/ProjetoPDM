package com.example.projetopdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetopdm.database.dao.ViagemDAO;
import com.example.projetopdm.database.model.Viagem;
import com.example.projetopdm.adapter.RvAdapter;

import java.util.ArrayList;
import java.util.List;

import com.example.projetopdm.util.Entretenimento;
import com.example.projetopdm.util.Shared;
import com.example.projetopdm.util.ViagemCard;

import java.util.Set;

public class Trips extends AppCompatActivity {

    private ImageView adicionarViagem;
    private ViagemDAO dao;
    private List<Viagem> model;
    private Shared shared = new Shared(Trips.this);
    Viagem viagemModel=new Viagem();
    private Set<Entretenimento> set;
    List<ViagemCard> viagens = new ArrayList<>();
    private float total;
    private RecyclerView rv;
    private LinearLayoutManager llm;

    public void atualizar(){
        model=dao.Select(shared.getLong("ID"));
        for(Viagem model : model){
            viagens.add(new ViagemCard(model.getId(), "Viagem Teste 2", model.getValor_total()));
        }
        RvAdapter adapter = new RvAdapter(viagens);

        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        atualizar();
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trips);
        dao=new ViagemDAO(Trips.this);
        // Na linha de cima criei um modelo pra testar o select do array list

        Intent configInicial = new Intent(Trips.this, InitialInformation.class);
        rv = findViewById(R.id.recycler_view);
        llm = new LinearLayoutManager(this);

        atualizar();

        adicionarViagem = findViewById(R.id.adicionarViagem);
        adicionarViagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(configInicial);
            }
        });

        adicionarViagem.bringToFront();
        adicionarViagem.invalidate();
    }

}
