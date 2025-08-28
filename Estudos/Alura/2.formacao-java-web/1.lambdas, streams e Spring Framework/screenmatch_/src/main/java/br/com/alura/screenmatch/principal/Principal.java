package br.com.alura.screenmatch.principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import br.com.alura.screenmatch.model.Episodio;

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
    
        System.out.println("\n"+dados);

        // ------------------------- Imprime episodios de todas as temporadas -------------------------
		var totalTemp = dados.totalTemporadas();
		List<DadosTemporada> temporadas = new ArrayList<>();
		for (int t = 1; t <= totalTemp; t++){
			var json_ = consumo.obterDados(ENDERECO + 
                                           nomeSerie.replace(" ", "+") + 
                                           "&season=" + 
                                           t + 
                                           API_KEY);
			DadosTemporada dadosTemporada = conversor.obterDados(json_, DadosTemporada.class);
			temporadas.add(dadosTemporada);
        }
        // temporadas.forEach(System.out::println);


        // ------------------------- Pega episódios com Loop por Temporada -------------------------        
        // for(int i = 0; i < dados.totalTemporadas(); i++){
            
        //     List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();

        //     for(int j = 0; j < episodiosTemporada.size(); j++){
        //         System.out.println(episodiosTemporada.get(j).titulo());
        //     }

        // }


        // ------------------------- Pega episódios com Lambda -------------------------        
        // Lambdas
        // temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));;


        // ------------------------- Exemplo Didático do Uso de Stream -------------------------        
        //Stream, fluxo de dados
        // List<String> nomes = Arrays.asList("Graciliano Ramos", "Machado de Assis", "Clarice Lispector", "Jane Austen", "Lygia Fagundes Telles");

        // nomes.stream()
        //         .sorted()
        //         .limit(3)
        //         .filter(n -> n.startsWith("G"))
        //         .map(n -> n.toUpperCase())
        //         .forEach(System.out::println);


        // ------------------------- Pega episódios, filta, ordena, e imprime com Stream -------------------------        
        // List<DadosEpisodio> dadosEpisodios = temporadas.stream().flatMap(t -> t.episodios().stream()).collect(Collectors.toList());
        // dadosEpisodios.stream()
        //                 .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
        //                 .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
        //                 .limit(5)
        //                 .forEach(System.out::println);
        
        // System.out.println("\n ---------------------- \n");
        

        // ------------------------- peek para mostrar etapas das transformações -------------------------                
        // var top = 5;
        // System.out.println("\n Top" + top + "episodios");                                    
        List<Episodio> episodios = temporadas.stream()
                                    .flatMap(t -> t.episodios()
                                                .stream()
                                                .map(d -> new Episodio(t.numero(), d))
                                                // .peek(e -> System.out.println("Map " + e))
                                                )
                                    // .sorted(Comparator.comparing(Episodio::getAvaliacao).reversed())
                                    // .peek(e -> System.out.println("Sorted " + e))
                                    // .limit(top)
                                    // .peek(e -> System.out.println("Limit " + e))
                                    .collect(Collectors.toList());
                                    
        // episodios.forEach(System.out::println);


        // ------------------------- stream para busca de título -------------------------                
        // System.out.print("\nTrecho do Título a ser buscado: ");
        // String trechoTitulo = leitura.nextLine();

        // Optional<Episodio> ep = episodios.stream()
        //             .filter(e -> e.getTitulo().toUpperCase().contains(trechoTitulo.toUpperCase()))
        //             .findFirst();

        // if(ep.isPresent()){
        //     System.out.println("Episodio encontrado!");
        //     System.out.println(ep);
        // }else{
        //     System.out.println("Episoódio não encontrado!");
        // }


        // ------------------------- stream para filtrar por ano -------------------------                
        // System.out.println("A partir de que ano você deseja ver os episodios? ");

        // var ano = leitura.nextInt();
        // leitura.nextLine();

        // LocalDate dataBusca = LocalDate.of(ano, 1, 1);

        // DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // episodios.stream()
        //             .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
        //             .forEach(e -> System.out.println(
        //                             "\nTemporada: " + e.getTemporada() +
        //                             " | Episodio: " + e.getNumeroEpisodio() +
        //                             " | Data Lancamento: " + e.getDataLancamento().format(formatador)
        //             ));


        // ------------------------- stream para média das temporadas - estatisticas -------------------------                
        
        System.out.println("\nMédia das avaliações das Temporadas");

        Map<Integer, Double> avaliacoesPorTemporada = episodios.stream()
            .filter(e -> e.getAvaliacao() > 0.0)
            .collect(Collectors.groupingBy(Episodio::getTemporada, 
            Collectors.averagingDouble(Episodio::getAvaliacao)));

        System.out.println(avaliacoesPorTemporada);

        DoubleSummaryStatistics est = episodios.stream()
            .filter(e -> e.getAvaliacao() > 0.0)
            .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));
        
        System.out.println("\n--------- ");
        System.out.println("Média " + est.getAverage());
        System.out.println("Melhor episódio "+ est.getMax());
        System.out.println("Pior episodio " + est.getMin());
        System.out.println("Quantidade de Episodios Avaliados " + est.getCount());
        System.out.println("\n--------- ");


	}
}
