public class CommissionEmployeeTest {

    public static void main(String[] args) {
        
        CommissionEmployee emp = new CommissionEmployee("Sue", 
                                                        "Jones", 
                                                        "222-22-2222", 
                                                        10000, 
                                                        0.06);
        
        System.out.println("Employee information obtained by get methods:");
        System.out.printf("%n%s %s%n", "First name is", 
                            emp.getFirstName());
        System.out.printf("%n%s %s%n", "Last name is", 
                            emp.getLastName());
        System.out.printf("%n%s %s%n", "Social security number is", 
                            emp.getSocialSecurityNumber());                           
        System.out.printf("%n%s %.2f%n", "Gross sales is", 
                            emp.getGrossSales());
        System.out.printf("%n%s %.2f%n", "Commission rate is", 
                            emp.getCommissionRate());
        emp.setGrossSales(5000)                                 ;
        emp.setCommissionRate(.1);

        System.out.printf("%n%s:%n%n%s%n",
            "Updated employee information obtained by toString", emp);
    }

}
