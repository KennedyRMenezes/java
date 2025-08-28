import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {

        try (Scanner leitura = new Scanner(System.in)) {
            double mediaAvaliacao = 0;
            double nota = 0;

            for (int i = 0; i < 3; i++) {
                System.out.println("Qual a avaliacao?");
                nota = leitura.nextDouble();
                mediaAvaliacao += nota;
            }

            System.out.println("Media de avaliacoes " + mediaAvaliacao/3);
        }

    }
}
