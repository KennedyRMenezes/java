
import java.util.ArrayList;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
// import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.*;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("La La Land", 2016);
        meuFilme.setDuracaoEmMinutos(135);
        // System.out.println("Duração filme: " + meuFilme.getDuracaoEmMinutos());

        // meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        // System.out.println(meuFilme.getTotalDeAvaliacoes());
        // System.out.println(meuFilme.pegaMedia());

        // System.out.println("----------------");

        Serie lost = new Serie("Lost", 2000);
        // lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);

        // System.out.println("Duracao para maratonar Lost: " + lost.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("Blue Valentine", 2016);
        outroFilme.setDuracaoEmMinutos(180);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        // System.out.println(calculadora.getTempoTotal());


        // FiltroRecomendacao filtro = new FiltroRecomendacao();
        // filtro.filtra(meuFilme);
        
        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        // filtro.filtra(episodio);

        var filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.setDuracaoEmMinutos(200);
        filmeDoPaulo.avalia(10);
        
        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoPaulo);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);

        System.out.println("\nTamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println("toString do filme: " + listaDeFilmes.get(0).toString() + "\n");

        System.out.println(listaDeFilmes+"\n");
    }
}
