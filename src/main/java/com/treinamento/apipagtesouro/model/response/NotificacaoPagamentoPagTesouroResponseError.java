package com.treinamento.apipagtesouro.model.response;

public class NotificacaoPagamentoPagTesouroResponseError {

    private String codigo;
    private String descricao;


    public NotificacaoPagamentoPagTesouroResponseError() { }

    public NotificacaoPagamentoPagTesouroResponseError(String codigo, String descricao) {
        super();
        this.codigo = codigo;
        this.descricao = descricao;
    }


    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
