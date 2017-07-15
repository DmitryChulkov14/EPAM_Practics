package ua.nure.chulkov.Practice2;

import java.util.*;

public class MyListImpl implements MyList, ListIterable {
    private final int ARRAY_LENGTH = 10;

    private Object[] array;
    private int size;

    public MyListImpl() {
        array = new Object[ARRAY_LENGTH];
    }

    @Override
    public void add(Object element) {
        if (size == array.length) {
            Object[] temp = array;
            array = new Object[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                array[i] = temp[i];
            }
        }
        array[size++] = element;
    }

    @Override
    public void clear() {
        size = 0;
        array = new Object[ARRAY_LENGTH];
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (array[i] == null) {
                    deleteCurElementAndShift(i);
                    return true;
                }
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(array[i])) {
                    deleteCurElementAndShift(i);
                    return true;
                }
        }
        return false;
    }

    private void deleteCurElementAndShift(int i) {
        for (int j = i; j < size; j++) {
            array[j] = array[j + 1];
        }
        size--;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = array[i];
        }
        return arr;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++){
                if (array[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++){
                if (o.equals(array[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(MyList c) {
        Object[] arr = c.toArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        Object[] o = new Object[size];
        for (int i = 0; i < o.length; i++) {
            o[i] = array[i];
        }
        return "{" + Arrays.toString(o) +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyListImpl objects = (MyListImpl) o;

        if (size != objects.size) return false;
        return Arrays.equals(array, objects.array);
    }

    @Override
    public int hashCode() {
        int result = ARRAY_LENGTH;
        result = 31 * result + Arrays.hashCode(array);
        result = 31 * result + size;
        return result;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Object next() {
            int i = cursor;
            if (i >= size) {
                throw new NoSuchElementException();
            }
            Object[] elementData = MyListImpl.this.array;
            cursor = i + 1;
            return elementData[lastRet = i];
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            MyListImpl.this.remove(array[lastRet]);
            cursor = lastRet;
            lastRet = -1;
        }
    }

    @Override
    public ListIterator listIterator() {
        return new ListIteratorImpl();
    }

    private class ListIteratorImpl extends IteratorImpl implements ListIterator {
        ListIteratorImpl(){
            cursor = size;
        }

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @Override
        public Object previous() {
            int i = cursor - 1;
            if (i < 0){
                throw new NoSuchElementException();
            }
            Object[] elementData = MyListImpl.this.array;
            cursor = i;
            return elementData[lastRet = i];
        }

        @Override
        public void set(Object e) {
            array[lastRet] = e;
        }
    }
}
