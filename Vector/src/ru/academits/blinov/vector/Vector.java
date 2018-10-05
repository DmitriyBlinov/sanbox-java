package ru.academits.blinov.vector;

import java.util.Arrays;

public class Vector {
    private double[] numbers;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равна нулю!");
        }
        numbers = new double[n];
    }

    public Vector(Vector vector) {
        numbers = Arrays.copyOf(vector.numbers, vector.getSize());
    }

    public Vector(double[] array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равна нулю!");
        }
        numbers = Arrays.copyOf(array, array.length);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равна нулю!");
        }
        numbers = Arrays.copyOf(array, n);
    }

    public int getSize() {
        return numbers.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{ ");
        for (double e : numbers) {
            stringBuilder.append(e).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append(" }");

        return stringBuilder.toString();
    }

    public void addVector(Vector vector) {
        int maxSize = getSize() > vector.getSize() ? getSize() : vector.getSize();

        double[] currentVector = Arrays.copyOf(numbers, maxSize);
        double[] currentVector2 = Arrays.copyOf(vector.numbers, maxSize);

        for (int i = 0; i < maxSize; i++) {
            currentVector[i] += currentVector2[i];
        }
        numbers = Arrays.copyOf(currentVector, maxSize);
    }

    public void subtractVector(Vector vector) {
        int maxSize = getSize() > vector.getSize() ? getSize() : vector.getSize();

        double[] currentVector = Arrays.copyOf(numbers, maxSize);
        double[] currentVector2 = Arrays.copyOf(vector.numbers, maxSize);

        for (int i = 0; i < maxSize; i++) {
            currentVector[i] -= currentVector2[i];
        }
        numbers = Arrays.copyOf(currentVector, maxSize);
    }

    public void multipleByScalar(double scalar) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] *= scalar;
        }
    }

    public void reverseVector() {
        multipleByScalar(-1);
    }

    public double calculateLength() {
        double sum = 0;
        for (double e : numbers) {
            sum += Math.pow(e, 2);
        }
        return Math.sqrt(sum);
    }

    public double getComponent(int index) {
        return numbers[index];
    }

    public void setComponent(int index, double newComponent) {
        numbers[index] = newComponent;
    }

    public static Vector addVector(Vector vector, Vector vector2) {
        Vector currentVector = new Vector(vector);
        Vector currentVector2 = new Vector(vector2);

        currentVector.addVector(currentVector2);
        return currentVector;
    }

    public static Vector subtractVector(Vector vector, Vector vector2) {
        Vector currentVector = new Vector(vector);
        Vector currentVector2 = new Vector(vector2);

        currentVector.subtractVector(currentVector2);
        return currentVector;
    }

    public static double multiplyByVector(Vector vector, Vector vector2) {
        int maxSize = vector.getSize() > vector2.getSize() ? vector.getSize() : vector2.getSize();

        double[] currentNumbers = Arrays.copyOf(vector.numbers, maxSize);
        double[] currentNumbers2 = Arrays.copyOf(vector2.numbers, maxSize);

        double multiple = 0.0;

        for (int i = 0; i < maxSize; i++) {
            multiple += currentNumbers[i] * currentNumbers2[i];
        }
        return multiple;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(numbers);
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
        return (getSize() == vector.getSize()) && (Arrays.equals(numbers, vector.numbers));
    }
}