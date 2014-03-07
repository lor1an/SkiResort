package com.epam.ski_systems;

import com.epam.ski_cards.DaysCard;
import com.epam.ski_cards.LiftsCard;
import com.epam.ski_cards.SeasonCard;
import com.epam.ski_cards.SkiCard;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class Turnstile {

    private SkiControlingSystem sks;

    public void check(SkiCard sc) {
        switch (sc.CARD_TYPE) {
            case DAYS:
                DaysCard dc = (DaysCard) sc;
                check(dc);
                break;
            case LIFTS:
                LiftsCard lc = (LiftsCard) sc;
                check(lc);
                break;
            case SEASON:
                SeasonCard sec = (SeasonCard) sc;
                check(sec);
                break;
        }

    }

    private void check(DaysCard dc) {
        switch (dc.DC) {
            case FIRST_HALF:
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

    }

    private void check(LiftsCard lc) {
        if (lc.lc.getCounts() < lc.getTrips() + 1) {
            System.out.println("------------You shall not pass------------");
            sks.writeData("Lifts card has not pass. Reason: over trips");
        } else if (!lc.isWorking()) {
            System.out.println("-------------Your card was blocked--------");
            sks.writeData("Lifts card has not pass. Reason: blocked");
        }

    }

    private void check(SeasonCard sc) {

    }
}
