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
            UsuarioModel.COLUNA_NOME,
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
            values.put(UsuarioModel.COLUNA_NOME, model.getNome());
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

    public List<UsuarioModel> Select(){

        List<UsuarioModel> lista= new ArrayList<UsuarioModel>();

        try{
            Open();
            Cursor cursor = db.query(UsuarioModel.COLUNA_ID,colunas,null,null,null,null,null); //-> Select * from TABELA_NOME;
            cursor.moveToFirst();
             while(!cursor.isAfterLast()){
                 lista.add(Cursor_id(cursor));
                 cursor.moveToNext();
             }

        }finally {
            Close();
        }

        return null;
    }

    public final UsuarioModel CursorToStructure(Cursor cursor){
        UsuarioModel model=new UsuarioModel();
        model.setId(cursor.getLong(0));
        model.setNome(cursor.getString(1));
        model.setUsuario(cursor.getString(2));
        model.setSenha(cursor.getString(3));
        return model;
    }

    public final UsuarioModel Cursor_id(Cursor cursor){
        UsuarioModel model=new UsuarioModel();
        model.setId(cursor.getLong(0));
        return model;
    }

}
