public class Principal {

    public static void main(String[] args) {

        Filme meuFilme = new Filme();
        meuFilme.nome = "O poderoso chefão";
        meuFilme.anoDeLancamento = 1970;
        meuFilme.duracaoEmMinutos = 180;

        System.out.println(meuFilme); //Filme@1b28cdfa
        meuFilme.exibeFichaTecnica();

    }
}
