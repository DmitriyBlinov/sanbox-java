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
        if (this.isEmpty()) {
            return false;
        }
        for (ArrayList<T> e : hashTable) {
            if (e.contains(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        if (collection.isEmpty() || this.isEmpty()) {
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
        if (this.isEmpty()) {
            return false;
        }
        boolean isDeleted = false;
        for (ArrayList<T> e : hashTable) {
            if (e.remove(object)) {
                isDeleted = true;
                modCount++;
            }
        }
        return isDeleted;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection.isEmpty() || this.isEmpty()) {
            return false;
        }
        boolean isDeleted = false;
        for (ArrayList<T> e : hashTable) {
            if (e.removeAll(collection)) {
                isDeleted = true;
                modCount++;
            }
        }
        return isDeleted;
    }

    @Override
    public void clear() {
        if (this.isEmpty()) {
            return;
        }
        for (ArrayList<T> e : hashTable) {
            e.clear();
        }
        modCount++;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (collection.isEmpty() || this.isEmpty()) {
            return false;
        }
        boolean isRetained = false;
        for (ArrayList<T> e : hashTable) {
            if (e.retainAll(collection)) {
                isRetained = true;
                modCount++;
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

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;
            private int currentInnerIndex = 0;
            int currentModCount = modCount;

            @Override
            public boolean hasNext() {
                return (currentIndex++ < hashTable.length) && (currentInnerIndex++ < hashTable[currentIndex].size());
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != currentModCount) {
                    throw new ConcurrentModificationException();
                }
                //если есть где брать next() в текущем ArrayList
                if (currentInnerIndex++ < hashTable[currentIndex].size()) {
                    return hashTable[currentIndex].get(currentInnerIndex++);
                }
                //если дошел до конца ArrayList, обнуляет внутр.индекс
                currentInnerIndex = 0;
                return hashTable[currentIndex++].get(currentInnerIndex);
            }

            @Override
            public void remove() {
                if (currentIndex > hashTable.length) {
                    throw new NoSuchElementException();
                }
                hashTable[currentIndex].remove(currentInnerIndex);
                //после удаления проверяет перевести ли curIndex дальше по ArrayList...
                if (currentInnerIndex++ < hashTable[currentIndex].size()) {
                    currentInnerIndex++;
                    //или по hashTable
                } else if (hasNext()) {
                    currentIndex++;
                }
            }
        };
    }
}