package br.com.alura.apiendereco;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.print("\nInsira o CEP para consulta: ");
        Scanner busca = new Scanner(System.in);
        String cep = busca.nextLine();

        ConsultaCEP consulta = new ConsultaCEP();

        Endereco endereco = new Endereco(consulta.buscaEndereco(cep));
        System.out.println(endereco);


        FileWriter escrita = new FileWriter("endereco.json");
        escrita.write(new Gson().toJson(endereco));
        escrita.close();
    }

}
