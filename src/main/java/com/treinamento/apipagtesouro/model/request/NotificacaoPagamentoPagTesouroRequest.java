package com.treinamento.apipagtesouro.model.request;

public class NotificacaoPagamentoPagTesouroRequest {

    private String idPagamento;
    private String dataHora;

    public NotificacaoPagamentoPagTesouroRequest() { }

    public NotificacaoPagamentoPagTesouroRequest(String idPagamento, String dataHora) {
        this.idPagamento = idPagamento;
        this.dataHora = dataHora;
    }


    public String getIdPagamento() {
        return idPagamento;
    }
    public void setIdPagamento(String idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getDataHora() {
        return dataHora;
    }
    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "NotificacaoPagamentoPagTesouroRequest [idPagamento=" + idPagamento + ", dataHora=" + dataHora + "]";
    }
}
