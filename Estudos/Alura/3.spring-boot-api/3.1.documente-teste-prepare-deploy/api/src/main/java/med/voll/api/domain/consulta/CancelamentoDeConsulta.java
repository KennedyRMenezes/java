package med.voll.api.domain.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelamentoDeConsulta     {

    @Autowired
    private ConsultaRepository consultaRepository;


    public void excluir(Long id){
        consultaRepository.deleteById(id);
    }
}
