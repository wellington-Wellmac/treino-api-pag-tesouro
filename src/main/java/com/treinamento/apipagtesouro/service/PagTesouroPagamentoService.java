package com.treinamento.apipagtesouro.service;

import java.util.Date;
import java.util.List;

import com.treinamento.apipagtesouro.entity.PagTesouroPagamento;
import com.treinamento.apipagtesouro.enums.ESituacaoPagTesouro;
import com.treinamento.apipagtesouro.repository.PagTesouroPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(transactionManager = "pagTesouroTransactionManager")
public class PagTesouroPagamentoService {
    @Autowired
    private PagTesouroPagamentoRepository pagTesouroPagamentoRepository;

    public List<PagTesouroPagamento> findByIdPagamento(String idPagamento) {
        return pagTesouroPagamentoRepository.findByIdPagamentoOrderByDataSituacao(idPagamento);
    }


    public PagTesouroPagamento salvar(PagTesouroPagamento pagTesouroPagamento) {
        if(pagTesouroPagamento.getDescricaoSituacao().equals(ESituacaoPagTesouro.CONCLUIDO.name())
                || pagTesouroPagamento.getDescricaoSituacao().equals(ESituacaoPagTesouro.REJEITADO.name())
                || pagTesouroPagamento.getDescricaoSituacao().equals(ESituacaoPagTesouro.CANCELADO.name())) {
            Date pagDataCriacao = pagTesouroPagamentoRepository
                    .findDataCriacaoByIdPagamento(pagTesouroPagamento.getIdPagamento());
            Date pagDataVencimento = pagTesouroPagamentoRepository
                    .findDataVencimentoByIdPagamento(pagTesouroPagamento.getIdPagamento());
            if(pagDataCriacao != null) {
                pagTesouroPagamento.setDataCriacao(pagDataCriacao);
            }
            if(pagDataVencimento != null) {
                pagTesouroPagamento.setDataVencimento(pagDataVencimento);
            }
        }
        PagTesouroPagamento pagamento = pagTesouroPagamentoRepository
                .findPagamentoByIdPagamentoAndSituacao(pagTesouroPagamento.getIdPagamento(), pagTesouroPagamento.getDescricaoSituacao());
        if(pagamento == null) {
            return pagTesouroPagamentoRepository.save(pagTesouroPagamento);
        }
        return null;
    }
}
