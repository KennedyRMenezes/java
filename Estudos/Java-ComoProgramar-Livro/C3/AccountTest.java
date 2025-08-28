import java.util.Scanner;

public class AccountTest {

    public static void main(String[] args) {


        //Segunda parte
        Account myAccount = new Account("Kennedy Menezes", 50.00);
        System.out.println("Name in object myAccount is: " + myAccount.getName());

        displayAccount(myAccount);

        Scanner input = new Scanner(System.in);

        System.out.print("Enter deposit amount: ");
        double dep = input.nextDouble();

        myAccount.deposit(dep);

        System.out.printf("\nAdding $%.2f to myAccount balance", dep);

        displayAccount(myAccount);

        input.close();

        // Primeira parte
        /*
        Scanner input = new Scanner(System.in);

        Account myAccount = new Account();

        System.out.printf("Initial name is: %s$n", myAccount.getName());

        System.out.println("Please enter the name:");
        String theName = input.nextLine();
        myAccount.setName(theName);
        System.out.println();

        System.out.printf("Name in object myAccount is: %n%s%n", myAccount.getName());

        input.close();
        */
    }

    public static void displayAccount(Account accountToDisplay){
        System.out.printf("\n\n%s balance: $%.2f %n", 
                                            accountToDisplay.getName(), 
                                            accountToDisplay.getBalance());
    }

}
