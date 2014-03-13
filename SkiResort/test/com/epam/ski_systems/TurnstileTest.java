/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.ski_systems;

import com.epam.ski_cards.DaysCard;
import com.epam.ski_cards.LiftsCard;
import com.epam.ski_cards.SeasonCard;
import com.epam.ski_cards.SkiCard;
import static com.epam.ski_cards.enums.CardType.DAY;
import static com.epam.ski_cards.enums.CardType.LIFT;
import static com.epam.ski_cards.enums.CardType.SEASON;
import com.epam.ski_cards.enums.DayCounts;
import static com.epam.ski_cards.enums.DayCounts.FIRST_HALF;
import static com.epam.ski_cards.enums.DayCounts.FIVE;
import static com.epam.ski_cards.enums.LiftCounts.TEN;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class TurnstileTest {

    public TurnstileTest() {
    }

    final boolean TEST_WEEKEND = true;

    @Test
    public void testPassingTurnstileFailWorkdayCardAtHoliday() {
        SkiCard sc = new LiftsCard(0, LIFT, new GregorianCalendar(),
                !TEST_WEEKEND, TEN);
        Turnstile instance = new Turnstile();
        instance.sks.weekend = TEST_WEEKEND;
        instance.passingTurnstile(sc);
        boolean expResult = false;
        boolean result = instance.passingTurnstile(sc);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckBlockedCard() {
        SkiCard sc = new LiftsCard(0, LIFT, new GregorianCalendar(),
                false, TEN);
        sc.setWorking(false);
        Turnstile instance = new Turnstile();
        boolean expResult = false;
        boolean result = instance.check(sc);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckLiftCardWithOverTrips() {
        LiftsCard lc = new LiftsCard(0, LIFT, new GregorianCalendar(),
                false, TEN);
        int overTrips = 5;
        lc.setTrips(TEN.getCounts() + overTrips);
        Turnstile instance = new Turnstile();
        boolean expResult = false;
        boolean result = instance.check(lc);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckLiftCardWithSatisfyCountsOfTrip() {
        LiftsCard lc = new LiftsCard(0, LIFT, new GregorianCalendar(),
                false, TEN);
        int trips = 5;
        lc.setTrips(trips);
        Turnstile instance = new Turnstile();
        boolean expResult = true;
        boolean result = instance.check(lc);
        assertEquals(expResult, result);
    }

    @Test
    public void testLiftCardNumberOfTripsAfterPositiveChecking() {
        LiftsCard lc = new LiftsCard(0, LIFT, new GregorianCalendar(),
                false, TEN);
        int trips = 5;
        lc.setTrips(trips);
        Turnstile instance = new Turnstile();
        instance.check(lc);
        int expResult = trips + 1;
        int result = lc.getTrips();
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckNegativeResponseWithOldSeasonCard() {
        Calendar regDate = new GregorianCalendar();
        Calendar endOfSeason = new GregorianCalendar();
        endOfSeason.add(Calendar.MONTH, -3);
        SeasonCard sc = new SeasonCard(0, SEASON, regDate, endOfSeason);
        Turnstile instance = new Turnstile();
        boolean expResult = false;
        boolean result = instance.check(sc);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckPositiveResponseWithSeasonCard() {
        Calendar regDate = new GregorianCalendar();
        Calendar endOfSeason = new GregorianCalendar();
        endOfSeason.add(Calendar.MONTH, 3);
        SeasonCard sc = new SeasonCard(0, SEASON, regDate, endOfSeason);
        Turnstile instance = new Turnstile();
        boolean expResult = true;
        boolean result = instance.check(sc);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckNotTodayHalfDayCard() {
        Calendar regDate = new GregorianCalendar();
        regDate.add(Calendar.DAY_OF_MONTH, -1);
        DayCounts halfDayCounts = FIRST_HALF;
        DaysCard dc = new DaysCard(0, DAY, regDate, false, halfDayCounts);
        Turnstile instance = new Turnstile();
        boolean expResult = false;
        boolean result = instance.check(dc);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckNegativeResponseWithOldFullDayCard() {
        Calendar regDate = new GregorianCalendar();
        regDate.add(Calendar.DAY_OF_MONTH, -7);
        DayCounts fullDayCounts = FIVE;
        DaysCard dc = new DaysCard(0, DAY, regDate, false, fullDayCounts);
        Turnstile instance = new Turnstile();
        boolean expResult = false;
        boolean result = instance.check(dc);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckPositiveResponseWithFullDayCard() {
        Calendar regDate = new GregorianCalendar();
        DayCounts fullDayCounts = FIVE;
        DaysCard dc = new DaysCard(0, DAY, regDate, false, fullDayCounts);
        Turnstile instance = new Turnstile();
        boolean expResult = true;
        boolean result = instance.check(dc);
        assertEquals(expResult, result);
    }

    @Test
    public void testPassingTurnstileWithPositiveCheck() {
        LiftsCard lc = new LiftsCard(0, LIFT, new GregorianCalendar(),
                TEST_WEEKEND, TEN);
        Turnstile instance = new Turnstile();
        boolean expResult = true;
        boolean result = instance.passingTurnstile(lc);
        assertEquals(expResult, result);
    }

    @Test
    public void testPassingTurnstileWithNegativeCheck() {
        LiftsCard lc = new LiftsCard(0, LIFT, new GregorianCalendar(),
                TEST_WEEKEND, TEN);
        int trips = 10;
        lc.setTrips(trips);
        Turnstile instance = new Turnstile();
        boolean expResult = false;
        boolean result = instance.passingTurnstile(lc);
        assertEquals(expResult, result);
    }

    @Test
    public void testWritingToLogAfterPassingTurnstileWithPositiveCheck() {
        LiftsCard lc = new LiftsCard(0, LIFT, new GregorianCalendar(),
                TEST_WEEKEND, TEN);
        Turnstile instance = new Turnstile();
        int expResult = instance.sks.getLog().size() + 1;
        instance.passingTurnstile(lc);
        int result = instance.sks.getLog().size();
        assertEquals(expResult, result);
    }

    @Test
    public void testWritingToLogAfterDayCardPassingTurnstileWithNegativeCheck() {
        Calendar regDate = new GregorianCalendar();
        regDate.add(Calendar.DAY_OF_MONTH, -7);
        DayCounts fullDayCounts = FIVE;
        DaysCard dc = new DaysCard(0, DAY, regDate, false, fullDayCounts);
        Turnstile instance = new Turnstile();
        int expResult = instance.sks.getLog().size() + 1;
        instance.passingTurnstile(dc);
        int result = instance.sks.getLog().size();
        assertEquals(expResult, result);
    }

    @Test
    public void testWritingToLogAfterSeasonCardPassingTurnstileWithNegativeCheck() {
        Calendar regDate = new GregorianCalendar();
        Calendar endOfSeason = new GregorianCalendar();
        endOfSeason.add(Calendar.MONTH, -3);
        SeasonCard sc = new SeasonCard(0, SEASON, regDate, endOfSeason);
        Turnstile instance = new Turnstile();
        int expResult = instance.sks.getLog().size() + 1;
        instance.passingTurnstile(sc);
        int result = instance.sks.getLog().size();
        assertEquals(expResult, result);
    }

    @Test
    public void testWritingToLogAfterLiftCardPassingTurnstileWithNegativeCheck() {
        LiftsCard lc = new LiftsCard(0, LIFT, new GregorianCalendar(),
                TEST_WEEKEND, TEN);
        int overTrips = 5;
        lc.setTrips(TEN.getCounts() + overTrips);
        Turnstile instance = new Turnstile();
        int expResult = instance.sks.getLog().size() + 1;
        instance.passingTurnstile(lc);
        int result = instance.sks.getLog().size();
        assertEquals(expResult, result);
    }

    @Test
    public void testWritingToLogAfterWorkdayCardPassingTurnstileAtHoliday() {
        SkiCard sc = new LiftsCard(0, LIFT, new GregorianCalendar(),
                !TEST_WEEKEND, TEN);
        Turnstile instance = new Turnstile();
        instance.sks.weekend = TEST_WEEKEND;
        int expResult = instance.sks.getLog().size() + 1;
        instance.passingTurnstile(sc);
        int result = instance.sks.getLog().size();
        assertEquals(expResult, result);
    }
}
