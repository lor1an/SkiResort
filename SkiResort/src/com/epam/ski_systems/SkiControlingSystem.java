package com.epam.ski_systems;

import com.epam.my_arraylist.MyArrayList;
import com.epam.ski_cards.DaysCard;
import com.epam.ski_cards.LiftsCard;
import com.epam.ski_cards.SeasonCard;
import com.epam.ski_cards.SkiCard;
import com.epam.ski_cards.enums.CardType;
import static com.epam.ski_cards.enums.CardType.DAYS;
import static com.epam.ski_cards.enums.CardType.LIFTS;
import com.epam.ski_cards.enums.DayCounts;
import com.epam.ski_cards.enums.LiftCounts;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class SkiControlingSystem {

    private static SkiControlingSystem instance;
    private final MyArrayList list = new MyArrayList();
    private static int id;

    public static SkiControlingSystem getInstance() {
        if (instance == null) {
            instance = new SkiControlingSystem();
        }
        return instance;
    }

    public SkiCard makeCard(CardType ct, Calendar regDate, Boolean weekend, DayCounts dc) {
        if (!ct.equals(CardType.DAYS)) {
            throw new NullPointerException();
        }
        return new DaysCard(id++, ct, regDate, weekend, dc);
    }

    public SkiCard makeCard(CardType ct, Calendar regDate, Boolean weekend, LiftCounts lc) {
        if (!ct.equals(CardType.LIFTS)) {
            throw new NullPointerException();
        }
        return new LiftsCard(id++, ct, regDate, weekend, lc);
    }

    public SkiCard makeCard(CardType ct, Calendar regDate, Calendar endOfSeason) {
        if (!ct.equals(CardType.SEASON)) {
            throw new NullPointerException();
        }
        return new SeasonCard(id++, ct, regDate, endOfSeason);
    }
    
    public void writeData(String message){
        
    }

}
