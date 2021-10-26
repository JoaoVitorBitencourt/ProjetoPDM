package com.example.projetopdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Trip extends AppCompatActivity {

    private Button teste,fuel,snack,entretenimento,accommodation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trip);

        teste = findViewById(R.id.viagem);
        fuel = findViewById(R.id.fuel);
        snack = findViewById(R.id.snack);
        entretenimento = findViewById(R.id.entretenimento);
        accommodation = findViewById(R.id.accommodation);
        Intent combustivel = new Intent(Trip.this, Fuel.class);
        Intent Airfare = new Intent(Trip.this, Airfare.class);
        Intent Snack = new Intent(Trip.this, Snack.class);
        Intent Entretenimento = new Intent(Trip.this, Entretenimento.class);
        Intent Accommodation = new Intent(Trip.this, Accommodation.class);


        teste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(Airfare);
            }
        });

        fuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(combustivel);
            }
        });
        snack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(Snack);
            }
        });
        accommodation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(Accommodation);
            }
        });
        entretenimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(Entretenimento);
            }
        });
    }
}
