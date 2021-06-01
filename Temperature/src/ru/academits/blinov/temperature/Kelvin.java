package ru.academits.blinov.temperature;

public class Kelvin implements Scales {
    private double temperature;

    public double getTemperature () {
        return temperature;
    }

    public double convert () {
        //здесь должно быть convertTo Celsius, а вернуть нужно уже просто конвертнув из цельсия в кельвины
        return temperature;
    }

    public String toString() {
        return "°K";
    }

    private static double convertKelvin (int indexTo, double temperature) {
        if (indexTo == 0) {
            return temperature - 273.15;
        } else if (indexTo == 1) {
            return temperature * 1.8 - 459.67;
        } else {
            return temperature;
        }
    }
}
