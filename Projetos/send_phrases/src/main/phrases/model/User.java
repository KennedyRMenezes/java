package phrases.model;

public class User {

    private String name;
    private String email;

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getUserName(){
        return this.name;
    }

    public String getUserEmail(){
        return this.email;
    }


    @Override
    public String toString() {
        return "\n---------------------------------\n" + 
               this.name + ", Email: " + this.email +
               "\n---------------------------------\n";

    }

}
