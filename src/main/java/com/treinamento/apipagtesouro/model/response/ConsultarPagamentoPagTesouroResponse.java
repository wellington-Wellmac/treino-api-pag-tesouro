package com.treinamento.apipagtesouro.model.response;

import com.treinamento.apipagtesouro.entity.PagTesouroPagamento;

import java.util.List;

public class ConsultarPagamentoPagTesouroResponse {

    private int status;
    private String response;
    private List<PagTesouroPagamento> listPagamentoPagTesouro;
    private long timestamp;


    public ConsultarPagamentoPagTesouroResponse() { }

    public ConsultarPagamentoPagTesouroResponse(int status, String response, long timestamp) {
        super();
        this.status = status;
        this.response = response;
        this.timestamp = timestamp;
    }

    public ConsultarPagamentoPagTesouroResponse(int status, String response,
                                                List<PagTesouroPagamento> listPagamentoPagTesouro, long timestamp) {
        super();
        this.status = status;
        this.response = response;
        this.listPagamentoPagTesouro = listPagamentoPagTesouro;
        this.timestamp = timestamp;
    }


    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }
    public void setResponse(String response) {
        this.response = response;
    }

    public List<PagTesouroPagamento> getListPagamentoPagTesouro() {
        return listPagamentoPagTesouro;
    }
    public void setListPagamentoPagTesouro(List<PagTesouroPagamento> listPagamentoPagTesouro) {
        this.listPagamentoPagTesouro = listPagamentoPagTesouro;
    }

    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
