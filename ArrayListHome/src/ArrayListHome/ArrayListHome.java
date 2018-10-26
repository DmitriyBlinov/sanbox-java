package ArrayListHome;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream("list.txt"))) {
            ArrayList<Integer> numbers = new ArrayList<>();
            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
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
}
