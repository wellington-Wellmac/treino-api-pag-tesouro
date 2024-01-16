package com.treinamento.apipagtesouro.enums;

public enum ESituacaoPagTesouro {
    CRIADO("CRIADO", "O pagamento foi solicitado pelo sistema cliente, mas a URL retornada pelo PagTesouro (proximaUrl) ainda não foi acionada."),
    INICIADO("INICIADO", "	A URL retornada pelo PagTesouro (proximaUrl) foi acionada e o usuário já está na tela de seleção da forma de pagamento."),
    SUBMETIDO("SUBMETIDO", "O usuário selecionou uma forma de pagamento e acionou a opção \"Pagar\"."),
    CONCLUIDO("CRIADO", "O pagamento digital (Pix ou cartão de crédito) foi confirmado pelo PSP."),
    REJEITADO("REJEITADO", "O pagamento digital (Pix ou cartão de crédito) foi rejeitado por algum motivo pelo PSP."),
    CANCELADO("CANCELADO", "O pagamento foi cancelado após 1h sem ter sido SUBMETIDO pelo contribuinte.");

    private String situacao;
    private String descricao;

    private ESituacaoPagTesouro(String situacao, String descricao) {
        this.situacao = situacao;
        this.descricao = descricao;
    }

    public String getSituacao() {
        return situacao;
    }

    public String getDescricao() {
        return descricao;
    }
}
