package Course;

public class Class51 {

    public static void main(String[] args) {


        displayHighScorePosition("Lygia", calculateHigScorePosition(1500));
        displayHighScorePosition("Fyodor", calculateHigScorePosition(1000));
        displayHighScorePosition("Austen", calculateHigScorePosition(500));
        displayHighScorePosition("Victor", calculateHigScorePosition(100));
        displayHighScorePosition("Oscar", calculateHigScorePosition(25));


    }

    public static void displayHighScorePosition(String playerName, int position){
        System.out.println(playerName + " managed to get into position " + position + " on the high score list");
    }

    public static int calculateHigScorePosition(int playerScore){
        if(playerScore >= 1000){
            return 1;
        }else if( (playerScore >= 500) && (playerScore < 1000) ){
            return 2;
        }else if( (playerScore >= 100) && (playerScore < 500) ){
            return 3;
        }else{
            return 4;
        }
    }

    public static int betterCalculateHigScorePosition(int playerScore){

        if(playerScore >= 1000){
            return 1;
        }else if(playerScore >= 500){
            return 2;
        }else if(playerScore >= 100){
            return 3;
        }

        return 4;
    }

    public static int evenBetterCalculateHigScorePosition(int playerScore){

        int position = 4;
        if(playerScore >= 1000){
            position = 1;
        }else if(playerScore >= 500){
            position = 2;
        }else if(playerScore >= 100){
            position = 3;
        }

        return position;
    }

}
