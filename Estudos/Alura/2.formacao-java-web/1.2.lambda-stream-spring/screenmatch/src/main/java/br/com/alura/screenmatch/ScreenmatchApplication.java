package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String endereco = "https://omdbapi.com/?t=" + "game+of+thrones" + "&apikey=" + System.getenv("al_api_key");

		var consumoapi = new ConsumoAPI();
		var json = consumoapi.oberDados(endereco);

		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
		System.out.println();

		endereco = "https://omdbapi.com/?t=" + "game+of+thrones" + "&season=1" + "&episode=1" + "&apikey=" + System.getenv("al_api_key");
		json = consumoapi.oberDados(endereco);
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);
		System.out.println();

		List<DadosTemporada> temporadas = new ArrayList<>();
		for (int i = 1; i <= dados.totalTemporadas(); i++){
			endereco = "https://omdbapi.com/?t=" + "game+of+thrones" + "&season=" + i + "&apikey=" + System.getenv("al_api_key");
			json = consumoapi.oberDados(endereco);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);

	}
}
