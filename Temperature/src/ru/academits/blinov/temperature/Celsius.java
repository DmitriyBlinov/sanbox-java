package ru.academits.blinov.temperature;

public class Celsius implements Scales {
    private double temperature;

    public double getTemperature () {
        return temperature;
    }

    public double convertToCelsius () {
        return temperature;
    }

    public String toString() {
        return "°C";
    }

    public double convertToFahrenheit (Fahrenheit fahrenheit) {
        return fahrenheit.getTemperature() * 1.8 + 32;
    }

    public double convertToKelvin (Kelvin kelvin) {
        return kelvin.getTemperature() * 1.8 - 459.67;
    }
}
