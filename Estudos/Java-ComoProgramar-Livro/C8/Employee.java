import java.util.Date;

public class Employee {

    private static int count = 0;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Date hiredDate;

    public Employee(String firstName, String lastName, 
                    Date birthDate, Date hiredDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.hiredDate = hiredDate;

        ++count;
        System.out.println("Employee constructor: " + firstName + lastName + 
                                    "; count = " + count + "\n");
    }

    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        ++count;
        System.out.println("Employee constructor: " + firstName + " " + lastName + 
                                    "; count = " + count + "\n");
    }

    
    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public static int getCount() {
        return count;
    }

    public String toString(){
        return String.format("%s,  %s  Hired: %s Birthday: %s",
                            lastName, firstName, hiredDate, birthDate);
    }
}
