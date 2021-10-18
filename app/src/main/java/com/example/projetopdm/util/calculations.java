package com.example.projetopdm.util;

public class calculations {

    private float total;

    public String custoCombustivel(float totalKM, float mediaKmL, float custoMedioL, int totalVeiculos) {
        total = ((totalKM / mediaKmL) * custoMedioL) / totalVeiculos;

        return "R$ " + String.format("%.2f", total);
    }

    public String custoTarifaAerea(float custoPorPessoa, int totalViajantes, float custoAluguelVeiculo) {
        total = (custoPorPessoa * totalViajantes) + custoAluguelVeiculo;

        return "R$ " + String.format("%.2f", total);
    }

    public String custoRefeicoes(int refeicoesPorDia, int totalViajantes, float custoEstimado, int duracaoDaViagem) {
        total = ((refeicoesPorDia * totalViajantes) * custoEstimado) * duracaoDaViagem;

        return "R$ " + String.format("%.2f", total);
    }

    public String custoHospedagem(float custoMedio, int totalNoites, int totalQuartos) {
        total = (custoMedio * totalNoites) * totalQuartos;

        return "R$ " + String.format("%.2f", total);
    }
}
