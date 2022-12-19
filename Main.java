public class Main {
    public static void main(String[] args) {

        Deck deck = new Deck();

        for(int i=0 ; i<52 ; i++){
            System.out.println(Deck.allCards[i].getSuit()+ Deck.allCards[i].getNumber());
        }



    }
}