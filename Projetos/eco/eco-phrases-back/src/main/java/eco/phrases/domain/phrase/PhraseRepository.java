package eco.phrases.domain.phrase;

import eco.phrases.domain.user.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

public interface PhraseRepository extends JpaRepository<Phrase, Long>{

    List<Phrase> findByUserId(Long id);

    List<Phrase> findByUser(User usuario);

    @Modifying
    @Transactional
    @Query("DELETE FROM Phrases p WHERE p.id = :idPhrase AND p.user.id = :idUser")
    int deletePhrase(Long idPhrase, Long idUser);
}
