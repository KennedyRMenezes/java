package phrases.controller;

import java.util.Scanner;
import phrases.model.Phrase;

public class ConsolePhraseInput {

    private final Scanner scan;

    public ConsolePhraseInput(Scanner scan){
        this.scan = scan;
    }

    public String readText(){
        System.out.println("Enter the phrase: ");
        return scan.nextLine().trim();
    }

    public String readOrigin(){
        System.out.println("Enter the origin: ");
        return scan.nextLine().trim();
    }

    public String readAuthor(){
        System.out.println("Enter the author: ");
        return scan.nextLine().trim();
    }

    public Phrase readPhrase(){
        String phrase = readText();
        String origin = readOrigin();
        String author = readAuthor();
        return new Phrase (phrase, origin, author);
    }

}
