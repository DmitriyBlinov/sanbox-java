package checkhashtable;

import hashtable.HashTable;

public class CheckHashTable {
    public static void main(String[] args) {
        HashTable<Integer, String> hashTable = new HashTable<>();

        hashTable.add(1, "This");
        hashTable.add(2, "is");
        hashTable.add(3, "HashTable");

        System.out.println("Initial size: " + hashTable.size());
        System.out.println("Removed value: " + hashTable.remove(2));
        System.out.println("Size: " + hashTable.size());
        System.out.println("Is empty: " + hashTable.isEmpty());
        System.out.println(hashTable);
    }
}