public class Main {
    public static void main(String[] args) {

        Board board= new Board();
        Deck deck = new Deck();

        deck.shuffle();
        deck.cut();

        /*for(int i=0 ; i<52 ; i++){
            System.out.println(Deck.allCards[i].getSuit()+ Deck.allCards[i].getNumber());
        }*/

        Player player = new Player();
        Player dealer = new Player();

        /* for (int i = 0; i < player.getHand().length; i++) {
            System.out.print(player.getHand()[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < dealer.getHand().length; i++) {
            System.out.print(dealer.getHand()[i] + " ");
        }*/

        int index= 51;
        deck.deal(index, player, dealer);

        for (int i = 0; i < player.getHand().length; i++) {
            System.out.print(player.getHand()[i].getSuit() +  player.getHand()[i].getNumber()+ " ");
        }
        System.out.println();
        for (int i = 0; i < dealer.getHand().length; i++) {
            System.out.print(dealer.getHand()[i].getSuit() +  dealer.getHand()[i].getNumber()+ " ");
        }








    }
}