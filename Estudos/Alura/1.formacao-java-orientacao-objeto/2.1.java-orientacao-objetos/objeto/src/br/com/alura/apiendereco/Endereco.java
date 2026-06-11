package br.com.alura.apiendereco;

public class Endereco {

    String rua;
    String cep;
    String bairro;
    String cidade;
    String estado;

    public Endereco(EnderecoAPI endereco){
        this.rua = endereco.logradouro();
        this.cep = endereco.cep();
        this.bairro = endereco.bairro();
        this.cidade = endereco.localidade();
        this.estado = endereco.estado();
    }

    @Override
    public String toString() {
        return "\tO endereço é: " + this.rua +
                "\n\t\tCEP: " + this.cep +
                "\n\t\t\tBairro: " + this.bairro +
                "\n\t\t\t\tCidade: " + this.cidade +
                "\n\t\t\t\t\tEstado: " + this.estado;
    }
}
