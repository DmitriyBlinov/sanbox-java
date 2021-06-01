package ru.academits.blinov.temperature;

public class Fahrenheit implements Scales {
    private double temperature;

    public double getTemperature () {
        return temperature;
    }

    public double convert () {
        return temperature;
    }

    public String toString() {
        return "°F";
    }

    private static double convertFahrenheit(int indexTo, double temperature) {
        if (indexTo == 0) {
            return (temperature - 32) / 1.8;
        } else if (indexTo == 1) {
            return temperature;
        } else {
            return (temperature + 459.67) / 1.8;
        }
    }
}
