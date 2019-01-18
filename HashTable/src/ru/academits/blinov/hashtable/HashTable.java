package ru.academits.blinov.hashtable;

import java.util.*;

public class HashTable<E> implements Collection<E> {
    private ArrayList<E>[] hashTable;
    private int modCount = 0;
    private int entries = 0;

    public HashTable(int size) {
        //noinspection unchecked
        hashTable = new ArrayList[size];
    }

    @Override
    public int size() {
        return entries;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean add(E value) {
        int index = Math.abs(Objects.hashCode(value) % hashTable.length);
        if (hashTable[index] == null) {
            hashTable[index] = new ArrayList<>();
        }
        if (hashTable[index].add(value)) {
            entries++;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean isAdded = false;
        for (E e : collection) {
            if (add(e)) {
                entries++;
                modCount++;
                isAdded = true;
            }
        }
        return isAdded;
    }

    @Override
    public boolean contains(Object object) {
        int index = Math.abs(Objects.hashCode(object) % hashTable.length);
        if (hashTable[index] == null) {
            return Objects.equals(object, hashTable[index]);
        }
        return hashTable[index].contains(object);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object e : collection) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        Iterator<E> iterator = iterator();
        for (int i = 0; i < size(); i++) {
            array[i] = iterator.next();
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < size()) {
            //noinspection unchecked
            return (T[]) Arrays.copyOf(this.toArray(), size(), array.getClass());
        }
        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(this.toArray(), 0, array, 0, array.length);
        if (array.length > size()) {
            array[size()] = null;
            return array;
        }
        return array;
    }

    @Override
    public boolean remove(Object object) {
        int index = Math.abs(Objects.hashCode(object) % hashTable.length);
        if (hashTable[index] == null) {
            return false;
        }
        if (hashTable[index].remove(object)) {
            entries--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean isDeleted = false;
        for (Object e : collection) {
            if (this.remove(e)) {
                isDeleted = true;
            }
        }
        return isDeleted;
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            return;
        }
        for (ArrayList<E> e : hashTable) {
            if (e == null) {
                continue;
            }
            if (!e.isEmpty()) {
                e.clear();
                modCount++;
            }
        }
        entries = 0;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean isRetained = false;
        for (ArrayList<E> e : hashTable) {
            if (e == null) {
                continue;
            }
            int tempSize = e.size();
            if (e.retainAll(collection)) {
                isRetained = true;
                entries -= (tempSize - e.size());
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
        for (ArrayList<E> e : hashTable) {
            stringBuilder.append(e).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append("]");

        return stringBuilder.toString();
    }

    private class HashTableIterator implements Iterator<E> {
        private int index = 0;
        private int innerIndex = -1;
        private int entriesCount = 0;
        private int currentModCount = modCount;

        @Override
        public boolean hasNext() {
            return (entriesCount < size());
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (modCount != currentModCount) {
                throw new ConcurrentModificationException();
            }
            for (; hasNext(); index++) {
                if (hashTable[index] == null) {
                    continue;
                }
                if (innerIndex + 1 >= hashTable[index].size()) {
                    innerIndex = -1;
                } else {
                    break;
                }
            }
            entriesCount++;
            innerIndex++;
            return hashTable[index].get(innerIndex);
        }
    }

    public Iterator<E> iterator() {
        return new HashTableIterator();
    }
}