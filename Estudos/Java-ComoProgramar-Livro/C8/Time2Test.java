public class Time2Test {

    public static void main(String[] args) {
        
        Time2 t1 = new Time2(); // 00:00:00
        Time2 t2 = new Time2(2); // 02:00:00
        Time2 t3 = new Time2(21, 34); // 21:34:00
        Time2 t4 = new Time2(12, 25, 42); // 12:25:42
        Time2 t5 = new Time2(t4); // 12:25:42

        System.out.println("Constructed with:");
        displayTime("t1: all default args.", t1);
        displayTime("t2: only hour specidied", t2);
        displayTime("t3: hour and minute specified", t3);
        displayTime("t4: all specified", t4);
        displayTime("t5: Tim2 object t4 specified", t5);

        try{
            Time2 t6 = new Time2(27, 74, 99);
        }catch(IllegalArgumentException e){
            System.out.println("\nException while initializing t6: " + 
                                e.getMessage());
        }

    }

    private static void displayTime(String header, Time2 t){

        System.out.printf("%s%n  %s%n  %s%n",
                            header, t.toUniversalString(), t.toString());

    }

}
