package br.com.alura.screenmatch.principal;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {

    public static void main(String[] args) {

        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        Serie lost = new Serie("Lost", 2000);
        Filme outroFilme = new Filme("Avatar", 2023);
        var filmeDoKennedy = new Filme("La La Land", 2016);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(filmeDoKennedy);
        lista.add(lost);

        System.out.println("\nTrabalhando com listas\n");

        for (Titulo item: lista){
            System.out.println(item.getNome());

//            if (item instanceof Filme){
//                // ***** cast manual *****
//                Filme filme = (Filme) item;
//                System.out.println("\tClassificação " + filme.getClassificacao());
//            }

            // ***** sem cast / pattern variable *****
            if (item instanceof Filme filme){
                System.out.println("\tClassificação " + filme.getClassificacao());
            }
        }

        List<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);

        System.out.println("\nDepois da ordenação");
        System.out.println(buscaPorArtista);

        System.out.println("\nOrdenação dos títulos");
        Collections.sort(lista);
        System.out.println(lista);

        System.out.println("\nOrdenação dos títulos por ano usando Comparator (.sort())");
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);
    }

}
