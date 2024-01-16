package com.treinamento.apipagtesouro.model.response;

import com.treinamento.apipagtesouro.model.Situacao;

import java.math.BigDecimal;

public class ConsultarPagamentoPagTesouro {

    private String idPagamento;
    private String tipoPagamentoEscolhido;
    private BigDecimal valor;
    private String nomePSP;
    private String transacaoPSP;
    private Situacao situacao;

    public ConsultarPagamentoPagTesouro() { }

    public ConsultarPagamentoPagTesouro(String idPagamento, String tipoPagamentoEscolhido, BigDecimal valor, String nomePSP, String transacaoPSP, Situacao situacao) {
        super();
        this.idPagamento = idPagamento;
        this.tipoPagamentoEscolhido = tipoPagamentoEscolhido;
        this.valor = valor;
        this.nomePSP = nomePSP;
        this.transacaoPSP = transacaoPSP;
        this.situacao = situacao;
    }


    public String getIdPagamento() {
        return idPagamento;
    }
    public void setIdPagamento(String idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getTipoPagamentoEscolhido() {
        return tipoPagamentoEscolhido;
    }
    public void setTipoPagamentoEscolhido(String tipoPagamentoEscolhido) {
        this.tipoPagamentoEscolhido = tipoPagamentoEscolhido;
    }

    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNomePSP() {
        return nomePSP;
    }
    public void setNomePSP(String nomePSP) {
        this.nomePSP = nomePSP;
    }

    public String getTransacaoPSP() {
        return transacaoPSP;
    }
    public void setTransacaoPSP(String transacaoPSP) {
        this.transacaoPSP = transacaoPSP;
    }

    public Situacao getSituacao() {
        return situacao;
    }
    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }


    @Override
    public String toString() {
        return "ConsultarPagamentoPagTesouro [idPagamento=" + idPagamento + ", tipoPagamentoEscolhido="
                + tipoPagamentoEscolhido + ", valor=" + valor + ", nomePSP=" + nomePSP + ", situacao=" + situacao + "]";
    }
}
