package br.com.alura.screenmatch.calculos;

public class FiltroRecomendacao {

    private String recomendacao;

    public void filtra(Classificavel cl){
        if (cl.getClassificacao() >= 4){
            System.out.println("Está entre os preferidos do momento");
        }else if(cl.getClassificacao() >= 2){
            System.out.println("Muito bem avaliado no momento!");
        }else{
            System.out.println("Coloque na sua lista para assistir depois");
        }
    }

}
