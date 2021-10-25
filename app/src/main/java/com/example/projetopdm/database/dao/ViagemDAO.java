package com.example.projetopdm.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.projetopdm.Airfare;
import com.example.projetopdm.Registration;
import com.example.projetopdm.database.DBOpenHelper;
import com.example.projetopdm.database.model.UsuarioModel;
import com.example.projetopdm.database.model.Viagem;

public class ViagemDAO extends AbstrataDAO{

    Airfare airfare=new Airfare();


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
            values.put(Viagem.COLUNA_IDUSUARIO, model.getIdusuario());
            values.put(Viagem.COLUNA_VALORTOTAL, model.getValor_total());
            values.put(Viagem.COLUNA_VALORTOTAL_COMBUSTIVEL, model.getTotal_combustivel());
            values.put(Viagem.COLUNA_TARIFA_AEREA, model.getTarifa_aerea());
            values.put(Viagem.COLUNA_REFERICOES, model.getRefeicoes());
            values.put(Viagem.COLUNA_HOSPEDAGEM, model.getHospedagem());
            values.put(Viagem.getColunaIdEntretenimento(),model.getId_entretenimento());
            linhasAfetadas = db.insert(UsuarioModel.TABELA_NOME,null,values);

        }finally {
            Close();
        }

        return linhasAfetadas;
    }


    public long Insert_id(Viagem model){

        long linhasAfetadas;

        try{
            Open();
            ContentValues values = new ContentValues();
            values.put(Viagem.COLUNA_IDUSUARIO, model.getIdusuario());
            linhasAfetadas = db.insert(UsuarioModel.TABELA_NOME,null,values);

        }finally {
            Close();
        }

        return linhasAfetadas;
    }

    public long Update_Airfare(Viagem model) {


        long linhasAfetadas;
        try {
            Open();
            ContentValues values = new ContentValues();
            values.put(Viagem.COLUNA_TARIFA_AEREA, model.getTarifa_aerea());
            linhasAfetadas=db.update(Viagem.TABELA_NOME,values,Viagem.getColunaId() + " = ?",new String[]{String.valueOf(airfare.getidViagem())});
        }finally {
            Close();
        }
        return linhasAfetadas;
    }

    public Viagem Select(){

        Viagem model = null;
        try{
            Open();
            Cursor cursor = db.query(
                    Viagem.TABELA_NOME,
                    colunas,
                    null,
                    null,
                    null,
                    null,
                    null);

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
