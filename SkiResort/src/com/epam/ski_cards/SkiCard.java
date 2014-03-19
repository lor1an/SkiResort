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
    public final Boolean WEEKEND;
    public final CardType CARD_TYPE;
    public final Calendar REG_DATE;

    public SkiCard(int id, CardType ct, Calendar regDate, Boolean weekend) {
        this.id = id;
        this.CARD_TYPE = ct;
        REG_DATE = regDate;
        WEEKEND = weekend;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

}
