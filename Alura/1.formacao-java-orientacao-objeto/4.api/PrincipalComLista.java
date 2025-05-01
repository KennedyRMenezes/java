import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

public class PrincipalComLista {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("La La Land", 2016);
        Serie lost = new Serie("Lost", 2000);
        Filme outroFilme = new Filme("Blue Valentine", 2012);
        var filmeDoPaulo = new Filme("Dogville", 2003);

        List<Titulo> listaDeAssistidos = new ArrayList<>();
        listaDeAssistidos.add(filmeDoPaulo);
        listaDeAssistidos.add(meuFilme);
        listaDeAssistidos.add(outroFilme);
        listaDeAssistidos.add(lost);

        // for (Titulo titulo : listaDeAssistidos) {
        //     System.out.println(titulo);
        //     Filme filme = (Filme) titulo;
        //     System.out.println("Classificação " + filme.getClassificacao());
        // }

        // for (Titulo titulo : listaDeAssistidos) {
        //     System.out.println(titulo);
        //     if (titulo instanceof Filme){
        //         Filme filme = (Filme) titulo;
        //         System.out.println("Classificação " + filme.getClassificacao());
        //     }
        // }

        for (Titulo titulo : listaDeAssistidos) {
            System.out.println(titulo);
            if (titulo instanceof Filme filme){
                System.out.println("Classificação " + filme.getClassificacao());
            }
        }

        List<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");

        System.out.println("\nArtistas");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("\nArtistas depois da ordenação");
        System.out.println(buscaPorArtista);

        Collections.sort(listaDeAssistidos);
        System.out.println("\nOrdenação por Titulo");
        System.out.println(listaDeAssistidos);

        listaDeAssistidos.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("\nOrdenação por ano");
        System.out.println(listaDeAssistidos);

    }
}
