package Course;

public class Class41 {

    public static void main(String[] args) {

        double vOne = 20.00;
        double vTwo = 80.00;
        double result = (vOne + vTwo) * 100.00;

        double remainder = result % 40.00;

        boolean checkRemainder = (remainder == 0.00) ? true : false;

        System.out.println(checkRemainder);

        if (!checkRemainder) {
            System.out.println("got some remainder");
        }


    }

}
