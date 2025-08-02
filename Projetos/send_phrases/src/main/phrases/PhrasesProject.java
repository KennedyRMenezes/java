package phrases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.text.DateFormatter;

import phrases.controller.*;
import phrases.model.*;

public class PhrasesProject {

    public static void main(String[] args) {

            try{

                Scanner scan = new Scanner(System.in);

                // ConsoleUserInput input = new ConsoleUserInput(scan);
                // User user = input.readUser();
                // System.out.println(user);

                // ConsolePhraseInput input_phrase = new ConsolePhraseInput(scan);
                // Phrase phrase = input_phrase.readPhrase();
                // System.out.println(phrase);

                // Origin origin = new Origin(phrase.getOrigin());
                // Author author = new Author(phrase.getAuthor());

                // System.out.println("Origem e Author da Frase anterior: " + origin + ", " + author);

                //TODO: Lógica de Inserção do BD (primeiro origem, autor, usuario e depois a frase)
                

                scan.close();

            }catch(Exception e){
                System.out.println("Error: " + e);
            }finally{
                System.out.println("\nFim do programa!\n");
            }
    }

}
