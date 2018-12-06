package ru.academits.blinov.temperature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temperature {

    public static double convertCelsiusToFahrenheit(double temperatureCelsius) {
        return (temperatureCelsius * 1.8 + 32);
    }

    public static double convertCelsiusToKelvin(double temperatureCelsius) {
        return (temperatureCelsius + 273.15);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Конвертация температур");
            frame.setSize(330, 130);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);

            frame.setLayout(new FlowLayout());

            JLabel welcome, convert, result;

            JButton convertToFahrenheit = new JButton("Фаренгейты");
            JButton convertToKelvin = new JButton("Кельвины");
            welcome = new JLabel("Введите температуру по Цельсию: ");
            convert = new JLabel("Перевести в: ");


            JTextField celsius = new JTextField("0", 7);
            frame.add(welcome);
            frame.add(celsius);
            frame.add(convert);
            frame.add(convertToFahrenheit);
            frame.add(convertToKelvin);

            convertToFahrenheit.addActionListener((ActionEvent e) -> {
                String text = celsius.getText();
                int number = Integer.parseInt(text);
                frame.add(new JLabel("Результат: " + convertCelsiusToFahrenheit(number) + "°F"));
                frame.setVisible(true);
            });

            convertToKelvin.addActionListener((ActionEvent e) -> {
                String text = celsius.getText();
                int number = Integer.parseInt(text);
                frame.add(new JLabel("Результат: " + convertCelsiusToKelvin(number) + "°K"));
                frame.setVisible(true);
            });
        });
    }
}