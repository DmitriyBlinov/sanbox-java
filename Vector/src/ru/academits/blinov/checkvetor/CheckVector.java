package ru.academits.blinov.checkvetor;

import ru.academits.blinov.vector.Vector;

import static ru.academits.blinov.vector.Vector.addVector;
import static ru.academits.blinov.vector.Vector.multiplyByVector;
import static ru.academits.blinov.vector.Vector.subtractVector;

public class CheckVector {
    public static void main(String[] args) {
        double[] array = new double[]{3.0, 2.0, 4.0, 6.0};
        double[] array2 = new double[]{3.0, 2.0, 4.0, 6.0};
        Vector vector = new Vector(8, array);
        Vector vector2 = new Vector(array2);

        System.out.println("Размерность 1-го вектора = " + vector.getSize());
        System.out.println("Размерность 2-го вектора = " + vector2.getSize());

        vector.addVector(vector2);
        System.out.println("Прибавление 2-го вектора к 1-му: " + vector.toString());
        System.out.println("Результат сложения векторов: " + addVector(vector, vector2).toString());
        System.out.println();

        vector.subtractVector(vector2);
        System.out.println("Вычитание вещ.векторов: " + vector.toString());
        System.out.println("Результат разности векторов: " + subtractVector(vector, vector2).toString());
        System.out.println();

        vector.multipleByScalar(2);
        System.out.println("Умножения 1-го вектора на скаляр: " + vector.toString());
        System.out.println("Скалярное произведение векторов: " + multiplyByVector(vector, vector2));
        System.out.println();

        System.out.println("Длина 1-го вектора: " + vector.calculateLength());
        System.out.println();

        vector.reverseVector();
        System.out.println("Разворот 1-го вектора: " + vector.toString());
        System.out.println();

        System.out.println("Компонента по индексу 2 = " + vector.getComponent(2));
        System.out.println();

        vector.setComponent(2, 2.2);
        System.out.println("Переопределение компоненты на число 2,2 = " + vector.toString());
        System.out.println();

        System.out.println("Проверка векторов на равенство дает значение: " + vector.equals(vector2));
        System.out.println();

        System.out.println("Проверка хешкодов на равенство дает значение: " + (vector.hashCode() == vector2.hashCode()));
    }
}