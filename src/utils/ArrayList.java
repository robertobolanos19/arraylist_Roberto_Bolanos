package utils;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] data;
    private int size;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        data = (E[]) new Object[capacity];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public ArrayList(List<E> otherList) {
        data = (E[]) new Object[otherList.size()];
        for (int i = 0; i < otherList.size(); i++) {
            data[i] = otherList.get(i);
        }
        size = otherList.size();
    }

    @Override
    public boolean add(E item) {
        ensureCapacity(size + 1);
        data[size++] = item;
        return true;
    }

    @Override
    public void add(int index, E item) {
        checkIndex(index, true);
        ensureCapacity(size + 1);
        shiftRight(index);
        data[index] = item;
        size++;
    }

    @Override
    public boolean addAll(List<E> otherList) {
        ensureCapacity(size + otherList.size());
        for (int i = 0; i < otherList.size(); i++) {
            add(otherList.get(i));
        }
        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index, false);
        return data[index];
    }

    @Override
    public boolean contains(E item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(E item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(data, 0, size, null);
        size = 0;
    }

    @Override
    public E remove(int index) {
        checkIndex(index, false);
        E removedItem = data[index];
        shiftLeft(index);
        size--;
        return removedItem;
    }

    @Override
    public boolean remove(E item) {
        int index = indexOf(item);
        if (index == -1) return false;
        remove(index);
        return true;
    }

    @Override
    public boolean removeAll(utils.List<E> otherList) {
        boolean removed = false;
        for (int i = 0; i < otherList.size(); i++) {
            removed |= remove(otherList.get(i));
        }
        return removed;
    }

    @Override
    public E set(int index, E item) {
        checkIndex(index, false);
        E oldItem = data[index];
        data[index] = item;
        return oldItem;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, minCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    private void shiftRight(int index) {
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
    }

    private void shiftLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
    }

    private void checkIndex(int index, boolean allowEnd) {
        if (index < 0 || index > size || (!allowEnd && index == size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}