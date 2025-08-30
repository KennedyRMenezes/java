package br.com.projeto.tabela_fipe.principal;

import java.util.List;
import java.util.Scanner;
import br.com.projeto.tabela_fipe.service.ConsumoAPI;
import br.com.projeto.tabela_fipe.service.DataConversor;
import br.com.projeto.tabela_fipe.model.Marcas;

public class PrincipalFIPE {

    private Scanner input = new Scanner(System.in);
    private String url = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumoAPI consumo = new ConsumoAPI();
    private DataConversor conversor = new DataConversor();


    public void exibeMenu(){

        System.out.println("\n\n\n\n\n");
        System.out.println("**** OPÇÕES ****\n"+
                           "Carros\n"+
                           "Motos\n"+
                           "Caminhões\n");
        System.out.println("\n\n");

        System.out.print("Digite uma das opções para consultar valores:");

        String option = input.nextLine();

        String modelo = option.toLowerCase();
        String busca = url+modelo+"/"+"marcas";

        var json = consumo.getData(busca);
        List<Marcas> marcas = conversor.getListData(json, Marcas.class);

        for(int i = 0; i < marcas.size(); i++){
            System.out.println(marcas.get(i));
        }

        System.out.println();
    }

}
