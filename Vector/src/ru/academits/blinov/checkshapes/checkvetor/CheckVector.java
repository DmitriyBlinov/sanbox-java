package ru.academits.blinov.checkshapes.checkvetor;

import ru.academits.blinov.checkshapes.vector.Vector;

public class CheckVector {
    public static void main(String[] args) {
        double[] array = new double[]{3.0, 2.0, 4.0, 6.0};
        double[] array2 = new double[]{3.0, 2.0, 4.0, 6.0};
        Vector vector = new Vector(5, array);
        Vector vector2 = new Vector(array2);

        System.out.println("Размерность 1-го вектора = " + vector.getSize());
        System.out.println("Размерность 2-го вектора = " + vector2.getSize());

        vector.addVector(vector2);
        System.out.println("Прибавление 2-го вектора к 1-му: " + vector.toString());
        System.out.println("Результат сложения векторов: " + Vector.addVector(vector, vector2).toString());

        vector.subtractVector(vector2);
        System.out.println("Вычитание вещ.векторов: " + vector.toString());
        System.out.println("Результат разности векторов: " + Vector.subtractVector(vector, vector2).toString());

        vector.multipleByScalar(2);
        System.out.println("Умножения 1-го вектора на скаляр: " + vector.toString());
        System.out.println("Скалярное произведение векторов: " + Vector.multiplyByVector(vector, vector2));

        System.out.println("Длина 1-го вектора: " + vector.calculateLength());

        vector.reverseVector();
        System.out.println("Разворот 1-го вектора: " + vector.toString());

        System.out.println("Компонента по индексу 2 = " + vector.getComponent(2));

        vector.setComponent(2, 2.2);
        System.out.println("Переопределение компоненты на число 2,2 = " + vector.toString());

        System.out.println("Проверка векторов на равенство: " + vector.equals(vector2));

        System.out.println("Проверка хешкодов на равенство: " + (vector.hashCode() == vector2.hashCode()));
    }
}