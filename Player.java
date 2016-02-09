package Pontoon;

import java.util.ArrayList;

/**
 *
 * @author dylcl_000
 */
public class Player {
    int chips = 20;
    
    int getChips() {       
        return chips;
    }
    

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

//    int chips() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
