package com.example.projetopdm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetopdm.database.dao.ViagemDAO;
import com.example.projetopdm.database.model.Viagem;
import com.example.projetopdm.util.calculations;

public class Airfare extends AppCompatActivity {

    private EditText CustoPessoa, AluguelVeic,QtdadePessoas;
    private TextView Valor_Total;
    private Viagem viagem;
    private Button calcular, finalizar;
    private ViagemDAO dao;
    private long id_viagem;

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.airfare);

        //Fuel fuel=new Fuel();

        CustoPessoa=findViewById(R.id.editCustoEstPess);
        AluguelVeic=findViewById(R.id.editAluguelVeic);
        QtdadePessoas=findViewById(R.id.editqtadePessoas);
        calcular = findViewById(R.id.calcular);
        finalizar = findViewById(R.id.finalizar);
        Valor_Total=findViewById(R.id.TextViewTotal);
        calculations calculos = new calculations();
        dao = new ViagemDAO(Airfare.this);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String total;

                total = calculos.custoTarifaAerea(
                        Float.parseFloat(CustoPessoa.getText().toString()),
                        Integer.parseInt(QtdadePessoas.getText().toString()),
                        Float.parseFloat(AluguelVeic.getText().toString())
                );
                Valor_Total.setText(total);
            }

        });


        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public void setidViagem(long id){
        this.id_viagem=id;
    }

    public long getidViagem(){
        return id_viagem;
    }

}

//