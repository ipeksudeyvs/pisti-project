import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

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
            board.topBoardIndex=i ;
        }
        System.out.println("-------------BOARD--------------");
        System.out.println();
        for (int i = board.topBoardIndex ; i >=0 ; i--) {

            System.out.print(board.cards[i].getSuit() +  board.cards[i].getNumber()+ " ");
            if(i==board.topBoardIndex){
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("----------YOUR HAND------------");
        System.out.println();
        for (int i = 0; i < player.cardNum; i++) {

            System.out.print(player.hand[i].getSuit() +  player.hand[i].getNumber()+ " ");
        }
        System.out.println();
        for (int i = 0; i < player.cardNum; i++) {
            System.out.print(" " + (i+1) + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Please choose the card you want to play. ");
        int selectedCard = input.nextInt();
        player.playwithInput(selectedCard-1, board);

        System.out.println("-------------BOARD--------------");
        System.out.println();
        for (int i = board.topBoardIndex ; i >=0 ; i--) {

            System.out.print(board.cards[i].getSuit() +  board.cards[i].getNumber()+ " ");
            if(i==board.topBoardIndex){
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("----------YOUR HAND------------");
        System.out.println();
        for (int i = 0; i < player.cardNum; i++) {

            System.out.print(player.hand[i].getSuit() +  player.hand[i].getNumber()+ " ");
        }











    }
}