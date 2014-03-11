package com.epam.my_arraylist;

import java.util.Arrays;

public class MyArrayList<E> {

    private int size;
    private Object[] elementData;

    public MyArrayList(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }

    public MyArrayList() {
        this(10);
    }

    public void add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
    }

    public void add(int index, E e) {
        if (index == 0) {
            add(e);
            return;
        }
        checkIndex(index);
        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData,
                index + 1, size - index);
        elementData[index] = e;
        size++;
    }

    public void addAll(E[] e) {
        ensureCapacity(size + e.length);
        for (E e1 : e) {
            elementData[size++] = e1;
        }
    }

    public void addAll(int index, E[] e) {
        checkIndex(index);
        if (index == 0) {
            addAll(e);
            return;
        }
        ensureCapacity(size + e.length);
        System.arraycopy(elementData, index, elementData,
                index + e.length, size - index);

        System.arraycopy(e, 0, elementData,
                index, e.length);
        size += e.length;

    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length) {
            elementData = Arrays.copyOf(elementData, minCapacity);
        }
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elementData[index];
    }

    public E remove(int index) {
        checkIndex(index);
        E removingElement = (E) elementData[index];
        for (int i = index; i < elementData.length - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData = Arrays.copyOfRange(elementData, 0, elementData.length - 1);
        --size;
        return removingElement;

    }

    public void removeAll() {
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }
        elementData = new Object[size];
        size = 0;
    }

    public void set(int index, E element) {
        checkIndex(index);
        elementData[index] = element;
    }

    public int size() {
        return size;
    }

    public E[] toArray() {
        return (E[]) Arrays.copyOfRange(elementData, 0, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(elementData, 0, size));
    }

    private boolean checkForNull(E[] e) {
        if (e == null) {
            System.err.println("You can`t add null as array to the list.");
            return true;
        }
        return false;
    }

    private boolean checkIndex(int i) {
        if (i > size || i < 0) {
            System.out.println("Index out of bounds.");
            throw new IndexOutOfBoundsException("Index out of bounds."
                    + " Index = " + i + ".");
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
