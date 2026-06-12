package br.com.alura.apiendereco;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.print("\nInsira o CEP para consulta: ");
        Scanner busca = new Scanner(System.in);
        String cep = busca.nextLine();

        ConsultaCEP consulta = new ConsultaCEP();

        try {
            Endereco endereco = new Endereco(consulta.buscaEndereco(cep));
            System.out.println(endereco);

            GeradorDeArquivo gerador = new GeradorDeArquivo();

            gerador.salvaJson(endereco);

        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }
    }

}
