import java.util.Scanner;

public class Deck {
    public static Card[] allCards; // array for storing the deck
    public int topDeckIndex = 51; // shows the index of the top card on deck
    Scanner input = new Scanner(System.in);

    public Deck() {
        String[] suit = {"♠", "♣", "♥", "♦"};
        String[] number = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        allCards = new Card[52];

        for (int i = 0; i < 52; i++) {
            allCards[i] = new Card(suit[i / 13], number[i % 13]);
        }

    }

    public void shuffle() { //method to shuffle the cards

        for (int i = allCards.length - 1; i >= 1; i--) {
            int j = (int) (Math.random() * (i + 1));
            Card temp = allCards[i];
            allCards[i] = allCards[j];
            allCards[j] = temp;
        }

    }

    public void cut() { //method to cut the cards

        System.out.print("Please enter a number between 1 and 52:");
        int inputNum = input.nextInt();
        Card tempArr[] = new Card[allCards.length];

        for (int i = 0; i < allCards.length; i++) {
            tempArr[i] = allCards[i];
        }

        for (int i = 0; i < 52; i++) {
            allCards[i] = tempArr[(inputNum + i) % 52];
        }

    }

    public void deal(Player player, Player dealer) { //method to deal the cards to player
        int cardNum = 0;

        for (int i = this.topDeckIndex; i >= this.topDeckIndex - 6; i = i - 2) {
            //player add i
            player.hand[cardNum] = allCards[i];
            //dealer add i-1
            dealer.hand[cardNum] = allCards[i - 1];
            cardNum++;
        }
        player.cardNum = 4;
        dealer.cardNum = 4;
        this.topDeckIndex -= 8;

    }

}
