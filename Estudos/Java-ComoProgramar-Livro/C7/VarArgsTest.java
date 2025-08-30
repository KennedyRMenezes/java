public class VarArgsTest {

    public static void main(String[] args) {
        
        double d1 = 10.0;
        double d2 = 20.0;
        double d3 = 30.0;
        double d4 = 40.0;

        System.out.println("d1 = " + d1 + "\n" + 
                           "d2 = " + d2 + "\n" +
                           "d3 = " + d3 + "\n" +
                           "d4 = " + d4 + "\n");

        System.out.println("Average of d1 and d2 is " + average(d1, d2));
        System.out.println("Average of d1, d2 and d3 is " + average(d1, d2, d3));
        System.out.println("Average of d1, d2, d3 and d4 is " + average(d1, d2, d3, d4));
    }

    public static double average(double... numbers){

        double total = 0.0;

        for(double d : numbers)
            total += d;

        return total / numbers.length;
    }

}
