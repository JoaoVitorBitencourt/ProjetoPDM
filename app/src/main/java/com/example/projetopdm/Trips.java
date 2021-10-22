package com.example.projetopdm;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Trips extends AppCompatActivity {

    private ImageView adicionarViagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trips);

        adicionarViagem = findViewById(R.id.adicionarViagem);
        /*adicionarViagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

        adicionarViagem.bringToFront();
        adicionarViagem.invalidate();
    }
}
