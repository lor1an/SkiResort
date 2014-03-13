/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.ski_systems;

import com.epam.exceptions.WrongCardTypeException;
import com.epam.ski_cards.DaysCard;
import com.epam.ski_cards.LiftsCard;
import com.epam.ski_cards.SkiCard;
import com.epam.ski_cards.enums.CardType;
import static com.epam.ski_cards.enums.CardType.DAY;
import static com.epam.ski_cards.enums.CardType.LIFT;
import com.epam.ski_cards.enums.DayCounts;
import static com.epam.ski_cards.enums.DayCounts.FIRST_HALF;
import com.epam.ski_cards.enums.LiftCounts;
import static com.epam.ski_cards.enums.LiftCounts.TEN;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class SkiControlingSystemTest {

    public SkiControlingSystemTest() {
    }

    @Test(expected = WrongCardTypeException.class)
    public void testMakeDayCardThrowExceptionWhenSendIncorrectCardType() {
        Calendar regDate = new GregorianCalendar();
        CardType incorrectCardType = LIFT;
        DayCounts halfDayCounts = FIRST_HALF;
        Boolean weekend = false;
        SkiControlingSystem instance = new SkiControlingSystem();
        SkiCard result = instance.makeCard(incorrectCardType, regDate, weekend, halfDayCounts);
    }

    @Test(expected = WrongCardTypeException.class)
    public void testMakeLiftCardThrowExceptionWhenSendIncorrectCardType() {
        CardType incorrectCardType = DAY;
        Calendar regDate = new GregorianCalendar();
        SkiControlingSystem instance = new SkiControlingSystem();
        Boolean weekend = false;
        LiftCounts lcounts = TEN;
        SkiCard result = instance.makeCard(incorrectCardType, regDate, weekend, lcounts);
    }

    @Test(expected = WrongCardTypeException.class)
    public void testMakeSeasonCardThrowExceptionWhenSendIncorrectCardType() {
        CardType incorrectCardType = DAY;
        Calendar regDate = new GregorianCalendar();
        Calendar endOfSeason = new GregorianCalendar();
        SkiControlingSystem instance = new SkiControlingSystem();
        Boolean weekend = false;
        SkiCard result = instance.makeCard(incorrectCardType, regDate, endOfSeason);
    }

    @Test
    public void testBlockCard() {
        SkiCard sc = new LiftsCard(0, LIFT, new GregorianCalendar(),
                false, TEN);
        SkiControlingSystem instance = new SkiControlingSystem();
        boolean expResult = false;
        instance.blockCard(sc);
        boolean result = sc.isWorking();
        assertEquals(expResult, result);
    }

}
