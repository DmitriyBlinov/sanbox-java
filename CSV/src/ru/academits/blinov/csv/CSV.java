package ru.academits.blinov.csv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CSV {
    /* следующая ячейка содержит перевод строки,"до перевода строки
    после перевода строки",а это третий столбец
    следующая ячейка содержит кавычку и запятую,"вот они: "",",
    в этой строке вторая и третья ячейка содержат по одной кавычке,"""",""""
     */
    public static void main(String[] args) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter("csvHTML.txt");
             Scanner scanner = new Scanner(new FileInputStream("csv.txt"))) {
            writer.print("<table>");
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                writer.print("<tr>");
                writer.print("</br>");
            }
            writer.print("</table>");
        }
    }
}
