package com.epam.ski_cards;

import com.epam.ski_cards.enums.CardType;

/**
 *
 * @author Anatolii_Hlazkov
 */
public abstract class SkiCard {

    public final int id;
    private boolean working = true;
    private CardType ct;

    public SkiCard(int id) {
        this.id = id;
    }

    public boolean isWorking() {
        return working;
    }

    public void set(boolean working) {
        this.working = working;
    }

}
