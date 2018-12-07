package ru.academits.blinov.temperature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Temperature {
    private static double convertCelsiusToFahrenheit(double temperatureCelsius) {
        return temperatureCelsius * 1.8 + 32;
    }

    private static double convertFahrenheitToCelsius(double temperatureFahrenheit) {
        return (temperatureFahrenheit - 32) / 1.8;
    }

    private static double convertCelsiusToKelvin(double temperatureCelsius) {
        return temperatureCelsius + 273.15;
    }

    private static double convertKelvinToCelsius(double temperatureKelvin) {
        return temperatureKelvin - 273.15;
    }

    private static double convertKelvinToFahrenheit(double temperatureKelvin) {
        return temperatureKelvin * 1.8 - 459.67;
    }

    private static double convertFahrenheitToKelvin(double temperatureFahrenheit) {
        return (temperatureFahrenheit + 459.67) / 1.8;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Конвертация температур");
            frame.setSize(360, 100);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setLayout(new FlowLayout());
            frame.setResizable(false);

            frame.add(new JLabel("ПЕРЕВЕСТИ ИЗ "));

            JTextField usersTemperature = new JTextField("0", 5);
            frame.add(usersTemperature);

            String[] scales = {"°C", "°F", "°K"};
            JComboBox comboBoxFrom = new JComboBox(scales);
            frame.add(comboBoxFrom);

            frame.add(new JLabel(" в "));

            JTextField result = new JTextField("0", 5);
            result.setEditable(false);
            frame.add(result);

            JComboBox comboBoxTo = new JComboBox(scales);
            frame.add(comboBoxTo);

            JButton convert = new JButton("КОНВЕРТИРОВАТЬ");
            frame.add(convert);

            convert.addActionListener((ActionEvent e) -> {
                String text = usersTemperature.getText();
                int number = Integer.parseInt(text);
                switch (comboBoxFrom.getSelectedIndex()) {
                    case 0:
                        switch (comboBoxTo.getSelectedIndex()) {
                            case 0:
                                result.setText(usersTemperature.getText());
                                break;
                            case 1:
                                result.setText(String.valueOf(convertCelsiusToFahrenheit(number)));
                                break;
                            case 2:
                                result.setText(String.valueOf(convertCelsiusToKelvin(number)));
                                break;
                        }
                    case 1:
                        switch (comboBoxTo.getSelectedIndex()) {
                            case 0:
                                result.setText(String.valueOf(convertFahrenheitToCelsius(number)));
                                break;
                            case 1:
                                result.setText(usersTemperature.getText());
                                break;
                            case 2:
                                result.setText(String.valueOf(convertFahrenheitToKelvin(number)));
                                break;
                        }
                    case 2:
                        switch (comboBoxTo.getSelectedIndex()) {
                            case 0:
                                result.setText(String.valueOf(convertKelvinToCelsius(number)));
                                break;
                            case 1:
                                result.setText(String.valueOf(convertKelvinToFahrenheit(number)));
                                break;
                            case 2:
                                result.setText(usersTemperature.getText());
                                break;
                        }
                }
            });
        });
    }
}


/* frame.add(new JLabel("Введите температуру по Цельсию: "));
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
        });*/