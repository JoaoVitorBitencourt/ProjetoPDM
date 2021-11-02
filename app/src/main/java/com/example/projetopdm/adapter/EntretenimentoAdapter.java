package com.example.projetopdm.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projetopdm.R;
import com.example.projetopdm.database.model.EntretenimentoModel;
import com.example.projetopdm.util.Entretenimento;

import java.util.List;

public class EntretenimentoAdapter extends BaseAdapter {

    private Activity activity;
    private List<EntretenimentoModel> listaEntretenimentoModel;
    private LayoutInflater layoutInflater;
    private List<Entretenimento> listaEntretenimento;

    public EntretenimentoAdapter(Activity context, List<Entretenimento> lista) {
        this.activity = context;
        //this.listaEntretenimentoModel = lista;
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
        TextView nome = rootView.findViewById(R.id.nome);
        nome.setText(listaEntretenimento.get(i).getNome());

        return rootView;
    }
}
