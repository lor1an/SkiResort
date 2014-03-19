package com.epam.ski_cards;

import com.epam.ski_cards.enums.CardType;
import com.epam.ski_cards.enums.DayCounts;
import java.util.Calendar;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class DaysCard extends SkiCard {

    public final DayCounts DAY_COUNTS;

    public DaysCard(int id, CardType ct, Calendar regDate, Boolean weekend, DayCounts dc) {
        super(id, ct, regDate, weekend);
        DAY_COUNTS = dc;
    }

}
