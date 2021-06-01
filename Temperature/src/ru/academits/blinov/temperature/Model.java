package ru.academits.blinov.temperature;

import java.awt.event.ActionEvent;

public class Model {
    private View view;

    public Model(View view) {
        this.view = view;
    }

    //по идее функция может принимать флаг комбобокса и число, дальше просто лямбдой возвращать, видимо
    //сделать интерфейс, в кот-ом обозначены все функции и каждый метод, чтобы он умел конвертить из себя
    //и дальше. проще всего, чтобы принимал флаг
    //сделать convertToCelsius и дальше просто пусть смотрит флаг что именно нужно конвертнуть в цельсий
    //либо может просто конвертировать каждую в цельсий, а из неё уже в нужную
    //интерфейс должен принять температуру, конвертнуть её в цельсий и затем выдать нужную

    public void calculateResult() {
        view.getConvert().addActionListener((ActionEvent e) -> {
            int from = view.getFrom().getSelectedIndex();
            int to = view.getTo().getSelectedIndex();
            double number = view.getUsersTemperature();

            //по идее, здесь должна быть одна строчка типа view.setResultTemperature(Scales.convert(from, to));
// 1. celsius должен любую температуру из from переводить в себя 2. celsius должен уметь из любой температуры сделать to
            switch(from){
                default:
                    view.setResultTemperature(Scales.convertCelsius(to, number));
                    break;
                case 1:
                    view.setResultTemperature(Scales.convertFahrenheit(to, number));
                    break;
                case 2:
                    view.setResultTemperature(Scales.convertKelvin(to, number));
                    break;
            }
        });
    }
}