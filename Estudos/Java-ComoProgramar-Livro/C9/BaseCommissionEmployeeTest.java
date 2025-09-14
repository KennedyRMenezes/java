public class BaseCommissionEmployeeTest {

    public static void main(String[] args) {
        
        BasePlusCommissionEmployee baseemp = new BasePlusCommissionEmployee(
                                                    "Bob",
                                                    "Lewis",
                                                    "333-33-3333",
                                                    5000,
                                                    .04,
                                                    300);

        System.out.println("Employee information obtained by get methods:");
        System.out.printf("%n%s %s%n", "First name is", 
                            baseemp.getFirstName());
        System.out.printf("%n%s %s%n", "Last name is", 
                            baseemp.getLastName());
        System.out.printf("%n%s %s%n", "Social security number is", 
                            baseemp.getSocialSecurityNumber());                           
        System.out.printf("%n%s %.2f%n", "Gross sales is", 
                            baseemp.getGrossSales());
        System.out.printf("%n%s %.2f%n", "Commission rate is", 
                            baseemp.getCommissionRate());
        System.out.printf("%n%s %.2f%n", "Base salary is", 
                            baseemp.getbaseSalary());

        baseemp.setBaseSalary(1000);                                 ;

        System.out.printf("%n%s:%n%n%s%n",
            "Updated employee information obtained by toString", baseemp.toString());                                            

    }

}
