package br.com.alura.screenmatch.calculos;
import br.com.alura.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return this.tempoTotal;
    }

    // SOBRECARGA DE METODOS: VARIOS METODOS COM MESMO NOME
    // public void inclui(Filme f){
    //     this.tempoTotal += f.getDuracaoEmMinutos();
    // }

    // public void inclui(Serie s){
    //     this.tempoTotal += s.getDuracaoEmMinutos();
    // }

    /* POLIMORFISMO
       Aqui o metodo busca .getDuracaoEmMinutos da subclasse especifica
       passada como argumento de inclui.
       Se Serie calcula como Serie.
       Se Filme calcula como Filme.
     */
    public void inclui(Titulo titulo){
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
    
}

