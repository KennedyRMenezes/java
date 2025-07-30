package br.com.alura.screenmatch;
import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Busca endereco
		var consumoapi = new ConsumoAPI();
		var json = consumoapi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");

		// Faz conversao dos tipos serie
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println("\n");
		System.out.println(dados);


		// Faz conversao dos tipos episodio
		var json_ep = consumoapi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
		DadosEpisodio dados_ep = conversor.obterDados(json_ep, DadosEpisodio.class);
		System.out.println("\n");
		System.out.println(dados_ep);

		//Imprime episodios de todas as temporadas
		var totalTemp = dados.totalTemporadas();
		List<DadosTemporada> temporadas = new ArrayList<>();
		for (int t = 1; t <= totalTemp; t++){
			var json_ = consumoapi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=" + t + "&apikey=6585022c");
			DadosTemporada dadosTemporada = conversor.obterDados(json_, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}

		temporadas.forEach(System.out::println);


		System.out.println("\n");


	}

}

