package eco.phrases.domain.phrase;

import eco.phrases.domain.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
public class PhraseService {

    @Autowired
    private PhraseRepository phraseRepository;

    @Autowired
    private UserRepository userRepository;

    public Phrase cadastrar(PhraseInsertData dados, String email){

        var user = userRepository.findByEmail(email);

        Phrase savedPhrase = phraseRepository.save(new Phrase(null, dados.text(), dados.author(), dados.origin(), nextSeen(3), user));

        return savedPhrase;

    }

    public LocalDateTime nextSeen(int interval){
        return LocalDateTime.now().plusDays(interval);
    }


    public void deletePhrase(Long id, Authentication authentication) {

        var email = authentication.getName();
        var user = userRepository.getUserByEmail(email);
        int idDeleted = phraseRepository.deletePhrase(id, user.getId());

        if(idDeleted == 0){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Frase não encontrada"
            );
        }

    }

    public void updateNextSeen(PhraseUpdateDays dados, Authentication authentication) {

        var email = authentication.getName();
        var user = userRepository.getUserByEmail(email);
        int updated = phraseRepository.updateNextSeen(dados.id(), nextSeen(dados.days()), user.getId());

        if(updated == 0){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Frase não encontrada"
            );
        }

    }
}
