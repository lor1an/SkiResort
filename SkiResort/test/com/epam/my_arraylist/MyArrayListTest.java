/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.my_arraylist;

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
public class MyArrayListTest {

    public MyArrayListTest() {
    }

    @Test
    public void testAdd_GenericType() {
        System.out.println("add");
        Object e = null;
        MyArrayList instance = new MyArrayList();
        instance.add(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithNegativeIndex() {
        int index = -10;
        Object e = null;
        MyArrayList instance = new MyArrayList();
        instance.add(index, e);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllWithNegativeIndex() {
        int index = -10;
        Object[] e = {new Object(), new Object(), new Object(), new Object()};
        MyArrayList instance = new MyArrayList();
        instance.addAll(index, e);
    }

    @Test
    public void testAddAll_GenericType() {
        System.out.println("addAll");
        Object[] e = null;
        MyArrayList instance = new MyArrayList();
        instance.addAll(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAll method, of class MyArrayList.
     */
    @Test
    public void testAddAll_int_GenericType() {
        System.out.println("addAll");
        int index = 0;
        Object[] e = null;
        MyArrayList instance = new MyArrayList();
        instance.addAll(index, e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class MyArrayList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        MyArrayList instance = new MyArrayList();
        Object expResult = null;
        Object result = instance.get(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class MyArrayList.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        int index = 0;
        MyArrayList instance = new MyArrayList();
        Object expResult = null;
        Object result = instance.remove(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAll method, of class MyArrayList.
     */
    @Test
    public void testRemoveAll() {
        System.out.println("removeAll");
        MyArrayList instance = new MyArrayList();
        instance.removeAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class MyArrayList.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int index = 0;
        Object element = null;
        MyArrayList instance = new MyArrayList();
        instance.set(index, element);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class MyArrayList.
     */
    @Test
    public void testSizeAfterAdding() {
        int size = 100;
        MyArrayList instance = new MyArrayList();
        for (int i = 0; i < size; i++) {
            instance.add(new Object());
        }
        int expResult = size;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    @Test
    public void testComparingSizeWithLength() {
        int size = 100;
        MyArrayList instance = new MyArrayList(150);
        for (int i = 0; i < size; i++) {
            instance.add(new Object());
        }
        int expResult = size;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    @Test
    public void testToArray() {
        System.out.println("toArray");
        MyArrayList instance = new MyArrayList();
        Object[] expResult = null;
        Object[] result = instance.toArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class MyArrayList.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MyArrayList instance = new MyArrayList();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class MyArrayList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        MyArrayList instance = new MyArrayList();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
