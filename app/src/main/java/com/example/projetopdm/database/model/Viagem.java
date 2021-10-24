package com.example.projetopdm.database.model;

public class Viagem {
    public static final String
            TABELA_NOME="tb_viagem";

    public static final String
            COLUNA_ID="_id",
            COLUNA_IDUSUARIO="idusuario",
            COLUNA_VALORTOTAL="valor_total",
            COLUNA_VALORTOTAL_COMBUSTIVEL="total_combustivel";

    public static final String
            CREATE_TABLE=
            "create table "+ TABELA_NOME+ ""
                    +"("
                    +   COLUNA_ID + " integer primary key autoincrement, "
                    +   COLUNA_IDUSUARIO +" integer not null, "
                    +   COLUNA_VALORTOTAL +" float not null, "
                    +   COLUNA_VALORTOTAL_COMBUSTIVEL + " float not null " +
                    "   tarifa_aerea float not null" +
                    "   refeicoes float not null" +
                    "   hospedagem float not null" +
                    "   id_entretenimento int);";

    public static final String
            DROP_TABLE = " drop table if exists " + TABELA_NOME;

    private long id;
    private long usuario;
    private float valor_total;
    private float total_combustivel;
    private float tarifa_aerea;
    private float refeicoes;
    private float hospedagem;
    private long id_entretenimento;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUsuario() {
        return usuario;
    }

    public void setUsuario(long usuario) {
        this.usuario = usuario;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public float getTotal_combustivel() {
        return total_combustivel;
    }

    public void setTotal_combustivel(float total_combustivel) {
        this.total_combustivel = total_combustivel;
    }

    public float getTarifa_aerea() {
        return tarifa_aerea;
    }

    public void setTarifa_aerea(float tarifa_aerea) {
        this.tarifa_aerea = tarifa_aerea;
    }

    public float getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(float refeicoes) {
        this.refeicoes = refeicoes;
    }

    public float getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(float hospedagem) {
        this.hospedagem = hospedagem;
    }

    public long getId_entretenimento() {
        return id_entretenimento;
    }

    public void setId_entretenimento(long id_entretenimento) {
        this.id_entretenimento = id_entretenimento;
    }
}
