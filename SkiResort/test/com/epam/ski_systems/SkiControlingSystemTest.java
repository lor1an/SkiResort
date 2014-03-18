/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.ski_systems;

import com.epam.exceptions.WrongCardTypeException;
import com.epam.ski_cards.DaysCard;
import com.epam.ski_cards.LiftsCard;
import com.epam.ski_cards.SeasonCard;
import com.epam.ski_cards.SkiCard;
import com.epam.ski_cards.enums.CardType;
import static com.epam.ski_cards.enums.CardType.DAY;
import static com.epam.ski_cards.enums.CardType.LIFT;
import static com.epam.ski_cards.enums.CardType.SEASON;
import com.epam.ski_cards.enums.DayCounts;
import static com.epam.ski_cards.enums.DayCounts.FIRST_HALF;
import static com.epam.ski_cards.enums.DayCounts.FIVE;
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

    @Test
    public void testDaysLog() {
        Calendar regDate = new GregorianCalendar();
        DayCounts fullDayCounts = FIVE;
        DaysCard dc = new DaysCard(0, DAY, regDate, false, fullDayCounts);
        Turnstile instance = new Turnstile();
        int passCount = 10;
        for (int i = 0; i < passCount; i++) {
            instance.passingTurnstile(dc);
        }
        int expResult = passCount;
        int result = instance.sks.getDaysCardLog().size();
        instance.sks.printWholeLog();
        System.out.println(instance.sks.getDaysCardLog().size());
        assertEquals(expResult, result);
    }

    @Test
    public void testLiftsLog() {
        LiftsCard lc = new LiftsCard(0, LIFT, new GregorianCalendar(),
                false, TEN);
        Turnstile instance = new Turnstile();
        int passCount = 10;
        for (int i = 0; i < passCount; i++) {
            instance.passingTurnstile(lc);
        }
        int expResult = passCount;
        int result = instance.sks.getLiftsCardLog().size();
        instance.sks.printWholeLog();
        System.out.println(instance.sks.getLiftsCardLog().size());
        assertEquals(expResult, result);
    }

    @Test
    public void testSeasonLog() {
        Calendar regDate = new GregorianCalendar();
        Calendar endOfSeason = new GregorianCalendar();
        endOfSeason.add(Calendar.MONTH, 3);
        SeasonCard sc = new SeasonCard(0, SEASON, regDate, endOfSeason);
        Turnstile instance = new Turnstile();
        int passCount = 10;
        for (int i = 0; i < passCount; i++) {
            instance.passingTurnstile(sc);
        }
        int expResult = passCount;
        int result = instance.sks.getSeasonCardLog().size();
        instance.sks.printWholeLog();
        System.out.println(instance.sks.getSeasonCardLog().size());
        assertEquals(expResult, result);
    }

}
