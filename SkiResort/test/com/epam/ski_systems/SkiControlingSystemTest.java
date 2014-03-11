/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.ski_systems;

import com.epam.ski_cards.SkiCard;
import com.epam.ski_cards.enums.CardType;
import com.epam.ski_cards.enums.DayCounts;
import com.epam.ski_cards.enums.LiftCounts;
import java.util.ArrayList;
import java.util.Calendar;
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
public class SkiControlingSystemTest {

    public SkiControlingSystemTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class SkiControlingSystem.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        SkiControlingSystem expResult = null;
        SkiControlingSystem result = SkiControlingSystem.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeCard method, of class SkiControlingSystem.
     */
    @Test
    public void testMakeCard_4args_1() {
        System.out.println("makeCard");
        CardType ct = null;
        Calendar regDate = null;
        Boolean weekend = null;
        DayCounts dc = null;
        SkiControlingSystem instance = new SkiControlingSystem();
        SkiCard expResult = null;
        SkiCard result = instance.makeCard(ct, regDate, weekend, dc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeCard method, of class SkiControlingSystem.
     */
    @Test
    public void testMakeCard_4args_2() {
        System.out.println("makeCard");
        CardType ct = null;
        Calendar regDate = null;
        Boolean weekend = null;
        LiftCounts lc = null;
        SkiControlingSystem instance = new SkiControlingSystem();
        SkiCard expResult = null;
        SkiCard result = instance.makeCard(ct, regDate, weekend, lc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeCard method, of class SkiControlingSystem.
     */
    @Test
    public void testMakeCard_3args() {
        System.out.println("makeCard");
        CardType ct = null;
        Calendar regDate = null;
        Calendar endOfSeason = null;
        SkiControlingSystem instance = new SkiControlingSystem();
        SkiCard expResult = null;
        SkiCard result = instance.makeCard(ct, regDate, endOfSeason);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeData method, of class SkiControlingSystem.
     */
    @Test
    public void testWriteData() {
        System.out.println("writeData");
        String message = "";
        SkiControlingSystem instance = new SkiControlingSystem();
        instance.writeData(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of blockCard method, of class SkiControlingSystem.
     */
    @Test
    public void testBlockCard() {
        System.out.println("blockCard");
        SkiCard sk = null;
        SkiControlingSystem instance = new SkiControlingSystem();
        instance.blockCard(sk);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLog method, of class SkiControlingSystem.
     */
    @Test
    public void testGetLog() {
        System.out.println("getLog");
        SkiControlingSystem instance = new SkiControlingSystem();
        ArrayList expResult = null;
//        ArrayList result = instance.getLog();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printWholeLog method, of class SkiControlingSystem.
     */
    @Test
    public void testPrintWholeLog() {
        System.out.println("printWholeLog");
        SkiControlingSystem instance = new SkiControlingSystem();
        instance.printWholeLog();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printDaysCardLog method, of class SkiControlingSystem.
     */
    @Test
    public void testPrintDaysCardLog() {
        System.out.println("printDaysCardLog");
        SkiControlingSystem instance = new SkiControlingSystem();
        instance.printDaysCardLog();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printLiftsCardLog method, of class SkiControlingSystem.
     */
    @Test
    public void testPrintLiftsCardLog() {
        System.out.println("printLiftsCardLog");
        SkiControlingSystem instance = new SkiControlingSystem();
        instance.printLiftsCardLog();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printSeasonCardLog method, of class SkiControlingSystem.
     */
    @Test
    public void testPrintSeasonCardLog() {
        System.out.println("printSeasonCardLog");
        SkiControlingSystem instance = new SkiControlingSystem();
        instance.printSeasonCardLog();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
