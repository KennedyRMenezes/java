package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://omdbapi.com/?t=";
    private final String API_KEY = "&apikey=" + System.getenv("al_api_key");

    public void exibeMenu(){

        System.out.print("\n" + "Digite o nome da seria a ser buscada: ");
        var nomeSerie = leitura.nextLine();
        String endereco =  ENDERECO + nomeSerie.replace(" ", "+") + API_KEY;
        var json = consumo.oberDados(endereco);

        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

        System.out.println("\n" + dados);

        List<DadosTemporada> temporadas = new ArrayList<>();
		for (int i = 1; i <= dados.totalTemporadas(); i++){
			endereco = ENDERECO +
                        nomeSerie.replace(" ", "+") +
                        "&season=" + i +
                        API_KEY;
			json = consumo.oberDados(endereco);
            var dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);
    }

}
