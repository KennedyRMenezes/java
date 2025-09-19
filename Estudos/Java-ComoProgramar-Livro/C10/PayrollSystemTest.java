public class PayrollSystemTest{


    public static void main(String[] args){


        SalariedEmployee salEmp = new SalariedEmployee(
                                    "John",
                                    "Smith",
                                    "111-11-1111",
                                    800.00);
        HourlyEmployee hourEmp = new HourlyEmployee(
                                    "Karen",
                                    "Price",
                                    "222-22-2222",
                                    16.75,
                                    40);
        CommissionEmployee comEmp = new CommissionEmployee(
                                    "Sue",
                                    "Jones",
                                    "333-33-3333",
                                    10000,
                                    .06);
        BasePlusCommissionEmployee baseEmp = new BasePlusCommissionEmployee(
                                    "Bod",
                                    "Lewis",
                                    "444-44-4444",
                                    5000,
                                    .04,
                                    300);
        
        System.out.println("Employees processed individually:");

        System.out.printf("%n%s%n%s: $%,.2f%n%n",
            salariedEmployee, "earned", salariedEmployee.earnings());
        
        System.out.printf("%s%n%s: $%,.2f%n%n",
            hourlyEmployee, "earned", hourlyEmployee.earnings());
        
        System.out.printf("%s%n%s: $%,.2f%n%n",
            commissionEmployee, "earned", commissionEmployee.earnings());
        
        System.out.printf("%s%n%s: $%,.2f%n%n",
            basePlusCommissionEmployee,
            "earned", basePlusCommissionEmployee.earnings());

        Employee[] employees = new Employee[4];

    }


}