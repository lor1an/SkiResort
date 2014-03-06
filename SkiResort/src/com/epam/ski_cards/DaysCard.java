package com.epam.ski_cards;

import com.epam.ski_cards.enums.CardType;
import java.util.Calendar;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class DaysCard extends SkiCard {

    public DaysCard(int id, CardType ct, Calendar regDate) {
        super(id, ct, regDate);
    }

}
