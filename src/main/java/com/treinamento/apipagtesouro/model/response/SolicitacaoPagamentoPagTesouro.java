package com.treinamento.apipagtesouro.model.response;

import com.treinamento.apipagtesouro.model.Situacao;

public class SolicitacaoPagamentoPagTesouro {

    private String idPagamento;
    private String dataCriacao;
    private String dataVencimento;
    private String proximaUrl;
    private Situacao situacao;


    public SolicitacaoPagamentoPagTesouro() { }

    public SolicitacaoPagamentoPagTesouro(String idPagamento,
                                          String dataCriacao, String proximaUrl, Situacao situacao) {
        super();
        this.idPagamento = idPagamento;
        this.dataCriacao = dataCriacao;
        this.proximaUrl = proximaUrl;
        this.situacao = situacao;
    }

    public SolicitacaoPagamentoPagTesouro(String idPagamento, String dataVencimento,
                                          String dataCriacao, String proximaUrl, Situacao situacao) {
        super();
        this.idPagamento = idPagamento;
        this.dataCriacao = dataCriacao;
        this.dataVencimento = dataVencimento;
        this.proximaUrl = proximaUrl;
        this.situacao = situacao;
    }


    public String getIdPagamento() {
        return idPagamento;
    }
    public void setIdPagamento(String idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }
    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getProximaUrl() {
        return proximaUrl;
    }
    public void setProximaUrl(String proximaUrl) {
        this.proximaUrl = proximaUrl;
    }

    public Situacao getSituacao() {
        return situacao;
    }
    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
}
