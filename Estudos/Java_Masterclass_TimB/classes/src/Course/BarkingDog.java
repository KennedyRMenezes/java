package Course;

public class BarkingDog {

    public static void main(String[] args) {

    }


    public static boolean shouldWakeUp(boolean barking, int hourOfDay){
        boolean needToWakeUp = false;
        if(hourOfDay > 23 || hourOfDay < 0)
            return needToWakeUp;

        if(barking && (hourOfDay < 8 || hourOfDay > 22) )
            needToWakeUp = true;

        return needToWakeUp;
    }


}
