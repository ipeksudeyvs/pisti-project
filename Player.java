public class Player {
    public Card[] hand = new Card[4];
    public Card[] gatheredCards = new Card[52];
    public int points = 0;
    public int pistiCounter = 0;
    public int gatheredCardsIndex = 0;
    public int cardNum = 0;

    public void play(Board board) {
        if (board.topBoardIndex == -1) {
            int random = (int) (Math.random() * this.cardNum);
            while (this.hand[random].getNumber().equals("J")) {
                random = (int) (Math.random() * this.cardNum);
            }
            //play random card and return
            if (random == cardNum - 1) {
                board.cards[board.topBoardIndex + 1] = this.hand[random];
                this.hand[random] = null;
                board.topBoardIndex++;
                cardNum--;
            } else {
                Card temp = this.hand[cardNum - 1];
                this.hand[cardNum - 1] = this.hand[random];
                this.hand[random] = temp;
                board.cards[board.topBoardIndex + 1] = this.hand[cardNum - 1];
                this.hand[cardNum - 1] = null;
                board.topBoardIndex++;
                this.cardNum--;
            }
        }
        for (int i = 0; i < this.cardNum; i++) {
            if (this.hand[i].getNumber().equals(board.cards[board.topBoardIndex].getNumber())) {
                // play with this card and return
                if (board.topBoardIndex == 0) {
                    pistiCounter++;
                    board.topBoardIndex = -1;
                }
                for (int j = 0; j < board.topBoardIndex; j++) {
                    gatheredCards[gatheredCardsIndex] = board.cards[j];
                    board.cards[j] = null;
                    gatheredCardsIndex++;
                }
                gatheredCards[gatheredCardsIndex] = this.hand[i];
                gatheredCardsIndex++;
                if (i == cardNum - 1) {
                    this.hand[i] = null;
                    cardNum--;
                } else {
                    Card temp = this.hand[cardNum - 1];
                    this.hand[cardNum - 1] = this.hand[i];
                    this.hand[i] = temp;
                    this.hand[cardNum - 1] = null;
                    this.cardNum--;
                }

                board.topBoardIndex = 0;
                return;

            }
        }
        for (int i = 0; i < this.cardNum; i++) {
            if (this.hand[i].getNumber().equals("J")) {
                // play with this card and return
                for (int j = 0; j < board.topBoardIndex; j++) {
                    gatheredCards[gatheredCardsIndex] = board.cards[j];
                    board.cards[j] = null;
                    gatheredCardsIndex++;
                }
                gatheredCards[gatheredCardsIndex] = this.hand[i];
                gatheredCardsIndex++;
                if (i == cardNum - 1) {
                    this.hand[i] = null;
                    cardNum--;
                } else {
                    Card temp = this.hand[cardNum - 1];
                    this.hand[cardNum - 1] = this.hand[i];
                    this.hand[i] = temp;
                    this.hand[cardNum - 1] = null;
                    this.cardNum--;
                }
                board.topBoardIndex = 0;
                return;
            }
        }
        int random = (int) (Math.random() * this.cardNum);
        //play random card and return
        if (random == cardNum - 1) {
            board.cards[board.topBoardIndex + 1] = this.hand[random];
            this.hand[random] = null;
            board.topBoardIndex++;
            cardNum--;
        } else {
            Card temp = this.hand[cardNum - 1];
            this.hand[cardNum - 1] = this.hand[random];
            this.hand[random] = temp;
            board.cards[board.topBoardIndex + 1] = this.hand[cardNum - 1];
            this.hand[cardNum - 1] = null;
            board.topBoardIndex++;
            this.cardNum--;
        }
    }

    public void playwithInput(int playedCard, Board board) {
        if (this.hand[playedCard].getNumber().equals(board.cards[board.topBoardIndex].getNumber())) {
            // play with this card and return
            for (int j = 0; j < board.topBoardIndex; j++) {
                gatheredCards[gatheredCardsIndex] = board.cards[j];
                board.cards[j] = null;
                gatheredCardsIndex++;
            }
            gatheredCards[gatheredCardsIndex] = this.hand[playedCard];
            gatheredCardsIndex++;
            if (playedCard == cardNum - 1) {
                this.hand[playedCard] = null;
                cardNum--;
            } else {
                Card temp = this.hand[cardNum - 1];
                this.hand[cardNum - 1] = this.hand[playedCard];
                this.hand[playedCard] = temp;
                this.hand[cardNum - 1] = null;
                this.cardNum--;
            }

            board.topBoardIndex = 0;

        } else if (this.hand[playedCard].getNumber().equals("J")) {
            // play with this card and return
            for (int j = 0; j < board.topBoardIndex; j++) {
                gatheredCards[gatheredCardsIndex] = board.cards[j];
                board.cards[j] = null;
                gatheredCardsIndex++;
            }
            gatheredCards[gatheredCardsIndex] = this.hand[playedCard];
            gatheredCardsIndex++;
            if (playedCard == cardNum - 1) {
                this.hand[playedCard] = null;
                cardNum--;
            } else {
                Card temp = this.hand[cardNum - 1];
                this.hand[cardNum - 1] = this.hand[playedCard];
                this.hand[playedCard] = temp;
                this.hand[cardNum - 1] = null;
                this.cardNum--;
            }
            board.topBoardIndex = 0;
        } else {
            if (playedCard == cardNum - 1) {
                board.cards[board.topBoardIndex + 1] = this.hand[playedCard];
                this.hand[playedCard] = null;
                board.topBoardIndex++;
                cardNum--;
            } else {
                Card temp = this.hand[cardNum - 1];
                this.hand[cardNum - 1] = this.hand[playedCard];
                this.hand[playedCard] = temp;
                board.cards[board.topBoardIndex + 1] = this.hand[cardNum - 1];
                this.hand[cardNum - 1] = null;
                board.topBoardIndex++;
                this.cardNum--;
            }
        }
    }
}
