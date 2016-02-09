package Pontoon;

import java.util.ArrayList;

/**
 *
 * @author dylcl_000
 */
public class Player {

    /**
     * Stores the cards that are dealt to players
     */
    int getScore() {
        int score = 0;
        int aces = 0;
        for (Card i : hand) {
            if (i.getValue() == 1) {
                aces++;
            } else {
                score += i.getValue();
            }
        }
        if (score <= 10 && aces == 1) {
            aces--;
            score += 11;
        } else {
            for (int i = 0; i < aces; i++) {
                score++;
            }
        }
        return score;
    }

    public ArrayList<Card> hand = new ArrayList<>();
}
