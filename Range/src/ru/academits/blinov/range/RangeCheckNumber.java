package ru.academits.blinov.range;

import java.util.Scanner;

public class RangeCheckNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите два вещественных числа через пробел: ");
        String usersRange = scanner.nextLine();

        String[] rangeToArray = usersRange.split(" ");

        double firstNumber = Double.parseDouble(rangeToArray[0]);
        double secondNumber = Double.parseDouble(rangeToArray[1]);

        System.out.print("Введите искомое вещественное число: ");
        double usersNumber = scanner.nextDouble();

        Range range = new Range(firstNumber, secondNumber);

        if (range.isInside(usersNumber)) {
            System.out.println("Ваше число принадлежит диапазону от " + range.getFrom() + " до " + range.getTo());
        } else {
            System.out.println("Число не принадлежит диапазону от " + range.getFrom() + " до " + range.getTo());
        }

        double length = range.calculateLength();
        System.out.println("Длина отрезка: " + length);

        double fNum = 5.2;
        double secNum = 8.0;
        Range range2 = new Range (fNum, secNum);

        range.checkCrossing(firstNumber, secondNumber, fNum, secNum);
        System.out.println(range.getFrom() + " " + range.getTo());
    }
}
