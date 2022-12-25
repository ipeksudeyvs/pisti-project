public class Board {
    public Card[] cards = new Card[52]; // array for seeing the cards on the board=game area
    public int topBoardIndex = -1; // shows the index of the card that is on the top of the game area, -1 means no card
    public int lastWinner = -1; // this is 0 if dealer got the last card gathering, 1 if player did.


}
