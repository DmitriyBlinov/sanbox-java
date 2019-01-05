package ru.academits.blinov.checkhashtable;

import ru.academits.blinov.hashtable.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CheckHashTable {
    public static void main(String[] args) {
        HashTable<Integer> hashTable = new HashTable<>(15);
        hashTable.add(2);
        hashTable.add(12);
        hashTable.add(55);
        hashTable.add(6);
        hashTable.add(1);
        hashTable.add(99);
        hashTable.add(21);

        System.out.println("Изначальная таблица: " + hashTable.toString());

        hashTable.remove(55);
        System.out.println("Удаление элемента: " + hashTable.toString());

        Iterator<Integer> iterator = hashTable.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();

        List<Integer> collection = new ArrayList<>();
        collection.add(2);
        collection.add(12);
        collection.add(55);
        hashTable.removeAll(collection);
        System.out.println("Удаление элементов другой коллекции: " + hashTable.toString());
    }
}