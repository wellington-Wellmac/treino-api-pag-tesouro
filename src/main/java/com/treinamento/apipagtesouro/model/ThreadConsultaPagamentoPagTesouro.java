package com.treinamento.apipagtesouro.model;

import com.treinamento.apipagtesouro.entity.PagTesouroPagamento;
import com.treinamento.apipagtesouro.enums.ESituacaoPagTesouro;
import com.treinamento.apipagtesouro.model.response.ConsultarPagamentoPagTesouro;
import com.treinamento.apipagtesouro.service.PagTesouroPagamentoService;

import java.util.List;

public class ThreadConsultaPagamentoPagTesouro<DataUtils> {
    private PagTesouroAPI pagTesouroAPI;
    private PagTesouroPagamentoService pagTesouroPagamentoService;
    private DataUtils dataUtils;

    private String idPagamento;
    private String dataCriacao;
    private String dataVencimento;


    public ThreadConsultaPagamentoPagTesouro(
            PagTesouroAPI pagTesouroAPI,
            PagTesouroPagamentoService pagTesouroPagamentoService,
            DataUtils dataUtils) {
        this.pagTesouroAPI = pagTesouroAPI;
        this.pagTesouroPagamentoService = pagTesouroPagamentoService;
        this.dataUtils = dataUtils;
    }

    public void setIdPagamento(String idPagamento) {
        this.idPagamento = idPagamento;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }


    @Override
    public void run() {
        PagTesouroPagamento pagTesouroPagamento = null;
        ConsultarPagamentoPagTesouro consultarPagamentoPagTesouro = null;
        try {
            for(int i = 0; i < 100; i++) {
                consultarPagamentoPagTesouro = pagTesouroAPI.consultarPagamentoPagTesouro(idPagamento);
                String dtVencimento = dataUtils.convertDateToISOFormatter(dataVencimento);
                if(dataUtils.comparingDateWithNow(dataUtils.convertToDate(dtVencimento, "yyyy-MM-dd'T'HH:mm:ss'Z'"))) {
                    break;
                }
                if(!isHistoricoPagamentoRegistrado(ESituacaoPagTesouro.CRIADO, ESituacaoPagTesouro.INICIADO, ESituacaoPagTesouro.SUBMETIDO)) {
                    pagTesouroPagamento = new PagTesouroPagamento(consultarPagamentoPagTesouro);
                    pagTesouroPagamento.setDataCriacao(dataUtils.convertToDate(dataCriacao, "yyyy-MM-dd'T'HH:mm:ss'Z'"));
                    pagTesouroPagamento.setDataVencimento(dataUtils.convertToDate(dtVencimento, "yyyy-MM-dd'T'HH:mm:ss'Z'"));
                    pagTesouroPagamentoService.salvar(pagTesouroPagamento);
                }
                if(consultarPagamentoPagTesouro.getSituacao().getCodigo().equals(ESituacaoPagTesouro.CONCLUIDO.name())
                        || consultarPagamentoPagTesouro.getSituacao().getCodigo().equals(ESituacaoPagTesouro.REJEITADO.name())
                        || consultarPagamentoPagTesouro.getSituacao().getCodigo().equals(ESituacaoPagTesouro.CANCELADO.name())) {
                    break;
                }
                Thread.sleep(2000);
            }
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isHistoricoPagamentoRegistrado(ESituacaoPagTesouro... situacao) {
        boolean retorno = false;
        List<PagTesouroPagamento> listPagTesouroPagamento = pagTesouroPagamentoService.findByIdPagamento(idPagamento);
        for(ESituacaoPagTesouro sit : situacao) {
            retorno = listPagTesouroPagamento.stream()
                    .filter(pag -> pag.getIdPagamento().equals(idPagamento) && pag.getDescricaoSituacao().equals(sit.name()))
                    .findAny()
                    .isPresent();
        }
        return retorno;
    }

    public void start() {
    }
}
