package com.epam.ski_cards;

import com.epam.ski_cards.enums.CardType;
import com.epam.ski_cards.enums.LiftCounts;
import java.util.Calendar;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class LiftsCard extends SkiCard {

    private int trips;
    public final LiftCounts lc;

    public LiftsCard(int id, CardType ct, Calendar regDate, Boolean weekend, LiftCounts lc) {
        super(id, ct, regDate, weekend);
        this.lc = lc;
    }

    public int getTrips() {
        return trips;
    }

    public LiftCounts getLc() {
        return lc;
    }

    public void setTrips(int trips) {
        this.trips = trips;
    }

}
