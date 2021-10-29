package com.example.projetopdm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetopdm.database.dao.UsuarioDAO;
import com.example.projetopdm.database.model.UsuarioModel;

public class Registration extends AppCompatActivity {

    private EditText editEmail, editUsuario, editSenha;
    private Button btn_cadastrar,btn_voltar;
    private UsuarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        dao= new UsuarioDAO(Registration.this);


        editEmail=findViewById(R.id.editEmail);
        editUsuario=findViewById(R.id.editNomeUsuario);
        editSenha=findViewById(R.id.editSenhaUsuario);
        btn_cadastrar=findViewById(R.id.btnEntrar);

        btn_cadastrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                UsuarioModel model=new UsuarioModel();
                UsuarioModel userVerify= new UsuarioModel();
                model.setEmail(editEmail.getText().toString());
                model.setUsuario(editUsuario.getText().toString());
                model.setSenha(editSenha.getText().toString());

                userVerify  = dao.Select(editUsuario.getText().toString(),editSenha.getText().toString());
                if(userVerify!=null){
                    Toast.makeText(Registration.this, "Usuário Já Cadastrado, por favor insira outro Usuário", Toast.LENGTH_SHORT).show();
                }else{
                    if(dao.Insert(model)!=-1){
                        Toast.makeText(Registration.this, "Usuário Cadastrado", Toast.LENGTH_LONG).show();
                        Registration.super.onBackPressed();
                    }
                }
            }
        });

    }
}
