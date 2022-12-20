public class Main {
    public static void main(String[] args) {

        Board board= new Board();
        Deck deck = new Deck();

        Player player = new Player();
        Player dealer = new Player();


        deck.shuffle();
        deck.cut();





        int index= 51;
        deck.deal(index, player, dealer);

        index= index-8 ;
        for (int i = 0; i < 4; i++) {
            board.cards[i] = deck.allCards[index];
            index--;
        }

        for (int i = 0; i < 4; i++) {
            System.out.print(board.cards[i].getSuit() +  board.cards[i].getNumber()+ " ");
        }
        System.out.println();

        for (int i = 0; i < player.getHand().length; i++) {
            System.out.print(player.getHand()[i].getSuit() +  player.getHand()[i].getNumber()+ " ");
        }
        System.out.println();
        for (int i = 0; i < dealer.getHand().length; i++) {
            System.out.print(dealer.getHand()[i].getSuit() +  dealer.getHand()[i].getNumber()+ " ");
        }









    }
}