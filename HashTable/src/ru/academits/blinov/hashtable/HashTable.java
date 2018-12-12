package ru.academits.blinov.hashtable;

import java.util.*;

//геттер и сеттер для элементов? Сделать итератор
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
        return new Iterator<>() {
            private int currentIndex = 0;
            private int currentInnerIndex = 0;
            int currentModCount = modCount;

            @Override
            public boolean hasNext() {
                return (currentIndex++ < hashTable.length) || (currentInnerIndex++ < hashTable[currentIndex].size());
                //&& hashTable[currentIndex].get(currentInnerIndex++) != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (currentModCount > modCount) {
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
        modCount++;
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
        modCount++;
        return isDeleted;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isRetained = false;
        for (ArrayList<T> e : hashTable) {
            isRetained = e.retainAll(c);
        }
        modCount++;
        return isRetained;
    }

    @Override
    public void clear() {
        for (ArrayList<T> e : hashTable) {
            e.clear();
        }
        modCount++;
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
