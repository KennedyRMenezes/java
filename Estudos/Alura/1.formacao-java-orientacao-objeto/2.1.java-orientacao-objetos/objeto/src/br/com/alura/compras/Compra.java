package br.com.alura.compras;

public class Compra implements Comparable<Compra> {

    private String descricao;
    private double valor;

    public Compra (String descricao, double valor){
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public double getValor(){
        return this.valor;
    }

    @Override
    public String toString() {
        return "Compra: descricao = " + descricao + ", valor=" + valor + '}';
    }

    @Override
    public int compareTo(Compra o) {
        return Double.valueOf(this.valor).compareTo(Double.valueOf(o.valor));
//        return Double.compare(this.valor, o.valor);
    }
}
