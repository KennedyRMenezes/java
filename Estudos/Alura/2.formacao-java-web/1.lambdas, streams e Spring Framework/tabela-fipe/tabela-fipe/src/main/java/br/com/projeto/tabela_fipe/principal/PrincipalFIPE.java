package br.com.projeto.tabela_fipe.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.Spring;

import br.com.projeto.tabela_fipe.service.ConsumoAPI;
import br.com.projeto.tabela_fipe.service.DataConversor;
import br.com.projeto.tabela_fipe.model.Modelos;
import br.com.projeto.tabela_fipe.model.Veiculo;
import br.com.projeto.tabela_fipe.model.Dados;


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

        System.out.print("Digite uma das opções para consultar valores: ");

        String option = input.nextLine();

        String endereco;

        if(option.toLowerCase().contains("car")){
            endereco = url + "carros/marcas";
        }else if(option.toLowerCase().contains("mot")){
            endereco = url + "motos/marcas";
        }else{
            endereco = url + "caminhoes/marcas";
        }

        var json = consumo.getData(endereco);
        List<Dados> marcas = conversor.getList(json, Dados.class);

        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.print("\nInforme o codigo da marca para consulta: ");

        var codigoMarcar = input.nextLine();

        endereco = endereco + "/" + codigoMarcar + "/modelos";

        json = consumo.getData(endereco);
        var modeloLista = conversor.getData(json, Modelos.class);
        System.out.println("\nModelos dessa marca: ");;
        modeloLista.modelos().stream()
                                .sorted(Comparator.comparing(Dados::codigo))
                                .forEach(System.out::println);

        System.out.print("\nDigite um trecho do nome do carro a ser buscado: ");
        var nomeCarro = input.nextLine();

        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
                                        .filter(m -> m.nome()
                                                    .toLowerCase()
                                                    .contains(
                                                        nomeCarro.toLowerCase()
                                                    ))
                                        .collect(Collectors.toList());
        System.out.println("\nModelos filtrados");
        modelosFiltrados.forEach(System.out::println);

        boolean sentinela = true;
        String endereco_ ;
        while(sentinela){

            System.out.print("\nDigite por favor o código do modelo: ");
            var codigoModelos = input.nextLine();

            endereco_ = endereco + "/" + codigoModelos + "/anos";
            json = consumo.getData(endereco_);

            List<Dados> anos = conversor.getList(json, Dados.class);

            List<Veiculo> veiculos = new ArrayList<>();

            for(int i = 0; i < anos.size(); i++){

                var enderecoAnos = endereco_ + "/" + anos.get(i).codigo();
                json = consumo.getData(enderecoAnos);
                Veiculo veiculo = conversor.getData(json, Veiculo.class);
                veiculos.add(veiculo);
            }

            System.out.println("\nTodos os veículos filtrados com avaliações por ano: ");

            veiculos.forEach(System.out::println);

            System.out.println("\n0: para sair\nQualquer outra tecla para continuar\n");
            String command_input = input.nextLine();


            if(command_input.equals("0")){
                sentinela = false;
            }else if(command_input.equals("1")){
                sentinela = true;
                endereco_ = "";
            }
            
        }
        
        // System.out.print("\nDigite por favor o código do modelo: ");
        // var codigoModelos = input.nextLine();

        // endereco = endereco + "/" + codigoModelos + "/anos";
        // json = consumo.getData(endereco);

        // List<Dados> anos = conversor.getList(json, Dados.class);

        // List<Veiculo> veiculos = new ArrayList<>();

        // for(int i = 0; i < anos.size(); i++){

        //     var enderecoAnos = endereco + "/" + anos.get(i).codigo();
        //     json = consumo.getData(enderecoAnos);
        //     Veiculo veiculo = conversor.getData(json, Veiculo.class);
        //     veiculos.add(veiculo);
        // }

        // System.out.println("\nTodos os veículos filtrados com avaliações por ano: ");

        // veiculos.forEach(System.out::println);
    }
}
