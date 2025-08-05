import java.util.Scanner;

public class Comparison {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int n1, n2;

        System.out.print("Enter firt integer: ");
        n1 = input.nextInt();

        System.out.print("Enter second integer: ");
        n2 = input.nextInt();

        if(n1 == n2)
            System.out.printf("%d == %d%n", n1, n2);

        if(n1 != n2)
            System.out.printf("%d != %d%n", n1, n2);

        if(n1 < n2)
            System.out.printf("%d < %d%n", n1, n2);

        if(n1 > n2)
            System.out.printf("%d > %d%n", n1, n2);

        if(n1 <= n2)
            System.out.printf("%d <= %d%n", n1, n2);

        if(n1 >= n2)
            System.out.printf("%d >= %d%n", n1, n2);

        input.close();

    }

}
