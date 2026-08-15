package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoExcetion;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferenceEntreMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferenceEntreMinutos < 30){
            throw new ValidacaoExcetion("Consulta deve ser agendada com antecedência minima de 30 minutos");
        }
    }

}
