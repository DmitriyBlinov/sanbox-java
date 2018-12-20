package ru.academits.blinov.temperature;

import javax.swing.*;

public class Temperature {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            View view = new View();
            Model model = new Model(view);
            model.calculateResult();
        });
    }
}