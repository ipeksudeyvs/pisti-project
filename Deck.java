import java.util.Scanner;

public class Deck {
    public static Cards[] allCards;
    Scanner input = new Scanner(System.in);

    public Deck() {
        String[] suit = {"♠", "♣", "♥", "♦"};
        String[] number = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        allCards = new Cards[52];

        for (int i = 0; i < 52; i++) {
            allCards[i] = new Cards(suit[i / 13], number[i % 13]);
        }


    }

    public void shuffle() {

        for (int i = allCards.length - 1; i >= 1; i--) {
            int j = (int) (Math.random() * (i + 1));
            Cards temp = allCards[i];
            allCards[i] = allCards[j];
            allCards[j] = temp;
        }

    }

    public void cut() {

        System.out.print("Please enter a number between 1 and 52:");
        int inputNum = input.nextInt();
        Cards tempArr[] = new Cards[allCards.length];

        for (int i = 0; i < allCards.length; i++) {
            tempArr[i] = allCards[i];
        }

        for (int i = 0; i < 52; i++) {
            allCards[i] = tempArr[(inputNum + i) % 52];
        }

    }

    public void deal(int index,Player player, Player dealer ){
       int cardNum = 0;

            for (int i = index; i >= index - 6; i=i-2) { // 40 39 38 37 36 35 34 33
                //player add i
                player.getHand()[cardNum] = allCards[i];
                //dealer add i-1
                dealer.getHand()[cardNum] = allCards[i-1];
                cardNum++;
        }


        //board add 43-42-41-40
    }

}
