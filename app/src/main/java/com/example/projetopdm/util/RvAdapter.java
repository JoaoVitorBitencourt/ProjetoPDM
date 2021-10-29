package com.example.projetopdm.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetopdm.R;

import java.util.ArrayList;
import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.PersonViewHolder> {
    List<ViagemCard> viagens;

    public RvAdapter(List<ViagemCard> viagem) {
        this.viagens = viagem;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int i) {
        holder.Titulo.setText(viagens.get(i).getNome());
        holder.data.setText(Integer.toString(viagens.get(i).getQtde_dias()));
        holder.valor_total.setText(Float.toString(viagens.get(i).getTotal_viagem()));
    }

    @Override
    public int getItemCount() {
        return viagens.size();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView Titulo, data, valor_total;

        PersonViewHolder (View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            Titulo = (TextView) itemView.findViewById(R.id.tituloCard);
            data = (TextView) itemView.findViewById(R.id.dataCard);
            valor_total = (TextView) itemView.findViewById(R.id.totalViagem);
        }
    }
}
