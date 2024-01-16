package com.treinamento.apipagtesouro.controller;
import java.util.List;



import com.treinamento.apipagtesouro.model.PagTesouroAPI;
import com.treinamento.apipagtesouro.model.ThreadConsultaPagamentoPagTesouro;
import com.treinamento.apipagtesouro.model.request.SolicitacaoPagamentoRequest;
import com.treinamento.apipagtesouro.model.response.SolicitacaoPagamentoPagTesouro;
import com.treinamento.apipagtesouro.model.response.SolicitacaoPagamentoPagTesouroResponse;
import com.treinamento.apipagtesouro.service.PagTesouroPagamentoService;
import feign.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController(value = "ApiPagTesouro")
@RequestMapping(path = "/treinamento")
@Api(tags = { "pagTesouro" })
public class PagTesouroController<DataUtils> {

    private static final long serialVersionUID = 1L;

    @Value("${pagtesouro.bearer-token}")
    private String BEARER_TOKEN_PAG_TESOURO;

    public static final String PATH = "/ApisPagTesouro";
    public static final String OBJETIVO_API_SOLICITA_PAGAMENTO_PAGTESOURO = "Solicita Pagamento do PagTesouro por CPF/CNPJ (Endpoint: PagTesouro).";
    public static final String TAG_API_SOLICITA_PAGAMENTO_PAGTESOURO = "API_SOLICITA_PAGAMENTO_PAGTESOURO";
    public static final String URI_API_SOLICITA_PAGAMENTO_PAGTESOURO = "/pagtesouro/solicita_pagamento";

    @Autowired
    private DataUtils dataUtils;

    @Autowired
    private PagTesouroAPI pagTesouroAPI;

    @Autowired
    private PagTesouroPagamentoService pagTesouroPagamentoService;

    private ThreadConsultaPagamentoPagTesouro threadConsultaPagamentoPagTesouro;


    @ApiOperation(tags = {"pagTesouro" },
            nickname = TAG_API_SOLICITA_PAGAMENTO_PAGTESOURO,
            value = OBJETIVO_API_SOLICITA_PAGAMENTO_PAGTESOURO,
            consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON)
    @PostMapping(URI_API_SOLICITA_PAGAMENTO_PAGTESOURO)
    @Produces(CONTENT_TYPE_APPLICATION_JSON)
    public SolicitacaoPagamentoPagTesouroResponse pagamentoResponse(
            @ApiParam(name = "uuid", required = true) @QueryParam("uuid") String uuid,
            @Context HttpServletRequest request,
            @RequestBody SolicitacaoPagamentoRequest solicitacaoPagamento) {
        String json = null;
        SolicitacaoPagamentoPagTesouroResponse spResponse = null;
        SolicitacaoPagamentoPagTesouroResponse spResponseLog = null;
        try {
            super.validarCredencialPorUUID(uuid);
            if (!super.isUsuarioTemPrivilegioAcessoNasApis(EApis
                    .fromTagApi(TAG_API_SOLICITA_PAGAMENTO_PAGTESOURO).getTagApi())) {
                throw new Exception("UNAUTHORIZED:" + MSG_ERRO_PRIVILEGIO_ACESSO_APIS);
            }
            if (!super.isUsuarioTemPrivilegioAcessoNasApisRelevantes(request)) {
                throw new Exception("UNAUTHORIZED:" + MSG_ERRO_PRIVILEGIO_ACESSO_APIS_RELEVANTES);
            }
            if (solicitacaoPagamento == null) {
                throw new Exception("BAD_REQUEST:Parâmetro(s) obrigatório(s) não informado(s)!");
            }
            String dtVencimento = dataUtils.convertDateToISOFormatter(solicitacaoPagamento.getVencimento());
            if (dataUtils.comparingDateWithNow(dataUtils.convertToDate(dtVencimento, "yyyy-MM-dd'T'HH:mm:ss'Z'"))) {
                throw new Exception("BAD_REQUEST:Pagamento Vencido!");
            }
            solicitacaoPagamento.setCodigoServico("018");
            solicitacaoPagamento.setUrlNotificacao("https://pagtesouro/pagamento/notificacao");
            SolicitacaoPagamentoPagTesouro solicitacaoPagamentoPagTesouro = pagTesouroAPI.solicitacaoPagamentoPagTesouro(solicitacaoPagamento);
            threadConsultaPagamentoPagTesouro = new ThreadConsultaPagamentoPagTesouro(pagTesouroAPI, pagTesouroPagamentoService, dataUtils);
            threadConsultaPagamentoPagTesouro.setIdPagamento(solicitacaoPagamentoPagTesouro.getIdPagamento());
            threadConsultaPagamentoPagTesouro.setDataCriacao(solicitacaoPagamentoPagTesouro.getDataCriacao());
            threadConsultaPagamentoPagTesouro.setDataVencimento(solicitacaoPagamentoPagTesouro.getDataVencimento());
            threadConsultaPagamentoPagTesouro.start();
            spResponse = new SolicitacaoPagamentoPagTesouroResponse(Response.Status.OK.getStatusCode(), solicitacaoPagamento.getCnpjCpf(),
                    solicitacaoPagamentoPagTesouro, System.currentTimeMillis());
            spResponseLog = new SolicitacaoPagamentoPagTesouroResponse(Response.Status.OK.getStatusCode(),
                    solicitacaoPagamento.getCnpjCpf(), System.currentTimeMillis());
        } catch (Exception e) {
            SolicitacaoPagamentoPagTesouroResponse spResponseError = new SolicitacaoPagamentoPagTesouroResponse(
                    Response.Status.valueOf(super.getResponseStatusFromMessageError(e.getMessage())).getStatusCode(),
                    super.getMessageFromMessageError(e.getMessage()), System.currentTimeMillis());
            spResponse = spResponseError;
            spResponseLog = spResponseError;
        }
        json = super.getGson().toJson(spResponseLog, SolicitacaoPagamentoPagTesouroResponse.class);
        super.gravarLog(
                Logger.createLogApiSolicitaPagamentoPagTesouro(PATH + URI_API_SOLICITA_PAGAMENTO_PAGTESOURO, json));
        return spResponse;
    }
}
