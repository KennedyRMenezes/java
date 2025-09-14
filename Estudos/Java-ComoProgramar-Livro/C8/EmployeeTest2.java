public class EmployeeTest2 {

    public static void main(String[] args) {
        
        System.out.println("Employees before instantiation: " + Employee.getCount() + "\n");

        Employee e1 = new Employee("Susan", "Baker");
        Employee e2 = new Employee("Bob", "Blue");

        System.out.println("\nEmployees after instantiation:\n");
        System.out.println("via e1.getCount(): " + e1.getCount());
        System.out.println("via e2.getCount(): " + e2.getCount());
        System.out.println("via Employee.getCount(): " + Employee.getCount() + "\n  ");

    }

}
