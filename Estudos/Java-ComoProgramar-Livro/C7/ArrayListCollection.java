import java.util.ArrayList;

public class ArrayListCollection {

    public static void main(String[] args) {
        
        ArrayList<String> items = new ArrayList<String>();

        items.add("red");
        items.add(0, "yellow");

        System.out.print("\nDisplay list contents with counter-controlled loop:");

        
        for(int i = 0; i < items.size(); i++)
            System.out.print("  " + items.get(i));

        System.out.println();
        display(items, "\nDisplay list content with enhanced for statement:");

        items.add("green");
        items.add("yellow");
        display(items, "\nList with two new elements:");

        items.remove("yellow");
        display(items, "\nRemove first instance of 'yellow':");

        items.remove(1);
        display(items, "\nRemove second list element (green):");

        // verifica se um valor está na List
        System.out.printf("\n\"red\" is %sin the list%n", items.contains("red") ? "" : "not ");

        // exibe o numero de elementos na List
        System.out.printf("\nSize: %s%n", items.size());

    }

    public static void display(ArrayList<String> items, String header){

        System.out.print(header);

        for(String item : items)
            System.out.print("  " + item);

        System.out.println();
    }

}
