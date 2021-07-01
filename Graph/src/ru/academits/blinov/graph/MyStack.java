package ru.academits.blinov.graph;

public class MyStack {
    final private int size = 10;
    private int top;
    private final int[] array;

    public MyStack() {
        array = new int[size];
        top = -1;
    }

    public void push(int vertex) {
        array[++top] = vertex;
    }

    public int pop() {
        return array[top--];
    }

    public int peek() {
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}