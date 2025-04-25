import java.util.ArrayList;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

public class PrincipalComLista {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("La La Land", 2016);
        Serie lost = new Serie("Lost", 2000);
        Filme outroFilme = new Filme("Blue Valentine", 2016);
        var filmeDoPaulo = new Filme("Dogville", 2003);

        ArrayList<Titulo> listaDeAssistidos = new ArrayList<>();
        listaDeAssistidos.add(filmeDoPaulo);
        listaDeAssistidos.add(meuFilme);
        listaDeAssistidos.add(outroFilme);
        listaDeAssistidos.add(lost);

        for (Titulo titulo : listaDeAssistidos) {
            System.out.println(titulo);
            Filme filme = (Filme) titulo;
            System.out.println("Classificação " + filme.getClassificacao());
        }
    }
}
