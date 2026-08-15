package eco.phrases.domain.phraseDelivery;

import eco.phrases.domain.phrase.PhraseRepository;
import eco.phrases.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhraseDeliveryService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PhraseRepository phraseRepository;

}
