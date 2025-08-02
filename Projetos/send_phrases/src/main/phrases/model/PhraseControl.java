package phrases.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class PhraseControl {

    private String phrase;
    private String user_email;
    private String nextShipment;

    public PhraseControl(User u, Phrase p){

        this.phrase = p.getPhrase();
        this.user_email = u.getUserEmail();
        this.nextShipment = defineNextShipmentDefault();

    }

    public String getNextShipment() {
        return nextShipment;
    }

    // private String getBDPhrase() {
    //     return phrase;
    // }

    public String getUser_email() {
        return user_email;
    }

    public String defineNextShipmentDefault(){
        
        int randomNum = ThreadLocalRandom.current().nextInt(1,7+1);
        LocalDateTime d = LocalDateTime.now().plusDays(randomNum);
        DateTimeFormatter formatting = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return d.format(formatting);

    }

}
