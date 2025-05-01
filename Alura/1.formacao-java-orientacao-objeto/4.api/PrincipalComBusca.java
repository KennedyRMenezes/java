import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;



public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException{

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um filme para busca: ");
        var busca = leitura.nextLine();

        String endereco = "https://omdbapi.com/?t=" + busca + "&apikey=6585022c";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
            .send(request, BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder()
                            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                            .create();

        //Titulo meuTitulo = gson.fromJson(json, Titulo.class);
        
        TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);

        System.out.println(meuTituloOmdb);


        try{
            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println("Titulo ja convertido: ");
            System.out.println(meuTitulo);
        } catch (NumberFormatException e){
            System.out.println("\nAconteceu um erro: ");
            System.out.println(e.getMessage());
        }

        System.out.println("\nO programa finalizou corretamente\n");        

        leitura.close();
    }
}
