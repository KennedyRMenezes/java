package med.voll.api.domain;

public class ValidacaoExcetion extends RuntimeException {
    public ValidacaoExcetion(String mensagem) {
        super(mensagem);
    }
}
