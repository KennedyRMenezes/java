package eco.phrases.domain.phraseDelivery;

import eco.phrases.domain.phrase.Phrase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PhraseDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime sentAt;

    @JoinColumn(name="phrase_id")
    @ManyToOne
    private Phrase phrase;

}
