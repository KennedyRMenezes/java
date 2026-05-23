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
            salEmp, "earned", salEmp.earnings());
        
        System.out.printf("%s%n%s: $%,.2f%n%n",
            hourEmp, "earned", hourEmp.earnings());
        
        System.out.printf("%s%n%s: $%,.2f%n%n",
            comEmp, "earned", comEmp.earnings());
        
        System.out.printf("%s%n%s: $%,.2f%n%n",
            baseEmp,
            "earned", baseEmp.earnings());

        Employee[] employees = new Employee[4];

        employees[0] = salEmp;
        employees[1] = hourEmp;
        employees[2] = comEmp;
        employees[3] = baseEmp;

        System.out.printf("Employees processed polymorphically:%n%n");

        for (Employee currentEmployee : employees){

            System.out.println(currentEmployee);

            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                
                // downcast da referência de Employee para
                // referência a BasePlusCommissionEmployee
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;

                employee.setBaseSalary(1.10 * employee.getBaseSalary());

                System.out.printf(
                            "new base salary with 10%% increase is: $%,.2f%n",
                            employee.getBaseSalary());
            }

            System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings());
            
        }

        for (int j = 0; j < employees.length; j++){
            System.out.printf("Employee %d is a %s%n", j, employees[j].getClass().getName());
        }
    }
}