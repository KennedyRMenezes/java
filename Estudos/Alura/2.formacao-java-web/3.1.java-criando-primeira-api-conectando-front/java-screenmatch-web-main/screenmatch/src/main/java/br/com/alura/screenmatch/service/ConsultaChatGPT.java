package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {

    public static String obterTraducao(String texto){

        OpenAiService service = new OpenAiService(System.getenv("gpt_key"));

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-5.5")
                .prompt("Traduza para o português do Brasil o texto a seguir: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();

    }

}
