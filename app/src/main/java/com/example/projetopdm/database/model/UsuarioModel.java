package com.example.projetopdm.database.model;

    public class UsuarioModel {

        public static final String
                TABELA_NOME="tb_usuario";

        public static final String
                COLUNA_ID="_id",
                COLUNA_USUARIO="usuario",
                COLUNA_NOME="nome",
                COLUNA_SENHA="senha";

        public static final String
                CREATE_TABLE=
                "create table "+ TABELA_NOME+ ""
                        +"("
                        +   COLUNA_ID + " integer primary key autoincrement, "
                        +   COLUNA_NOME +" text not null, "
                        +   COLUNA_USUARIO +" text not null, "
                        +   COLUNA_SENHA + " text not null "
                        +");";

        public static final String
                DROP_TABLE = " drop table if exists " + TABELA_NOME;



        private int id;
        private String nome;
        private String usuario;
        private String senha;

        public int getId() {
            return id;
        }

        public String getNome() { return nome; }

        public String getUsuario() {
            return usuario;
        }

        public String getSenha() {
            return senha;
        }

        public void setId(int id) { this.id = id; }

        public void setNome(String nome) { this.nome = nome; }

        public void setUsuario(String usuario) { this.usuario = usuario; }

        public void setSenha(String senha) { this.senha = senha; }
    }


