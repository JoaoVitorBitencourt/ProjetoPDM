package com.example.projetopdm.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.projetopdm.database.DBOpenHelper;
import com.example.projetopdm.database.model.UsuarioModel;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends AbstrataDAO {

    private final String[]
            colunas = {
            UsuarioModel.COLUNA_ID,
            UsuarioModel.COLUNA_EMAIL,
            UsuarioModel.COLUNA_USUARIO,
            UsuarioModel.COLUNA_SENHA

    };

    public UsuarioDAO(final Context contexto){
        db_helper = new DBOpenHelper(contexto);
    }

    public long Insert(UsuarioModel model){

        long linhasAfetadas;

        try{
            Open();
            ContentValues values = new ContentValues();
            values.put(UsuarioModel.COLUNA_EMAIL, model.getEmail());
            values.put(UsuarioModel.COLUNA_USUARIO, model.getUsuario());
            values.put(UsuarioModel.COLUNA_SENHA, model.getSenha());
            linhasAfetadas = db.insert(UsuarioModel.TABELA_NOME,null,values);

        }finally {
            Close();
        }

        return linhasAfetadas;
    }

    public int Delete(){
        return 0;
    }

    public int Update(){
        return 0;
    }

    //- Select da validação do login.
    public UsuarioModel Select(final String usuario, final String senha){

        UsuarioModel model = null;
        try{
            Open();
            Cursor cursor = db.query(
                    UsuarioModel.TABELA_NOME,
                    colunas,
                    UsuarioModel.COLUNA_USUARIO + " = ? and " + UsuarioModel.COLUNA_SENHA +" = ?" ,
                    new String[]{usuario,senha},
                    null,
                    null,
                    null); //

            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                model= CursorToStructure(cursor);
                break;
            }
        }finally {
            Close();
        }
        return model;
    }

    public UsuarioModel Select(final String usuario){


        UsuarioModel model = null;
        try{
            Open();
            Cursor cursor = db.query(
                    UsuarioModel.TABELA_NOME,
                    colunas,
                    UsuarioModel.COLUNA_USUARIO + " = ?",
                    new String[]{usuario},
                    null,
                    null,
                    null); //

            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                model= CursorToStructure(cursor);
                break;
            }
        }finally {
            Close();
        }
        return model;
    }

    public final UsuarioModel CursorToStructure(Cursor cursor){
        UsuarioModel model=new UsuarioModel();
        model.setId(cursor.getLong(0));
        model.setEmail(cursor.getString(1));
        model.setUsuario(cursor.getString(2));
        model.setSenha(cursor.getString(3));
        return model;
    }


}
