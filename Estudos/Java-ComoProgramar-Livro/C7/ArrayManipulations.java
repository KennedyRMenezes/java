import java.util.Arrays;

public class ArrayManipulations {

    public static void main(String[] args) {
        
        double[] doubleArray = {8.4, 9.3, 0.2, 7.9, 3.4};
        Arrays.sort(doubleArray);
        System.out.print("\ndoubleArray: ");

        for(double value : doubleArray)
            System.out.printf("%.1f ", value);

        // preenche o array de 10 elementos com 7
        int[] filledIntArray = new int[10];
        Arrays.fill(filledIntArray, 7);
        displayArray(filledIntArray, "filledIntArray");

        // copia de array
        int[] intArray = {1,2,3,4,5,6};
        int[] intArrayCopy = new int[intArray.length];
        System.arraycopy(intArray, 0, intArrayCopy, 0, intArray.length);        displayArray(intArray, "intArray");
        displayArray(intArrayCopy, "intArrayCopy");

        // verifica igualdade de arrays
        boolean b = Arrays.equals(intArray, intArrayCopy);
        System.out.printf("%n%nintArray %s intArrayCopy%n", 
                            (b ? "==" : "!="));

        b = Arrays.equals(intArray, filledIntArray);
        System.out.printf("intArray %s filledIntArray%n", 
                            (b ? "==" : "!="));
                
        // pesquisa o valor 5 em intArray
        int location = Arrays.binarySearch(intArray, 5);
        if(location >= 0){
            System.out.println("Found 5 at element " + location + " in intArrayan");
        }else{
            System.out.println("5 not found in intArray");
        }

        // pesquisa o valor 8763 em intArray
        location = Arrays.binarySearch(intArray, 8763);
        if(location >= 0){
            System.out.println("Found 8763 at element " + location + " in intArrayan");
        }else{
            System.out.println("8763 not found in intArray");
        }
    }

    public static void displayArray(int[] array, String description){

        System.out.printf("%n%s: ", description);

        for(int val : array)
            System.out.printf("%d ", val);

    }

}
