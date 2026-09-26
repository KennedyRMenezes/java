package Course;

public class SpeedConverter {

    public static void main(String[] args) {

        double[] nums = {0, 1.5, 10.25, -5.6, 25.42, 75.114};

        for(double num: nums ){
            printConversion(num);
        }

    }

    public static long toMilesPerHour(double kilometersPerHour){
        return kilometersPerHour < 0 ? -1 : Math.round(kilometersPerHour / 1.609);
    }

    public static void printConversion(double kilometersPerHour){
        if(kilometersPerHour < 0){
            System.out.println("Invalid Value");
        }else{
            System.out.println(kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h");
        }
    }
}
