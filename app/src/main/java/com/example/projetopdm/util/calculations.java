package com.example.projetopdm.util;

public class calculations {

    private float total;

    public float custoCombustivel(float totalKM, float mediaKmL, float custoMedioL, int totalVeiculos) {
        total = ((totalKM / mediaKmL) * custoMedioL) / totalVeiculos;

        return total;
    }

    public float custoTarifaAerea(float custoPorPessoa, int totalViajantes, float custoAluguelVeiculo) {
        total = (custoPorPessoa * totalViajantes) + custoAluguelVeiculo;

        return total;
    }

    public float custoRefeicoes(int refeicoesPorDia, int totalViajantes, float custoEstimado, int duracaoDaViagem) {
        total = ((refeicoesPorDia * totalViajantes) * custoEstimado) * duracaoDaViagem;

        return total;
    }

    public float custoHospedagem(float custoMedio, int totalNoites, int totalQuartos) {
        total = (custoMedio * totalNoites) * totalQuartos;

        return total;
    }
}
