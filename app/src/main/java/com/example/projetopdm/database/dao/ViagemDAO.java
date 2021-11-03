package com.example.projetopdm.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;

import com.example.projetopdm.Airfare;
import com.example.projetopdm.Registration;
import com.example.projetopdm.Trip;
import com.example.projetopdm.database.DBOpenHelper;
import com.example.projetopdm.database.model.UsuarioModel;
import com.example.projetopdm.database.model.Viagem;

import java.util.ArrayList;
import java.util.List;

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
            Viagem.COLUNA_QTDEPESSOAS,
            Viagem.COLUNA_QTDEDIAS,
            Viagem.COLUNA_NOMEVIAGEM
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
            values.put(Viagem.COLUNA_QTDEDIAS, model.getQtde_dias());
            values.put(Viagem.COLUNA_QTDEPESSOAS, model.getQtde_pessoas());
            values.put(Viagem.COLUNA_NOMEVIAGEM, model.getNome_viagem());
            linhasAfetadas = db.insert(Viagem.TABELA_NOME,null,values);

        }finally {
            Close();
        }

        return linhasAfetadas;
    }


    public List<Viagem> Select(long id_user){

        List<Viagem> lista= new ArrayList<>();

        Viagem model = null;
        try{
            Open();
            Cursor cursor = db.query(
                    Viagem.TABELA_NOME,
                    colunas,
                    Viagem.COLUNA_IDUSUARIO + " = ?",new String[]{Long.toString(id_user)},
                    null,
                    null,
                    null,
                    null);

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

    public Viagem SelectCard(long id_card){

        Viagem viagem = new Viagem();

        Viagem model = null;
        try{
            Open();
            Cursor cursor = db.query(
                    Viagem.TABELA_NOME,
                    colunas,
                    Viagem.COLUNA_ID + " = ?",new String[]{Long.toString(id_card)},
                    null,
                    null,
                    null,
                    null);

            cursor.moveToFirst();

            viagem = CursorToStructure(cursor);

        }finally {
            Close();
        }
        return viagem;
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
        model.setQtde_pessoas(cursor.getInt(7));
        model.setQtde_dias(cursor.getInt(8));
        model.setNome_viagem(cursor.getString(9));
        return model;
    }

}
