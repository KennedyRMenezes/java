package Course;

public class MegaBytesConverter {

    public static void main(String[] args) {
        int[] nums = {2500, -1024, 5000};
        for(int num: nums){
            printMegaBytesAndKiloBytes(num);
        }
    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes){
        if(kiloBytes < 0){
            System.out.println("Invalid Value");
        }else {
            System.out.println(kiloBytes + " KB = " + kiloBytes / 1024 + " MB and " + kiloBytes % 1024 + " KB");
        }
    }
}
