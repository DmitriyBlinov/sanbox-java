package ru.academits.blinov.arraylisthome;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("list.txt"))) {
            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Изначальная коллекция: " + numbers);

        ArrayList<Integer> newNumbers = new ArrayList<>();
        for (int e : numbers) {
            if (!newNumbers.contains(e)) {
                newNumbers.add(e);
            }
        }
        System.out.println("Без повторений: " + newNumbers);

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                i--;
            }
        }
        System.out.println("Без четных: " + numbers);
    }
}