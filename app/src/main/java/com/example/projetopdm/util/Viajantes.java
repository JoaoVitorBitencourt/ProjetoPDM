package com.example.projetopdm.util;

public class Viajantes {
    private int totalViajantes, duracaoViagem;
    private float custoTotalViagem, custoTotalPessoa;

    public void setViajantes (int totalViajantes, int duracaoViagem) {
        this.totalViajantes = totalViajantes;
        this.duracaoViagem = duracaoViagem;
    }

    public int getTotalViajantes() {
        return totalViajantes;
    }

    public int getDuracaoViagem() {
        return duracaoViagem;
    }
}
