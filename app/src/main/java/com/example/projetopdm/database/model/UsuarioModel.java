package com.example.projetopdm.database.model;

    public class UsuarioModel {

        public static final String
                TABELA_NOME="tb_usuario";

        public static final String
                COLUNA_ID="_id",
                COLUNA_EMAIL="email",
                COLUNA_USUARIO="usuario",
                COLUNA_SENHA="senha";

        public static final String
                CREATE_TABLE=
                "create table if not exists "+ TABELA_NOME+ ""
                        +"("
                        +   COLUNA_ID + " integer primary key autoincrement, "
                        +   COLUNA_EMAIL +" text not null, "
                        +   COLUNA_USUARIO +" text not null, "
                        +   COLUNA_SENHA + " text not null "
                        +");";

        public static final String
                DROP_TABLE = " drop table if exists " + TABELA_NOME;



        private long id;
        private String email;
        private String usuario;
        private String senha;

        public long getId() {
            return id;
        }

        public String getEmail() { return email; }

        public String getUsuario() {
            return usuario;
        }

        public String getSenha() {
            return senha;
        }

        public void setId(long id) { this.id = id; }

        public void setEmail(String email) { this.email = email; }

        public void setUsuario(String usuario) { this.usuario = usuario; }

        public void setSenha(String senha) { this.senha = senha; }
    }


