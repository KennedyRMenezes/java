public class Card {

    private final String face; // face da carta ("Ace", "Deuce", ...)
    private final String suit; // naipe da carta ("Hearts", "Diamonds", ...)

    // construtor de dois argumento inicializa face e naipe da carta
    public Card(String cardFace, String cardSuit){
        this.face = cardFace;
        this.suit = cardSuit;
    }

    // retorna representação String de Card
    public String toString(){
        return face + " of " + suit;
    }
}
