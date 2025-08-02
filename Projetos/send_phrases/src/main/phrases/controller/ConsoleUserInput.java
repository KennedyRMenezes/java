package phrases.controller;

import java.util.Scanner;
import phrases.model.User;

public class ConsoleUserInput {

    private final Scanner scan;

    public ConsoleUserInput(Scanner scan){
        this.scan = scan;
    }

    public String readName(){
        System.out.println("Enter your name: ");
        return scan.nextLine().trim();
    }

    public String readEmail(){
        System.out.println("Enter your email: ");
        return scan.nextLine().trim();
    }

    public User readUser(){
        String name = readName();
        String email = readEmail();
        return new User (name, email);
    }

}
