import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {
        try (Scanner leitura = new Scanner(System.in)) {
            System.out.println("Digite seu filme favorito");;
            String filme = leitura.nextLine();
            
            System.out.println("Qual o ano de lancamento?");
            int anoLancamento = leitura.nextInt();

            System.out.println("Qual a avaliacao?");
            double avaliacao = leitura.nextDouble();
            
            System.out.println(filme + " " + anoLancamento + " " + avaliacao);
        }
    }
}
