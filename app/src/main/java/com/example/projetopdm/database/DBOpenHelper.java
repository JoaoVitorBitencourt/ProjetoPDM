package com.example.projetopdm.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.projetopdm.database.model.Entretenimento;
import com.example.projetopdm.database.model.UsuarioModel;
import com.example.projetopdm.database.model.Viagem;


public class DBOpenHelper extends SQLiteOpenHelper {

    public static final String
            DATABASE_NOME="banco.db";

    public static final int
            DATABASE_VERSAO = 1;

    public DBOpenHelper(final Context contexto){
        super(contexto, DATABASE_NOME,null, DATABASE_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsuarioModel.CREATE_TABLE);
        db.execSQL(Entretenimento.CREATE_TABLE);
        db.execSQL(Viagem.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(UsuarioModel.DROP_TABLE);
        db.execSQL(Entretenimento.DROP_TABLE);
        db.execSQL(Viagem.DROP_TABLE);
        db.execSQL(UsuarioModel.CREATE_TABLE);
        db.execSQL(Entretenimento.CREATE_TABLE);
        db.execSQL(Viagem.CREATE_TABLE);

    }
}
