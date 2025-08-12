public class Account {

    private String name;
    private double balance;

    public Account(String name, Double balance){
        this.name = name;
        if (balance > 0.0){
            this.balance = balance;
        }
    }

    public void deposit(Double depositAmount){
        if( depositAmount > 0.0){
            this.balance = balance + depositAmount;
        }
    }

    public double getBalance(){
        return this.balance;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


}
