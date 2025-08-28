public class PassArray {

    public static void main(String[] args) {
        
        int[] array = {1, 2, 3, 4, 5};

        System.out.println("Effects of passing reference to entire array\n"+
                            "The values of the original array are:");
        
        for(int value : array){
            System.out.print("   " + value);
        }

        modifyArray(array);
        System.out.println("\n\nThe values of the modified array are:");

        for(int value : array){
            System.out.print("   " + value);
        }

        System.out.println("\n\nEffects of passing array element value:\n"+
                        "array[3] before modifyElement: " + array[3]) ;
        
        modifyElement(array[3]);
        System.out.println("array[3] afeter modifyElement: " + array[3]) ;
    }

     public static void modifyArray(int[] array2){
            
        for(int counter = 0; counter < array2.length; counter++){
            array2[counter] *= 2;
        }
    }

    public static void modifyElement(int element){

        element *= 2;
        System.out.println("Value of elemento in modifyElement: " + element);;
    }

}
