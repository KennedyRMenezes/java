package desafio;

import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limite = leitura.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while(sair != 0) {
            System.out.println("Digite a descrição da compra:");
            String descricao = leitura.next();

            System.out.println("Digite o valor da compra:");
            double valor = leitura.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = leitura.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                sair = 0;
            }
        }

        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");
        Collections.sort(cartao.getCompras());
        for (Compra c : cartao.getCompras()) {
            System.out.println(c.getDescricao() + " - " +c.getValor());
        }
        System.out.println("\n***********************");

        System.out.println("\nSaldo do cartão: " +cartao.getSaldo());

        leitura.close();
    }

    /*
    Digite o limite do cartão: 
    100
    Digite a descrição da compra:
    a
    Digite o valor da compra:
    50
    Compra realizada!
    Digite 0 para sair ou 1 para continuar
    1
    Digite a descrição da compra:
    b
    Digite o valor da compra:
    30
    Compra realizada!
    Digite 0 para sair ou 1 para continuar
    1
    Digite a descrição da compra:
    c
    Digite o valor da compra:
    2
    Compra realizada!
    Digite 0 para sair ou 1 para continuar
    1
    Digite a descrição da compra:
    d
    Digite o valor da compra:
    5
    Compra realizada!
    Digite 0 para sair ou 1 para continuar
    1
    Digite a descrição da compra:
    e
    Digite o valor da compra:
    30
    Saldo insuficiente!
    ***********************
    COMPRAS REALIZADAS:

    c - 2.0
    d - 5.0
    b - 30.0
    a - 50.0

    ***********************

    Saldo do cartão: 13.0
     */


}