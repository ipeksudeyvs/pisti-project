public class Board {
    public Card[] cards = new Card[52]; // cards on the board
    public int topBoardIndex = -1; // shows the index of the card that is on the top of the board
    public int lastWinner = -1; // this is 0 if dealer got the last card gathering, 1 if player did.


}
