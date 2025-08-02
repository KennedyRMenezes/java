package phrases.model;

public class Phrase {

    private String phrase;
    private String origin;
    private String author;

    public Phrase(String phrase, String origin, String author){
        this.phrase = phrase;
        this.origin = origin;
        this.author = author;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getOrigin(){
        return this.origin;
    }

    public String getPhrase(){
        return this.phrase;
    }

    @Override
    public String toString() {
        return "\n----------------------------------------------------------------------------------\n" + 
               this.phrase + "\n- [" + this.origin + ", " + this.author + "]"+
               "\n----------------------------------------------------------------------------------\n";
    }

}
