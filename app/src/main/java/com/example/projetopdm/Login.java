package com.example.projetopdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetopdm.database.DBOpenHelper;
import com.example.projetopdm.database.dao.UsuarioDAO;
import com.example.projetopdm.database.model.UsuarioModel;
import com.example.projetopdm.database.model.Viagem;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    private EditText editNomeUsuario, editSenhaUsuario;
    private TextView cadastre_se;
    private Button btnEntrar, btnCadastro;
    private UsuarioDAO dao;
    private String Usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Viagem viagem = new Viagem();

        dao = new UsuarioDAO(Login.this);
        Intent Cadastro = new Intent(Login.this, Registration.class);
        Intent Viagens = new Intent(Login.this, Trips.class);
        cadastre_se = findViewById(R.id.cadastre_se);


        editNomeUsuario = findViewById(R.id.editNomeUsuario);
        editSenhaUsuario = findViewById(R.id.editSenhaUsuario);
        btnEntrar = findViewById(R.id.btnEntrar);

        cadastre_se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(Cadastro);
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioModel model = dao.Select(editNomeUsuario.getText().toString(),editSenhaUsuario.getText().toString());
                //startActivity(Viagens);

                // PARA FUNCIONAR A VALIDAÇÃO DO LOGIN É PRECISO DESCOMENTAR ESSE TRECHO E TIRAR O startActicity DA LINHA ACIMA.

                if(model!=null){
                    viagem.setIdusuario(model.getId());
                    setUser(editNomeUsuario.getText().toString());
                    startActivity(Viagens);
                }else{
                    Toast.makeText(Login.this, "Usuário Não Encontrado!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        cadastre_se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(Cadastro);
            }
        });
    }

    public void setUser(String Usuario){
        this.Usuario=Usuario;
    }

    public String getUser(){
        return this.Usuario;
    }


}