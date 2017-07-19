package ua.nure.chulkov.Practice2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyListImpl implements MyList, ListIterable {
    private static final int ARRAY_LENGTH = 10;

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
            System.arraycopy(temp, 0, array, 0, temp.length);
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
            for (int i = 0; i < size; i++){
                if (array[i] == null) {
                    deleteCurElementAndShift(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++){
                if (o.equals(array[i])) {
                    deleteCurElementAndShift(i);
                    return true;
                }
            }
        }
        return false;
    }

    private void deleteCurElementAndShift(int i) {
        System.arraycopy(array, i + 1, array, i, size - i);
        size--;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        System.arraycopy(array, 0, arr, 0, arr.length);
        return arr;
    }

    @Override
    public int size() {
        return size;
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
        for (Object anArr : arr) {
            if (!this.contains(anArr)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        Object[] o = new Object[size];
        System.arraycopy(array, 0, o, 0, o.length);
        return Arrays.toString(o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MyListImpl objects = (MyListImpl) o;

        return size == objects.size && Arrays.equals(array, objects.array);
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

        private int cursor;
        private int lastRet = -1;

        int getCursor() {
            return cursor;
        }

        void setCursor(int cursor) {
            this.cursor = cursor;
        }

        int getLastRet() {
            return lastRet;
        }

        void setLastRet(int lastRet) {
            this.lastRet = lastRet;
        }

        @Override
        public boolean hasNext() {
            return getCursor() != size;
        }

        @Override
        public Object next() {
            int i = getCursor();
            if (i >= size) {
                throw new NoSuchElementException();
            }
            Object[] elementData = MyListImpl.this.array;
            setCursor(i + 1);
            setLastRet(i);
            return elementData[getLastRet()];
        }

        @Override
        public void remove() {
            if (getLastRet() < 0) {
                throw new IllegalStateException();
            }
            MyListImpl.this.remove(array[getLastRet()]);
            setCursor(getLastRet());
            setLastRet(-1);
        }
    }

    @Override
    public ListIterator listIterator() {
        return new ListIteratorImpl();
    }

    private class ListIteratorImpl extends IteratorImpl implements ListIterator {

        @Override
        public boolean hasPrevious() {
            return getCursor() != 0;
        }

        @Override
        public Object previous() {
            int i = getCursor() - 1;
            if (i < 0){
                throw new NoSuchElementException();
            }
            Object[] elementData = MyListImpl.this.array;
            setCursor(i);
            setLastRet(i);
            return elementData[getLastRet()];
        }

        @Override
        public void set(Object e) {
            array[getLastRet()] = e;
        }
    }
}
