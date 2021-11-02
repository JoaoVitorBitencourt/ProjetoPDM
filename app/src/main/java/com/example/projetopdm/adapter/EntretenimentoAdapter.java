package com.example.projetopdm.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.example.projetopdm.R;
import com.example.projetopdm.database.model.EntretenimentoModel;

import java.util.List;

public class EntretenimentoAdapter extends BaseAdapter {

    private Activity activity;
    private List<EntretenimentoModel> listaEntretenimento;
    private LayoutInflater layoutInflater;

    public EntretenimentoAdapter(Activity context, List<EntretenimentoModel> lista) {
        this.activity = context;
        this.listaEntretenimento = lista;
    }

    @Override
    public int getCount() {
        return listaEntretenimento.size();
    }

    @Override
    public Object getItem(int i) {
        return listaEntretenimento.get(i);
    }

    @Override
    public long getItemId(int i) {
        return -99;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(layoutInflater == null) {
            layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        View rootView = layoutInflater.inflate(R.layout.entertainment_row, null);
        EditText nome = rootView.findViewById(R.id.nome);

        return null;
    }
}
