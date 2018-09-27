package ru.academits.blinov.range;

import java.util.Scanner;

public class RangeCheckNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите два вещественных числа 1-го диапазона через пробел: ");
        String usersRange = scanner.nextLine();
        String[] rangeToArray = usersRange.split(" ");
        double from1 = Double.parseDouble(rangeToArray[0]);
        double to1 = Double.parseDouble(rangeToArray[1]);

        System.out.print("Введите два вещественных числа 2-го диапазона через пробел: ");
        String usersRange2 = scanner.nextLine();
        String[] rangeToArray2 = usersRange2.split(" ");
        double from2 = Double.parseDouble(rangeToArray2[0]);
        double to2 = Double.parseDouble(rangeToArray2[1]);

        System.out.print("Введите искомое вещественное число: ");
        double usersNumber = scanner.nextDouble();

        Range range = new Range(from1, to1);

        Range range2 = new Range(from2, to2);

        if (range.isInside(usersNumber)) {
            System.out.println("Ваше число принадлежит диапазону от " + range.getFrom() + " до " + range.getTo());
        } else {
            System.out.println("Число не принадлежит диапазону от " + range.getFrom() + " до " + range.getTo());
        }

        double length = range.calculateLength();
        System.out.println("Длина отрезка 1-го диапазона: " + length);

        range2.checkRangeCrossing(range.getFrom(), range.getTo());
    }
}
