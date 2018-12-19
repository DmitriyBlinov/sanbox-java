package ru.academits.blinov.temperature;

public class Model {
    private String usersTemperature;
    private String resultTemperature;

    public void setUsersTemperature (String usersTemperature) {
        this.usersTemperature = usersTemperature;
    }

    public void calculateResult () {
        //по идее, здесь должны быть лямбды, с помощью кот-ых потом будет проще добавлять новые шкалы
    }
}
