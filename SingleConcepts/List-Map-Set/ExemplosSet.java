import java.util.HashSet;
import java.util.Set;

public class ExemplosSet {

    public static void main(String[] args) {
        

        Set<Pessoa> pessoas = new HashSet<>();
        Pessoa joao = new Pessoa("Joao", 1L);
        pessoas.add(joao);

        for (Pessoa pessoa: pessoas){
            System.out.println(pessoa.getNome());
        }

        System.out.println("------------");

        //  .add retorna um boolean
        boolean adicionou = pessoas.add(new Pessoa("Joao", 1L));

        if (adicionou){
            System.out.println("Adicionou");
        }
        else {
            System.out.println("Nao adicionou");
        }

        for (Pessoa pessoa: pessoas){
            System.out.println(pessoa.getNome());
        }

    }

}
