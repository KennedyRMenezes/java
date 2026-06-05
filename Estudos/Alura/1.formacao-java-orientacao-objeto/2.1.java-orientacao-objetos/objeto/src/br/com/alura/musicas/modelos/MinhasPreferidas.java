package br.com.alura.musicas.modelos;

public class MinhasPreferidas {

    public void inclui(Audio audio){

        if (audio.getClassificacao() >= 9){
            System.out.println(audio.getTitulo() + " é considerado sucesso absoluto!");
        }else{
            System.out.println(audio.getTitulo() + " também é um dos que todos curtem!");
        }

    }

}
