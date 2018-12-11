package ru.academits.blinov.hashtable;

import java.util.*;

//геттер и сеттер для элементов? Сделать итератор
public class HashTable<T> implements Collection<T> {
    private ArrayList<T>[] hashTable;

    public HashTable() {
        hashTable = new ArrayList[]{};
    }

    public HashTable(int size) {
        hashTable = new ArrayList[size];
    }

    @Override
    public boolean add(T value) {
        int index = Math.abs(value.hashCode() % size());
        if (hashTable[index] == null) {
            hashTable[index] = new ArrayList<>();
        }
        hashTable[index].add(value);
        return true;
    }

    @Override
    public int size() {
        if (hashTable.length == 0) {
            return 0;
        }
        return hashTable.length;
    }

    @Override
    public boolean isEmpty() {
        return hashTable.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (ArrayList<T> e : hashTable) {
            if (e.contains(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;
            private int currentInnerIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < hashTable.length
                        && hashTable[currentIndex].size() < currentInnerIndex
                        && hashTable[currentIndex].get(currentInnerIndex) != null;
            }

            @Override
            public T next() {
                return hashTable[currentIndex].get(currentInnerIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(hashTable, size());
    }

    @Override
    public <T> T[] toArray(T[] array) {
        return array;
    }

    @Override
    public boolean remove(Object o) {
        boolean isDeleted = false;
        for (ArrayList<T> e : hashTable) {
            isDeleted = e.remove(o);
        }
        return isDeleted;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isDeleted = false;
        for (ArrayList<T> e : hashTable) {
            isDeleted = e.removeAll(c);
        }
        return isDeleted;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isRetained = false;
        for (ArrayList<T> e : hashTable) {
            isRetained = e.retainAll(c);
        }
        return isRetained;
    }

    @Override
    public void clear() {
        for (ArrayList<T> e : hashTable) {
            e.clear();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (hashTable.length == 0) {
            return stringBuilder.append("[ ]").toString();
        }
        stringBuilder.append("[");
        for (ArrayList<T> e : hashTable) {
            stringBuilder.append(e).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append("]");

        return stringBuilder.toString();
    }
}
