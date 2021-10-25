package com.example.projetopdm.database.model;

public class Entretenimento {
    public static final String
            TABELA_NOME="tb_viagem";

    public static final String
            COLUNA_ID="_id",
            COLUNA_IDVIAGEM="idviagem",
            COLUNA_NOME="nome",
            COLUNA_VALORTOTAL="valor_total";

    public static final String
            CREATE_TABLE=
            "create table if not exists "+ TABELA_NOME+ ""
                    +"("
                    +   COLUNA_ID + " integer primary key autoincrement, "
                    +   COLUNA_IDVIAGEM +" integer not null, "
                    +   COLUNA_NOME +" text not null, "
                    +   COLUNA_VALORTOTAL + " float not null " +
                        ");";

    public static final String
            DROP_TABLE = " drop table if exists " + TABELA_NOME;

    private long id;
    private long idviagem;
    private String nome;
    private float valor_total;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdviagem() {
        return idviagem;
    }

    public void setIdviagem(long idviagem) {
        this.idviagem = idviagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }
}
