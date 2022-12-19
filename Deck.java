public class Deck {
    public static Cards[] allCards;
    public Deck () {
        String[] suit = { "♠", "♣", "♥", "♦" };
        String[] number = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        allCards = new Cards[52];

        for( int i=0; i<52 ; i++){
            allCards[i] = new Cards( suit[i/13], number[i%13] );
        }

    }
}
