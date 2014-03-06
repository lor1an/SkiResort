package com.epam.ski_cards;

import com.epam.ski_cards.enums.LiftCounts;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class LiftsCard extends SkiCard {

    int trips;
    LiftCounts lc;

    public LiftsCard(int id, int trips, LiftCounts lc) {
        super(id);
        this.lc = lc;
    }
    

}
