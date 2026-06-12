package br.com.alura.apiendereco;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCEP {

    public EnderecoAPI buscaEndereco(String cep){

        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {

            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), EnderecoAPI.class);

        } catch (Exception e){
            throw new RuntimeException("Não foi possível buscar endereço com esse CEP");
        }

    }

}
