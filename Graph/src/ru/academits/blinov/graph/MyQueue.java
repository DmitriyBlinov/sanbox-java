package ru.academits.blinov.graph;

public class MyQueue {
    private final int[] array;
    final private int size = 10;
    private int head;
    private int tail;
    private int count;

    public MyQueue() {
        array = new int[size];
        head = 0;
        tail = -1;
        count = 0;
    }

    public void insert(int vertex) {
        if (tail == size - 1) {
            tail = -1;
        }

        array[++tail] = vertex;
        count++;
    }

    public int remove() {
        if (head == size) {
            head = 0;
        }

        count--;
        return array[head++];
    }

    public boolean isEmpty() {
        return count == 0;
    }
}