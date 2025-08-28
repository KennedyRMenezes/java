public class Condicional {
    public static void main(String[] args) {
        int ano = 1986;
        boolean incluidoNoPlano = false;
        String tipoPlano = "normal";

        if(ano >= 2022){
            System.out.println("Lancamento!");
        }else{
            System.out.println("Retro");
        }

        if(incluidoNoPlano == true || tipoPlano.equals("plus")){
            System.out.println("Filme liberado");
        }else{
            System.out.println("Deve pagar a locacao");
        }
    }
}
