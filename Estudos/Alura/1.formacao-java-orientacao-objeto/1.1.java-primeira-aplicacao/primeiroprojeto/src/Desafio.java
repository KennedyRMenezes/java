import java.util.Scanner;

public class Desafio {

    static String nomeCliente = "Joaquim Maria Machado de Assis";
    static String tipoConta = "Conta Corrente";
    static double saldoConta = 1000;

    public static void main(String[] args) {

        System.out.println("***************************************");
        System.out.println("Dados iniciais do cliente:\n");
        System.out.printf("%-20s %s%n", "Nome:", nomeCliente);
        System.out.printf("%-20s %s%n", "Tipo conta:", tipoConta);
        System.out.printf("%-20s %.2f%n", "Saldo inicial:", saldoConta);
        System.out.println("***************************************\n\n");

        imprimeMenu();
        Scanner leitura = new Scanner(System.in);

        int opcao = 0;
        while(opcao != 4){

            opcao = leitura.nextInt();

            if (opcao == 1){
                consultaSaldo();
            } else if (opcao == 2) {
                System.out.print("Informe o valor a receber: ");
                fazDeposito(leitura.nextDouble());
            } else if (opcao == 3) {
                System.out.print("Informa o valor a ser transferido: ");
                fazTransferencia(leitura.nextDouble());
            } else if(opcao == 4){
                System.out.println("Programa encerrado!");
                break;
            } else {
                System.out.println("Insira uma opcao válida" + "\n");
            }

            imprimeMenu();
        }
    }

    public static void fazTransferencia(double transferencia){
        if(transferencia <= saldoConta){
            saldoConta -= transferencia;
            consultaSaldo();
        } else if (transferencia > saldoConta) {
            System.out.println("Não há saldo o suficiente para efetuar essa transação" + "\n");
        }
    }

    public static void fazDeposito(double deposito){

        if(deposito <= 0){
            System.out.println("Valor inválido");
        }else{
            saldoConta += deposito;
            consultaSaldo();
        }
    }

    public static void consultaSaldo(){
        System.out.printf("\nSaldo atual: R$ %.2f%n\n", saldoConta);
    }

    public static void imprimeMenu(){
        System.out.println("""
                MENU
                1 - Consultar saldo
                2 - Receber valor
                3 - Transferir valor
                4 - Sair
                
                Digite a opção desejada:""");
    }
}
