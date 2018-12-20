package ru.academits.blinov.temperature;

import java.awt.event.ActionEvent;

public class Model {
    private View view;

    public Model(View view) {
        this.view = view;
    }

    //по идее функция может принимать флаг комбобокса и число, дальше просто лямбдой возвращать, видимо
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

    public void calculateResult() {
        view.getConvert().addActionListener((ActionEvent e) -> {
            int from = view.getFrom().getSelectedIndex();
            int to = view.getTo().getSelectedIndex();
            double number = view.getUsersTemperature();
            if (from == 0) {
                if (to == 0) {
                    view.setResultTemperature(number);
                } else if (to == 1) {
                    view.setResultTemperature(convertCelsiusToFahrenheit(number));
                } else {
                    view.setResultTemperature(convertCelsiusToKelvin(number));
                }
            } else if (from == 1) {
                if (to == 0) {
                    view.setResultTemperature(convertFahrenheitToCelsius(number));
                } else if (to == 1) {
                    view.setResultTemperature(number);
                } else {
                    view.setResultTemperature(convertFahrenheitToKelvin(number));
                }
            } else {
                if (to == 0) {
                    view.setResultTemperature(convertKelvinToCelsius(number));
                } else if (to == 1) {
                    view.setResultTemperature(convertKelvinToFahrenheit(number));
                } else {
                    view.setResultTemperature(number);
                }
            }
        });
    }
}