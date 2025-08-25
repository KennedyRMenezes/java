package br.com.alura.screenmatch.principal;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.model.DadosEpisodio;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu(){

        System.out.println("\n\nDigite o nome da série para busca");

        var nomeSerie = leitura.nextLine();

		var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
    
        System.out.println(dados);

        //Imprime episodios de todas as temporadas
		var totalTemp = dados.totalTemporadas();
		List<DadosTemporada> temporadas = new ArrayList<>();
		for (int t = 1; t <= totalTemp; t++){
			var json_ = consumo.obterDados(ENDERECO + 
                                           nomeSerie.replace(" ", "+") + 
                                           "&season=" + 
                                           t + 
                                           API_KEY);
			DadosTemporada dadosTemporada = conversor.obterDados(json_, DadosTemporada.class);
			assert temporadas.add(dadosTemporada);
                    }
            
                    // temporadas.forEach(System.out::println);
            
            
                    // for(int i = 0; i < dados.totalTemporadas(); i++){
                        
                    //     List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
            
                    //     for(int j = 0; j < episodiosTemporada.size(); j++){
                    //         System.out.println(episodiosTemporada.get(j).titulo());
                    //     }
            
                    // }
            

                    // Lambdas
                    // temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));;
            
            
                    //Stream, fluxo de dados
                    List<String> nomes = Arrays.asList("Graciliano Ramos", "Machado de Assis", "Clarice Lispector", "Jane Austen", "Lygia Fagundes Telles");
            
                    nomes.stream()
                            .sorted()
                            .limit(3)
                            .filter(n -> n.startsWith("G"))
                            .map(n -> n.toUpperCase())
                            .forEach(System.out::println);

	}
}
