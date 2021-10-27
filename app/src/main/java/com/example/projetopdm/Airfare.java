package com.example.projetopdm;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    private SharedPreferences preferences;
    private ViagemDAO dao;
    private Float valor_tarifa;
    private long id_user,viagem_id;

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.airfare);

        //Fuel fuel=new Fuel();

        CustoPessoa=findViewById(R.id.editCustoEstPess);
        AluguelVeic=findViewById(R.id.editAluguelVeic);
        QtdadePessoas=findViewById(R.id.editqtadePessoas);
        preferences = PreferenceManager.getDefaultSharedPreferences(Airfare.this);
        calcular = findViewById(R.id.calcular);
        finalizar = findViewById(R.id.finalizar);
        Valor_Total=findViewById(R.id.TextViewTotal);
        calculations calculos = new calculations();
        dao = new ViagemDAO(Airfare.this);
        Viagem viagemModel = new Viagem();

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String total;

                total = calculos.custoTarifaAerea(
                        Float.parseFloat(CustoPessoa.getText().toString()),
                        Integer.parseInt(QtdadePessoas.getText().toString()),
                        Float.parseFloat(AluguelVeic.getText().toString())
                );
                valor_tarifa=Float.parseFloat(total);
                Valor_Total.setText("R$ "+total);

            }

        });


        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viagemModel.setTarifa_aerea(valor_tarifa);
                id_user = preferences.getLong("ID", id_user);
                viagem_id=preferences.getLong("ID_VIAGEM",viagem_id);
                if(dao.Update_Airfare(viagemModel, id_user,viagem_id)!=-1){
                    Toast.makeText(Airfare.this, "Valor Cadastrado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}

//