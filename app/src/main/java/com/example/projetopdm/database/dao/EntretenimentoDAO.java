package com.example.projetopdm.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.projetopdm.database.DBOpenHelper;
import com.example.projetopdm.database.model.EntretenimentoModel;

import java.util.ArrayList;
import java.util.List;

public class EntretenimentoDAO extends AbstrataDAO{

    private final String[]
            colunas = {
                EntretenimentoModel.COLUNA_ID,
                EntretenimentoModel.COLUNA_IDVIAGEM,
                EntretenimentoModel.COLUNA_NOME,
                EntretenimentoModel.COLUNA_VALORTOTAL
            };

    public EntretenimentoDAO(final Context contexto){
        db_helper = new DBOpenHelper(contexto);
    }

    public long Insert(EntretenimentoModel model){

        long linhasAfetadas;

        try{
            Open();
            ContentValues values = new ContentValues();
            values.put(EntretenimentoModel.COLUNA_IDVIAGEM, model.getIdviagem());
            values.put(EntretenimentoModel.COLUNA_NOME, model.getNome());
            values.put(EntretenimentoModel.COLUNA_VALORTOTAL, model.getValor_total());
            linhasAfetadas = db.insert(EntretenimentoModel.TABELA_NOME,null,values);
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
    public List<EntretenimentoModel> Select(final long id_viagem){

        List<EntretenimentoModel> lista= new ArrayList<EntretenimentoModel>();

        try{
            Open();
            Cursor cursor = db.query(
                    EntretenimentoModel.TABELA_NOME,
                    colunas,
                    EntretenimentoModel.COLUNA_IDVIAGEM + " = ? ",
                    new String[]{Long.toString(id_viagem)},
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

        return lista;
    }

    public final EntretenimentoModel CursorToStructure(Cursor cursor){
        EntretenimentoModel model=new EntretenimentoModel();
        model.setId(cursor.getLong(0));
        model.setIdviagem(cursor.getLong(1));
        model.setNome(cursor.getString(2));
        model.setValor_total(cursor.getFloat(3));
        return model;
    }

}
