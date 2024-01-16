package com.treinamento.apipagtesouro.model.response;

public class SolicitacaoPagamentoPagTesouroResponse {

    private int status;
    private String response;
    private SolicitacaoPagamentoPagTesouro solicitacaoPagamentoPagTesouro;
    private long timestamp;


    public SolicitacaoPagamentoPagTesouroResponse() { }

    public SolicitacaoPagamentoPagTesouroResponse(int status, String response, long timestamp) {
        super();
        this.status = status;
        this.response = response;
        this.timestamp = timestamp;
    }

    public SolicitacaoPagamentoPagTesouroResponse(int status, String response,
                                                  SolicitacaoPagamentoPagTesouro solicitacaoPagamentoPagTesouro, long timestamp) {
        super();
        this.status = status;
        this.response = response;
        this.solicitacaoPagamentoPagTesouro = solicitacaoPagamentoPagTesouro;
        DataUtils dataUtils = new DataUtils();
        this.solicitacaoPagamentoPagTesouro.setDataVencimento(
                dataUtils.convertDateToISOFormatter(solicitacaoPagamentoPagTesouro.getDataVencimento()));
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

    public SolicitacaoPagamentoPagTesouro getSolicitacaoPagamentoPagTesouro() {
        return solicitacaoPagamentoPagTesouro;
    }
    public void setSolicitacaoPagamentoPagTesouro(SolicitacaoPagamentoPagTesouro solicitacaoPagamentoPagTesouro) {
        this.solicitacaoPagamentoPagTesouro = solicitacaoPagamentoPagTesouro;
    }

    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
