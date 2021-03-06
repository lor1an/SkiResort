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
    public final LiftCounts LIFT_COUNTS;

    public LiftsCard(int id, CardType ct, Calendar regDate, Boolean weekend, LiftCounts lc) {
        super(id, ct, regDate, weekend);
        this.LIFT_COUNTS = lc;
    }

    public int getTrips() {
        return trips;
    }

    public LiftCounts getLc() {
        return LIFT_COUNTS;
    }

    public void setTrips(int trips) {
        this.trips = trips;
    }

}
