package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://omdbapi.com/?t=";
    private final String API_KEY = "&apikey=" + System.getenv("al_api_key");

    private String json = "";
    private List<DadosTemporada> temporadas = null;
    private List<Episodio> episodios = null;
    private DadosSerie dados = null;
    private String enderecoFinal = "";
    private String nomeSerie = "";

    public void exibeMenu(){

        System.out.print("\n" + "Digite o nome da série a ser buscada: ");
        nomeSerie = leitura.nextLine();
        enderecoFinal =  ENDERECO + nomeSerie.replace(" ", "+") + API_KEY;
        this.json = consumo.oberDados(enderecoFinal);
        dados = conversor.obterDados(this.json, DadosSerie.class);

//        listaDadosSerie();

        listaTemporadas(false);

//        listaTodosEpisodios();

        var top = 10;

//        listaEpisodiosAntesDaClasseEpisodio(top);

//        listaEpisodiosComClasseEpisodio();

//        streamAndPeek(top);

//        buscaAposAno();

//        buscaPorTrechoEpisodio();

        utilizandoMap(); // 4.3, 2:36


    }

    public void utilizandoMap(){

        

    }

    public void buscaPorTrechoEpisodio(){

        System.out.print("Digite o trecho do nome de um episodio para ser buscado: ");
        var trechoTitulo = leitura.nextLine();
        Optional<Episodio> episodioBuscado = episodios.stream()
                .filter(e -> e.getTitulo().toUpperCase().contains(trechoTitulo.toUpperCase()))
                .findFirst();
        if(episodioBuscado.isPresent()){
            var ep = episodioBuscado.get();
            System.out.println("✓ Episódio encontrado!");
            System.out.println("Temporada: " + ep.getTemporada());
            System.out.println("\t" + ep.getTitulo() + ", " +  ep.getDataLancamento());
        }else{
            System.out.println("✕ Episódio não encontrado.");
        }

    }


    public void buscaAposAno(){

        System.out.print("A partir de que ano você deseja ver os episodios?: ");
        var ano = leitura.nextInt();
        // necessário nextLine() quando se lê um inteiro
        leitura.nextLine();

        LocalDate dataBusca = LocalDate.of(ano, 1, 1);
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        episodios.stream()
                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
                .forEach(e -> System.out.println(
                        "Temporada: " + e.getTemporada() +
                                ", Episodio: " + e.getTitulo() +
                                ", Data lançamento: " + e.getDataLancamento().format(dft)
                ));
        System.out.println();

    }


    public void streamAndPeek(Integer top){

        // usando peek
        System.out.println("\nTop " + top + " Episódios");
        episodios.stream()
                .sorted(Comparator.comparing(Episodio::getAvaliacao).reversed())
                .peek(e -> System.out.println("\nOrdenação " + e))
                .limit(top)
                .peek(e -> System.out.println("\nLimite " + e))
                .map(e -> e.getTitulo().toUpperCase())
                .peek(e -> System.out.println("\nMapeamento" + e))
                .forEach(System.out::println);
        System.out.println();

    }


    public void listaEpisodiosComClasseEpisodio(){

        this.episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d))
                ).collect(Collectors.toList());

        episodios.forEach(System.out::println);
        System.out.println();

    }


    public void listaEpisodiosAntesDaClasseEpisodio(Integer top){

        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());


        System.out.println("\nTop " + top + " Episódios");
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .limit(top)
                .forEach(System.out::println);
        System.out.println();

    }


    public void listaTodosEpisodios(){

        // for antigo no Notion, aqui Lambda.
        temporadas.forEach(
                t -> t.episodios().forEach(
                        e -> System.out.println(e.titulo())
                )
        );
        System.out.println();

    }


    public void listaDadosSerie(){

        System.out.println("\n" + dados);
        System.out.println();

    }


    public void listaTemporadas(Boolean lista){
        temporadas = new ArrayList<>();
        for (int i = 1; i <= dados.totalTemporadas(); i++){
            enderecoFinal = ENDERECO +
                    nomeSerie.replace(" ", "+") +
                    "&season=" + i +
                    API_KEY;
            json = consumo.oberDados(enderecoFinal);
            var dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }


        if(lista){
            temporadas.forEach(System.out::println);
            System.out.println();
        }

    }

}
