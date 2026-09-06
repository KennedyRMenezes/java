package eco.phrases.domain.phrase;

import java.time.LocalDateTime;

public record PhraseResponseData(Long id,
                                 String text,
                                 String author,
                                 String origin,
                                    LocalDateTime nextSeen) {

    public PhraseResponseData(Phrase p){
        this(p.getId(), p.getText(), p.getAuthor(), p.getOrigin(), p.getNextSeen());
    }

}
