package ru.academits.blinov.temperature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

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

            frame.add(new JLabel(" В "));

            JTextField result = new JTextField("0", 5);
            result.setEditable(false);
            frame.add(result);

            JComboBox comboBoxTo = new JComboBox(scales);
            frame.add(comboBoxTo);

            JButton convert = new JButton("КОНВЕРТИРОВАТЬ");
            frame.add(convert);

            convert.addActionListener((ActionEvent e) -> {
                if (usersTemperature.getText().isEmpty()) {
                    usersTemperature.setText("0");
                }
                String text = usersTemperature.getText();
                double number = Double.parseDouble(text);
                int from = comboBoxFrom.getSelectedIndex();
                int to = comboBoxTo.getSelectedIndex();
                DecimalFormat df = new DecimalFormat("#.##");
                if (from == 0) {
                    if (to == 0) {
                        result.setText(usersTemperature.getText());
                    } else if (to == 1) {
                        result.setText(String.valueOf(df.format(convertCelsiusToFahrenheit(number))));
                    } else {
                        result.setText(String.valueOf(df.format(convertCelsiusToKelvin(number))));
                    }
                } else if (from == 1) {
                    if (to == 0) {
                        result.setText(String.valueOf(df.format(convertFahrenheitToCelsius(number))));
                    } else if (to == 1) {
                        result.setText(usersTemperature.getText());
                    } else {
                        result.setText(String.valueOf(df.format(convertFahrenheitToKelvin(number))));
                    }
                } else {
                    if (to == 0) {
                        result.setText(String.valueOf(df.format(convertKelvinToCelsius(number))));
                    } else if (to == 1) {
                        result.setText(String.valueOf(df.format(convertKelvinToFahrenheit(number))));
                    } else {
                        result.setText(usersTemperature.getText());
                    }
                }
            });
        });
    }
}