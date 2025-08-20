package java.Projetos.send_phrases.src.main.phrases;

import java.util.Scanner;

public class PhrasesProject {

    public static void main(String[] args) {

            try (Scanner objScanner = new Scanner(System.in)) {
                System.out.println("Enter your name");

                String userName = objScanner.nextLine();
                System.out.println("Name of User: " + userName);
            }
    }

}
