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
        //TODO
        //true if this collection changed as a result of the call
        //здесь возвращает true, если коллекция в которую добавляли, была изменена
        //значит даже если 1 раз добавили, то по логике будет true
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
            return false;
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
        //TODO итератором по всей хеш-таблице
        List<ArrayList<E>> tempHashTable = new ArrayList<>(Arrays.asList(hashTable));
        tempHashTable.removeAll(Collections.singleton(null));
        return tempHashTable.toArray();
    }

    @Override
    public <T> T[] toArray(T[] array) {
        //TODO
        if (array.length < size()) {
            //noinspection unchecked
            return (T[]) Arrays.copyOf(toArray(), size(), array.getClass());
        }
        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(toArray(), 0, array, 0, array.length);
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
        //TODO
        //true if this collection changed as a result of the call
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
        for (int i = 0; i < size(); i++) {
            if (!hashTable[i].isEmpty()) {
                hashTable[i].clear();
                modCount++;
            }
        }
        entries = 0;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        //TODO
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
        private int currentModCount = modCount;

        @Override
        public boolean hasNext() {
            return (index + 1 < hashTable.length);
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (modCount != currentModCount) {
                throw new ConcurrentModificationException();
            }
            if (hashTable[index] != null) {
                if (innerIndex + 1 < hashTable[index].size()) {
                    innerIndex++;
                    return hashTable[index].get(innerIndex);
                }
                innerIndex = -1;
                index++;
                if (hashTable[index] != null) {
                    innerIndex++;
                    return hashTable[index].get(innerIndex);
                }
            }
            index++;
            return null;
        }
    }

    public Iterator<E> iterator() {
        return new HashTableIterator();
    }
}