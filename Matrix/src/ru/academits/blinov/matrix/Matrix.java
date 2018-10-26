package ru.academits.blinov.matrix;

import ru.academits.blinov.vector.Vector;

public class Matrix {
    private Vector[] matrix;

    public Matrix(int n, int m) {
        for (int i = 0; i < n; i++) {
            matrix = new Vector[n];
            Vector row = new Vector(m);
            matrix[i] = row;
        }
    }
}
