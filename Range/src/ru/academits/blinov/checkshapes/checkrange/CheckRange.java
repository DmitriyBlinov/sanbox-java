package ru.academits.blinov.checkshapes.checkrange;

import ru.academits.blinov.checkshapes.range.Range;

import java.util.Scanner;

public class CheckRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите два вещественных числа 1-го интервала через пробел: ");
        String usersRange = scanner.nextLine();
        String[] rangeToArray = usersRange.split(" ");
        double from = Double.parseDouble(rangeToArray[0]);
        double to = Double.parseDouble(rangeToArray[1]);

        System.out.print("Введите два вещественных числа 2-го интервала через пробел: ");
        String usersRange2 = scanner.nextLine();
        String[] rangeToArray2 = usersRange2.split(" ");
        double from2 = Double.parseDouble(rangeToArray2[0]);
        double to2 = Double.parseDouble(rangeToArray2[1]);

        System.out.print("Введите искомое вещественное число: ");
        double usersNumber = scanner.nextDouble();
        System.out.println();

        Range range = new Range(from, to);

        if (range.isInside(usersNumber)) {
            System.out.println("Ваше число принадлежит интервалу от " + range.getFrom() + " до " + range.getTo());
        } else {
            System.out.println("Число не принадлежит интервалу от " + range.getFrom() + " до " + range.getTo());
        }

        double length = range.calculateLength();
        System.out.println("Длина отрезка 1-го диапазона: " + length);

        Range range2 = new Range(from2, to2);

        Range crossing = range.getCrossingOfRanges(range2);
        if (crossing == null) {
            System.out.println("Интервалы не пересекаются");
        } else {
            System.out.println("Интервалы пересекаются в диапазоне: " + crossing.getFrom() + " - " + crossing.getTo());
        }

        Range complement[] = range.getComplementOfRanges(range2);
        if (complement.length == 0) {
            System.out.println("Разность интервалов: 1-й интервал полностью нах-ся во 2-ом");
        } else if (complement.length == 1) {
            System.out.println("Разность интервалов: " + complement[0].getFrom() + " - " + complement[0].getTo());
        } else {
            System.out.print("Разность интервалов: " + complement[0].getFrom() + " - " + complement[0].getTo());
            System.out.println(", " + complement[1].getFrom() + " - " + complement[1].getTo());
        }

        Range union[] = range.getUnionOfRanges(range2);
        if (union.length == 2) {
            System.out.print("Результат объединения интервалов: " + union[0].getFrom() + " - " + union[0].getTo());
            System.out.println(", " + union[1].getFrom() + " - " + union[1].getTo());
        } else {
            System.out.println("Результат объединения интервалов: " + union[0].getFrom() + " - " + union[0].getTo());
        }
    }
}
