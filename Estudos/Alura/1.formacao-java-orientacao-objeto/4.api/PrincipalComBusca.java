import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.screenmatch.excecao.ErrorDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                        .setPrettyPrinting()
                        .create();

        while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("\nDigite um filme para busca: ");
            busca = leitura.nextLine();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }

            //A chave que consta aqui é proveniente do curso ministrado
            String endereco = "https://omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=6585022c";

            try {

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                HttpResponse<String> response = client
                        .send(request, BodyHandlers.ofString());

                String json = response.body();
                // System.out.println(json);

                

                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);

                System.out.println(meuTituloOmdb);

                // try{
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo ja convertido: ");
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);

            } catch (NumberFormatException e) {
                System.out.println("\nAconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("\nAlgum erro de argumento da busca, verifique o endereço");
            } catch (ErrorDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println(titulos);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));

        System.out.println("\nO programa finalizou corretamente\n");

        leitura.close();
        escrita.close();
    }
}
