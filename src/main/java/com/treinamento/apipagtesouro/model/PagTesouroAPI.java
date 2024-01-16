package com.treinamento.apipagtesouro.model;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.treinamento.apipagtesouro.model.request.SolicitacaoPagamentoRequest;
import com.treinamento.apipagtesouro.model.response.ConsultarPagamentoPagTesouro;
import com.treinamento.apipagtesouro.model.response.SolicitacaoPagamentoPagTesouro;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Component
public class PagTesouroAPI {

    @Value("${pagtesouro.solicitar.pagamento.url}")
    private String URL_API_PAGTESTOURO_SOLICITAR_PAGAMENTO;

    @Value("${pagtesouro.consultar.pagamento.url}")
    private String URL_API_PAGTESTOURO_CONSULTAR_PAGAMENTO;

    @Value("${pagtesouro.bearer-token}")
    private String BEARER_TOKEN_PAG_TESOURO;

    private static Gson gson;

    public SolicitacaoPagamentoPagTesouro solicitacaoPagamentoPagTesouro(SolicitacaoPagamentoRequest request) throws Exception {
        URL url = new URL(URL_API_PAGTESTOURO_SOLICITAR_PAGAMENTO);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty(HttpHeaders.AUTHORIZATION, BEARER_TOKEN_PAG_TESOURO);
        String requestBody = getGson().toJson(request);
        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
        outputStream.writeBytes(requestBody);
        outputStream.flush();
        outputStream.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        SolicitacaoPagamentoPagTesouro solicitacaoPagamentoPagTesouro = gson.fromJson(response.toString(), SolicitacaoPagamentoPagTesouro.class);
        solicitacaoPagamentoPagTesouro.setDataVencimento(request.getVencimento());
        return solicitacaoPagamentoPagTesouro;
    }

    public ConsultarPagamentoPagTesouro consultarPagamentoPagTesouro(String idPagamento) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(URL_API_PAGTESTOURO_CONSULTAR_PAGAMENTO + "/" + idPagamento);
        httpGet.setHeader(HttpHeaders.AUTHORIZATION, BEARER_TOKEN_PAG_TESOURO);
        HttpResponse response = null;
        StringBuilder result = new StringBuilder();
        ConsultarPagamentoPagTesouro consultarPagamentoPagTesouro = null;
        try {
            response = httpClient.execute(httpGet);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String output = "";
        try {
            while ((output = br.readLine()) != null) {
                result.append(output);
            }
            consultarPagamentoPagTesouro = getGson().fromJson(result.toString(), ConsultarPagamentoPagTesouro.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return consultarPagamentoPagTesouro;
    }

    public static Gson getGson() {
        if(gson == null) {
            gson = new GsonBuilder().create();
        }
        return gson;
    }
}
