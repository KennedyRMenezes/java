import java.util.Scanner;

public class Analysis {

    public static void main(String[] args) {
        
        int aprovacoes = 0;
        int reprovacoes = 0;
        int contadorAlunos = 1;

        Scanner input = new Scanner(System.in);

        while (contadorAlunos <= 10) {
            
            System.out.print("Insira a nota: ");
            int indicador = input.nextInt();

            if (indicador == 1){
                aprovacoes++;
            }else if(indicador == 2){
                reprovacoes++;
            }else{
                System.out.println("Número inválido");
            }

            contadorAlunos++;

        }

        System.out.println("\nNúmero de Aprovações: " + aprovacoes);
        System.out.println("Número de Reprovações: " + reprovacoes);

        if(aprovacoes > 8)
            System.out.println("Bonus to instructor");



    }

}
