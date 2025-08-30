public class CloneArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        int[] newArr = modifyArray(arr);

        System.out.println("\nOriginal Array");
        for(int pos = 0; pos < arr.length; pos++){
            System.out.print("   " + arr[pos]);
        }


        System.out.println("\n\nModified Array");
        for(int pos = 0; pos < newArr.length; pos++){
            System.out.print("   " + newArr[pos]);
        }

        System.out.println("\n");
    }


    public static int[] modifyArray(int[] array){

        int[] copy = array.clone();

        for(int index = 0; index < copy.length; index++){

            copy[index] = copy[index] * 2;

        }

        return copy;

    }
}


