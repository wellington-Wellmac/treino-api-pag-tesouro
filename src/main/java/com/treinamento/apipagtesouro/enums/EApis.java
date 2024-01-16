package com.treinamento.apipagtesouro.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.treinamento.apipagtesouro.controller.PagTesouroController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonFormat(shape=JsonFormat.Shape.OBJECT)
public class EApis {

    CONECTA_CADE_API_SOLICITACAO_PAGAMENTO_PAG_TESOURO(
            PagTesouroController.OBJETIVO_API_SOLICITA_PAGAMENTO_PAGTESOURO,
            PagTesouroController.TAG_API_SOLICITA_PAGAMENTO_PAGTESOURO,
            PagTesouroController.PATH + PagTesouroController.URI_API_SOLICITA_PAGAMENTO_PAGTESOURO)

    public static final Map<String, EApis> apisToEnum = new HashMap<String, EApis>();

    private String objetivoApi;
    private String tagApi;
    private String uriApi;

    private EApis(String objetivoApi, String tagApi, String uriApi) {
        this.objetivoApi = objetivoApi;
        this.tagApi = tagApi;
        this.uriApi = uriApi;
    }

    public String getObjetivoApi() {
        return objetivoApi;
    }

    public String getTagApi() {
        return tagApi;
    }

    public String getUriApi() {
        return uriApi;
    }

    public static List<EApis> getApisList() {
        return Arrays.asList(EApis.values());
    }

    public static final String getUriApi(String tagApi) {
        return fromTagApi(tagApi).getUriApi();
    }

    static {
        for (EApis api : values())
            apisToEnum.put(api.getTagApi(), api);
    }

    public static EApis fromTagApi(String tagApi) {
        return apisToEnum.get(tagApi);
    }

}
