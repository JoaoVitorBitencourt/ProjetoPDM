package com.example.projetopdm.database.dao;

import android.content.Context;

import com.example.projetopdm.database.DBOpenHelper;
import com.example.projetopdm.database.model.UsuarioModel;

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

    public int Insert(){
        return 0;
    }

    public int Delete(){
        return 0;
    }

    public int Update(){
        return 0;
    }

    public List<UsuarioModel> Select(){
        return null;
    }

}
