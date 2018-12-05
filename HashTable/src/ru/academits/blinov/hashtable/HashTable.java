package ru.academits.blinov.hashtable;

import java.util.*;

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
        int index = value.hashCode() % size();
        if (hashTable[index] == null) {
            hashTable[index] = new ArrayList<>();
            hashTable[index].add(value);
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
        return null;
    }

    //возвращает массив, в от-ом содержатся все элементы коллекции
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(hashTable, size());
    }

    //не устраивает, что я хочу, чтобы потом T поменялась на мой тип
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
        for (ArrayList<T> e : hashTable) {
            for (T i : e) {

            }
        }
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

    //Как вообще делать, получается нужно создавать ArrayList, элементами которого будут массивы Hash[]?
    //Какой длины нужно создавать, нужно ли подгонять под единый размер все хеши, ведь они могут получаться
    //разной величины
    //Какие элементы может принимать
    //Что именно должен хранить элемент таблицы key и value или это должен быть просто элемент, к примеру
}
