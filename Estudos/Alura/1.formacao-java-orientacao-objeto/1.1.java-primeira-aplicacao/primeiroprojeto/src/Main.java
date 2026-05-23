public class Main {
    public static void main(String[] args) {

        System.out.println("Esse é o Screen Match");

        int ano = 2022;

        // padrao Camel Case
        int anoDeLancamento = 2022;
        System.out.println("Ano de lançamento: " + anoDeLancamento);

        boolean incluidoNoPlano = true;
        double nota = 8.1;

        double media = (9.8 + 6.3 + 8.0) / 3;
        System.out.println("Média: "+media);

        String sinopse;
        sinopse = "Filme de aventura";
        System.out.println(sinopse);

        //Text block
        sinopse = """
                
                Filme Top Gun
                Filme de aventura
                Muito bom!
                """;

        System.out.println(sinopse);

        // casting
        int classificacao = (int) (media/2);
        System.out.println(classificacao);

    }
}