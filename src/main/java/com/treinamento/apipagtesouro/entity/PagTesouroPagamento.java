package com.treinamento.apipagtesouro.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.treinamento.apipagtesouro.model.response.ConsultarPagamentoPagTesouro;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "pgt_tb_pagamento", schema = "pgt")
public class PagTesouroPagamento implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @Column(name="id_pagamento")
    private String idPagamento;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="dd/MM/yyyy 'às' HH:mm:ss 'hrs'")
    @Column(name="dt_criacao")
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="dd/MM/yyyy 'às' HH:mm:ss 'hrs'")
    @Column(name="dt_vencimento")
    private Date dataVencimento;

    @Column(name="vl_pagamento")
    private BigDecimal valorPagamento;

    @Column(name="nm_prestador_servico_pag")
    private String nomePrestadorServicoPagamento;

    @Column(name="id_transacao_prestador_servico_pag")
    private String idTransacaoPrestadorServicoPagamento;

    @Column(name="ds_tipo_pagamento")
    private String descricaoTipoPagamento;

    @Column(name="ds_situacao")
    private String descricaoSituacao;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="dd/MM/yyyy 'às' HH:mm:ss 'hrs'")
    @Column(name="dt_situacao")
    private Date dataSituacao;


    public PagTesouroPagamento() { }

    public PagTesouroPagamento(ConsultarPagamentoPagTesouro consultarPagamentoPagTesouro){
        try {
            this.idPagamento = consultarPagamentoPagTesouro.getIdPagamento();
            this.descricaoTipoPagamento = consultarPagamentoPagTesouro.getTipoPagamentoEscolhido();
            this.valorPagamento = consultarPagamentoPagTesouro.getValor();
            this.nomePrestadorServicoPagamento = consultarPagamentoPagTesouro.getNomePSP();
            this.idTransacaoPrestadorServicoPagamento = consultarPagamentoPagTesouro.getTransacaoPSP();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
            LocalDateTime dateTime = LocalDateTime.parse(consultarPagamentoPagTesouro.getSituacao().getData(), formatter);
            this.dataSituacao = Date.from(dateTime.atZone(ZoneId.of("America/Sao_Paulo")).toInstant());
            this.descricaoSituacao = consultarPagamentoPagTesouro.getSituacao().getCodigo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdPagamento() {
        return idPagamento;
    }
    public void setIdPagamento(String idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }
    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValorPagamento() {
        return valorPagamento;
    }
    public void setValorPagamento(BigDecimal valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public String getNomePrestadorServicoPagamento() {
        return nomePrestadorServicoPagamento;
    }
    public void setNomePrestadorServicoPagamento(String nomePrestadorServicoPagamento) {
        this.nomePrestadorServicoPagamento = nomePrestadorServicoPagamento;
    }

    public String getIdTransacaoPrestadorServicoPagamento() {
        return idTransacaoPrestadorServicoPagamento;
    }
    public void setIdTransacaoPrestadorServicoPagamento(String idTransacaoPrestadorServicoPagamento) {
        this.idTransacaoPrestadorServicoPagamento = idTransacaoPrestadorServicoPagamento;
    }

    public String getDescricaoTipoPagamento() {
        return descricaoTipoPagamento;
    }
    public void setDescricaoTipoPagamento(String descricaoTipoPagamento) {
        this.descricaoTipoPagamento = descricaoTipoPagamento;
    }

    public String getDescricaoSituacao() {
        return descricaoSituacao;
    }
    public void setDescricaoSituacao(String descricaoSituacao) {
        this.descricaoSituacao = descricaoSituacao;
    }

    public Date getDataSituacao() {
        return dataSituacao;
    }
    public void setDataSituacao(Date dataSituacao) {
        this.dataSituacao = dataSituacao;
    }


    @Override
    public String toString() {
        return "PagTesouroPagamento [id=" + id + ", idPagamento=" + idPagamento + ", dataCriacao=" + dataCriacao
                + ", valorPagamento=" + valorPagamento + ", nomePrestadorServicoPagamento="
                + nomePrestadorServicoPagamento + ", descricaoTipoPagamento=" + descricaoTipoPagamento
                + ", descricaoSituacao=" + descricaoSituacao + ", dataSituacao=" + dataSituacao + "]";
    }

}
