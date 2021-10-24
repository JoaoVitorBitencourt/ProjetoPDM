package com.example.projetopdm.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.projetopdm.database.DBOpenHelper;
import com.example.projetopdm.database.model.Entretenimento;

import java.util.ArrayList;
import java.util.List;

public class EntretenimentoDAO extends AbstrataDAO{

    private final String[]
            colunas = {
                Entretenimento.COLUNA_ID,
                Entretenimento.COLUNA_IDVIAGEM,
                Entretenimento.COLUNA_NOME,
                Entretenimento.COLUNA_VALORTOTAL
            };

    public EntretenimentoDAO(final Context contexto){
        db_helper = new DBOpenHelper(contexto);
    }

    public long Insert(Entretenimento model){

        long linhasAfetadas;

        try{
            Open();
            ContentValues values = new ContentValues();
            values.put(Entretenimento.COLUNA_IDVIAGEM, model.getIdviagem());
            values.put(Entretenimento.COLUNA_NOME, model.getNome());
            values.put(Entretenimento.COLUNA_VALORTOTAL, model.getValor_total());
            linhasAfetadas = db.insert(Entretenimento.TABELA_NOME,null,values);
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

    // select all, traz todos os entretenimentos.
    public List<Entretenimento> Select(final String id_viagem){

        List<Entretenimento> lista= new ArrayList<Entretenimento>();

        try{
            Open();
            Cursor cursor = db.query(
                    Entretenimento.TABELA_NOME,
                    colunas,
                    Entretenimento.COLUNA_IDVIAGEM + " = ? ",
                    new String[]{id_viagem},
                    null,
                    null,
                    null,
                    null); //-> Select * from TABELA_NOME;
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                lista.add(CursorToStructure(cursor));
                cursor.moveToNext();
            }

        }finally {
            Close();
        }

        return null;
    }

    public final Entretenimento CursorToStructure(Cursor cursor){
        Entretenimento model=new Entretenimento();
        model.setId(cursor.getLong(0));
        model.setIdviagem(cursor.getLong(0));
        model.setNome(cursor.getString(1));
        model.setValor_total(cursor.getFloat(2));
        return model;
    }

}
