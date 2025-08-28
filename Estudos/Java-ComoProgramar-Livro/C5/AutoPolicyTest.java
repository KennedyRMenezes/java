public class AutoPolicyTest {

    public static void main(String[] args) {

        AutoPolicy p1 = new AutoPolicy(11, "Toyota", "NJ");
        AutoPolicy p2 = new AutoPolicy(22, "Ford", "ME");

        policyIsNoFaultState(p1);
        policyIsNoFaultState(p2);
    }

    public static void policyIsNoFaultState(AutoPolicy policy){
        System.out.println("The auto policy:");;
        System.out.printf("Account #: %d; Car: %s; State %s %s a no-fault state%n%n",
                            policy.getAccountNumber(), policy.getMakeAndModel(), policy.getState(),
                            (policy.isNoFaultState() ? "is" : "is not"));
    }

}
