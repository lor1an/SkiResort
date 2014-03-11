/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epam.ski_systems;

import com.epam.ski_cards.SkiCard;
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
     * Test of passingTurnstile method, of class Turnstile.
     */
    @Test
    public void testPassingTurnstile() {
        System.out.println("passingTurnstile");
        SkiCard sc = null;
        Turnstile instance = new Turnstile();
        instance.passingTurnstile(sc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
