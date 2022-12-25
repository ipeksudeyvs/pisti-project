import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        // main scanner for getting inputs from the human player
        Scanner input = new Scanner(System.in);

        //initialization of board, deck and player objects
        Board board = new Board();
        Deck deck = new Deck();

        Player player = new Player();
        Player dealer = new Player();

        deck.shuffle();
        deck.cut();

        deck.deal(player, dealer);

        // a for loop to deal 4 cards on the board
        for (int i = 0; i < 4; i++) {
            board.cards[i] = deck.allCards[deck.topDeckIndex];
            deck.topDeckIndex--;
            board.topBoardIndex++;
        }

        while (deck.topDeckIndex >= -1) {  //main loop
            System.out.println("<-<-<-<-<-<->BOARD<->->->->->->");
            System.out.println();
            for (int i = board.topBoardIndex; i >= 0; i--) {

                System.out.print(board.cards[i].getSuit() + board.cards[i].getNumber() + " ");
                if (i == board.topBoardIndex) {
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println();

            System.out.println("*-*-*-*----YOUR HAND----*-*-*-*");
            System.out.println();

            for (int i = 0; i < player.cardNum; i++) {
                System.out.print(player.hand[i].getSuit() + player.hand[i].getNumber() + " ");
            }

            System.out.println();

            for (int i = 0; i < player.cardNum; i++) {
                System.out.print(" " + (i + 1) + " ");
            }

            System.out.println();
            System.out.println();

            System.out.println("Please choose the card you want to play.<3 ");
            int selectedCard = input.nextInt();

            player.playWithInput(selectedCard - 1, board);
            System.out.println();

            System.out.println("<-<-<-<-<-<->BOARD<->->->->->->");
            System.out.println();

            for (int i = board.topBoardIndex; i >= 0; i--) {

                System.out.print(board.cards[i].getSuit() + board.cards[i].getNumber() + " ");
                if (i == board.topBoardIndex) {
                    System.out.println();
                }
            }
            System.out.println();

            /*try {  // i learnt this from internet it feels like computer thinks
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/

            dealer.play(board); // calling the method and making computer play
            
            if (dealer.cardNum == 0) {  // if no cards then deal
                if (deck.topDeckIndex != -1) {
                    deck.deal(player, dealer);
                } else {
                    System.out.println("Game is over!");
                    System.out.println(" <3 Thank you for playing :* ");
                    System.out.println();
                    if (board.lastWinner == 0) {
                        dealer.giveAllCardsToPlayer(board);
                    } else {
                        player.giveAllCardsToPlayer(board);
                    }
                    break;
                }
            }
        }


        player.calculatePoints();
        dealer.calculatePoints();
        // after calculating points, check who has the most cards
        if ((player.gatheredCardsLength + 2 * player.pistiCounter) > (dealer.gatheredCardsLength + 2 * dealer.pistiCounter)) {
            player.points += 3;
        } else if ((player.gatheredCardsLength + 2 * player.pistiCounter) < (dealer.gatheredCardsLength + 2 * dealer.pistiCounter)) {
            dealer.points += 3;
        }


        Scanner highScoreFile = null;
        String[] fileContent = new String[10];
        try {
            highScoreFile = new Scanner(Paths.get("high-scores.txt"));
        } catch (IOException e) {
            System.out.println("file error");
        }

        // reading the high score file and storing it into a string array
        int fileLineIndex = -1;
        for (int i = 0; highScoreFile.hasNextLine(); i++) {
            fileContent[i] = highScoreFile.nextLine();
            fileLineIndex = i;
        }
        highScoreFile.close();

        // for loop comparing the high scores with the players score
        for (int i = 0; i <= fileLineIndex; i++) {
            String[] tokens = fileContent[i].split(",");
            int points = Integer.parseInt(tokens[2]);

            if (points < player.points) {
                // for loop shifting all the other lesser ordered high scores
                for (int j = fileLineIndex; j >= i; j--) {
                    if (j + 1 != 10) {
                        int x = Integer.parseInt(fileContent[j].split(",")[0]) + 1;
                        String temp = x + "," + fileContent[j].split(",")[1] + "," + fileContent[j].split(",")[2] + "\n";
                        fileContent[j + 1] = temp;
                    }
                }
                System.out.println("HIGH SCORE!!! Please enter your username:");
                String userName = input.nextLine();
                userName = input.nextLine();
                //insert new high score
                fileContent[i] = (i + 1) + "," + userName + "," + player.points + "\n";
                if (fileLineIndex != 9) {
                    fileLineIndex++;
                }
                break;
            }
        }

        FileWriter fw = null;
        try {
            fw = new FileWriter("high-scores.txt");
            if (fileLineIndex == -1) { //if the file is empty
                System.out.println("HIGH SCORE!!! Please enter your username:");
                String userName = input.nextLine();
                userName = input.nextLine();
                fw.write("1," + userName + "," + player.points + "\n");
                fw.close();
            } else {
                // a for loop writing the updated contents to the file
                for (int i = 0; i <= fileLineIndex; i++) {
                    fw.write(fileContent[i]);
                }
                fw.close();
            }
        } catch (IOException e) {
            System.out.println("write error");
        }


    }
}