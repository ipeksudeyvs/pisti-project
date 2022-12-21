public class Player {
    public Card[] hand = new Card[4];
    public Card[] gatheredCards = new Card[52];
    public int points = 0;
    public int pistiCounter = 0;
    public int gatheredCardsLength = 0;
    public int cardNum = 0;

    public void play(Board board) {
        if (board.topBoardIndex == -1) {
            int random = (int) (Math.random() * this.cardNum);
            while (this.hand[random].getNumber().equals("J")) {
                random = (int) (Math.random() * this.cardNum);
            }
            System.out.println("The computer played   " + this.hand[random].getSuit() + this.hand[random].getNumber());
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
            return;
        }
        for (int i = 0; i < this.cardNum; i++) {
            if (this.hand[i].getNumber().equals(board.cards[board.topBoardIndex].getNumber())) {
                System.out.println("The computer played   " + this.hand[i].getSuit() + this.hand[i].getNumber());
                board.lastWinner = 0;
                // play with this card and return
                if (board.topBoardIndex == 0) {
                    pistiCounter++;
                    board.topBoardIndex = -1;
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
                    return;
                }
                for (int j = 0; j <= board.topBoardIndex; j++) {
                    gatheredCards[gatheredCardsLength] = board.cards[j];
                    board.cards[j] = null;
                    gatheredCardsLength++;
                }
                gatheredCards[gatheredCardsLength] = this.hand[i];
                gatheredCardsLength++;
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

                board.topBoardIndex = -1;
                return;

            }
        }
        for (int i = 0; i < this.cardNum; i++) {
            if (this.hand[i].getNumber().equals("J")) {
                System.out.println("The computer played  " + this.hand[i].getSuit() + this.hand[i].getNumber());

                board.lastWinner = 0;
                // play with this card and return
                for (int j = 0; j <= board.topBoardIndex; j++) {
                    gatheredCards[gatheredCardsLength] = board.cards[j];
                    board.cards[j] = null;
                    gatheredCardsLength++;
                }
                gatheredCards[gatheredCardsLength] = this.hand[i];
                gatheredCardsLength++;
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
                board.topBoardIndex = -1;
                return;
            }
        }
        int random = (int) (Math.random() * this.cardNum);
        while (this.hand[random].getNumber().equals("J")) {
            random = (int) (Math.random() * this.cardNum);
        }
        System.out.println("The computer played   " + this.hand[random].getSuit() + this.hand[random].getNumber());
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
        if (board.topBoardIndex == -1) {
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
            return;
        }
        if (this.hand[playedCard].getNumber().equals(board.cards[board.topBoardIndex].getNumber())) {
            // play with this card and return
            board.lastWinner = 1;
            if (board.topBoardIndex == 0) {
                pistiCounter++;
                board.topBoardIndex = -1;
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
                return;
            }
            for (int j = 0; j <= board.topBoardIndex; j++) {
                gatheredCards[gatheredCardsLength] = board.cards[j];
                board.cards[j] = null;
                gatheredCardsLength++;
            }
            gatheredCards[gatheredCardsLength] = this.hand[playedCard];
            gatheredCardsLength++;
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

            board.topBoardIndex = -1;

        } else if (this.hand[playedCard].getNumber().equals("J")) {
            // play with this card and return
            if (board.topBoardIndex != -1) {
                board.lastWinner = 1;
            }

            for (int j = 0; j <= board.topBoardIndex; j++) {
                gatheredCards[gatheredCardsLength] = board.cards[j];
                board.cards[j] = null;
                gatheredCardsLength++;
            }
            gatheredCards[gatheredCardsLength] = this.hand[playedCard];
            gatheredCardsLength++;
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
            board.topBoardIndex = -1;
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

    public void calculatePoints() {
        for (int i = 0; i < gatheredCardsLength; i++) {
            if (gatheredCards[i].getSuit().equals("♦") && gatheredCards[i].getNumber().equals("10")) {
                this.points += 3;
            } else if (gatheredCards[i].getSuit().equals("♣") && gatheredCards[i].getNumber().equals("2")) {
                this.points += 2;
            } else {
                this.points += 1;
            }
        }
        this.points += 10 * this.pistiCounter;
    }

    public void giveAllCardsToPlayer(Board board) {
        for (int j = 0; j <= board.topBoardIndex; j++) {
            gatheredCards[gatheredCardsLength] = board.cards[j];
            board.cards[j] = null;
            gatheredCardsLength++;
        }
    }
}
