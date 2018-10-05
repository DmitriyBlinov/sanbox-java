package ru.academits.blinov.checkshapes.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равна нулю!");
        }
        components = new double[n];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.getSize());
    }

    public Vector(double[] array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равна нулю!");
        }
        components = Arrays.copyOf(array, array.length);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равна нулю!");
        }
        components = Arrays.copyOf(array, n);
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{ ");
        for (double e : components) {
            stringBuilder.append(e).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append(" }");

        return stringBuilder.toString();
    }

    public void addVector(Vector vector) {
        if (getSize() == vector.getSize()) {
            for (int i = 0; i < getSize(); i++) {
                components[i] += vector.components[i];
            }
            return;
        }

        int maxSize = getSize() > vector.getSize() ? getSize() : vector.getSize();
        double[] currentVector = Arrays.copyOf(components, maxSize);

        for (int i = 0; i < vector.getSize(); i++) {
            currentVector[i] += vector.components[i];
        }
        components = currentVector;
    }
    
    public void subtractVector(Vector vector) {
        if (getSize() == vector.getSize()) {
            for (int i = 0; i < getSize(); i++) {
                components[i] -= vector.components[i];
            }
            return;
        }

        int maxSize = getSize() > vector.getSize() ? getSize() : vector.getSize();
        double[] currentVector = Arrays.copyOf(components, maxSize);

        for (int i = 0; i < vector.getSize(); i++) {
            currentVector[i] -= vector.components[i];
        }
        components = currentVector;
    }

    public void multipleByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public void reverseVector() {
        multipleByScalar(-1);
    }

    public double calculateLength() {
        double sum = 0;
        for (double e : components) {
            sum += Math.pow(e, 2);
        }
        return Math.sqrt(sum);
    }

    public double getComponent(int index) {
        return components[index];
    }

    public void setComponent(int index, double newComponent) {
        components[index] = newComponent;
    }

    public static Vector addVector(Vector vector, Vector vector2) {
        Vector currentVector = new Vector(vector);

        currentVector.addVector(vector2);
        return currentVector;
    }

    public static Vector subtractVector(Vector vector, Vector vector2) {
        Vector currentVector = new Vector(vector);

        currentVector.subtractVector(vector2);
        return currentVector;
    }

    public static double multiplyByVector(Vector vector, Vector vector2) {
        int minSize = vector.getSize() < vector2.getSize() ? vector.getSize() : vector2.getSize();

        double multiple = 0.0;

        for (int i = 0; i < minSize; i++) {
            multiple += vector.components[i] * vector2.components[i];
        }
        return multiple;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
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
        return Arrays.equals(components, vector.components);
    }
}