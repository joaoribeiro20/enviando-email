package org.example;

public class Usuario {

    //class desenvolvida para descrever caracteristicas genericas e necessarias de um usuario, assim permitindo criar um objeto atraver dessa class

        String nome;
        String gmail;
        String login;
        int chave;

        Usuario(){

        }

        //String cor;

    /*void setCor(String cor) {
        this.cor = cor;
    }
    String getCor() {
        return cor;
    }*/

        void setNome(String nome) {
            this.nome = nome;
        }

        String getNome() {
            return nome;
        }

        void setLogin(String login) {
            this.login = login;
        }

        String getLogin() {
            return login;
        }

        void setGmail(String gmail) {
            this.gmail = gmail;
        }

        String getGmail() {
            return gmail;
        }

        public int setChave(int chave) {
            this.chave = chave;
            return chave;
        }
        int getChave() {
            return chave;
        }


    }
