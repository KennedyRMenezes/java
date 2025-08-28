public class AutoPolicy {

    private int accountNumber;
    private String makeAndModel;
    private String state;

    public AutoPolicy(int acc, String model, String state){
        this.accountNumber = acc;
        this.makeAndModel = model;
        this.state = state;
    }

    public void setAccountNumber(int num){
        this.accountNumber = num;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public void setMakeAndModel(String model){
        this.makeAndModel = model;
    }

    public String getMakeAndModel(){
        return makeAndModel;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public boolean isNoFaultState(){

        boolean noFaultState;

        switch(getState()){
            case "MA": case "NJ": case "NY": case "PA":
                noFaultState = true;
                break;
            default:
                noFaultState = false;
                break;
        }

        return noFaultState;

    }

}
