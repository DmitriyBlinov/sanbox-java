package ru.academits.blinov.hashtable;

public class Util {

    public static <K, V> boolean compare(Hash<K, V> pair1, Hash<K, V> pair2) {
        return pair1.getKey().equals(pair2.getKey()) && pair1.getValue().equals(pair2.getValue());
    }

    public static void main(String[] args) {
        Hash<Integer, String> pair1 = new Hash<>(1, "abc");
        Hash<Integer, String> pair2 = new Hash<>(2, "abc");
        System.out.println(Util.compare(pair1, pair2));
    }
}