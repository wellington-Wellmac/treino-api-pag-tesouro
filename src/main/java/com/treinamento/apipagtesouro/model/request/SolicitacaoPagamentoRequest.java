package com.treinamento.apipagtesouro.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolicitacaoPagamentoRequest {

    @JsonProperty("codigoServico")
    private String codigoServico;
    @JsonProperty("competencia")
    private String competencia;
    @JsonProperty("vencimento")
    private String vencimento;
    @JsonProperty("cnpjCpf")
    private String cnpjCpf;
    @JsonProperty("nomeContribuinte")
    private String nomeContribuinte;
    @JsonProperty("valorPrincipal")
    private String valorPrincipal;
    @JsonProperty("modoNavegacao")
    private String modoNavegacao;
    @JsonProperty("urlNotificacao")
    private String urlNotificacao;

    public SolicitacaoPagamentoRequest(String codigoServico, String competencia, String vencimento, String cnpjCpf, String nomeContribuinte, String valorPrincipal, String modoNavegacao, String urlNotificacao) {
        this.codigoServico = codigoServico;
        this.competencia = competencia;
        this.vencimento = vencimento;
        this.cnpjCpf = cnpjCpf;
        this.nomeContribuinte = nomeContribuinte;
        this.valorPrincipal = valorPrincipal;
        this.modoNavegacao = modoNavegacao;
        this.urlNotificacao = urlNotificacao;
    }

    public SolicitacaoPagamentoRequest() {

    }

    public String getCodigoServico() {
        return codigoServico;
    }

    public void setCodigoServico(String codigoServico) {
        this.codigoServico = codigoServico;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getNomeContribuinte() {
        return nomeContribuinte;
    }

    public void setNomeContribuinte(String nomeContribuinte) {
        this.nomeContribuinte = nomeContribuinte;
    }

    public String getValorPrincipal() {
        return valorPrincipal;
    }

    public void setValorPrincipal(String valorPrincipal) {
        this.valorPrincipal = valorPrincipal;
    }

    public String getModoNavegacao() {
        return modoNavegacao;
    }

    public void setModoNavegacao(String modoNavegacao) {
        this.modoNavegacao = modoNavegacao;
    }

    public String getUrlNotificacao() {
        return urlNotificacao;
    }

    public void setUrlNotificacao(String urlNotificacao) {
        this.urlNotificacao = urlNotificacao;
    }
}
