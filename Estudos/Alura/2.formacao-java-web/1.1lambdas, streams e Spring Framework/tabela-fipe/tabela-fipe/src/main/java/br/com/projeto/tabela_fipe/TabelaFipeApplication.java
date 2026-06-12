package br.com.projeto.tabela_fipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import br.com.projeto.tabela_fipe.principal.PrincipalFIPE;

@SpringBootApplication
public class TabelaFipeApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TabelaFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		PrincipalFIPE principal = new PrincipalFIPE();
		principal.exibeMenu();

	}

}
