package ru.academits.blinov.hashtable;

public class Util {

    public static <K, V> boolean compare(Pair<K, V> pair1, Pair<K, V> pair2) {
        return pair1.getKey().equals(pair2.getKey()) && pair1.getValue().equals(pair2.getValue());
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(1, "abc");
        Pair<Integer, String> pair2 = new Pair<>(2, "abc");
        System.out.println(Util.compare(pair1, pair2));
    }
}