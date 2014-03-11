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
    public void testAddNull() {
        Object e = null;
        MyArrayList instance = new MyArrayList();
        instance.add(e);
    }

    @Test
    public void testAddNullToSpecificIndex() {
        Object e = null;
        int index = 10;
        MyArrayList instance = new MyArrayList();
        for (int i = 0; i < 15; i++) {
            instance.add(new Object());
        }
        instance.add(index, e);
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

    @Test
    public void testRemove() {
        int size = 5;
        MyArrayList instance = new MyArrayList();
        for (int i = 0; i < size; i++) {
            instance.add(new Object());
        }
        System.out.println("SIZE" + instance.size());
        int expResult = size - 1;
        instance.remove(size);
        int result = instance.size();
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveAll() {
        System.out.println("removeAll");
        MyArrayList instance = new MyArrayList();
        instance.removeAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

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
    public void testToString() {
        System.out.println("toString");
        MyArrayList instance = new MyArrayList();
        String expResult = "[]";
        String result = instance.toString();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        MyArrayList instance = new MyArrayList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

}
