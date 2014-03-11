package com.epam.ski_systems;

import com.epam.ski_cards.DaysCard;
import com.epam.ski_cards.LiftsCard;
import com.epam.ski_cards.SeasonCard;
import com.epam.ski_cards.SkiCard;
import java.util.Calendar;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class Turnstile {

    private SkiControlingSystem sks;

    public boolean check(SkiCard sc) {
        switch (sc.CARD_TYPE) {
            case DAY:
                DaysCard dc = (DaysCard) sc;
                return check(dc);
            case LIFT:
                LiftsCard lc = (LiftsCard) sc;
                return check(lc);
            case SEASON:
                SeasonCard sec = (SeasonCard) sc;
                return check(sec);
            default:
                return false;
        }

    }

    private boolean check(DaysCard dc) {
        switch (dc.DC) {
            case FIRST_HALF:
                if(dc.REG_DATE.DAY_OF_WEEK==1);
                
                break;
            case SECOND_HALF:
                break;
            case ONE:
                break;
            case TWO:
                break;
            case FIVE:
                break;
        }
        return false;

    }

    private boolean check(LiftsCard lc) {
        if (lc.lc.getCounts() < lc.getTrips() + 1) {
            System.out.println("You shall not pass.");
            sks.writeData(lc.CARD_TYPE.toString() + " card, id = " + lc.id
                    + ".\nCard has not pass. Reason: over trips.");
            return false;
        } else if (!lc.isWorking()) {
            System.out.println("Your card was blocked.");
            sks.writeData(lc.CARD_TYPE.toString() + " card, id = " + lc.id
                    + ".\nCard has not pass. Reason: blocked.");
            return false;
        }
        return true;

    }

    private boolean check(SeasonCard sc) {
        return false;
    }
}
