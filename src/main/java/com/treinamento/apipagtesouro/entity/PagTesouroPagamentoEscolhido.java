package com.treinamento.apipagtesouro.entity;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pgt_tb_tipo_pagamento_escolhido", schema = "pgt")
public class PagTesouroPagamentoEscolhido implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tipo_pagamento")
    private Integer tipoPagamento;

    @Column(name="ds_descricao_tipo_pagamento")
    private String descricaoTipoPagamento;

    public PagTesouroPagamentoEscolhido() { }

    public PagTesouroPagamentoEscolhido(Integer tipoPagamento,
                                        String descricaoTipoPagamento) {
        super();
        this.tipoPagamento = tipoPagamento;
        this.descricaoTipoPagamento = descricaoTipoPagamento;
    }

    public Integer getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(Integer tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getDescricaoTipoPagamento() {
        return descricaoTipoPagamento;
    }

    public void setDescricaoTipoPagamento(String descricaoTipoPagamento) {
        this.descricaoTipoPagamento = descricaoTipoPagamento;
    }
}
