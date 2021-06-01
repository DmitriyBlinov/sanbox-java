package ru.academits.blinov.checkhashtable;

import ru.academits.blinov.hashtable.HashTableHome;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CheckHashTable {
    public static void main(String[] args) {
        HashTableHome<Integer> hashTableHome = new HashTableHome<>(14);
        hashTableHome.add(2);
        hashTableHome.add(12);
        hashTableHome.add(55);
        hashTableHome.add(6);
        hashTableHome.add(1);
        hashTableHome.add(99);
        hashTableHome.add(21);
        hashTableHome.add(225);
        hashTableHome.add(3);

        System.out.println("Изначальная таблица: " + hashTableHome.toString());

        System.out.println("Содержит ли число 99: " + hashTableHome.contains(99));
        hashTableHome.remove(null);
        System.out.println("Удаление null: " + hashTableHome.toString());

        Iterator<Integer> iterator = hashTableHome.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();

        List<Integer> collection = new ArrayList<>(5);
        collection.add(2);
        collection.add(12);
        collection.add(99);
        System.out.println(hashTableHome.containsAll(collection));
        hashTableHome.removeAll(collection);
        hashTableHome.remove(null);
        System.out.println("Удаление элементов другой коллекции: " + hashTableHome.toString());
    }
}