/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pontoon;

/**
 *
 * @author dylcl_000
 */
public class Card {

    Card(int i) {
        value = i;
    }

    int value = 0;

    /**
     *
     * @return
     */
    public int getValue() {
        if (value > 10)
            return 10;
        else return value;
    }

    /**
     *
     * @return
     */
    public String getString() {
        switch (value) {
            case 1:
                return "Ace";

            case 11:
                return "Jack";

            case 12:
                return "Queen";

            case 13:
                return "King";

            default:
                return Integer.toString(value);

        }
    }
}
