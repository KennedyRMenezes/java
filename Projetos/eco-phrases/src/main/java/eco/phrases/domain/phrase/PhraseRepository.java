package eco.phrases.domain.phrase;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface PhraseRepository extends JpaRepository<Phrase, Long>{

    List<Phrase> findByUserId(Long id);
}
