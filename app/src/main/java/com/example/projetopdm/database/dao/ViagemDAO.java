package com.example.projetopdm.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.projetopdm.database.DBOpenHelper;
import com.example.projetopdm.database.model.Entretenimento;
import com.example.projetopdm.database.model.UsuarioModel;
import com.example.projetopdm.database.model.Viagem;

import java.util.ArrayList;

public class ViagemDAO extends AbstrataDAO{


    private final String[]
            colunas = {
            Viagem.COLUNA_ID,
            Viagem.COLUNA_IDUSUARIO,
            Viagem.COLUNA_VALORTOTAL,
            Viagem.COLUNA_VALORTOTAL_COMBUSTIVEL,
            Viagem.COLUNA_TARIFA_AEREA,
            Viagem.COLUNA_REFERICOES,
            Viagem.COLUNA_HOSPEDAGEM,
            Viagem.COLUNA_ID_ENTRETENIMENTO,

    };

    public ViagemDAO(final Context contexto){
        db_helper = new DBOpenHelper(contexto);
    }

    public long Insert(Viagem model){
        long linhasAfetadas;

        try{
            Open();
            ContentValues values = new ContentValues();
            values.put();
            values.put();
            values.put();
            values.put();
            values.put();
            values.put();
            linhasAfetadas = db.insert(UsuarioModel.TABELA_NOME,null,values);

        }finally {
            Close();
        }

        return linhasAfetadas;
    }



    public final Viagem CursorToStructure(Cursor cursor){
        Viagem model=new Viagem();
        model.setId(cursor.getLong(0));
        model.setIdusuario(cursor.getLong(1));
        model.setValor_total(cursor.getFloat(2));
        model.setTotal_combustivel(cursor.getFloat(3));
        model.setTarifa_aerea(cursor.getFloat(4));
        model.setRefeicoes(cursor.getFloat(5));
        model.setHospedagem(cursor.getFloat(6));
        model.setId_entretenimento(cursor.getLong(7));
        return model;
    }

}
