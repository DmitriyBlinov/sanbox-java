package ru.academits.blinov.temperature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temperature {
    private static double convertCelsiusToFahrenheit(double temperatureCelsius) {
        return (temperatureCelsius * 1.8 + 32);
    }

    private static double convertCelsiusToKelvin(double temperatureCelsius) {
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

            frame.add(new JLabel("Введите температуру по Цельсию: "));
            JTextField celsius = new JTextField("0", 7);
            frame.add(celsius);
            frame.add(new JLabel("Перевести в: "));

            JButton convertToFahrenheit = new JButton("Фаренгейты");
            frame.add(convertToFahrenheit);

            JButton convertToKelvin = new JButton("Кельвины");
            frame.add(convertToKelvin);

            JLabel result = new JLabel("Результат: ");
            frame.add(result);

            convertToFahrenheit.addActionListener((ActionEvent e) -> {
                String text = celsius.getText();
                int number = Integer.parseInt(text);
                result.setText("Результат: " + convertCelsiusToFahrenheit(number) + "°F");
            });

            convertToKelvin.addActionListener((ActionEvent e) -> {
                String text = celsius.getText();
                int number = Integer.parseInt(text);
                result.setText("Результат: " + convertCelsiusToKelvin(number) + "°K");
            });
        });
    }
}