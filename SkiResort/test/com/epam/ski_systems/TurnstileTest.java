/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.ski_systems;

import com.epam.ski_cards.LiftsCard;
import com.epam.ski_cards.SkiCard;
import com.epam.ski_cards.enums.CardType;
import static com.epam.ski_cards.enums.CardType.LIFT;
import static com.epam.ski_cards.enums.DayCounts.ONE;
import com.epam.ski_cards.enums.LiftCounts;
import static com.epam.ski_cards.enums.LiftCounts.TEN;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anatolii_Hlazkov
 */
public class TurnstileTest {

    public TurnstileTest() {
    }

    @Test
    public void testPassingTurnstileFailWorkdayCardAtHoliday() {
        SkiCard sc = new LiftsCard(0, LIFT, new GregorianCalendar(),
                false, TEN);
        Turnstile instance = new Turnstile();
        instance.sks.weekend = true;
        instance.passingTurnstile(sc);
        boolean expResult = false;
        boolean result = instance.passingTurnstile(sc);
        assertEquals(expResult, result);
    }

    /**
     * Test of check method, of class Turnstile.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        SkiCard sc = null;
        Turnstile instance = new Turnstile();
        boolean expResult = false;
        boolean result = instance.check(sc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
