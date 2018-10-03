package ru.academits.blinov.vector;

import java.util.Arrays;

public class Vector {
    private double[] vectors;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равна нулю!");
        }
        this.vectors = new double[n];

        for (int i = 0; i < vectors.length; i++) {
            vectors[i] = 0.0;
        }
    }

    public Vector(Vector vector) {
        vectors = vector.vectors;
    }

    public Vector(double[] array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равна нулю!");
        }
        this.vectors = array;
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равна нулю!");
        }
        vectors = new double[n];

        for (int i = 0; i < vectors.length; i++) {
            vectors[i] = i < array.length ? array[i] : 0.0;
        }

    }

    public int getSize() {
        return vectors.length;
    }

    public void setVectors(double[] vectors) {
        if (vectors.length <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равна нулю!");
        }
        this.vectors = vectors;
    }

    public double[] getVectors() {
        return vectors;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{ ");
        for (double e : vectors) {
            stringBuilder.append(e).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append(" }");

        return stringBuilder.toString();
    }

    public void addVector(Vector vector) {
        int maxSize = getSize() > vector.getSize() ? getSize() : vector.getSize();
        Vector currentVector1 = new Vector(maxSize, vectors);
        Vector currentVector2 = new Vector(maxSize, vector.vectors);

        Vector sum = new Vector(maxSize);

        for (int i = 0; i < sum.getSize(); i++) {
            sum.vectors[i] = currentVector1.vectors[i] + currentVector2.vectors[i];
        }
        this.vectors = sum.vectors;
    }

    public void subtractVector(Vector vector) {
        int maxSize = this.getSize() > vector.getSize() ? this.getSize() : vector.getSize();
        Vector currentVector1 = new Vector(maxSize, this.vectors);
        Vector currentVector2 = new Vector(maxSize, vector.vectors);

        Vector subtraction = new Vector(maxSize);

        for (int i = 0; i < subtraction.getSize(); i++) {
            subtraction.vectors[i] = currentVector1.vectors[i] - currentVector2.vectors[i];
        }
        this.vectors = subtraction.vectors;
    }

    public void multipleByScalar(int scalar) {
        for (int i = 0; i < vectors.length; i++) {
            vectors[i] *= scalar;
        }
    }

    public void reverseVector() {
        for (int i = 0; i < vectors.length; i++) {
            vectors[i] *= -1;
        }
    }

    public double calculateLength() {
        double sum = 0;
        for (double e : vectors) {
            sum += Math.pow(e, 2);
        }
        return Math.sqrt(sum);
    }

    public double getComponent(int index) {
        return vectors[index];
    }

    public void setComponent(int index, double newComponent) {
        vectors[index] = newComponent;
    }

    public static Vector addVector(Vector vector, Vector vector2) {
        int maxSize = vector.getSize() > vector2.getSize() ? vector.getSize() : vector2.getSize();
        Vector currentVector1 = new Vector(maxSize, vector.vectors);
        Vector currentVector2 = new Vector(maxSize, vector2.vectors);

        Vector sum = new Vector(maxSize);

        for (int i = 0; i < sum.getSize(); i++) {
            sum.vectors[i] = currentVector1.vectors[i] + currentVector2.vectors[i];
        }
        return sum;
    }

    public static Vector subtractVector(Vector vector, Vector vector2) {
        int maxSize = vector.getSize() > vector2.getSize() ? vector.getSize() : vector2.getSize();
        Vector currentVector1 = new Vector(maxSize, vector.vectors);
        Vector currentVector2 = new Vector(maxSize, vector2.vectors);

        Vector subtraction = new Vector(maxSize);

        for (int i = 0; i < subtraction.getSize(); i++) {
            subtraction.vectors[i] = currentVector1.vectors[i] - currentVector2.vectors[i];
        }
        return subtraction;
    }

    public static Vector multiplyByVector(Vector vector, Vector vector2) {
        int maxSize = vector.getSize() > vector2.getSize() ? vector.getSize() : vector2.getSize();
        Vector currentVector1 = new Vector(maxSize, vector.vectors);
        Vector currentVector2 = new Vector(maxSize, vector2.vectors);

        Vector multiple = new Vector(maxSize);

        for (int i = 0; i < multiple.getSize(); i++) {
            multiple.vectors[i] = currentVector1.vectors[i] * currentVector2.vectors[i];
        }
        return multiple;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(vectors);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        Vector vector = (Vector) obj;
        return (getSize() == vector.getSize()) && (Arrays.equals(vectors, vector.vectors));
    }
}