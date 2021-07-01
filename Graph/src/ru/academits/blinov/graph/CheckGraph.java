package ru.academits.blinov.graph;

public class CheckGraph<T> {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');

        graph.addEdge(0, 1, 1); //AB
        graph.addEdge(1, 2, 1); //BC
        graph.addEdge(2, 3, 1); //CD
        graph.addEdge(0, 4, 1); //AE
        graph.addEdge(4, 5, 1); //EF

        graph.depthFirstSearch(0);
        graph.breadthFirstSearch(0);
    }
}