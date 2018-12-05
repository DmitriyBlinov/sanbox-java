package ru.academits.blinov.checkhashtable;

import ru.academits.blinov.hashtable.HashTable;

import java.util.Arrays;

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

        System.out.println(hashTable.toString());
    }
}
