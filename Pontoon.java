package Pontoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Dylan Clarke
 */
public class Pontoon {

    static Player dealer = new Player();
    static ArrayList<Player> players = new ArrayList<>();
    static ArrayList<Card> deck = new ArrayList<>();

    /**
     * @param Player - The player to whom the card is to be dealt
     */
    static void dealCard(Player player) {
        player.hand.add(deck.get(0));
        deck.remove(0);
    }

    /**
     * @param Player - The player to whom the cards are to be dealt
     */
    static void dealCards(Player player, int numCards) {
        for (int i = 0; i < numCards; i++) {
            player.hand.add(deck.get(0));
            deck.remove(0);
        }
    }

    /**
     * @param args the command line arguments. Not expecting any, thus any cmd
     * input is not handled arguments
     */
    public static void main(String[] args) {

        // Initialise 52 Card Deck by placing 4 cards of each face value into deck to represent the 4 suits
        for (int i = 1; i <= 13; i++) {
            deck.add(new Card(i));
            deck.add(new Card(i));
            deck.add(new Card(i));
            deck.add(new Card(i));
        }
        // Shuffle cards randomly and deal cards to all players
        Collections.shuffle(deck);

        Scanner input = new Scanner(System.in, "ascii");
        int playerCount = 1;
        while (playerCount < 2 || playerCount > 6) {
            System.out.print("How many players are there? (2 - 6) : ");
            playerCount = input.nextInt();
        }

        dealCards(dealer, 2);

        for (int i = 0; i < playerCount; i++) {
            players.add(new Player());
            dealCards(players.get(i), 2);
        }

        System.out.println(deck.size() + " Cards");
        System.out.println(players.size() + " Players");

        for (int i = 0; i < players.size(); i++) {
            System.out.println("Player " + (i) + "'s hand is worth: " + players.get(i).getScore() + " Chip total: " + players.get(i).getChips());
        }
        System.out.println("Dealer's hand is worth: " + dealer.getScore());
        System.out.println("\n");

        int bet = 0;
        int curchips = 0;
        
        // Gameplay loop
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getScore() <= 21) {
                System.out.println("Player " + (i) + " please make a selction: Twist, Buy or Stick");
                String play = input.next();
                if (null != play) {
                    switch (play) {
                        case "Buy":
                            System.out.println("How much would you like to increase your bet by?");
                            bet = input.nextInt();
                            curchips = players.get(i).getChips();
                            curchips -= bet;
                            players.get(i).chips = curchips;
                            dealCards(players.get(i), 1);
                            System.out.println("Buy, new hand value: " + players.get(i).getScore());
                            break;
                        case "Stick":
                            System.out.println("Stick, new hand value: " + players.get(i).getScore());
                            break;
                        case "Twist":
                            dealCards(players.get(i), 1);
                            System.out.println("Twist, new hand value: " + players.get(i).getScore());
                            break;
                    }
                }
            }
                if (players.get(i).getScore() > 21) {
                    System.out.println("Player " + (i) + " is bust");
                }
                if (dealer.getScore() <= 17) {
                    dealCards(dealer, 1);
                }
                if (dealer.getScore() > 21) {
                    System.out.println("Dealer is bust");
                }
            
            System.out.println("Player " + (i) + "'s hand value is: " + players.get(i).getScore() + " Chip total: " + players.get(i).getChips());
            System.out.println("Dealers " + "hand value is: " + dealer.getScore());
            System.out.println("\n");

            if (players.get(i).getScore() > dealer.getScore() && players.get(i).getScore() <= 21 || players.get(i).getScore() > 0 && dealer.getScore() > 21) {
                curchips += (bet * 2);
                players.get(i).chips = curchips;
                System.out.println("Player " + (i) + " beats the dealer!" + " Player " + (i) + " now has: " + players.get(i).getChips() + " chips");
                System.out.println("\n");
            } else if (players.get(i).getScore() < dealer.getScore() && dealer.getScore() <= 21 || players.get(i).getScore() > 21 && dealer.getScore() <= 21) {
                System.out.println("Dealer wins!" + "Player " + (i) + " now has: " + players.get(i).getChips() + " chips");
                System.out.println("\n");
            }
        }

    }

}
