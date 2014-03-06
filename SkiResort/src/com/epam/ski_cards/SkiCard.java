package com.epam.ski_cards;

import com.epam.ski_cards.enums.CardType;
import java.util.Calendar;

/**
 *
 * @author Anatolii_Hlazkov
 */
public abstract class SkiCard {

    public final int id;
    private boolean working = true;
    public final CardType ct;
    public final Calendar REG_DATE;

    public SkiCard(int id, CardType ct, Calendar regDate) {
        this.id = id;
        this.ct = ct;
        REG_DATE = regDate;
    }

    public boolean isWorking() {
        return working;
    }

    public void set(boolean working) {
        this.working = working;
    }

}
