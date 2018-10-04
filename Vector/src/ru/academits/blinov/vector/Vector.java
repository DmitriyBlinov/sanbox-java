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
        numbers = new double[vector.getSize()];
        System.arraycopy(vector.numbers, 0, numbers, 0, vector.getSize());
    }

    public Vector(double[] array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равна нулю!");
        }
        numbers = new double[array.length];
        System.arraycopy(array, 0, numbers, 0, array.length);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равна нулю!");
        }
        numbers = new double[n];
        System.arraycopy(array, 0, numbers, 0, array.length);
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
        Vector currentVector1 = new Vector(maxSize, numbers);
        Vector currentVector2 = new Vector(maxSize, vector.numbers);

        Vector sum = new Vector(maxSize);

        for (int i = 0; i < sum.getSize(); i++) {
            sum.numbers[i] = currentVector1.numbers[i] + currentVector2.numbers[i];
        }
        this.numbers = sum.numbers;
    }

    public void subtractVector(Vector vector) {
        int maxSize = this.getSize() > vector.getSize() ? this.getSize() : vector.getSize();
        Vector currentVector1 = new Vector(maxSize, this.numbers);
        Vector currentVector2 = new Vector(maxSize, vector.numbers);

        Vector subtraction = new Vector(maxSize);

        for (int i = 0; i < subtraction.getSize(); i++) {
            subtraction.numbers[i] = currentVector1.numbers[i] - currentVector2.numbers[i];
        }
        this.numbers = subtraction.numbers;
    }

    public void multipleByScalar(int scalar) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] *= scalar;
        }
    }

    public void reverseVector() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] *= -1;
        }
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
        int maxSize = vector.getSize() > vector2.getSize() ? vector.getSize() : vector2.getSize();
        Vector currentVector1 = new Vector(maxSize, vector.numbers);
        Vector currentVector2 = new Vector(maxSize, vector2.numbers);

        Vector sum = new Vector(maxSize);

        for (int i = 0; i < sum.getSize(); i++) {
            sum.numbers[i] = currentVector1.numbers[i] + currentVector2.numbers[i];
        }
        return sum;
    }

    public static Vector subtractVector(Vector vector, Vector vector2) {
        int maxSize = vector.getSize() > vector2.getSize() ? vector.getSize() : vector2.getSize();
        Vector currentVector1 = new Vector(maxSize, vector.numbers);
        Vector currentVector2 = new Vector(maxSize, vector2.numbers);

        Vector subtraction = new Vector(maxSize);

        for (int i = 0; i < subtraction.getSize(); i++) {
            subtraction.numbers[i] = currentVector1.numbers[i] - currentVector2.numbers[i];
        }
        return subtraction;
    }

    public static Vector multiplyByVector(Vector vector, Vector vector2) {
        int maxSize = vector.getSize() > vector2.getSize() ? vector.getSize() : vector2.getSize();
        Vector currentVector1 = new Vector(maxSize, vector.numbers);
        Vector currentVector2 = new Vector(maxSize, vector2.numbers);

        Vector multiple = new Vector(maxSize);

        for (int i = 0; i < multiple.getSize(); i++) {
            multiple.numbers[i] = currentVector1.numbers[i] * currentVector2.numbers[i];
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