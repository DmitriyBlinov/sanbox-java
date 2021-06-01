package ru.academits.blinov.temperature;

public interface Scales {
    //0 celsius
    //1 fahrenheit
    //2 kelvin
    double convert();
    double convertToCelsius();

    double getTemperature();

    String toString();
}
