package ru.academits.blinov.graph;

public class Graph {
    //максимальное кол-во вершин в графе
    final private int maxNumber = 10;
    //матрица смежности
    private final int[][] adjacencyList;
    Vertex[] vertexList;
    private int currentVertex;
    private final MyStack stack = new MyStack();
    private final MyQueue queue = new MyQueue();

    public Graph() {
        vertexList = new Vertex[maxNumber];
        adjacencyList = new int[maxNumber][maxNumber];
        currentVertex = 0;
    }

    public void addVertex(char name) {
        vertexList[currentVertex++] = new Vertex(name);
    }

    //int val для инициализации матрицы смежности
    public void addEdge(int start, int end, int val) {
        adjacencyList[start][end] = 1;
        adjacencyList[end][start] = val;
    }

    public int check(int vertex) {
        for (int i = 0; i < currentVertex; i++) {
            if (adjacencyList[vertex][i] == 1 && !vertexList[i].isVisited) {
                return i;
            }
        }
        return -1;
    }

    public void depthFirstSearch(int index) {
        System.out.println(vertexList[index].name);
        vertexList[index].isVisited = true;
        stack.push(index);

        while (!stack.isEmpty()) {
            int neighbor = check(stack.peek());

            if (neighbor == -1) {
                neighbor = stack.pop();
            } else {
                System.out.println(vertexList[neighbor].name);
                vertexList[neighbor].isVisited = true;
                stack.push(neighbor);
            }
        }

        for (int i = 0; i < currentVertex; i++) {
            vertexList[i].isVisited = false;
        }
    }

    public void breadthFirstSearch(int index) {
        System.out.println(vertexList[index].name);
        vertexList[index].isVisited = true;
        queue.insert(index);

        int vertex;

        while (!queue.isEmpty()) {
            int temp = queue.remove();

            while ((vertex = check(temp)) != -1) {
                System.out.println(vertexList[vertex].name);
                vertexList[vertex].isVisited = true;
                queue.insert(vertex);
            }
        }

        for (int i = 0; i < currentVertex; i++) {
            vertexList[i].isVisited = false;
        }
    }
}