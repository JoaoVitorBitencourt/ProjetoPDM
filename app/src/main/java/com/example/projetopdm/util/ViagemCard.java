package com.example.projetopdm.util;

public class ViagemCard {
    private long qtde_dias;
    private String nome;
    private float total_viagem;

    public ViagemCard(long qtde_dias, String nome, float total_viagem) {
        this.qtde_dias = qtde_dias;
        this.nome = nome;
        this.total_viagem = total_viagem;
    }

    public long getQtde_dias() {
        return qtde_dias;
    }

    public void setQtde_dias(int qtde_dias) {
        this.qtde_dias = qtde_dias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getTotal_viagem() {
        return total_viagem;
    }

    public void setTotal_viagem(float total_viagem) {
        this.total_viagem = total_viagem;
    }
}