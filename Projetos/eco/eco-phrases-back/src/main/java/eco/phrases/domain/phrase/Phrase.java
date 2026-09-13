package eco.phrases.domain.phrase;

import eco.phrases.domain.phraseDelivery.PhraseDelivery;
import eco.phrases.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name="Phrases")
@Table(name="phrases")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Phrase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String text;
    private String author;
    private String origin;
    private LocalDateTime nextSeen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "phrase", cascade = CascadeType.REMOVE)
    private List<PhraseDelivery> deliveries;

}
