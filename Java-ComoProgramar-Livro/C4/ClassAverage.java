import java.util.Scanner;

public class ClassAverage {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int total = 0;
        int gradeCounter = 0;

        System.out.print("Enter grade or -1 to quit: ");
        int grade = input.nextInt();

        while(grade != -1){

            total = total + grade;
            
            System.out.print("Enter grade or -1 to quit: ");
            grade = input.nextInt(); 

            gradeCounter = gradeCounter + 1;
        }

        if(gradeCounter != 0){
            double average = (double) total / gradeCounter;

            System.out.println("\nTotal of all " +  gradeCounter + " grade is " + total);
            System.out.printf("Class average is %.2f%n", average);
        }else{
            System.out.println("No grades were entered");
        }

    }

}
