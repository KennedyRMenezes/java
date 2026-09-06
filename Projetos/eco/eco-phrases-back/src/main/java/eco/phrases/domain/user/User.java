package eco.phrases.domain.user;

import eco.phrases.domain.phrase.Phrase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "User")
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String photo;
    private String googleId;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Phrase> phrases;

    public User(Object o, String nome, String email, String foto, String googleId) {
        this.name = nome;
        this.email = email;
        this.photo = foto;
        this.googleId = googleId;
    }
}
