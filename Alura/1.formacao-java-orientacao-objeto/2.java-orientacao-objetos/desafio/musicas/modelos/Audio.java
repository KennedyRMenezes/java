package desafio.musicas.modelos;

public class Audio {

    private String titulo;
    private int totalReproducoes;
    private int totalCurtidas;
    private double classificacao;
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTotalReproducoes() {
        return totalReproducoes;
    }

    public int getTotalCurtidas() {
        return totalCurtidas;
    }

    public int getClassificacao() {
        return (int) classificacao;
    }

    public void curti(){
        this.totalCurtidas++;
    }

    public void reproduz(){
        this.totalReproducoes++;
    }

    


}
