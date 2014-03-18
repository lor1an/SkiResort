package com.epam.my_arraylist;

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
        int index = 5;
        MyArrayList instance = new MyArrayList();
        Object expResult = new Object();
        for (int i = 0; i < 10; i++) {
            if (i == index) {
                instance.add(expResult);
            } else {
                instance.add(new Object());
            }
        }
        Object result = instance.get(index);
        assertEquals(expResult, result);
    }

    @Test
    public void testRemove() {
        int size = 5;
        MyArrayList instance = new MyArrayList();
        for (int i = 0; i < size; i++) {
            instance.add(new Object());
        }
        int expResult = size - 1;
        instance.remove(size);
        int result = instance.size();
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveAll() {
        int size = 15;
        int expResult = 0;
        MyArrayList instance = new MyArrayList();
        for (int i = 0; i < size; i++) {
            instance.add(new Object());
        }
        instance.removeAll();
        int result = instance.size();
        assertEquals(expResult, result);
    }

    @Test
    public void testSet() {
        int index = 5;
        MyArrayList instance = new MyArrayList();
        Object expResult = new Object();
        for (int i = 0; i < 10; i++) {
            instance.add(new Object());
        }
        instance.set(index, expResult);
        Object result = instance.get(index);
        assertEquals(expResult, result);
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
        MyArrayList instance = new MyArrayList();
        String expResult = "[]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsEmpty() {
        MyArrayList instance = new MyArrayList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsReflection() {
        MyArrayList instance = new MyArrayList();
        for (int i = 0; i < 10; i++) {
            instance.add(new Object());
        }
        boolean expResult = true;
        boolean result = instance.equals(instance);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsSymmetry() {
        MyArrayList instance1 = new MyArrayList();
        MyArrayList instance2 = new MyArrayList();
        for (int i = 0; i < 10; i++) {
            Object obj = new Object();
            instance1.add(obj);
            instance2.add(obj);
        }
        boolean expResult = true;
        boolean result = instance1.equals(instance2) == instance2.equals(instance1);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsNull() {
        MyArrayList instance = new MyArrayList();
        boolean expResult = false;
        boolean result = instance.equals(null);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsNotArrayListInstance() {
        MyArrayList instance = new MyArrayList();
        boolean expResult = false;
        boolean result = instance.equals(new Object());
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsArrayListsWithDifferentSizes() {
        MyArrayList instance1 = new MyArrayList();
        MyArrayList instance2 = new MyArrayList();
        int size = 10;
        for (int i = 0; i < size; i++) {
            instance1.add(i);
            instance2.add(i);
        }
        instance2.add(size);
        boolean expResult = false;
        boolean result = instance1.equals(instance2);
        assertEquals(expResult, result);
    }

    @Test
    public void testHashOnEqualsLists() {
        MyArrayList instance1 = new MyArrayList();
        MyArrayList instance2 = new MyArrayList();
        int size = 10;
        for (int i = 0; i < size; i++) {
            instance1.add(i);
            instance2.add(i);
        }
        int hash1 = instance1.hashCode();
        int hash2 = instance2.hashCode();
        boolean expResult = true;
        boolean result = hash1 == hash2;
        assertEquals(expResult, result);
    }

}
