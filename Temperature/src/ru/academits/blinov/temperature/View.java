package ru.academits.blinov.temperature;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class View {
    private JTextField usersTemperature;
    private JTextField resultTemperature;
    private JComboBox<String> from;
    private JComboBox<String> to;
    private JButton convert;

    public View() {
        JFrame frame = new JFrame("Конвертация температур");
        frame.setSize(360, 100);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);

        usersTemperature = new JTextField("0", 5);
        resultTemperature = new JTextField("0", 5);
        resultTemperature.setEditable(false);
        String[] scales = {"°C", "°F", "°K"};
        from = new JComboBox<>(scales);
        to = new JComboBox<>(scales);
        convert = new JButton("КОНВЕРТИРОВАТЬ");

        frame.add(new JLabel("ПЕРЕВЕСТИ ИЗ "));
        frame.add(usersTemperature);
        frame.add(from);
        frame.add(new JLabel(" В "));
        frame.add(resultTemperature);
        frame.add(to);
        frame.add(convert);
    }

    public double getUsersTemperature() {
        if (usersTemperature.getText().isEmpty()) {
            return 0;
        }
        return Double.parseDouble(usersTemperature.getText());
    }

    public void setResultTemperature(double resultTemperature) {
        DecimalFormat df = new DecimalFormat("#.##");
        this.resultTemperature.setText(String.valueOf(df.format(resultTemperature)));
    }

    public JButton getConvert() {
        return convert;
    }

    public JComboBox<String> getFrom() {
        return from;
    }

    public JComboBox<String> getTo() {
        return to;
    }
}