package eco.phrases.domain.phraseDelivery;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface PhraseDeliveryRepository extends JpaRepository<PhraseDelivery, Long> {


}
