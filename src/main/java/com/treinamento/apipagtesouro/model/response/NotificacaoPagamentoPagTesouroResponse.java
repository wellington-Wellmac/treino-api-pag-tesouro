package com.treinamento.apipagtesouro.model.response;

import com.treinamento.apipagtesouro.model.request.NotificacaoPagamentoPagTesouroRequest;

public class NotificacaoPagamentoPagTesouroResponse {
    private int status;
    private String response;
    private NotificacaoPagamentoPagTesouroRequest notificacaoPagamentoPagTesouro;
    private long timestamp;


    public NotificacaoPagamentoPagTesouroResponse() { }

    public NotificacaoPagamentoPagTesouroResponse(int status, String response, long timestamp) {
        super();
        this.status = status;
        this.response = response;
        this.timestamp = timestamp;
    }

    public NotificacaoPagamentoPagTesouroResponse(int status, String response,
                                                  NotificacaoPagamentoPagTesouroRequest notificacaoPagamentoPagTesouro, long timestamp) {
        super();
        this.status = status;
        this.response = response;
        this.notificacaoPagamentoPagTesouro = notificacaoPagamentoPagTesouro;
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

    public NotificacaoPagamentoPagTesouroRequest getNotificacaoPagamentoPagTesouro() {
        return notificacaoPagamentoPagTesouro;
    }
    public void setNotificacaoPagamentoPagTesouro(NotificacaoPagamentoPagTesouroRequest notificacaoPagamentoPagTesouro) {
        this.notificacaoPagamentoPagTesouro = notificacaoPagamentoPagTesouro;
    }

    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


}
