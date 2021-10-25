package com.example.projetopdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Trips extends AppCompatActivity {

    private ImageView adicionarViagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trips);

        Intent viagem = new Intent(Trips.this, Trip.class);

        adicionarViagem = findViewById(R.id.adicionarViagem);
        adicionarViagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(viagem);
            }
        });

        adicionarViagem.bringToFront();
        adicionarViagem.invalidate();
    }

}
