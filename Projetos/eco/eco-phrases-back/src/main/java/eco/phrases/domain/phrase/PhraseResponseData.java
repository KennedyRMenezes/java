package eco.phrases.domain.phrase;

public record PhraseResponseData(Long id,
                                 String text,
                                 String author,
                                 String origin) {

    public PhraseResponseData(Phrase p){
        this(p.getId(), p.getText(), p.getAuthor(), p.getOrigin());
    }

}
