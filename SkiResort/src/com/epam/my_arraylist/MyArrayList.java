package com.epam.my_arraylist;

import java.util.Arrays;

public class MyArrayList {

    private int size;
    private Integer[] elementData;

    public MyArrayList(int initialCapacity) {
        this.elementData = new Integer[initialCapacity];
    }

    public MyArrayList() {
        this(10);
    }

    public void add(Integer e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
    }

    public void add(int index, Integer e) {
        if (index == 0) {
            add(e);
            return;
        }
        if (isEmpty()) {
            return;
        }
        if (checkIndex(index)) {
            return;
        }
        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData,
                index + 1, size - index);
        elementData[index] = e;
        size++;
    }

    public void addAll(Integer[] e) {
        if (checkForNull(e)) {
            return;
        }
        ensureCapacity(size + e.length);
        for (int i = 0; i < e.length; i++) {
            elementData[size++] = e[i];
        }

    }

    public void addAll(int index, Integer[] e) {
        if (checkForNull(e)) {
            return;
        }
        if (index == 0) {
            addAll(e);
            return;
        }
        if (isEmpty()) {
            return;
        }
        if (checkIndex(index)) {
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

    public Integer get(int index) {
        if (isEmpty() || checkIndex(index)) {
            return null;
        }
        return elementData[index];

    }

    public Integer remove(int index) {
        if (isEmpty() || checkIndex(index)) {
            return null;
        }
        Integer removingElement = elementData[index];
        for (int i = index; i < elementData.length - 1; i++) {
            elementData[i] = elementData[i + 1];
        }

        elementData = Arrays.copyOfRange(elementData, 0, elementData.length - 1);
        --size;
        return removingElement;

    }

    public void removeAll() {
        elementData = new Integer[size];
        size = 0;

    }

    public void set(int index, Integer element) {
        if (isEmpty() || checkIndex(index)) {
            return;
        }
        elementData[index] = element;
    }

    public int size() {
        return size;
    }

    public Integer[] toArray() {
        return Arrays.copyOfRange(elementData, 0, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(elementData, 0, size));
    }

    private boolean checkForNull(Integer[] e) {
        if (e == null) {
            System.err.println("You can`t add null as array to the list.");
            return true;
        }
        return false;
    }

    private boolean checkIndex(int i) {
        if (i > size || i < 0) {
            System.out.println("Index out of bounds.");
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            System.out.println("List is empty.");
            return true;
        } else {
            return false;
        }
    }
}
