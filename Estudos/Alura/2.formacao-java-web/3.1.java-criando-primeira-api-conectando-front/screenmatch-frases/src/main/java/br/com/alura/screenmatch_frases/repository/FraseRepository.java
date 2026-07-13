package br.com.alura.screenmatch_frases.repository;

import br.com.alura.screenmatch_frases.model.Frase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FraseRepository extends JpaRepository<Frase, Long> {

    @Query("select f from Frase f order by function('RANDOM') LIMIT 1")
    public Frase buscaFraseAleatoria();

}
