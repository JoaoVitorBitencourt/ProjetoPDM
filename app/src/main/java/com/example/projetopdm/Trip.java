package com.example.projetopdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Trip extends AppCompatActivity {

    private Button teste;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trip);

        teste = findViewById(R.id.viagem);
        Intent combustivel = new Intent(Trip.this, Fuel.class);

        teste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(combustivel);
            }
        });
    }
}
