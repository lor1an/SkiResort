package com.epam.ski_cards;

import com.epam.ski_cards.enums.CardType;
import java.util.Calendar;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class SeasonCard extends SkiCard {

    public final Calendar END_OF_THE_SEASON;

    public SeasonCard(int id, CardType ct, Calendar regDate, Calendar c) {
        super(id, ct, regDate);
        END_OF_THE_SEASON = c;
    }

}
