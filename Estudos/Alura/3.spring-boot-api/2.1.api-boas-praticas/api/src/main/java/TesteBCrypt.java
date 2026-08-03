import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TesteBCrypt {
    public static void main(String[] args) {

        var encoder = new BCryptPasswordEncoder();

        String senha = "123456";

        // gerar hash novo
        String hash = encoder.encode(senha);
        System.out.println("Hash gerado: " + hash);

        // testar hash do banco
        String hashBanco = "$2a$10$Y50UaMF0xteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.";

        boolean bate = encoder.matches(senha, hashBanco);
        System.out.println("Senha bate? " + bate);
    }
}