package ru.academits.blinov.checkhashtable;

import ru.academits.blinov.hashtable.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CheckHashTable {
    public static void main(String[] args) {
        HashTable<Integer> hashTable = new HashTable<>(14);
        hashTable.add(2);
        hashTable.add(12);
        hashTable.add(55);
        hashTable.add(6);
        hashTable.add(1);
        hashTable.add(99);
        hashTable.add(21);
        hashTable.add(225);
        hashTable.add(3);

        System.out.println("Изначальная таблица: " + hashTable.toString());

        System.out.println(hashTable.contains(99));
        System.out.println("***Удаление " + hashTable.remove(null));
        System.out.println("Удаление элемента: " + hashTable.toString());

        Iterator<Integer> iterator = hashTable.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();

        List<Integer> collection = new ArrayList<>(5);
        collection.add(2);
        collection.add(12);
        collection.add(99);
        System.out.println(hashTable.containsAll(collection));
        hashTable.removeAll(collection);
        hashTable.addAll(collection);
        System.out.println("Удаление элементов другой коллекции: " + hashTable.toString());
    }
}