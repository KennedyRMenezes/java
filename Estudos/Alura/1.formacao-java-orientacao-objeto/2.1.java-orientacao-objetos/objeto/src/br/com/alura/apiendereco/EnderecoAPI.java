package br.com.alura.apiendereco;

public record EnderecoAPI(String cep,
                          String logradouro,
                          String bairro,
                          String localidade,
                          String estado) {
}
