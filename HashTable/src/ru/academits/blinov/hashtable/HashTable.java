package ru.academits.blinov.hashtable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HashTable<T> implements Collection<T> {
    //Как вообще делать, получается нужно создавать ArrayList, элементами которого будут массивы Hash[]?
    //Какой длины нужно создавать, нужно ли подгонять под единый размер все хеши, ведь они могут получаться
    //разной величины
    //Какие элементы может принимать
    private int hash; //key
    private Hash[] pairs;
    private ArrayList<Hash> hashTable = new ArrayList<>();

    public HashTable () {
    }

    public HashTable (int size) {
    }

    public void add(int number) {
        final int prime = 37;
        Hash pair = new Hash(prime * hash + number, number);
        hashTable.add(pair);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
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
        return false;
    }



    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
