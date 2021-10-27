package com.example.projetopdm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetopdm.database.dao.ViagemDAO;
import com.example.projetopdm.database.model.Viagem;
import com.example.projetopdm.util.Viajantes;

public class Trip extends AppCompatActivity {

    private Button teste,fuel,snack,entretenimento,accommodation,salvar_pessoas;
    private EditText qtPessoas,diasviagem;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private int qtdadePessoas,dias_viagem;
    private long id_user,viagem_id;
    private Viajantes viajantes;
    private ViagemDAO dao;
    Viagem viagemModel=new Viagem();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trip);
        preferences = PreferenceManager.getDefaultSharedPreferences(Trip.this);
        viajantes= new Viajantes();

        teste = findViewById(R.id.viagem);
        salvar_pessoas= findViewById(R.id.Salvar_Pessoas);
        fuel = findViewById(R.id.fuel);
        qtPessoas= findViewById(R.id.qtdadePessoas);
        diasviagem= findViewById(R.id.diasviagem);
        snack = findViewById(R.id.snack);
        entretenimento = findViewById(R.id.entretenimento);
        dao= new ViagemDAO(Trip.this);
        accommodation = findViewById(R.id.accommodation);
        Intent combustivel = new Intent(Trip.this, Fuel.class);
        Intent Airfare = new Intent(Trip.this, Airfare.class);
        Intent Snack = new Intent(Trip.this, Snack.class);
        Intent Entretenimento = new Intent(Trip.this, Entretenimento.class);
        Intent Accommodation = new Intent(Trip.this, Accommodation.class);

        salvar_pessoas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(qtPessoas.getText().toString().equals("") || diasviagem.getText().toString().equals("")){
                    Toast.makeText(Trip.this, "Informe a quantidade de pessoas que irão participar da viagem ou a duração da viagem!", Toast.LENGTH_LONG).show();
                }else{
                    Viagem vModel= new Viagem();
                    qtdadePessoas=Integer.valueOf(qtPessoas.getText().toString());
                    dias_viagem=Integer.valueOf(diasviagem.getText().toString());
                    viajantes.setViajantes(qtdadePessoas,dias_viagem);
                    id_user=preferences.getLong("ID",id_user);
                    //vModel=dao.Select_idViagem(id_user);
                    viagem_id=vModel.getId();
                    editor.putLong("ID_VIAGEM",viagem_id);
                    editor.apply();
                    //dao.Insert(viagemModel);
                }
            }
        });


        teste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(qtPessoas.getText().toString().equals("") || diasviagem.getText().toString().equals("")){
                    Toast.makeText(Trip.this, "Informe a quantidade de pessoas que irão participar da viagem ou a duração da viagem!", Toast.LENGTH_LONG).show();
                }else{
                    startActivity(Airfare);
                }

            }
        });

        fuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(qtPessoas.getText().toString().equals("") || diasviagem.getText().toString().equals("")){
                    Toast.makeText(Trip.this, "Informe a quantidade de pessoas que irão participar da viagem ou a duração da viagem!", Toast.LENGTH_LONG).show();
                }else{
                startActivity(combustivel);
                }
            }
        });
        snack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(qtPessoas.getText().toString().equals("") || diasviagem.getText().toString().equals("")){
                    Toast.makeText(Trip.this, "Informe a quantidade de pessoas que irão participar da viagem ou a duração da viagem!", Toast.LENGTH_LONG).show();
                }else {
                    startActivity(Snack);
                }
            }
        });
        accommodation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(qtPessoas.getText().toString().equals("") || diasviagem.getText().toString().equals("")){
                    Toast.makeText(Trip.this, "Informe a quantidade de pessoas que irão participar da viagem ou a duração da viagem!", Toast.LENGTH_LONG).show();
                }else {
                    startActivity(Accommodation);
                }
            }
        });
        entretenimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(qtPessoas.getText().toString().equals("") || diasviagem.getText().toString().equals("")){
                    Toast.makeText(Trip.this, "Informe a quantidade de pessoas que irão participar da viagem ou a duração da viagem!", Toast.LENGTH_LONG).show();
                }else{
                startActivity(Entretenimento);
                }
            }
        });
    }
}
