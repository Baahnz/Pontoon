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
     *             input is not handled arguments
     */
    public static void main(String[] args) {

        // Initialise 52 Card Deck by placing 4 cards of each face value into deck to represent the 4 suits
        for (int i = 1; i <= 13; i++) {
            deck.add(new Card(i));
            deck.add(new Card(i));
            deck.add(new Card(i));
            deck.add(new Card(i));
        }
        // Shuffle cards randomly
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
    }

}
