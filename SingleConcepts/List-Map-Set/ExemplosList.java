import java.util.ArrayList;
import java.util.List;


public class ExemplosList {

    public static void main(String[] args) {
        
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("João", 1L));
        Pessoa a = pessoas.get(0);
        // pessoas.remove(a);

        for (Pessoa pessoa: pessoas){
            System.out.println(pessoa.getNome());
        }

        pessoas.add(a);

        for (Pessoa pessoa: pessoas){
            System.out.println(pessoa.getNome());
        }
    }

}
