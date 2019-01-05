package ru.academits.blinov.hashtable;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private ArrayList<T>[] hashTable;
    private int modCount = 0;

    public HashTable() {
        hashTable = new ArrayList[]{};
    }

    public HashTable(int size) {
        hashTable = new ArrayList[size];
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
        return size() == 0;
    }

    @Override
    public boolean add(T value) {
        int index = Math.abs(value.hashCode() % size());
        if (hashTable[index] == null) {
            hashTable[index] = new ArrayList<>();
        }
        hashTable[index].add(value);
        modCount++;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        for (T e : collection) {
            this.add(e);
        }
        modCount++;
        return true;
    }

    @Override
    public boolean contains(Object object) {
        if (hashTable.length == 0) {
            return false;
        }
        for (ArrayList<T> e : hashTable) {
            if (e == null) {
                continue;
            }
            if (e.contains(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        if (collection.isEmpty() || hashTable.length == 0) {
            return false;
        }
        for (Object e : collection) {
            int count = 0;
            for (ArrayList<T> i : hashTable) {
                if (i.contains(e)) {
                    count++;
                }
            }
            if (count == 0) {
                return false;
            }
        }
        return true;
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
    public boolean remove(Object object) {
        if (hashTable.length == 0) {
            return false;
        }
        boolean isDeleted = false;
        int count = 0;
        for (ArrayList<T> e : hashTable) {
            if (e == null) {
                count++;
                continue;
            }
            if (e.remove(object)) {
                isDeleted = true;
                modCount++;
                if (e.isEmpty()) {
                    hashTable[count] = null;
                }
            }
            count++;
        }
        return isDeleted;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection.isEmpty() || hashTable.length == 0) {
            return false;
        }
        boolean isDeleted = false;
        int count = 0;
        for (ArrayList<T> e : hashTable) {
            if (e == null) {
                count++;
                continue;
            }
            if (e.removeAll(collection)) {
                isDeleted = true;
                modCount++;
                if (e.isEmpty()) {
                    hashTable[count] = null;
                }
            }
            count++;
        }
        return isDeleted;
    }

    @Override
    public void clear() {
        if (hashTable.length == 0) {
            return;
        }
        int count = 0;
        for (ArrayList<T> e : hashTable) {
            if (e == null) {
                count++;
                continue;
            }
            e.clear();
            if (e.isEmpty()) {
                hashTable[count] = null;
            }
            count++;
        }
        modCount++;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (collection.isEmpty() || hashTable.length == 0) {
            return false;
        }
        boolean isRetained = false;
        for (ArrayList<T> e : hashTable) {
            if (e.retainAll(collection)) {
                isRetained = true;
                modCount++;
            }
            if (e.isEmpty()) {
                e.add(null);
            }
        }
        return isRetained;
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

    private class HashTableIterator implements Iterator<T> {
        private int currentIndex = 0;
        private int currentInnerIndex = -1;
        int currentModCount = modCount;

        @Override
        public boolean hasNext() {
            return (currentIndex + 1 < hashTable.length);
        }

        @Override
        public T next() {
            if (currentIndex >= hashTable.length) {
                throw new NoSuchElementException();
            }
            if (modCount != currentModCount) {
                throw new ConcurrentModificationException();
            }
            if (hashTable[currentIndex] == null) {
                currentIndex++;
                return null;
            }
            if (currentInnerIndex + 1 < hashTable[currentIndex].size()) {
                return hashTable[currentIndex].get(++currentInnerIndex);
            }
            currentInnerIndex = -1;
            if (hashTable[currentIndex + 1] == null) {
                currentIndex += 2;
                return null;
            }
            return hashTable[++currentIndex].get(++currentInnerIndex);
        }
    }

    public Iterator<T> iterator() {
        return new HashTableIterator();
    }
}