import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Board board= new Board();
        Deck deck = new Deck();

        Player player = new Player();
        Player dealer = new Player();


        deck.shuffle();
        deck.cut();




        deck.deal(player, dealer);

        for (int i = 0; i < 4; i++) {
            board.cards[i] = deck.allCards[deck.topDeckIndex];
            deck.topDeckIndex--;
            board.topBoardIndex++ ;
        }


        while(deck.topDeckIndex>= -1){
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
            System.out.println();

            System.out.println("-------------BOARD--------------");
            System.out.println();
            for (int i = board.topBoardIndex ; i >=0 ; i--) {

                System.out.print(board.cards[i].getSuit() +  board.cards[i].getNumber()+ " ");
                if(i==board.topBoardIndex){
                    System.out.println();
                }
            }
            System.out.println();
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            dealer.play(board);
            if( dealer.cardNum==0 && deck.topDeckIndex!= -1){
                deck.deal(player, dealer);
            }
        }


        player.calculatePoints();
        dealer.calculatePoints();
        if((player.gatheredCardsLength + 2*player.pistiCounter ) > (dealer.gatheredCardsLength + 2*dealer.pistiCounter)){
            player.points+=3;
        }else if((player.gatheredCardsLength + 2*player.pistiCounter ) < (dealer.gatheredCardsLength + 2*dealer.pistiCounter)){
            dealer.points+=3;
        }






    }
}