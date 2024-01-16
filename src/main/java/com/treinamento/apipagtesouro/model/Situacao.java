package com.treinamento.apipagtesouro.model;

public class Situacao {

    private String codigo;
    private String data;

    public Situacao(String codigo, String data) {
        super();
        this.codigo = codigo;
        this.data = data;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Situacao [codigo=" + codigo + ", data=" + data + "]";
    }
}
