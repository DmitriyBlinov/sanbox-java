package ru.academits.blinov.temperature;

import javax.swing.*;
import java.awt.*;

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
            frame.setSize(500,200);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);

            frame.setLayout(new GridLayout(4,2));

            JLabel celsius, fahrenheit, kelvin;

            JButton convert = new JButton("Конвертировать в Фаренгейты");
            celsius = new JLabel("По Цельсию: ");
            fahrenheit = new JLabel("По Фаренгейту: ");
            kelvin = new JLabel("По Кельвину: ");

            add(convert, GridLayout);


        });
    }
}
